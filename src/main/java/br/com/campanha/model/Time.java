package br.com.campanha.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "time")
public class Time implements Serializable{
	

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8657684344756836049L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="time_id_time_seq")
	@SequenceGenerator(name="time_id_time_seq", sequenceName="time_id_time_seq", allocationSize=1)
	private Long idTime;

	@Column 
	private String nome;

	
	//@OneToMany(mappedBy = "campanha")
	//@JsonBackReference
	//private List<Usuario> usuarios;
	
	//@OneToMany(mappedBy = "time", fetch = FetchType.EAGER)
	//@JsonBackReference
	//private List<Campanha> campanhas;
	
	
	public Time() {
		super();
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//public List<Usuario> getUsuarios() {
	//	return usuarios;
	//}

	//public void setUsuarios(List<Usuario> usuarios) {
	//	this.usuarios = usuarios;
	//}

	//public List<Campanha> getCampanhas() {
	//	return campanhas;
	//}

	//public void setCampanhas(List<Campanha> campanhas) {
	//	this.campanhas = campanhas;
	//}


	
	
	
	
	
}
