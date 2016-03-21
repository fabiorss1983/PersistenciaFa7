package br.com.persistenciafa7.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="JOGADORES")
@TableGenerator(table = "SEQUENCE_GENERATOR", 
				name = "PESSOA_GEN", 
				pkColumnName = "seq_id", 
				valueColumnName = "next_val", 
				pkColumnValue = "id_pessoa", 
				allocationSize = 1)
@PrimaryKeyJoinColumn(name="id")
public class Jogador extends Pessoa {

	private static final long serialVersionUID = -2253456062069161346L;
	
	@Basic(optional = false)
	private String posicao;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="jogadores")
	private Collection<Partida> partidas;

	public Jogador(String nome, String posicao, Time time) {
		this.nome = nome;
		this.posicao = posicao;
		this.time  = time;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Collection<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(Collection<Partida> partidas) {
		this.partidas = partidas;
	}
}