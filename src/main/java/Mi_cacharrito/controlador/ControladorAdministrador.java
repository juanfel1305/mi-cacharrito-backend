package Mi_cacharrito.controlador;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sun.jdi.FloatValue;

import Mi_cacharrito.modelo.Alquiler;
import Mi_cacharrito.modelo.Tipo_Vehiculo;
import Mi_cacharrito.modelo.Vehiculo;
import Mi_cacharrito.repositorio.RepositorioAlquiler;
import Mi_cacharrito.repositorio.RepositorioVehiculo;
import Mi_cacharrito.repositorio.RepositorioTipo_Vehiculo;

@RestController
@RequestMapping("/Admin/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAdministrador {

	
	@Autowired
    private RepositorioAlquiler repositorioAlquiler;

    @Autowired
    private RepositorioVehiculo repositorioVehiculo;
    
    @Autowired
    private RepositorioTipo_Vehiculo repositorioTipoVehiculo;
    
SergioCalderon
    @GetMapping("/vehiculos/disponibles")
    public List<Vehiculo> obtenerDisponiblesPorTipo(@RequestParam Integer tipo) {
        return repositorioVehiculo.buscarPorTipoYEstado(tipo, "DISPONIBLE");
    }
    
    @GetMapping("/alquileres/pendientes")
    public List<Alquiler> obtenerPendientes() {
        return repositorioAlquiler.findByEstado("PENDIENTE");
    }
    
    @GetMapping("/alquileres/buscar-placa/{placa}")
    public ResponseEntity<Alquiler> buscarPorPlaca(@PathVariable String placa) {
        Optional<Alquiler> alquiler = repositorioAlquiler.buscarPorPlacaYEstado(placa, "PENDIENTE");
        return alquiler.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/tipos-vehiculo")
    public ResponseEntity<List<Tipo_Vehiculo>> obtenerTiposVehiculo() {
        try {
            List<Tipo_Vehiculo> tipos = repositorioTipoVehiculo.findAll();
            return ResponseEntity.ok(tipos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    
}
