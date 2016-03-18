package br.com.persistenciafa7.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="TIMES")
@TableGenerator(table="SEQUENCE_GENERATOR", 
				name="TIME_GEN", 
				pkColumnName="seq_id", 
				valueColumnName="next_val",	
				pkColumnValue="id_time", 
				allocationSize=1)
public class Time extends BaseModel {

	private static final long serialVersionUID = 5L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="TIME_GEN")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="cidade_id")
	@Basic(optional = false)
	private Cidade cidade;
	
	@ManyToOne(targetEntity=Estadio.class)
	@JoinColumn(name="id_estadio")
	private Estadio estadio;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_time")
	private Collection<Pessoa> pessoas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Collection<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Collection<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}