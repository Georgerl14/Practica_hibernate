package logica.opcion;

import interfaz.Interfaz;
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
    		Interfaz.mostrarCrearDirector(director);
    		opcion = LogicaUtil.introducirOpcionNumero(0, 4);
    		terminar = LogicaGeneral.ejecutarOpcionMenuCrearDirector(opcion, escuela, director);
    	} while (!terminar);
    }

    public static void gestionarDirector(Escuela escuela) {
        System.out.println("gestionarDirector");
    }
    
}
