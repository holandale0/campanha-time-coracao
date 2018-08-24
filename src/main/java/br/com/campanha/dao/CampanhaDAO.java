package br.com.campanha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.campanha.model.Campanha;

@Repository
public interface CampanhaDAO extends CrudRepository<Campanha, Long>{

}
