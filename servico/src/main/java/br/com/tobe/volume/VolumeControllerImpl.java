package br.com.tobe.volume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolumeControllerImpl implements VolumeController {

	@Autowired
	private VolumeService volumeService;

	public ResponseEntity<Page<Volume>> getAll(Pageable pageable) {
		
		Page<Volume> VolumePage = this.volumeService.obtemTodos(pageable);
		return new ResponseEntity<Page<Volume>>(VolumePage,HttpStatus.OK);
	}
	
	public ResponseEntity<List<Volume>> consultarPorPedido(@PathVariable Long numero) {
		
		List<Volume> volume = this.volumeService.obterPorPedido(numero);
		return new ResponseEntity<List<Volume>>(volume,HttpStatus.OK);
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
