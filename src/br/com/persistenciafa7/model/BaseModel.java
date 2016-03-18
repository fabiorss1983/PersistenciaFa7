package br.com.persistenciafa7.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="is_ativo")
	private Boolean isAtivo;
	
}
