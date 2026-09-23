package Mi_cacharrito.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	//Crear endpoint /RegistrioUsuarios
	@PostMapping("/RegistrioUsuarios")
	public ResponseEntity<?> guardar(@RequestBody Usuario u){

		//validaciones
		if (u.getDocumento() == null || u.getDocumento().isBlank()) {
			return ResponseEntity.badRequest().body("El documento es obligatorio");
		}

		if (u.getNombres() == null || u.getNombres().isBlank()) {
			return ResponseEntity.badRequest().body("El nombre es obligatorio");
		}

		if (u.getApellidos() == null || u.getApellidos().isBlank()) {
			return ResponseEntity.badRequest().body("Los apellidos son obligatorios");
		}

		if (u.getCorreo() == null || u.getCorreo().isBlank()) {
			return ResponseEntity.badRequest().body("El correo es obligatorio");
		}

		if (u.getTelefono() == null || u.getTelefono().isBlank()) {
			return ResponseEntity.badRequest().body("El teléfono es obligatorio");
		}

		if (u.getPassword() == null || u.getPassword().isBlank()) {
			return ResponseEntity.badRequest().body("La contraseña es obligatoria");
		}

		//vailidacion datos duplicados
		if (repoUsuario.existsByDocumento(u.getDocumento())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un usuario registrado con ese documento");
		}

		List<Usuario> usuarios = repoUsuario.findAll();
		for (Usuario existente : usuarios) {
			if (existente.getCorreo().equalsIgnoreCase(u.getCorreo())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un usuario registrado con ese correo");
			}
		}

		//Implementacion servicio de registro
		Usuario usuarioGuardado = repoUsuario.save(u);
		return ResponseEntity.ok(usuarioGuardado);
	}
}