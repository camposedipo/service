package br.com.tobe.empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.tobe.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "empresa", uniqueConstraints = @UniqueConstraint(columnNames = { "numero" }))
@Data

@EqualsAndHashCode(callSuper = false)
public class Empresa extends AbstractEntity {
	
	@Column(nullable = false)
	Long numero;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column
	private String endereco;
	
	@Column
	private String bairro;
	
	@Column
	private String cep;			
	
	@Column
	private String uf;
	
	@Column
	private String cidade;
		
}
