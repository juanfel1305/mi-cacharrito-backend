package Mi_cacharrito.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import Mi_cacharrito.modelo.Administrador;
import Mi_cacharrito.modelo.Usuario;
import Mi_cacharrito.repositorio.RepositorioAdministrador;
import Mi_cacharrito.repositorio.RepositorioUsuario;
import Mi_cacharrito.modelo.Usuario;
import Mi_cacharrito.repositorio.RepositorioUsuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorUsuario {

	@Autowired
	private RepositorioUsuario repoUsuario;
	@Autowired
	private RepositorioAdministrador repoAdmin;

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

		
		Usuario usuarioEncontrado = repoUsuario.findByDocumento(u.getDocumento());

		if (usuarioEncontrado != null) {
			if (!usuarioEncontrado.getPassword().equals(u.getPassword())) {
				return ResponseEntity.status(401).body("La contraseña es incorrecta");
			}

			Map<String, Object> respuesta = new HashMap<>();
			respuesta.put("idUsuario", usuarioEncontrado.getIdUsuario());
			respuesta.put("documento", usuarioEncontrado.getDocumento());
			respuesta.put("nombres", usuarioEncontrado.getNombres());
			respuesta.put("apellidos", usuarioEncontrado.getApellidos());
			respuesta.put("correo", usuarioEncontrado.getCorreo());
			respuesta.put("rol", "USUARIO");

			return ResponseEntity.ok(respuesta);
		}

		Administrador adminEncontrado = repoAdmin.findByUsername(u.getDocumento());

		if (adminEncontrado != null) {
			if (!adminEncontrado.getPassword().equals(u.getPassword())) {
				return ResponseEntity.status(401).body("La contraseña es incorrecta");
			}

			Map<String, Object> respuesta = new HashMap<>();
			respuesta.put("idAdmin", adminEncontrado.getIdAdmin());
			respuesta.put("username", adminEncontrado.getUsername());
			respuesta.put("rol", "ADMIN");

			return ResponseEntity.ok(respuesta);
		}

		return ResponseEntity.status(404).body("No existe un usuario o administrador con esas credenciales");
	}
}