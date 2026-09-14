package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Mi_cacharrito.modelo.UsuarioModelo;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModelo, Long> {

	public List<UsuarioModelo> findByNombre(String nombre);
}