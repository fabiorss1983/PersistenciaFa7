package br.com.persistenciafa7.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ESTADOS")
public class Estado extends BaseModel {

	private static final long serialVersionUID = 2L;
	
	@Id
	@Basic(optional = false)
	private String sigla;
	
	@Basic(optional = false)
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Cidade.class)
	@JoinColumn(name="sigla_estado")
	private Collection<Cidade> cidades;
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}
}