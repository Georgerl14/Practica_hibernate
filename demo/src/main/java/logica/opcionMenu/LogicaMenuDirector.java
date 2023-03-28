package logica.opcionMenu;

import logica.conector.LogicaCRUD;
import logica.util.LogicaUtil;
import tablas.Director;
import tablas.Escuela;

public class LogicaMenuDirector {

    public static boolean terminar(Escuela escuela, Director director) {
    	if (director.getNombre().isBlank() || director.getApellido().isBlank() || director.getTelefono() == 0) {
    		System.out.println("Faltan datos por rellenar.");
    		return false;
    	} else {
    		try {
    			if (LogicaUtil.estarSeguro()) {
    				escuela.setDirector(director);
    				LogicaCRUD.actualizarAlgo(escuela);
    				System.out.println("El director se creo correctamente.");
    				LogicaUtil.pulsarEnter();
    			}
    		} catch (Exception e) {
    			System.out.println("No se pudo crear el director.");
    		}
    		return true;
    	}
    }

    public static void modificarNombre(Director director) {
    	System.out.println("Modificar nombre: ");
    	director.setNombre(LogicaUtil.introducirTexto());
    }

    public static void modificarApellido(Director director) {
    	System.out.println("Modificar apellido: ");
    	director.setApellido(LogicaUtil.introducirTexto());
    }

    public static void modificarTelefono(Director director) {
    	System.out.println("Modificar telefono: ");
    	director.setTelefono(LogicaUtil.introducirTelefono());
    }
    
}
