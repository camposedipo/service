package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "itensPedido", uniqueConstraints = @UniqueConstraint(columnNames = { "pedido_id", "produto_id" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class ItensPedido extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "separador_id", nullable = true)
	private Usuario separador;
	
	@Column(nullable = false)
	private Float qtcx;	
	
	@Column(nullable = false)
	private Float qtun;
	
	@Column
	private Float qtseparada;
	
	@Column
	private Float qtconferida;                              
	
	@Column(name="separado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char separado = 'N';
	
	@Column(name="conferido", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char conferido = 'N';
	
}
