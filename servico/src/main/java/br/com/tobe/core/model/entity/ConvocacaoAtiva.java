package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "convocacaoAtiva")
@Data

@EqualsAndHashCode(callSuper = false)
public class ConvocacaoAtiva extends AbstractEntity {
	
	@Column(nullable = false)
	Long numero;
	
	@OneToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name = "separador_id", nullable = true)
	private Usuario usuario;
	                     
	
	@Column(name="aceito", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char aceito = 'N';
		
}
