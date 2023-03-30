package logica.opcionMenu;

import java.util.Set;

import logica.conector.LogicaCRUD;
import logica.util.LogicaUtil;
import tablas.Escuela;
import tablas.Profesor;

public class LogicaMenuProfesor {
    public static void modificarId(Profesor profesor) {
    	System.out.println("Modificar id: ");
    	profesor.setId(LogicaUtil.introducirOpcionNumero(1,999999));
    }

	public static void modificarNombre(Profesor profesor) {
    	System.out.println("Modificar nombre: ");
    	profesor.setNombre(LogicaUtil.introducirNombreDirector());
    }

    public static void modificarApellido(Profesor profesor) {
    	System.out.println("Modificar apellido: ");
    	profesor.setApellido(LogicaUtil.introducirTexto());
    }

    public static void modificarSalario(Profesor profesor) {
    	System.out.println("Modificar sueldo: ");
    	profesor.setSueldo(LogicaUtil.introducirOpcionNumero(1,999999));
    }

    public static boolean terminarEditar(Escuela escuela, Profesor profesor) {
        try {
    		if (LogicaUtil.estarSeguro()) {

    			//LogicaCRUD.actualizarAlgo();
    			System.out.println("El director se ha editado correctamente.");
    			LogicaUtil.pulsarEnter();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("No se pudo editar el director.");
    	}
    	return true;
    }

    public static boolean terminar(Escuela escuela, Profesor profesor) {
    	if (profesor.getNombre().isBlank() || profesor.getApellido().isBlank() || profesor.getSueldo() == 0) {
    		System.out.println("Faltan datos por rellenar.");
    		return false;
    	} else {
    		try {
    			if (LogicaUtil.estarSeguro()) {
                    profesor.getEscuelas().add(escuela);
                    escuela.getProfesores().add(profesor);

    				LogicaCRUD.actualizarAlgo(escuela);
    				System.out.println("El profesor se creo correctamente.");
    				LogicaUtil.pulsarEnter();
    			}
    		} catch (Exception e) {
    			System.out.println("No se pudo crear el profesor.");
    		}
    		return true;
    	}
    }
}
