package EvaluacionContinua.AppTaller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Persona {

	private List<Vehiculo> vehiculos = new ArrayList<>();
	
	// con el metodo estatico de cuando se crea un cliente, agregarlo automaticamente al taller
	public Cliente(String nombre, String telefono) {
		super(nombre, telefono);
		Taller.getInstancia().registrarCliente(this);
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	
	public void eliminarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.remove(vehiculo);
	}

	// metodo abstracto de padre Persona. utilizando StringBuilder para que tiene aspecto de reporte. 
	@Override
	public String mostrarInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("La informacion del cliente es lo siguiente:\n");
		sb.append("El nombre del cliente es ").append(this.getNombre()).append(".\n");
		sb.append("El numero de contacto es ").append(this.getTelefono()).append(".\n");
		sb.append("Los vehiculos a nombre del cliente son:");
		for (int i = 0; i < vehiculos.size(); i++) {
			sb.append("\n- - - - - - - - - \n");
			sb.append("Vehiculo " + (i+1) + "\n");
			Vehiculo v = vehiculos.get(i);
			sb.append(v.toString());
		}
		sb.append("\n- - - - - - - - - \n");
		String string = sb.toString();
		return string;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(vehiculos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(vehiculos, other.vehiculos);
	}

	@Override
	public String toString() {
		return "Cliente [vehiculos=" + vehiculos + "]";
	}

}
