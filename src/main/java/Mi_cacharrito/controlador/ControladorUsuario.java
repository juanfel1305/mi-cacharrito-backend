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

		if (repoUsuario.existsByDocumento(u.getDocumento())) {
			return ResponseEntity.status(409).body("Ya existe una cuenta con ese número de documento");
		}

		if (repoUsuario.existsByCorreo(u.getCorreo())) {
			return ResponseEntity.status(409).body("Ya existe una cuenta con ese correo electrónico");
		}

		Usuario guardado = repoUsuario.save(u);
		return ResponseEntity.ok(guardado);
	}

	@PostMapping("/IniciarSesion")
	public ResponseEntity<?> iniciarSesion(@RequestBody Usuario u) {

		Usuario encontrado = repoUsuario.findByDocumento(u.getDocumento());

		if (encontrado == null) {
			return ResponseEntity.status(404).body("No existe un usuario con ese documento");
		}

		if (!encontrado.getPassword().equals(u.getPassword())) {
			return ResponseEntity.status(401).body("La contraseña es incorrecta");
		}

		// Se devuelve el usuario sin la contraseña
		Usuario respuesta = new Usuario(encontrado.getIdUsuario(), encontrado.getDocumento(),
				encontrado.getNombres(), encontrado.getApellidos(), encontrado.getFechaExpedicionLicencia(),
				encontrado.getCategoriaLicencia(), encontrado.getFechaVencimientoLicencia(),
				encontrado.getCorreo(), encontrado.getTelefono(), null);

		return ResponseEntity.ok(respuesta);
	}
}