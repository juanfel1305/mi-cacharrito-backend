package Mi_cacharrito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




public class Usuario {
	
	@Autowired
	private Usuario repoUsuario;

	
	@PostMapping("/guardarUsuario/")
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario u){
	    
		repoUsuario.save(u);
	    
	    return ResponseEntity.ok(u);
	}


}




		

