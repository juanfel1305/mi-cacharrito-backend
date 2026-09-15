package Mi_cacharrito.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Alquiler")
public class Alquiler {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_alquiler")
    private Integer idAlquiler;


	@ManyToOne
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id")
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "Id_vehiculo", referencedColumnName = "Id_vehiculo")
    private Vehiculo vehiculo;

    
    @Column(name = "Fecha_inicio")
    private Date fechaInicio;

    @Column(name = "Fecha_entrega_esperada")
    private Date fechaEntregaEsperada;

    @Column(name = "Valor_alquiler")
    private float valorAlquiler;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Fecha_entrega")
    private Date fechaEntrega;

    @Column(name = "Valor_dias_extra")
    private float valorDiasExtra;

    @Column(name = "Valor_total")
    private float valorTotal;
    
    public Alquiler() {}


    public Alquiler(Integer idAlquiler, Usuario usuario, Vehiculo vehiculo, Date fechaInicio,
			Date fechaEntregaEsperada, float valorAlquiler, String estado, Date fechaEntrega, float valorDiasExtra,
			float valorTotal) {
		this.idAlquiler = idAlquiler;
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaEntregaEsperada = fechaEntregaEsperada;
		this.valorAlquiler = valorAlquiler;
		this.estado = estado;
		this.fechaEntrega = fechaEntrega;
		this.valorDiasExtra = valorDiasExtra;
		this.valorTotal = valorTotal;
	}


	public Integer getIdAlquiler() {
		return idAlquiler;
	}


	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaEntregaEsperada() {
		return fechaEntregaEsperada;
	}


	public void setFechaEntregaEsperada(Date fechaEntregaEsperada) {
		this.fechaEntregaEsperada = fechaEntregaEsperada;
	}


	public float getValorAlquiler() {
		return valorAlquiler;
	}


	public void setValorAlquiler(float valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public float getValorDiasExtra() {
		return valorDiasExtra;
	}


	public void setValorDiasExtra(float valorDiasExtra) {
		this.valorDiasExtra = valorDiasExtra;
	}


	public float getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
    
    
    
}
