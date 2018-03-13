package br.com.tobe.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "carga", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Carga extends AbstractEntity {
	@Column(nullable = false)
	Long numero;

	@Column
	private Float totalPeso;	
	
	@Column
	private Float totalVolume;
	
	@Column
	private Date dtinicio;
	
	@Column
	private Date dtfim;
	
	@Column
	private Long codveiculo;
	
	@Column
	private String posicao;
	
	@Column
	private String destino;
	
	@Column
	private String box;
	
	@Column
	private String placa;
	
	@Column(name="separado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char separado = 'N';
	
	@Column(name="conferido", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char conferido = 'N';
	
	@Column(name="agrupado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char agrupado = 'N';
	
}
