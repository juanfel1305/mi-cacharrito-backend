package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Mi_cacharrito.modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

	public List<Usuario> findByNombre(String nombre);
}