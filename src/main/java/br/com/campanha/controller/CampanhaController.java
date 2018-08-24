package br.com.campanha.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.model.Campanha;
import br.com.campanha.service.CampanhaService;
import br.com.campanha.service.CampanhaServiceImpl;

@RestController
@RequestMapping(value = "/campanhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampanhaController {
	
	@Autowired private CampanhaService service;
	
	
	@GetMapping
	public @ResponseBody CompletableFuture<List<Campanha>> listar() throws InterruptedException{
		
		return service.listarTodos().thenApplyAsync(campanhas -> {
	          return campanhas;
	        });
		
	}
	
	@GetMapping(value = "/{id}")
    public @ResponseBody CompletableFuture<Campanha> findById(@PathVariable("id") Long id) throws InterruptedException {
        return service.getById(id).thenApplyAsync(campanha -> {
          return campanha;
        });
      } 
	
	
	@PostMapping
	public @ResponseBody CompletableFuture<Void> cadastrar(@RequestBody Campanha campanha) throws InterruptedException{
		service.salvarOuAtualizar(campanha);
		return service.salvarOuAtualizar(campanha).thenApplyAsync(Void -> {
          return null;
        });
	}
	/*
	@PutMapping
	public void atualizar(@RequestBody Campanha campanha){
		service.salvarOuAtualizar(campanha);
	}
	
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Long id) {
		service.deletar(id);
	}
	*/
	

}
