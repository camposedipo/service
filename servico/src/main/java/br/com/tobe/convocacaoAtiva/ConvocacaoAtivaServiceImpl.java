package br.com.tobe.convocacaoAtiva;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConvocacaoAtivaServiceImpl implements ConvocacaoAtivaService {

	@Autowired
	ConvocacaoAtivaoRepository convocacaoAtivaRepository;
	
	private EntityManager gerenciador;
	
	public ConvocacaoAtivaServiceImpl(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	@Override
	public List<ConvocacaoAtiva> obterPedidoSeparar() {
		
		Query query = gerenciador.createQuery("SELECT t FROM ConvocacaoAtiva t where t.aceito = 'N'");
		query.setMaxResults(1);		
		return query.getResultList();
		
//		List<ConvocacaoAtiva> pedidoConvocar = this.convocacaoAtivaRepository.findByOrderByAceitoAsc();
//		return pedidoConvocar;
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
