package br.com.persistenciafa7.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CONQUISTAS",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"id_campeonato", "id_time"})
	)
@TableGenerator(table="SEQUENCE_GENERATOR", 
				name="CONQUISTA_GEN", 
				pkColumnName="seq_id", 
				valueColumnName="next_val",	
				pkColumnValue="id_conquista", 
				allocationSize=1)
public class Conquista extends BaseModel {
	
	private static final long serialVersionUID = -7679363386554020379L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="CONQUISTA_GEN")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_time")
	@Basic(optional = false)
	private Time time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_campeonato")
	@Basic(optional = false)
	private Campeonato campeonato;
	
	private Integer quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}