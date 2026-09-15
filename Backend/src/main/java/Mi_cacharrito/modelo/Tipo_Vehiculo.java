package Mi_cacharrito.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tipo_Vehiculo")
public class Tipo_Vehiculo {
		
		@Id
		@Column(name="Id_Tipo_Vehiculo")
		private Integer Id_Tipo_Vehiculo;

		@Column(name="Tipo_Vehiculo")
		private String Tipo_Vehiculo;
		
		@Column(name="Descripcion")
		private String Descripcion;

		public Tipo_Vehiculo() {}
		
		public Tipo_Vehiculo(Integer id_Tipo_Vehiculo, String tipo_Vehiculo, String descripcion) {
			Id_Tipo_Vehiculo = id_Tipo_Vehiculo;
			Tipo_Vehiculo = tipo_Vehiculo;
			Descripcion = descripcion;
		}

		public Integer getId_Tipo_Vehiculo() {
			return Id_Tipo_Vehiculo;
		}

		public void setId_Tipo_Vehiculo(Integer id_Tipo_Vehiculo) {
			Id_Tipo_Vehiculo = id_Tipo_Vehiculo;
		}

		public String getTipo_Vehiculo() {
			return Tipo_Vehiculo;
		}

		public void setTipo_Vehiculo(String tipo_Vehiculo) {
			Tipo_Vehiculo = tipo_Vehiculo;
		}

		public String getDescripcion() {
			return Descripcion;
		}

		public void setDescripcion(String descripcion) {
			Descripcion = descripcion;
		}
}
