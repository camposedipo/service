package br.com.tobe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tobe.core.model.entity.ConvocacaoAtiva;
import br.com.tobe.core.model.repository.ConvocacaoAtivaoRepository;
import br.com.tobe.service.ConvocacaoAtivaService;

@Service
public class ConvocacaoAtivaServiceImpl implements ConvocacaoAtivaService {

	@Autowired
	ConvocacaoAtivaoRepository convocacaoAtivaRepository;
	
	@Override
	public List<ConvocacaoAtiva> obterPedidoSeparar() {
		
		List<ConvocacaoAtiva> pedidoConvocar = this.convocacaoAtivaRepository.findByOrderByAceitoAsc();
		return pedidoConvocar;
	}
	
	@Override	
	public Page<ConvocacaoAtiva> obterTudoParaConvocar(Pageable pageable) {
		
		Page<ConvocacaoAtiva> tudoParaConvocar = this.convocacaoAtivaRepository.findAll(pageable);
		return tudoParaConvocar; 
	}

	 
    @Override
	public ConvocacaoAtiva gravar(ConvocacaoAtiva convocacaoAtiva) {
		
		convocacaoAtiva = this.convocacaoAtivaRepository.save(convocacaoAtiva);
		return convocacaoAtiva;
		
	}

	@Override
	@Transactional
	public void remover(Long id) {		
		
		this.convocacaoAtivaRepository.delete(id);		
	}

	@Override
	public ConvocacaoAtiva obtemPorId(Long id) {
		
		ConvocacaoAtiva convocacaoAtiva = this.convocacaoAtivaRepository.findOne(id);
		return convocacaoAtiva;
		
	}

}
