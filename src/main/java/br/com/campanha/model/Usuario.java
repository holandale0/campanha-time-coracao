package br.com.campanha.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5076489411382244321L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="usuario_id_seq")
	@SequenceGenerator(name="usuario_id_seq", sequenceName="usuario_id_seq", allocationSize=1)
	private Long idUsuario;
	
	@Column 
	private String nome;
	
	@Column 
	private String email;
	
	@Column 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	
	@Column 
	private Long idCampanha;
	
	//@ManyToOne
	//@JoinColumn(name = "id_time")
	///@JsonManagedReference
	//private Time time;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_campanha")
	//@JsonBackReference
	//private Campanha campanha;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}
	
	

	//public Time getTime() {
	//	return time;
	//}

	//public void setTime(Time time) {
	//	this.time = time;
	//}

	//public Campanha getCampanha() {
	//	return campanha;
	//}

	//public void setCampanha(Campanha campanha) {
	//	this.campanha = campanha;
	//}
	
	
	

}
