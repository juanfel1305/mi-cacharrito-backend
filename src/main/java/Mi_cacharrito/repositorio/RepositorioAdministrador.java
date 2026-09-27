package Mi_cacharrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import Mi_cacharrito.modelo.Administrador;

public interface RepositorioAdministrador extends JpaRepository<Administrador, Integer> {

	    public Administrador findByUsername(String username);
	
}
