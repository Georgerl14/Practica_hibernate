package logica.opcion;

import interfaz.InterfazMenuDirector;
import logica.conector.LogicaCRUD;
import logica.opcionMenu.LogicaMenuDirector;
import logica.util.LogicaUtil;
import tablas.Director;
import tablas.Escuela;

public class LogicaGestionarDirector {

	public static void editarDirector(Escuela escuela, Director director) {
        boolean terminar;

            Director dirAntigua = director;
            Director dirNueva = LogicaUtil.clonarDirector(dirAntigua);
            do {
                InterfazMenuDirector.mostrarEditarDirector(dirAntigua, dirNueva);
                int opcion = LogicaUtil.introducirOpcionNumero(0, 4);
                terminar = LogicaGestionarDirector.ejecutarOpcionMenuEditarDirector(opcion, escuela, dirNueva);
            } while (!terminar);
        
    }

	public static void eliminarDirector(Escuela escuela, Director director) {
		if (LogicaUtil.estarSeguro()) {
			LogicaCRUD.eliminarAlgo(director);

			escuela.setDirector(null);
			LogicaCRUD.actualizarAlgo(escuela);
			
			System.out.println("Se ha elimido correctemente.");
			LogicaUtil.pulsarEnter();
		}
    }

	public static boolean ejecutarOpcionMenuGestionarDirector(int opcion, Escuela escuela, Director director) {
        switch (opcion) {
		case 1: editarDirector(escuela, director);
                break;
		case 2:	eliminarDirector(escuela, director);
				return true;
		case 0:
			return true;
		}
		return false;
    }

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

	public static boolean ejecutarOpcionMenuEditarDirector(int opcion, Escuela escuela, Director director) {
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
    			return LogicaMenuDirector.terminarEditar(escuela, director);
    
    		case 0:
    			return true;
    	}
    
    	return false;
    }

}
