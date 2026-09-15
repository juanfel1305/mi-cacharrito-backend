package Mi_cacharrito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




public class UsuarioControlador {
	
	@Autowired
	private UsuarioControlador repoUsuarioControlador;

	
	@PostMapping("/guardarUsuario/")
	public ResponseEntity<UsuarioControlador> guardar(@RequestBody UsuarioControlador u){
	    
		repoUsuarioControlador.save();
	    
	    return ResponseEntity.ok(u);
	}


}




		

