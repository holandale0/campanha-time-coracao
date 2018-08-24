package br.com.campanha.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import br.com.campanha.model.Campanha;

public interface CampanhaService {
	
	
	CompletableFuture<List<Campanha>> listarTodos() throws InterruptedException;
	
	CompletableFuture<Campanha> getById(Long idCampanha) throws InterruptedException;
	
	CompletableFuture<Void> salvarOuAtualizar(Campanha campanha) throws InterruptedException;
	
	CompletableFuture<Void> deletar(Long idCampanha) throws InterruptedException;
		
	
}
