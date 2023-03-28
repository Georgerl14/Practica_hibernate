package logica.opcion;

import interfaz.InterfazMenuAlumno;
import interfaz.InterfazMenuDirector;
import logica.LogicaGeneral;
import logica.LogicaUtil;
import tablas.Director;
import tablas.Escuela;

public class LogicaGestionarEscuela {

    public static void crearDirector(Escuela escuela) {
    	Director director = new Director();
    
    	int opcion;
    	boolean terminar;
    	do {
    		InterfazMenuDirector.mostrarCrearDirector(director);
    		opcion = LogicaUtil.introducirOpcionNumero(0, 4);
    		terminar = LogicaGeneral.ejecutarOpcionMenuCrearDirector(opcion, escuela, director);
    	} while (!terminar);
    }

    public static void gestionarDirector(Escuela escuela) {
        System.out.println("gestionarDirector");
    }

    public static void gestionarAlumnos(Escuela escuela) { 
    	int opcion;
    	boolean terminar;
    	do {
            InterfazMenuAlumno.mostrarAlumnos(escuela);
    		InterfazMenuAlumno.mostrarGestionarAlumno(escuela);
    		opcion = LogicaUtil.introducirOpcionNumero(0, 4);
    		terminar = LogicaGeneral.ejecutarOpcionMenuGestionarAlumno(opcion, escuela);
    	} while (!terminar);
    }

    public static void gestionarProfesores(Escuela escuela) {
        System.out.println("gestionarProfesores");
    }
    
}
