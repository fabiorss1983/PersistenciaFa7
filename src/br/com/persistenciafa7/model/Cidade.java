package br.com.persistenciafa7.model;

import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "CIDADES")
@TableGenerator(table = "SEQUENCE_GENERATOR", 
				name = "CIDADE_GEN", 
				pkColumnName = "seq_id", 
				valueColumnName = "next_val", 
				pkColumnValue = "id_cidade", 
				allocationSize = 1)
public class Cidade extends BaseModel {

	private static final long serialVersionUID = 3L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "CIDADE_GEN")
	private Long id;

	@Basic(optional = false)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sigla_estado")
	@Basic(optional = false)
	private Estado estado;

	@OneToMany(mappedBy = "cidade", targetEntity = Time.class, fetch = FetchType.LAZY)
	private Collection<Time> times;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cidade")
	private Collection<Estadio> estadios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Collection<Time> getTimes() {
		return times;
	}

	public void setTimes(Collection<Time> times) {
		this.times = times;
	}

	public Collection<Estadio> getEstadios() {
		return estadios;
	}

	public void setEstadios(Collection<Estadio> estadios) {
		this.estadios = estadios;
	}
}