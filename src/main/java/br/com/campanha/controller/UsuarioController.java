package br.com.campanha.controller;

import java.util.List;

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

import br.com.campanha.model.Usuario;
import br.com.campanha.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@Autowired private UsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity listar() {
		
		List<Usuario> lista = service.listarTodos();		
		return ResponseEntity.ok().body(lista);	
		
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity findById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(service.getById(id));
	}
	
	
	
	@PostMapping
	public void cadastrar(@RequestBody Usuario usuario){
		service.salvarOuAtualizar(usuario);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Usuario usuario){
		service.salvarOuAtualizar(usuario);
	}
	
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Long id) {
		service.deletar(id);
	}
	
	
	
	
	
	
	
}
