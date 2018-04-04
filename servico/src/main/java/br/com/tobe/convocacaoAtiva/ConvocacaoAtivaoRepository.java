package br.com.tobe.convocacaoAtiva;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvocacaoAtivaoRepository extends JpaRepository<ConvocacaoAtiva, Long> {
		
	List<ConvocacaoAtiva> findByOrderByAceitoAsc();
	
	Page<ConvocacaoAtiva> findBy(Pageable pageable);
	
}
