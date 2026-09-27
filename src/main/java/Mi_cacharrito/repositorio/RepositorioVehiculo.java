package Mi_cacharrito.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Mi_cacharrito.modelo.Vehiculo;


@Repository
public interface RepositorioVehiculo  extends JpaRepository<Vehiculo, Integer> {
	
	@Query(value = "SELECT * FROM vehiculo v WHERE v.id_tipo_vehiculo = :tipo AND v.estado = :estado", nativeQuery = true)
    List<Vehiculo> buscarPorTipoYEstado(@Param("tipo") Integer tipo, @Param("estado") String estado);
}
