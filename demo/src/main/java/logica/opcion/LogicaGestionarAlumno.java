package logica.opcion;

import interfaz.InterfazMenuAlumno;
import logica.util.LogicaUtil;
import tablas.Alumno;
import tablas.Escuela;

public class LogicaGestionarAlumno {

    public static void crearAlumno(Escuela escuela) {
        Alumno alumno = new Alumno();
    	int opcion;
    	boolean terminar;
    	do {
    		InterfazMenuAlumno.mostrarCrearAlumno(alumno);
    		opcion = LogicaUtil.introducirOpcionNumero(0, 5);
    		terminar = LogicaGestionarAlumno.ejecutarOpcionMenuCrearAlumno(opcion, escuela);
    	} while (!terminar);
    }

    public static void editarAlumno() {
    }

    public static void eliminarAlumno() {
    }

    public static boolean ejecutarOpcionMenuCrearAlumno(int opcion, Escuela escuela) {
    	return false;
    }
    
}
