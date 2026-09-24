package Mi_cacharrito.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_usuario")
	private Integer idUsuario;

	@Column(name="Documento", length=50, nullable=false, unique=true)
	private String documento;

	@Column(name="Nombres", length=50, nullable=false)
	private String nombres;

	@Column(name="Apellidos", length=50, nullable=false)
	private String apellidos;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="Fecha_expedicion_licencia")
	private Date fechaExpedicionLicencia;

	@Column(name="Categoria_licencia")
	private String categoriaLicencia;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="Fecha_vencimiento_licencia")
	private Date fechaVencimientoLicencia;

	@Column(name="Correo", unique=true)
	private String correo;

	@Column(name="Telefono")
	private String telefono;

	@Column(name="password")
	private String password;

	public Usuario() {
	}

	public Usuario(Integer idUsuario, String documento, String nombres, String apellidos,
			Date fechaExpedicionLicencia, String categoriaLicencia, Date fechaVencimientoLicencia,
			String correo, String telefono, String password) {

		this.idUsuario = idUsuario;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaExpedicionLicencia = fechaExpedicionLicencia;
		this.categoriaLicencia = categoriaLicencia;
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
		this.correo = correo;
		this.telefono = telefono;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public Date getFechaVencimientoLicencia() {
		return fechaVencimientoLicencia;
	}

	public void setFechaVencimientoLicencia(Date fechaVencimientoLicencia) {
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}