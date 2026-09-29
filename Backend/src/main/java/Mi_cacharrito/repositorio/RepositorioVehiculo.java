package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Mi_cacharrito.modelo.Administrador;
import Mi_cacharrito.modelo.Vehiculo;

public interface RepositorioVehiculo  extends JpaRepository< Vehiculo ,Integer >{
	@Query(value = "SELECT * FROM vehiculo WHERE Id_Tipo_Vehiculo = :id AND Estado = 'Disponible'", nativeQuery = true)
	public List<Vehiculo> obtenerDisponiblesPorTipo(@Param("id") Integer id);
}
