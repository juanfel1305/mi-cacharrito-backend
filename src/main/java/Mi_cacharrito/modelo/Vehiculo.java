package Mi_cacharrito.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @Column(name = "Id_vehiculo")
    private Integer Id_vehiculo;

    @Column(name = "Placa")
    private String Placa;

    @Column(name = "Marca")
    private String Marca;

    @Column(name = "Modelo")
    private String Modelo;

    @Column(name = "Color")
    private String Color;

    @Column(name = "Estado")
    private String Estado;

    @ManyToOne
    @JoinColumn(name = "Id_Tipo_Vehiculo")
    private Tipo_Vehiculo tipoVehiculo;

    public Vehiculo() {}

    public Vehiculo(Integer id_vehiculo, String placa, String marca, String modelo,
                     String color, String estado, Tipo_Vehiculo tipoVehiculo) {
        Id_vehiculo = id_vehiculo;
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Color = color;
        Estado = estado;
        this.tipoVehiculo = tipoVehiculo;
    }

	public Integer getId_vehiculo() {
		return Id_vehiculo;
	}

	public void setId_vehiculo(Integer id_vehiculo) {
		Id_vehiculo = id_vehiculo;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Tipo_Vehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Tipo_Vehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

  
}