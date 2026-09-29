package Mi_cacharrito.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Mi_cacharrito.modelo.Tipo_Vehiculo;
import Mi_cacharrito.modelo.Vehiculo;
import Mi_cacharrito.repositorio.RepositorioTipo_Vehiculo;
import Mi_cacharrito.repositorio.RepositorioVehiculo;

@RestController
@RequestMapping("/Vehiculos/v/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorVehiculo {

    @Autowired
    private RepositorioVehiculo repoVehiculo;

    @Autowired
    private RepositorioTipo_Vehiculo repoTipoVehiculo;

    @GetMapping("/listarTipos/")
    public List<Tipo_Vehiculo> listarTipos() {
        return repoTipoVehiculo.findAll();
    }

    @GetMapping("/buscarDisponibles/")
    public List<Vehiculo> buscarDisponibles(@RequestParam("id") Integer id) {
        return repoVehiculo.obtenerDisponiblesPorTipo(id);
    }
}
