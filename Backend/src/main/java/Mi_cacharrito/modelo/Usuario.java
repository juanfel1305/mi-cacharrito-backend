package Mi_cacharrito.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="id")
	private Long identificacion;
	
	@Column(name="nombre",length=50,nullable=false)
	private String nombre;
	
	@Column(name="apellidos",length=50,nullable=false)
	private String apellidos;
	
	@Column(name="correo",unique = true )
	private String correo;
	
	@Column(name="fechaExpedicionLicencia")
	private Date fechaExpedicionLicencia;
	
	@Column(name="categoriaLicencia")
	private String categoriaLicencia;
	
	
	@Column(name="vigenciaLicencia")
	private Date vigenciaLicencia;

	public Usuario() {
	}

	public Usuario(Long identificacion, String nombre, String apellidos, String correo, Date fechaExpedicionLicencia,
			String categoriaLicencia, Date vigenciaLicencia) {
		
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
		this.categoriaLicencia = categoriaLicencia;
		this.vigenciaLicencia = vigenciaLicencia;
	}


	public Long getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Date getFechaExpedicionLicencia() {
		return fechaExpedicionLicencia;
	}


	public void setFechaExpedicionLicencia(Date fechaExpedicionLicencia) {
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
	}


	public String getCategoriaLicencia() {
		return categoriaLicencia;
	}


	public void setCategoriaLicencia(String categoriaLicencia) {
		this.categoriaLicencia = categoriaLicencia;
	}


	public Date getVigenciaLicencia() {
		return vigenciaLicencia;
	}


	public void setVigenciaLicencia(Date vigenciaLicencia) {
		this.vigenciaLicencia = vigenciaLicencia;
	}
	 

	
	

}
