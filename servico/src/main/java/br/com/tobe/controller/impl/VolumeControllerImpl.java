package br.com.tobe.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tobe.controller.VolumeController;
import br.com.tobe.core.model.entity.Volume;
import br.com.tobe.service.VolumeService;

@RestController
public class VolumeControllerImpl implements VolumeController {

	@Autowired
	private VolumeService volumeService;

	public ResponseEntity<Page<Volume>> getAll(Pageable pageable) {
		Page<Volume> VolumePage = this.volumeService.obtemTodos(pageable);

		return new ResponseEntity<Page<Volume>>(VolumePage,HttpStatus.OK);
	}
	
	public ResponseEntity<Page<Volume>> obtemPorPedido(@PathVariable Long pedido_id) {
		Page<Volume> VolumePage = (Page<Volume>) this.volumeService.obtemPorPedido(pedido_id);

		return new ResponseEntity<Page<Volume>>(VolumePage,HttpStatus.OK);
	}

	public ResponseEntity<Volume> saveOrCretate(@RequestBody Volume volume) throws Exception {
		volume = this.volumeService.gravar(volume);
		
		return new ResponseEntity<Volume>(volume,HttpStatus.OK);
	}

	public ResponseEntity<Void> remove(@PathVariable Long id) {
		this.volumeService.remover(id);
		
		return ResponseEntity.noContent().build();
	}

}
