package br.com.persistenciafa7.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="CAMPEONATOS")
@TableGenerator(table="SEQUENCE_GENERATOR", 
				name="CAMPEONATO_GEN", 
				pkColumnName="seq_id", 
				valueColumnName="next_val",	
				pkColumnValue="id_campeonato", 
				allocationSize=1)
public class Campeonato extends BaseModel {

	private static final long serialVersionUID = -9054234433407220861L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="CAMPEONATO_GEN")
	private Long id;
	
	@Basic(optional = false)
	private String nome;
	
	@Basic(optional = false)
	private Double premiacao;

	public Campeonato(String nome, double premiacao) {
		this.nome = nome;
		this.premiacao = premiacao;
	}
	
	public Campeonato() {
	}

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

	public Double getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(Double premiacao) {
		this.premiacao = premiacao;
	}
}