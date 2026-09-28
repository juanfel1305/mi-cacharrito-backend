package Mi_cacharrito.controlador;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Mi_cacharrito.modelo.Alquiler;
import Mi_cacharrito.repositorio.RepositorioAlquiler;


@RestController
@RequestMapping("/Alquileres/a/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAlquiler {

	@Autowired
    private RepositorioAlquiler alquilerRepositorio;

	@GetMapping("/listarTodos/")
	public List<Alquiler> obtenerTodos() {
	    return alquilerRepositorio.findAll();
	}
}
