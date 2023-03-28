package logica.opcion;

import interfaz.InterfazMenuDirector;
import logica.LogicaGeneral;
import logica.util.LogicaUtil;
import tablas.Director;
import tablas.Escuela;

public class LogicaGestionarRelacion {

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
}
