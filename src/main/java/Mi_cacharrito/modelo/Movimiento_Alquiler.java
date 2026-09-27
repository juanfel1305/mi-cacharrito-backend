package Mi_cacharrito.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movimiento_Alquiler")
public class Movimiento_Alquiler {

	@Id
    @Column(name = "Id_movimiento")
    private Integer Id_movimiento;
	
	@ManyToOne
	@JoinColumn(name = "Id_alquiler", referencedColumnName = "Id_alquiler")
    private Alquiler alquiler;
	
	@ManyToOne
	@JoinColumn(name = "Id_admin", referencedColumnName = "Id_admin")
    private Administrador administrador;
	
	@Column(name = "Tipo_movimiento")
    private String Tipo_movimiento;
	
	@Column(name = "Fecha_movimiento")
    private Date Fecha_movimiento;
	
	@Column(name="Observacion")
	private String Observacion;
	
	public Movimiento_Alquiler() {}

	public Movimiento_Alquiler(Integer id_movimiento, Alquiler alquiler, Administrador administrador,
			String tipo_movimiento, Date fecha_movimiento, String observacion) {
		Id_movimiento = id_movimiento;
		this.alquiler = alquiler;
		this.administrador = administrador;
		Tipo_movimiento = tipo_movimiento;
		Fecha_movimiento = fecha_movimiento;
		Observacion = observacion;
	}

	public Integer getId_movimiento() {
		return Id_movimiento;
	}

	public void setId_movimiento(Integer id_movimiento) {
		Id_movimiento = id_movimiento;
	}

	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getTipo_movimiento() {
		return Tipo_movimiento;
	}

	public void setTipo_movimiento(String tipo_movimiento) {
		Tipo_movimiento = tipo_movimiento;
	}

	public Date getFecha_movimiento() {
		return Fecha_movimiento;
	}

	public void setFecha_movimiento(Date fecha_movimiento) {
		Fecha_movimiento = fecha_movimiento;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	
}
