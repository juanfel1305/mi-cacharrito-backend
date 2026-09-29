package Mi_cacharrito.controlador;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Mi_cacharrito.modelo.Alquiler;
import Mi_cacharrito.modelo.Tipo_Vehiculo;
import Mi_cacharrito.modelo.Vehiculo;
import Mi_cacharrito.repositorio.RepositorioAlquiler;
import Mi_cacharrito.repositorio.RepositorioVehiculo;
import Mi_cacharrito.repositorio.RepositorioTipo_Vehiculo;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAdministrador {

    @Autowired
    private RepositorioAlquiler repositorioAlquiler;

    @Autowired
    private RepositorioVehiculo repositorioVehiculo;
    
    @Autowired
    private RepositorioTipo_Vehiculo repositorioTipoVehiculo;


    // --- ALQUILERES ---

    @GetMapping("/alquileres/todos")
    public List<Alquiler> obtenerTodosLosAlquileres() {
        return repositorioAlquiler.findAll();
    }

    @GetMapping("/alquileres/pendientes")
    public List<Alquiler> obtenerPendientes() {
        return repositorioAlquiler.findByEstado("PENDIENTE");
    }

    @GetMapping("/alquileres/{idAlquiler}")
    public ResponseEntity<Alquiler> buscarPorNumero(@PathVariable Integer idAlquiler) {
        Optional<Alquiler> alquiler = repositorioAlquiler.findById(idAlquiler);
        return alquiler.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/alquileres/buscar-placa/{placa}")
    public ResponseEntity<Alquiler> buscarPorPlaca(@PathVariable String placa) {
        Optional<Alquiler> alquiler = repositorioAlquiler.buscarPorPlacaYEstado(placa, "PENDIENTE");
        return alquiler.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/alquileres/{idAlquiler}/entregar")
    public ResponseEntity<Void> marcarComoEntregado(@PathVariable Integer idAlquiler) {
        Optional<Alquiler> opt = repositorioAlquiler.findById(idAlquiler);
        if (opt.isPresent()) {
            Alquiler alquiler = opt.get();
            alquiler.setEstado("ENTREGADO");
            repositorioAlquiler.save(alquiler);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alquileres/{idAlquiler}/liberar")
    public ResponseEntity<Void> marcarComoDisponible(
            @PathVariable Integer idAlquiler,
            @RequestBody Map<String, Object> datosLiberacion) {


    
    
    
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
    
    @PutMapping("/alquileres/{idAlquiler}/entregar")
    public ResponseEntity<Void> marcarComoEntregado(@PathVariable Integer idAlquiler) {
        Optional<Alquiler> opt = repositorioAlquiler.findById(idAlquiler);
        if (opt.isPresent()) {
            Alquiler alquiler = opt.get();
            alquiler.setEstado("ENTREGADO");
            repositorioAlquiler.save(alquiler);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    @GetMapping("/alquileres/{idAlquiler}")
    public ResponseEntity<Alquiler> buscarPorNumero(@PathVariable Integer idAlquiler) {
        Optional<Alquiler> alquiler = repositorioAlquiler.findById(idAlquiler);
        return alquiler.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    @PutMapping("/alquileres/{idAlquiler}/liberar")
    public ResponseEntity<Void> marcarComoDisponible(
            @PathVariable Integer idAlquiler,
            @RequestBody Map<String, Object> datosLiberacion) {


        Optional<Alquiler> opt = repositorioAlquiler.findById(idAlquiler);
        if (opt.isPresent()) {
            Alquiler alquiler = opt.get();

            alquiler.setEstado("FINALIZADO");
            alquiler.setFechaEntrega(new Date());


            if (datosLiberacion.containsKey("valorDiasExtra") && datosLiberacion.get("valorDiasExtra") != null) {
                float diasExtra = Float.parseFloat(datosLiberacion.get("valorDiasExtra").toString());


            if (datosLiberacion.containsKey("valorDiasExtra") && datosLiberacion.get("valorDiasExtra") != null) {
                float diasExtra = ((Number) datosLiberacion.get("valorDiasExtra")).floatValue();

                alquiler.setValorDiasExtra(diasExtra);
            }

            if (datosLiberacion.containsKey("valorTotal") && datosLiberacion.get("valorTotal") != null) {

                float total = Float.parseFloat(datosLiberacion.get("valorTotal").toString());

                float total = ((Number) datosLiberacion.get("valorTotal")).floatValue();

                alquiler.setValorTotal(total);
            }

            repositorioAlquiler.save(alquiler);


            Vehiculo vehiculo = alquiler.getVehiculo();
            if (vehiculo != null) {
                vehiculo.setEstado("DISPONIBLE");
                repositorioVehiculo.save(vehiculo);
            }

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    // --- VEHÍCULOS ---

    @GetMapping("/vehiculos/todos")
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return repositorioVehiculo.findAll();
    }

    @GetMapping("/vehiculos/disponibles")
    public List<Vehiculo> obtenerDisponiblesPorTipo(@RequestParam Integer tipo) {
        return repositorioVehiculo.buscarPorTipoYEstado(tipo, "DISPONIBLE");
    }

    @PostMapping("/vehiculos/registrar")
    public ResponseEntity<?> registrarVehiculo(@RequestBody Map<String, Object> payload) {
        try {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca((String) payload.get("placa"));
            vehiculo.setMarca((String) payload.get("marca"));
            vehiculo.setModelo((String) payload.get("modelo"));
            vehiculo.setColor((String) payload.get("color"));
            vehiculo.setEstado("DISPONIBLE");

            if (payload.get("precioDia") != null) {
                vehiculo.setPrecioDia(Float.parseFloat(payload.get("precioDia").toString()));
            }

            if (payload.get("idTipoVehiculo") != null) {
                Integer idTipo = Integer.parseInt(payload.get("idTipoVehiculo").toString());
                Optional<Tipo_Vehiculo> tipoOpt = repositorioTipoVehiculo.findById(idTipo);
                
                if (tipoOpt.isPresent()) {
                    vehiculo.setTipoVehiculo(tipoOpt.get());
                } else {
                    return ResponseEntity.badRequest().body("El tipo de vehículo no existe.");
                }
            }

            Vehiculo guardado = repositorioVehiculo.save(vehiculo);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al registrar el vehículo: " + e.getMessage());
        }
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

    
}

