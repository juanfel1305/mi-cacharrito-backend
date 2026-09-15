package Mi_cacharrito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




public class ControladorUsuario {
	
	@Autowired
	private ControladorUsuario repoUsuarioControlador;

	
	@PostMapping("/guardarUsuario/")
	public ResponseEntity<ControladorUsuario> guardar(@RequestBody ControladorUsuario u){
	    
	    
	    return ResponseEntity.ok(u);
	}


}




		

