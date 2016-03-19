package br.com.persistenciafa7.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PESSOAS")
@TableGenerator(table="SEQUENCE_GENERATOR", 
				name="PESSOA_GEN", 
				pkColumnName="seq_id", 
				valueColumnName="next_val",	
				pkColumnValue="id_pessoa", 
				allocationSize=1)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends BaseModel {
	
	private static final long serialVersionUID = 6L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="PESSOA_GEN")
	private Long id;
	
	@Basic(optional = false)
	protected String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	protected Date dataNascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_time")
	protected Time time;

	public Pessoa(String nome, Time time) {
		this.nome = nome;
		this.time = time;
	}

	public Pessoa() {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}