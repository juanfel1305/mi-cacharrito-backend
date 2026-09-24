package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Mi_cacharrito.modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

	public List<Usuario> findByNombres(String nombres);

	public boolean existsByDocumento(String documento);

	public boolean existsByCorreo(String correo);
}