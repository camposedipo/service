package br.com.tobe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tobe.core.model.entity.Volume;
import br.com.tobe.core.model.repository.VolumeRepository;
import br.com.tobe.service.VolumeService;

@Service
public class VolumeServiceImpl implements VolumeService {

	@Autowired
	VolumeRepository volumeRepository;
	
	@Override	
	public Page<Volume> obtemTodos(Pageable pageable) {
		
		Page<Volume> volume = this.volumeRepository.findAll(pageable);
		return volume; 
	}
	
	@Override
	public Volume obtemPorPedido(Long pedido_id) {
		
		Volume volume = this.volumeRepository.findOne(pedido_id);
		return volume;
		
	}

	@Override
	@Transactional
	public Volume gravar(Volume volume) {
		
		volume = this.volumeRepository.save(volume);
		return volume;
		
	}

	@Override
	@Transactional
	public void remover(Long id) {		
		
		this.volumeRepository.delete(id);
		
	}

	@Override
	public Volume obtemPorId(Long id) {
		
		Volume Volume = this.volumeRepository.findOne(id);
		return Volume;
		
	}
}
