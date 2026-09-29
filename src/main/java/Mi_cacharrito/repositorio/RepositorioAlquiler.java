package Mi_cacharrito.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Mi_cacharrito.modelo.Alquiler;

@Repository
public interface RepositorioAlquiler extends JpaRepository<Alquiler, Integer> {
	
Optional<Alquiler> findById(Integer idAlquiler);
	
	List<Alquiler> findByEstado(String estado);

    
	@Query(value = "SELECT a.* FROM alquiler a INNER JOIN vehiculo v ON a.id_vehiculo = v.id_vehiculo WHERE v.placa = :placa AND a.estado = :estado", nativeQuery = true)
	Optional<Alquiler> buscarPorPlacaYEstado(@Param("placa") String placa, @Param("estado") String estado);
    
}
