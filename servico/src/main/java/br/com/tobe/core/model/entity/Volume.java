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
@Table(name = "volume" , uniqueConstraints = @UniqueConstraint(columnNames = { "pedido_id" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Volume extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "usuarioGerador_id", nullable = false)
	private Usuario usuarioGerador;
	
	@ManyToOne
	@JoinColumn(name = "usuarioAgrupador_id", nullable = true)
	private Usuario usuarioAgrupador;
		
	@Column(length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char volumesAgrupados = 'N';
	
	@Column(length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char volumesEmbarcados = 'N';
	
	@Column(nullable = false)
	Long qtdeTotalVolumes;
	
	@Column
	Long qtdeVolumesInformados;
		
}
