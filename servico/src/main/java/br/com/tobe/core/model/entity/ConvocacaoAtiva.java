package br.com.tobe.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "convocacaoAtiva")
@Data

@EqualsAndHashCode(callSuper = false)
public class ConvocacaoAtiva extends AbstractEntity {
			
	@Column(nullable = false)
	private String CodFilial;
	
	@Column(nullable = false)
	private Long pedido;
	
	@Column(nullable = true)
	private Long separador;
	
	@Column
	private Date dtrejeicao;

	@Column
	private Date dtaceitacao;
	
	@Column(name="aceito", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char aceito = 'N';
		
}
