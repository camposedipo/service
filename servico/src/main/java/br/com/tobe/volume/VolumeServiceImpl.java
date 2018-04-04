package br.com.tobe.volume;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VolumeServiceImpl implements VolumeService {

	@Autowired
	VolumeRepository volumeRepository;
	
    private EntityManager gerenciador;
	
	public VolumeServiceImpl(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	@Override	
	public Page<Volume> obtemTodos(Pageable pageable) {
		
		Page<Volume> volume = this.volumeRepository.findAll(pageable);
		return volume; 
	}
	
	@Override	
	public List<Volume> obterPorPedido(Long numero) {
		
		return gerenciador.createQuery("FROM Volume t where t.pedido_id = :pedido_id")
		          .setParameter("pedido_id", numero).getResultList();
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
