package br.com.tobe.core.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tobe.core.model.entity.ConvocacaoAtiva;

public interface ConvocacaoAtivaoRepository extends JpaRepository<ConvocacaoAtiva, Long> {
	
	List<ConvocacaoAtiva> findByOrderByAceitoAsc();
	
	Page<ConvocacaoAtiva> findBy(Pageable pageable);
	
}
