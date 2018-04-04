package br.com.tobe.volume;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeRepository extends JpaRepository<Volume, Long> {	
	
	Page<Volume> findBy(Pageable pageable);
	
}
