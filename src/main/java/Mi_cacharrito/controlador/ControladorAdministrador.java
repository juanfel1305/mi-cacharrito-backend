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
    

    
}
