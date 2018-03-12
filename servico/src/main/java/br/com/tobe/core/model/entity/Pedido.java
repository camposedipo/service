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
	
	@OneToOne
	@JoinColumn(name = "carga_id", nullable = true)
	private Carga carga;
	
	@OneToOne
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario separador_id;

	@Column(nullable = false)
	private Float totalPeso;	
	
	@Column(nullable = false)
	private Float totalVolume;
	
	@Column
	private Date dtinicio;
	
	@Column
	private Date dtfim;
	
	@Column
	private Long codSeparador;
	
	@Column
	private String posicao;	
}
