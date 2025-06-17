package EvaluacionContinua.AppTaller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Taller {
	
	// objeto statico para poder agregar reparaciones y clientes al instanciarlos en el taller
	private static Taller objetoTaller = new Taller();

	private final String nombre;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Reparacion> reparaciones = new ArrayList<>();
	
	public Taller() {
		this.nombre = "Taller principal";
	}
	
	public Taller(String nombre) {
		this.nombre = nombre;
	}
	
	public void registrarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void eliminarCliente(Cliente cliente) {
		this.clientes.remove(cliente);
	}

	public void registrarReparacion(Reparacion reparacion) {
		this.reparaciones.add(reparacion);
	}
	
	public void eliminarReparacion(Reparacion reparacion) {
		this.reparaciones.remove(reparacion);
	}

	//recorre la lista de reparaciones
	public void listarReparaciones() {
		for (int i = 0; i < reparaciones.size(); i++) {
			System.out.println("- - - - - - - - - ");
			System.out.println("Reparacion en vehiculo "+ (i+1));
			System.out.println(reparaciones.get(i).mostrarInfoReparacion());
			System.out.println("- - - - - - - - - ");
		}
		System.out.println();
	}

	// metodo static llamando al objeto statico de Taller para poder contar las reparaciones que existen en el taller
	public static int contarReparaciones(Taller taller) {
		return taller.getReparaciones().size();
	}
	
	public static Taller getInstancia() {
		return objetoTaller;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Reparacion> getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(List<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientes, nombre, reparaciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taller other = (Taller) obj;
		return Objects.equals(clientes, other.clientes) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(reparaciones, other.reparaciones);
	}

	@Override
	public String toString() {
		return "Taller [nombre=" + nombre + ", clientes=" + clientes + ", reparaciones=" + reparaciones + "]";
	}

}
