package br.com.campanha.service;

import java.util.List;

import br.com.campanha.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listarTodos();
	
	public Usuario getById(Long idUsuario);
	
	public void salvarOuAtualizar(Usuario usuario);
	
	public void deletar(Long idUsuario);
	
	

}
