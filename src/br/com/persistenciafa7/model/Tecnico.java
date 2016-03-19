package br.com.persistenciafa7.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="TECNICOS")
@TableGenerator(table = "SEQUENCE_GENERATOR", 
				name = "PESSOA_GEN", 
				pkColumnName = "seq_id", 
				valueColumnName = "next_val", 
				pkColumnValue = "id_pessoa", 
				allocationSize = 1)
@PrimaryKeyJoinColumn(name="id")
public class Tecnico extends Pessoa {
	private static final long serialVersionUID = -2253456016069161346L;
	
	@Basic(optional = false)
	private String especializacao;

	public Tecnico(String nome, String especializacao, Time time) {
		this.nome = nome;
		this.especializacao = especializacao;
		this.time = time;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
}