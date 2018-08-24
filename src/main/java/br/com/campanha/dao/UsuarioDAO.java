package br.com.campanha.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.campanha.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario,Long>{

}
