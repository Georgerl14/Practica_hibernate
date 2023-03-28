package logica.opcion;

import logica.LogicaCRUD;
import logica.LogicaUtil;
import tablas.Escuela;
import tablas.EscuelaId;

public class LogicaMenuEscuela {

    public static void modificarId(Escuela escuela) {
    	System.out.println("Modificar id: ");
    	EscuelaId id = new EscuelaId(LogicaUtil.introducirOpcionIdDublicada(1, 999999));
    	escuela.setEscuelaId(id);
    }

    public static void modificarNombre(Escuela escuela) {
    	System.out.println("Modificar nombre: ");
    	escuela.setNombre(LogicaUtil.introducirOpcionTexto());
    }

    public static void modificarProvincia(Escuela escuela) {
    	System.out.println("Modificar provincia: ");
    	escuela.setProvincia(LogicaUtil.introducirOpcionTexto());
    }

    public static void modificarTelefono(Escuela escuela) {
    	System.out.println("Modificar telefono: ");
    	escuela.setTelefono(LogicaUtil.introducirOpcionTelefono());
    }

    public static boolean terminar(Escuela escuela) {
    	// Comprobar si los campos estan vacios
    	if (escuela.getNombre().isBlank() || escuela.getProvincia().isBlank() || escuela.getTelefono() == 0
    			|| escuela.getEscuelaId() == null) {
    		System.out.println("Faltan datos por rellenar.");
    		return false;
    	} else {
    		try {
    			if (LogicaUtil.estarSeguro()) {
    				LogicaCRUD.agregarAlgo(escuela);
    				System.out.println("La escuela se creo correctamente");
    				LogicaUtil.pulsarEnter();
    			}
    		} catch (Exception e) {
    			System.out.println("No se pudo crear la escuela.");
    		}
    		return true;
    	}
    }

    public static boolean terminarEditar(Escuela escuela) {
    	// Comprobar si los campos estan vacios
    	try {
    		if (LogicaUtil.estarSeguro()) {
    			LogicaCRUD.actualizarAlgo(escuela);
    			System.out.println("La escuela se ha editado correctamente.");
    			LogicaUtil.pulsarEnter();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("No se pudo editar la escuela.");
    	}
    	return true;
    }
    
}
