package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "nome" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Usuario extends AbstractEntity {
	
	@Column(nullable = false)
	String nome;
		
	@Column(nullable = false)
	String senha;
	
	@Column(nullable = true)
	String email;
	
	@Column(name="ativo", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'S'")    
    private char ativo = 'S';
	
	@Column(name="conectado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char conectado = 'N';
	
	@Column(name="numeroConexao", length = 2, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 1")    
    private int numeroConexao = 1;
	
}
