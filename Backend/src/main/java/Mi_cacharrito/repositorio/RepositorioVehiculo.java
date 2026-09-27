package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Mi_cacharrito.modelo.Administrador;
import Mi_cacharrito.modelo.Vehiculo;

public interface RepositorioVehiculo  extends JpaRepository< Vehiculo ,Integer >{
	@Query(value = "SELECT v.* FROM vehiculo v " +
            "INNER JOIN Tipo_Vehiculo t ON v.Id_Tipo_Vehiculo = t.Id_Tipo_Vehiculo " +
            "WHERE t.Id_Tipo_Vehiculo = :idTipoVehiculo AND v.Estado = 'Disponible'",
    nativeQuery = true)
public List<Vehiculo> obtenerVehiculosDisponiblesPorTipo(@Param("idTipoVehiculo") Integer idTipoVehiculo);

}
