package Mi_cacharrito.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Mi_cacharrito.modelo.Vehiculo;
import Mi_cacharrito.repositorio.RepositorioVehiculo;

public class ControladorVehiculo {
	@Autowired
	private RepositorioVehiculo repoVehiculo;

	@GetMapping("/vehiculos/disponibles/{idTipoVehiculo}")
	public ResponseEntity<List<Vehiculo>> obtenerVehiculosDisponiblesPorTipo(@PathVariable Integer idTipoVehiculo) {
	    List<Vehiculo> vehiculos = repoVehiculo.obtenerVehiculosDisponiblesPorTipo(idTipoVehiculo);
	    if (vehiculos.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(vehiculos);
	}

}
