package Mi_cacharrito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Mi_cacharrito.modelo.Usuario;
import Mi_cacharrito.repositorio.RepositorioUsuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorUsuario {

	@Autowired
	private RepositorioUsuario repoUsuario;

	@PostMapping("/RegistrioUsuarios")
	public ResponseEntity<?> guardar(@RequestBody Usuario u) {

		System.out.println("CONTROLADOR NUEVO");

		if (repoUsuario.existsByDocumento(u.getDocumento())) {
			return ResponseEntity.status(409).body("Ya existe una cuenta con ese número de documento");
		}

		if (repoUsuario.existsByCorreo(u.getCorreo())) {
			return ResponseEntity.status(409).body("Ya existe una cuenta con ese correo electrónico");
		}

		Usuario guardado = repoUsuario.save(u);
		return ResponseEntity.ok(guardado);
	}
}