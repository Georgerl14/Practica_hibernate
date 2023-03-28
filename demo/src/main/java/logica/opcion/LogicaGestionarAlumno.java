package logica.opcion;

import interfaz.InterfazMenuAlumno;
import logica.LogicaGeneral;
import logica.LogicaUtil;
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
    		terminar = LogicaGeneral.ejecutarOpcionMenuCrearEscuela(opcion, escuela);
    	} while (!terminar);
    }

    public static void editarAlumno() {
    }

    public static void eliminarAlumno() {
    }
    
}
