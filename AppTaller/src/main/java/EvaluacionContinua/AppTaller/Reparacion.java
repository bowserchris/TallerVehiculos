package EvaluacionContinua.AppTaller;

import java.util.Objects;

public class Reparacion {

	private Vehiculo vehiculo;
	private String descripcion;
	private double costo;
	
	
	// llamada estatica a Taller para agregarlo automaticamente a lista de reparaciones cuando se crea una reparacion
	public Reparacion(String descripcion, double costo, String matricula, String marca, String modelo) {
		this.vehiculo = new Vehiculo(matricula, marca, modelo);
		this.descripcion = descripcion;
		this.costo = costo;
		Taller.getInstancia().registrarReparacion(this);
	}
	
	public String mostrarInfoReparacion() {
		return this.toString();
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, descripcion, vehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparacion other = (Reparacion) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(vehiculo, other.vehiculo);
	}

	@Override
	public String toString() {
		return vehiculo.mostrarInfoVehiculo() + "\nDescripcion = " + descripcion + "\nCosto = " + costo;
	}

}
