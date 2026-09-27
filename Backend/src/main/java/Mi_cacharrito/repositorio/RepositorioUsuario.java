package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Mi_cacharrito.modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

	public List<Usuario> findByNombres(String nombres);

	public boolean existsByDocumento(String documento);

	public boolean existsByCorreo(String correo);

	public Usuario findByDocumento(String documento);

	@Query(value = "SELECT * FROM usuario WHERE Id_usuario = :id", nativeQuery = true)
	public Usuario obtenerUsuarioPorId(@Param("id") Integer id);
}