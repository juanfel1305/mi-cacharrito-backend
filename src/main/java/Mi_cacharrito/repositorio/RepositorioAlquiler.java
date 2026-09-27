package Mi_cacharrito.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Mi_cacharrito.modelo.Alquiler;

@Repository
public interface RepositorioAlquiler extends JpaRepository<Alquiler, Integer> {
	
	Optional<Alquiler> findById(Integer idAlquiler);
	
	List<Alquiler> findByEstado(String estado);

    
    Optional<Alquiler> findByVehiculoPlacaAndEstado(String placa, String estado);
    
}
