package logica.opcion;

import interfaz.InterfazMenuDirector;
import logica.menu.LogicaMenuNexo;
import logica.opcionMenu.LogicaMenuEscuela;
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
    		terminar = LogicaGestionarDirector.ejecutarOpcionMenuCrearDirector(opcion, escuela, director);
    	} while (!terminar);
    }

    public static boolean ejecutarOpcionMenuRelacionEscuela(int opcion, Escuela escuela) {
    	switch (opcion) {
    		case 1:
    			try {
    				LogicaUtil.comprobarDirector(escuela);
    				LogicaMenuNexo.gestionarDirector(escuela);
    			} catch(Exception e) {
    				crearDirector(escuela);
    			}
    			break;
    
    		case 2:
    			LogicaMenuNexo.gestionarAlumnos(escuela);
    			break;
    
    		case 3:
    			LogicaMenuNexo.gestionarProfesores(escuela);
    			break;
    
    		case 4:
    			return LogicaMenuEscuela.terminarEditar(escuela);
    
    		case 0:
    			return true;
    	}
    
    	return false;
    }
}
