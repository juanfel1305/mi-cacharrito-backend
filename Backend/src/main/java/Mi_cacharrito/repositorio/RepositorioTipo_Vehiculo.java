package Mi_cacharrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import Mi_cacharrito.modelo.Tipo_Vehiculo;

public interface RepositorioTipo_Vehiculo  extends JpaRepository<Tipo_Vehiculo, Integer>  {
	List<Tipo_Vehiculo> findAll();
}
