package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Mi_cacharrito.modelo.Alquiler;
import jakarta.transaction.Transactional;


public interface RepositorioAlquiler extends JpaRepository<Alquiler, Integer>{
	@Query(value = "SELECT * FROM Alquiler WHERE Id_usuario = :id", nativeQuery = true)
	public List<Alquiler> obtenerAlquileresPorUsuario(@Param("id") Integer id);


	@Query(value = "SELECT a.* FROM alquiler a " +
	               "INNER JOIN vehiculo v ON a.id_vehiculo = v.id_vehiculo " +
	               "WHERE v.Placa = :placa AND a.estado = 'Pendiente'",
	       nativeQuery = true)
	public Alquiler buscarPorPlaca(@Param("placa") String placa);


	@Modifying
	@Transactional
	@Query(value = "UPDATE alquiler SET estado = 'Entregado', fecha_entrega = CURDATE() " +
	               "WHERE id_alquiler = :id",
	       nativeQuery = true)
	public void marcarEntregado(@Param("id") Integer id);
}
