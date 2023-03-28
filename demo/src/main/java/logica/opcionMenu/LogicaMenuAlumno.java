package logica.opcionMenu;

import java.util.List;

import logica.conector.LogicaCRUD;
import logica.util.LogicaUtil;
import tablas.Alumno;
import tablas.Escuela;

public class LogicaMenuAlumno {

    public static void modificarNombre(Alumno alumno) {
        System.out.println("Modificar nombre: ");
        alumno.setNombre(LogicaUtil.introducirTexto());
    }

    public static void modificarPrimerApellido(Alumno alumno) {
        System.out.println("Modificar primer apellido: ");
        alumno.setPrimerApellido(LogicaUtil.introducirTexto());
    }

    public static void modificarSegundoApellido(Alumno alumno) {
        System.out.println("Modificar segundo apellido: ");
        alumno.setSegundoApellido(LogicaUtil.introducirTexto());
    }

    public static void modificarCodigoPostal(Alumno alumno) {
        System.out.println("Modificar codigo postal: ");
        alumno.setCodigoPostal(LogicaUtil.introducirOpcionNumero(10000, 99999));
    }

    public static boolean terminar(Escuela escuela, Alumno alumno) {
        if (alumno.getNombre().isBlank() || alumno.getPrimerApellido().isBlank()
                || alumno.getSegundoApellido().isBlank()
                || alumno.getCodigoPostal() == 0) {
            System.out.println("Faltan datos por rellenar.");
            return false;
        } else {
            try {
                if (LogicaUtil.estarSeguro()) {
                    alumno.setEscuela(escuela);
                    List<Alumno> alumnoList = escuela.getListaAlumno();
                    alumnoList.add(alumno);
                    escuela.setListaAlumno(alumnoList);

                    LogicaCRUD.actualizarAlgo(escuela);
                    System.out.println("El alumno se creo correctamente");
                    LogicaUtil.pulsarEnter();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se pudo crear el alumno.");
            }
            return true;
        }
    }

    public static boolean terminarEditar(Alumno alumno) {
        try {
    		if (LogicaUtil.estarSeguro()) {
    			LogicaCRUD.actualizarAlgo(alumno);
    			System.out.println("El alumno se ha editado correctamente.");
    			LogicaUtil.pulsarEnter();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("No se pudo editar el alumno.");
    	}
    	return true;
    }

}
