package logica.opcion;

import logica.opcionMenu.LogicaMenuDirector;
import tablas.Director;
import tablas.Escuela;

public class LogicaGestionarDirector {

    public static boolean ejecutarOpcionMenuCrearDirector(int opcion, Escuela escuela, Director director) {
    	switch (opcion) {
    		case 1:
    			LogicaMenuDirector.modificarNombre(director);
    			break;
    
    		case 2:
    			LogicaMenuDirector.modificarApellido(director);
    			break;
    
    		case 3:
    			LogicaMenuDirector.modificarTelefono(director);
    			break;
    
    		case 4:
    			return LogicaMenuDirector.terminar(escuela, director);
    
    		case 0:
    			return true;
    	}
    
    	return false;
    }

    public static boolean ejecutarOpcionMenuGestionarDirector(int opcion, Escuela escuela) {
        return false;
    }
    
}
