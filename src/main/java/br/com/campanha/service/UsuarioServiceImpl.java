package br.com.campanha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanha.dao.UsuarioDAO;
import br.com.campanha.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired private UsuarioDAO dao;
	
	@Override
	public List<Usuario> listarTodos() {

		return (List<Usuario>) dao.findAll();
		
	}

	@Override
	public Usuario getById(Long idUsuario) {

		return dao.findOne(idUsuario);
	}

	@Override
	public void salvarOuAtualizar(Usuario usuario) {
		dao.save(usuario);
		
	}

	@Override
	public void deletar(Long idUsuario) {
		dao.delete(idUsuario);
		
	}

}
