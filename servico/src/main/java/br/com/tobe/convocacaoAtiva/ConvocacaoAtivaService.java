package br.com.tobe.convocacaoAtiva;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConvocacaoAtivaService {
		 
	List<ConvocacaoAtiva> obterPedidoSeparar();
	
	Page<ConvocacaoAtiva> obterTudoParaConvocar(Pageable pageable);
	
	ConvocacaoAtiva gravar(ConvocacaoAtiva convocacaoAtiva) throws Exception;

	void remover(Long id);

	ConvocacaoAtiva obtemPorId(Long id);
}