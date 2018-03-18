package br.com.tobe.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pedido", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Pedido extends AbstractEntity {
	
	@Column(nullable = false)
	Long numero;
	
	@Column(nullable = true)
	private Long carga_id;
	
	@Column(nullable = true)
	private Long separador_id;

	@Column(nullable = false)
	private Float totalPeso;	
	
	@Column(nullable = false)
	private Float totalVolume;
	
	@Column
	private Date dtinicio;
	
	@Column
	private Date dtfim;
	
	@Column
	private String posicao;	
	
	@Column(name="separado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char separado = 'N';
	
	@Column(name="conferido", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char conferido = 'N';
	
	@Column(name="agrupado", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")    
    private char agrupado = 'N';
}
