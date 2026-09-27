package Mi_cacharrito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Mi_cacharrito.modelo.Administrador;
import Mi_cacharrito.modelo.Usuario;
import Mi_cacharrito.repositorio.RepositorioAdministrador;
import Mi_cacharrito.repositorio.RepositorioUsuario;

@RestController
@RequestMapping("/pacientes/p/")
@CrossOrigin (origins="http://localhost:4200", allowedHeaders = "*")
public class ControladorAdministrador {
	@Autowired
	private RepositorioAdministrador repoAdministrador;
	@Autowired
	private RepositorioUsuario repoUsuario;
	
	
	


}
