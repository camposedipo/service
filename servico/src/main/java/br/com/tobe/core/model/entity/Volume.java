package br.com.tobe.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "volume")
@Data

@EqualsAndHashCode(callSuper = false)
public class Volume extends AbstractEntity {
	
	@OneToOne
	@JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name = "usuarioGerador_id", nullable = true)
	private Usuario usuarioGerador;
	
	@OneToOne
	@JoinColumn(name = "usuarioAgrupador_id", nullable = true)
	private Usuario usuarioAgrupador;
	
	
	@Column(name="todosAgrupados", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char volumesAgrupados = 'N';
	
	@Column(name="todosEmbarcados", length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char volumesEmbarcados = 'N';
	
	@Column(nullable = false)
	Long qtdeTotalVolumes;
	
	@Column
	Long qtdeVolumesInformados;
		
}
