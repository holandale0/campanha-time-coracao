package br.com.campanha.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "campanha")
public class Campanha implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5049389033091680279L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="campanha_id_seq")
	@SequenceGenerator(name="campanha_id_seq", sequenceName="campanha_id_seq", allocationSize=1)
	private Long idCampanha;
	
	@Column 
	private String nome;
	
	@Column 
	private Long idTime;
	
	
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "id_time")
	//@JsonManagedReference
	//private Time time;
	
	@Column 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date inicioVigencia;
	
	@Column 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fimVigencia;
	
	
	@Column 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ultimaAlteracao;
	
	//@OneToMany(mappedBy = "campanha")
	//@JsonManagedReference
	//private List<Usuario> usuarios;
	

	
	
	public Campanha() {
		
	}
	

	public Long getIdCampanha() {
		return idCampanha;
	}


	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getInicioVigencia() {
		return inicioVigencia;
	}


	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}


	public Date getFimVigencia() {
		return fimVigencia;
	}


	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}
	
	

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}




	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	
	


	//public List<Usuario> getUsuarios() {
	//	return usuarios;
	//}


	//public void setUsuarios(List<Usuario> usuarios) {
	//	this.usuarios = usuarios;
	//}


	//public Time getTime() {
	//	return time;
	//}


	//public void setTime(Time time) {
	//	this.time = time;
	//}


	public Long getIdTime() {
		return idTime;
	}


	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}


	@Override
	public String toString() {
		return "Campanha [nome da campanha=" + nome + ", time do coração=" + "" + ", início dia=" + inicioVigencia + " a "
				+ fimVigencia + "]";
	}

	
	
	

	
	
	
	
	
	
	
	
	

}
