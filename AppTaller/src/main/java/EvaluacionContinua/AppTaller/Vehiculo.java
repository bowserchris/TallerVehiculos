package EvaluacionContinua.AppTaller;

import java.util.Objects;

public class Vehiculo {

	private final String matricula;
	private String marca;
	private String modelo;
	private Cliente propietario;
	
	public Vehiculo(String matricula, String marca, String modelo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Vehiculo(String matricula, String marca, String modelo, Cliente propietario) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.agregarPropietario(propietario);
	}

	// al agregar el propietario, aseguramos agregar la misma instancia a su lista de vehiculos
	public void agregarPropietario(Cliente propietario) {
		this.setPropietario(propietario);
		propietario.agregarVehiculo(this);
	}

	public String mostrarInfoVehiculo() {
		return this.toString();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, matricula, modelo, propietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(propietario, other.propietario);
	}

	@Override
	public String toString() {
		return "Matricula: " + this.matricula + "\nMarca: " + this.marca + "\nModelo: " + this.modelo ;
	}

}
