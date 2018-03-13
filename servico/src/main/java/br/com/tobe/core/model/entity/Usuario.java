package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Usuario extends AbstractEntity {
	
	@Column(nullable = false)
	String numero;

	@Column(nullable = false)
	String nome;
		
	@Column(nullable = false)
	String senha;
	
	@Column(name="ativo", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'S'")    
    private char ativo = 'S';
}
