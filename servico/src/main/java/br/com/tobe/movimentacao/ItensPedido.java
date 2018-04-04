package br.com.tobe.movimentacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.tobe.core.model.entity.AbstractEntity;
import br.com.tobe.produto.Produto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "itensPedido", uniqueConstraints = @UniqueConstraint(columnNames = { "pedido_id", "produto_id" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class ItensPedido extends AbstractEntity {
	
	@Column(name = "pedido_id", nullable = false)
	private Long pedido_id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@Column(name = "separador_id", nullable = true)
	private Long separador_id;
	
	@Column(name = "conferente_id", nullable = true)
	private Long conferente_id;
	
	@Column(nullable = false)
	private Float qtcx;	
	
	@Column(nullable = false)
	private Float qtun;
	
	@Column(nullable = false)
	private Float qt;
	
	@Column
	private Float qtseparada;
	
	@Column
	private Float qtconferida;                              
	
	@Column(name="separado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char separado = 'N';
	
	@Column(name="conferido", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char conferido = 'N';	
}
