package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "itensPedido")
@Data

@EqualsAndHashCode(callSuper = false)
public class ItensPedido extends AbstractEntity {
	@Column(nullable = false)
	Long numero;
	
	@Column(nullable = false)
	private String produto;
	
	@Column(nullable = false)
	private String separador;
	
	@Column(nullable = false)
	private String infCompleta;

	@Column(nullable = false)
	private Float qtcx;	
	
	@Column(nullable = false)
	private Float qtun;
	
	@Column
	private Float qtseparada;
		
}
