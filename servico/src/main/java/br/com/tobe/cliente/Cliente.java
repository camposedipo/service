package br.com.tobe.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.tobe.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Cliente extends AbstractEntity {
	
	@Column(nullable = false)
	private Long numero;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private String razaoSocial;
		
}
