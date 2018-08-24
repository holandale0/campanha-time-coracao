package br.com.campanha.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.campanha.dao.CampanhaDAO;
import br.com.campanha.model.Campanha;

@Service
public class CampanhaServiceImpl implements CampanhaService{
	
	@Autowired private CampanhaDAO dao;	

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@Async
	public CompletableFuture<List<Campanha>> listarTodos() {
		
		List<Campanha> lista = (List<Campanha>) dao.findAll();
		
		List<Campanha> listaFinal = new ArrayList<Campanha>();
		
		for(int i = 0 ; i < lista.size() ; i++ ) {
			if(lista.get(i).getFimVigencia().compareTo(new Date()) > 0 || lista.get(i).getFimVigencia().compareTo(new Date()) == 0) {
				listaFinal.add(lista.get(i));
			}else {
				
			}
		}
		
		return CompletableFuture.completedFuture(listaFinal);
	}

	@Override
	@Async
	public CompletableFuture<Campanha> getById(Long id) {
		
		Campanha campanha = dao.findOne(id);
		
		if(campanha.getFimVigencia().compareTo(new Date()) > 0 || campanha.getFimVigencia().compareTo(new Date()) == 0) {
			
		}else {
			campanha = null;
		}
		
		return CompletableFuture.completedFuture(campanha);
	}

	@Override
	@Async
	public CompletableFuture<Void> salvarOuAtualizar(Campanha campanha) {
	
		try {
		
		// SE O ID FOR DIFERENTE DE NULL, SIGNIFICA QUE É UMA ATUALIZAÇÃO
		if(campanha.getIdCampanha() != null) {
			campanha.setUltimaAlteracao(new Date());
			dao.save(campanha);	
		}else {
			
			// RECUPERA A LISTA DE CAMPANHAS EXISTENTES
			List<Campanha> lista = (List<Campanha>) dao.findAll();
			
			
			// VERIFICA SE EXISTE ALGUMA CAMPANHA COM DATA DE TÉRMINO IGUAL A DATA DE INÍCIO DA NOVA CAMPANHA
			for(int i = 0 ; i < lista.size() ; i++) {
				
				Campanha campanhaExistente = lista.get(i);
				
				String s = formatter.format(campanha.getInicioVigencia());
			    String result = s;						    
			    Date dataInicioVigencia = formatter.parse(result);
				
				
				if(campanhaExistente.getFimVigencia().compareTo(dataInicioVigencia) == 0) {
							
					
					Date dt = campanhaExistente.getFimVigencia();
					Calendar c = Calendar.getInstance(); 
					c.setTime(dt); 
					c.add(Calendar.DATE, 1);
					dt = c.getTime();				
					campanhaExistente.setFimVigencia(dt);	
					campanhaExistente.setUltimaAlteracao(new Date());
					dao.save(campanhaExistente);																
				}								
				
			}
			
			
			// VERIFICA SE A NOVA CAMPANHA TEM DATA DE TÉRMINO IGUAL A DATA DE TÉRMINO DE ALGUMA CAMPANHA JÁ EXISTENTE
			for(int j = 0 ; j < lista.size() ; j++) {
				
				String s = formatter.format(campanha.getFimVigencia());
			    String result = s;						    
			    Date dataFimVigencia = formatter.parse(result);
				
				if(dataFimVigencia.compareTo(lista.get(j).getFimVigencia()) == 0) {
					Date dt = campanha.getFimVigencia();
					Calendar c = Calendar.getInstance(); 
					c.setTime(dt); 
					c.add(Calendar.DATE, 1);
					dt = c.getTime();				
					campanha.setFimVigencia(dt);	
				}
				
			}
			
			// SALVA A NOVA CAMPANHA
			dao.save(campanha);
					
		}
		
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	
	@Override
	@Async
	public CompletableFuture<Void> deletar(Long id) {
		dao.delete(id);
		return null;
	}
	

}
