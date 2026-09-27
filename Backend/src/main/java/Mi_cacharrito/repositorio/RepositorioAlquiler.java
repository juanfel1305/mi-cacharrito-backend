package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Mi_cacharrito.modelo.Alquiler;


public interface RepositorioAlquiler extends JpaRepository<Alquiler, Integer>{
	@Query(value = "SELECT * FROM Alquiler WHERE Id_usuario = :id", nativeQuery = true)
	public List<Alquiler> obtenerAlquileresPorUsuario(@Param("id") Integer id);


}
