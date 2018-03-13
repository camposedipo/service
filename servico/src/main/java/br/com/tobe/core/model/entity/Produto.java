package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "produto", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Produto extends AbstractEntity {
	
	@Column(nullable = false)
	Long numero;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column
	private String embalagem;
		
	@Column(name="qtunit", nullable = false, columnDefinition="FLOAT NOT NULL DEFAULT 1") 
	private Float qtunit = (float) 1;
	
	@Column(name="qtunitcx", nullable = false, columnDefinition="FLOAT NOT NULL DEFAULT 1") 
	private Float qtunitcx = (float) 1;
	
	@Column(name="multiplo", nullable = false, columnDefinition="FLOAT NOT NULL DEFAULT 1") 
	private Float multiplo = (float) 1;
		
	@Column
	private Float volume;                              
	
	@Column
	private Float peso;
	
	@Column
	private Float pesomaster;
	
	@Column(name="ativo", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'S'")  
    private char ativo = 'S';	
		
}
