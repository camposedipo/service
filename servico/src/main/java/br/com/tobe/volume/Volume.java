package br.com.tobe.volume;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.tobe.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "volume" , uniqueConstraints = @UniqueConstraint(columnNames = { "pedido_id" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Volume extends AbstractEntity {
	
	@Column(name = "pedido_id", nullable = false)
	private Long pedido_id;
	
	@Column(name = "usuarioGerador_id", nullable = false)
	private Long usuarioGerador_id;
	
	@Column(name = "usuarioAgrupador_id", nullable = true)
	private Long usuarioAgrupador_id;
		
	@Column(length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char volumesAgrupados = 'N';
	
	@Column(length = 1, nullable = false, columnDefinition="CHAR NOT NULL DEFAULT 'N'")  
    private char volumesEmbarcados = 'N';
	
	@Column(nullable = false)
	Long qtdeTotalVolumes;
	
	@Column
	Long qtdeVolumesInformados;
	
	@Column
	private Date dtgeracao;
		
}
