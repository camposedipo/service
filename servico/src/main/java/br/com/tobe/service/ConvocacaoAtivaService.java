package br.com.tobe.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.tobe.core.model.entity.ConvocacaoAtiva;

public interface ConvocacaoAtivaService {
	
	@Query("SELECT t FROM convocacao_ativa t WHERE t.aceito = 'N'")    
	List<ConvocacaoAtiva> obterPedidoSeparar();
	
	Page<ConvocacaoAtiva> obterTudoParaConvocar(Pageable pageable);
	
	ConvocacaoAtiva gravar(ConvocacaoAtiva convocacaoAtiva) throws Exception;

	void remover(Long id);

	ConvocacaoAtiva obtemPorId(Long id);
}
