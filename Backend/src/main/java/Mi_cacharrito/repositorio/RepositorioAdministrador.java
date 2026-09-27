package Mi_cacharrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Mi_cacharrito.modelo.Administrador;
import Mi_cacharrito.modelo.Usuario;

public interface RepositorioAdministrador  extends JpaRepository< Administrador ,Integer >{


}
