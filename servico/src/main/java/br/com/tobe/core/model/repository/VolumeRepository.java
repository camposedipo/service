package br.com.tobe.core.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tobe.core.model.entity.Volume;

public interface VolumeRepository extends JpaRepository<Volume, Long> {	
	
	Page<Volume> findBy(Pageable pageable);
	
}
