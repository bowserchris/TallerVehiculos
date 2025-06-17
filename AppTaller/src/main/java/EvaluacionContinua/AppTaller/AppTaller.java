package EvaluacionContinua.AppTaller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppTaller {
	
    public static void main( String[] args ) {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	Taller taller = new Taller("Pneumoniaticos");
    	
    	//// registra clientes y vehiculos
    	
    	Cliente cliente1 = new Cliente("Jorge", "+34697854374");
    	Cliente cliente2 = new Cliente("Juanjo", "+3465478451");
    	Cliente cliente3 = new Cliente("Jose", "+34632512451");
    	Cliente cliente4 = new Cliente("Jesus", "+34632985621");
    	
    	Vehiculo vehiculo1 = new Vehiculo("HJS123", "Seat", "Ibiza", cliente1);
    	Vehiculo vehiculo2 = new Vehiculo("YUX343", "Ford", "Focus");
    	Vehiculo vehiculo3 = new Vehiculo("HJX385", "Volvo", "S60", cliente2);
    	Vehiculo vehiculo4 = new Vehiculo("KIJ475", "Volvo", "V60");
    	Vehiculo vehiculo5 = new Vehiculo("LKJ098", "Ford", "Focus", cliente3);
    	Vehiculo vehiculo6 = new Vehiculo("PFR543", "Toyota", "Corolla");
    	Vehiculo vehiculo7 = new Vehiculo("YCQ398", "Toyota", "Corolla", cliente4);
    	Vehiculo vehiculo8 = new Vehiculo("RTT398", "Toyota", "Yaris");
    	Vehiculo vehiculo9 = new Vehiculo("GHG487", "Audi", "A6");
    	Vehiculo vehiculo10 = new Vehiculo("FUH398", "Seat", "Arona");
    	
    	cliente1.agregarVehiculo(vehiculo2);
    	cliente2.agregarVehiculo(vehiculo4);
    	cliente3.agregarVehiculo(vehiculo6);
    	cliente4.agregarVehiculo(vehiculo8);
    	cliente1.agregarVehiculo(vehiculo9);
    	cliente2.agregarVehiculo(vehiculo10);
    	
    	///meter vehiculos en hashmap para el bucle despues
    	Map<String, Vehiculo> vehiculos = new HashMap<>();
    	vehiculos.put("vehiculo1", vehiculo1);
    	vehiculos.put("vehiculo2", vehiculo2);
    	vehiculos.put("vehiculo3", vehiculo3);
    	vehiculos.put("vehiculo4", vehiculo4);
    	vehiculos.put("vehiculo5", vehiculo5);
    	vehiculos.put("vehiculo6", vehiculo6);
    	vehiculos.put("vehiculo7", vehiculo7);
    	vehiculos.put("vehiculo8", vehiculo8);
    	vehiculos.put("vehiculo9", vehiculo9);
    	vehiculos.put("vehiculo10", vehiculo10);
    	
    	
    	System.out.println("Informacion sobre los clientes de " + taller.getNombre() + ":\n");
    	System.out.println(cliente1.mostrarInfo());
    	System.out.println(cliente2.mostrarInfo());
    	System.out.println(cliente3.mostrarInfo());
    	System.out.println(cliente4.mostrarInfo());
    	
    	///realiza algunas reparaciones con el scanner
    	
    	boolean exit = false;
    	
    	// primer bucle para ir añadiendo reparaciones. tiene opcion de 1-10 de los vehiculos existentes en el mapa
    	// despues el usuario tendra la opcion de seguir o no añadiendo. Si da a 2 para salir exit se convierte a true y termina el main
    	while(!exit) {
    		int eleccion = -1;
    		boolean bucle = false;
    		
    		// segundo bucle para seguir creando reparaciones. Condicion de salida es en segundo bucle interior 
    		do {
				eleccion = inputInt(scan, "¿Cual vehiculo necesita una reparacion? Opciones entre 1 a 10");
				if (eleccion >= 1 && eleccion <= 10) {
					String key = "vehiculo" + eleccion;
					Vehiculo v = vehiculos.get(key);
					String desc = inputString(scan,"¿Cual es la descripcion de la reparacion necesario?");
					double precio = inputDouble(scan, "¿Cual es el precio para las reparaciones?");
					Reparacion reparacion = new Reparacion(desc,
												precio, 
												v.getMatricula(),
												v.getMarca(), 
												v.getModelo());
				} else {
					System.out.println("Eso no es una de las opciones. Intentalo de nuevo.");
				} 
				
				// bucle 2.5 para decidir si repite operacion arriba o sale de ello. Condicion 1 = repite, 2 sale, sino repite de todos modos
				do {
					eleccion = inputInt(scan, "¿Querras hacer otras reparaciones?\n 1 = Si | 2 = No");
					if (eleccion == 2) {
						bucle = true;
					} else if (eleccion == 1) {
						System.out.println("Volveremos al principio entonces.");
					} else {
						System.out.println("Eso no es una de las opciones");
					} 
				} while (eleccion != 1 && eleccion != 2);
				
			} while (!bucle );
    		
    		exit = true;
    		
    	}
    	
    	///muestra la lista de reparaciones activas
    	
    	taller.getInstancia().listarReparaciones();
    	
    	System.out.println("¿Cuantas reparaciones estan activas? " + Taller.getInstancia().contarReparaciones(taller.getInstancia()));
    	
    }
    
    // metodos de scanner para poder hacer llamadas sin abusar espacio en el main 
    
    public static int inputInt(Scanner scan, String pregunta) {
    	System.out.println(pregunta);
    	int i = scan.nextInt();
    	return i;
    }
    
    public static String inputString(Scanner scan, String pregunta) {
    	System.out.println(pregunta);
    	String s = scan.next();
    	//scan.nextLine();		//necesario para limpiar la memoria del scanner en string, sino cogera el proximo string automaticamente
    	return s;
    }
    
    public static double inputDouble(Scanner scan, String pregunta) {
    	System.out.println(pregunta);
    	double d = scan.nextDouble();
    	return d;
    }
}
