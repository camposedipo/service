package br.com.tobe.endereco; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.tobe.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "endereco", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Endereco extends AbstractEntity {
	
	@Column(nullable = false)
	private Long numero;
	
	@Column(nullable = false)
	private Long empresa_id;
	
	@Column(nullable = false)
	private Long deposito;
	
	@Column(nullable = false)
	private Long rua;
	
	@Column(nullable = false)
	private Long predio;			
	
	@Column(nullable = false)
	private Long nivel;
	
	@Column(nullable = false)
	private Long apto;
	
	@Column(name="tipoEndereco", nullable = false, columnDefinition="VARCHAR NOT NULL DEFAULT 'AP' ")	
	private String tipoEndereco;
		
	@Column(name="bloqueado", nullable = false, columnDefinition="VARCHAR NOT NULL DEFAULT 'N' ")
	private String bloqueado;
	
	@Column(name="situacao", nullable = false, columnDefinition="VARCHAR NOT NULL DEFAULT 'L' ")
	private String situacao;
	
	@Column(name="tipoEstoque", nullable = false, columnDefinition="VARCHAR NOT NULL DEFAULT 'N' ")
	private String tipoEstoque;
	
	@Column(nullable = false)
	private Long estrutura_id;
		
}
