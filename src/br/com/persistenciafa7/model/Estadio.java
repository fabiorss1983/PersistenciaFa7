package br.com.persistenciafa7.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="ESTADIOS")
@TableGenerator(table="SEQUENCE_GENERATOR", 
				name="ESTADIO_GEN", 
				pkColumnName="seq_id", 
				valueColumnName="next_val",	
				pkColumnValue="id_estadio", 
				allocationSize=1)
public class Estadio extends BaseModel {
	
	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ESTADIO_GEN")
	private Long id;
	
	@Basic(optional = false)
	private String nome;
	
	private Integer capacidade;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	@Basic(optional = false)
	private Cidade cidade;

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

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}