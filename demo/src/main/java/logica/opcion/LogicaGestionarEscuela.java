package logica.opcion;

import interfaz.InterfazMenuEscuela;
import logica.conector.LogicaCRUD;
import logica.menu.LogicaMenuNexo;
import logica.opcionMenu.LogicaMenuEscuela;
import logica.util.LogicaUtil;
import tablas.Escuela;

public class LogicaGestionarEscuela {

    public static void crearEscuela() {
    	Escuela escuela = new Escuela();
    	int opcion;
    	boolean terminar;
    	do {
    		InterfazMenuEscuela.mostrarCrearEscuela(escuela);
    		opcion = LogicaUtil.introducirOpcionNumero(0, 5);
    		terminar = LogicaGestionarEscuela.ejecutarOpcionMenuCrearEscuela(opcion, escuela);
    	} while (!terminar);
    }

    public static void editarEscuela() {
    	boolean terminar;
    
    	System.out.println("¿Qué escuela quiere editar?");
    	System.out.println("n. Id de la escuela a editar");
    	System.out.println(".....");
    	System.out.println("0. Volver");
    
    	int opcion = LogicaUtil.introducirOpcionNumero(0, 9999999);
    	if (opcion != 0) {
    		opcion = LogicaUtil.introducirOpcionIdExistente(opcion);
    		Escuela escAntigua = LogicaCRUD.buscarEscuela(opcion);
    		Escuela escNueva = LogicaUtil.clonarEscuela(escAntigua);
    		do {
    			InterfazMenuEscuela.mostrarEditarEscuela(escAntigua, escNueva);
    			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
    			terminar = LogicaGestionarEscuela.ejecutarOpcionMenuEditarEscuela(opcion, escNueva);
    		} while (!terminar);
    
    	}
    }

	public static void eliminarEscuela() {
    	System.out.println("¿Qué escuela quiere eliminar?");
    	System.out.println("n. Id de la escuela a eliminar");
    	System.out.println(".....");
    	System.out.println("0. Volver");
    
    	int opcion = LogicaUtil.introducirOpcionNumero(0, 9999999);
    	if (opcion != 0) {
    		opcion = LogicaUtil.introducirOpcionIdExistente(opcion);
    
    		Escuela escuela = LogicaCRUD.buscarEscuela(opcion);
    		if (LogicaUtil.estarSeguro()) {
    			LogicaCRUD.eliminarAlgo(escuela);
    			System.out.println("Se ha elimido correctemente.");
    			LogicaUtil.pulsarEnter();
    		}
    	}
    }

	public static void ejecutarOpcionMenuGestionarEscuela(int opcion) {
		// Realizar la opción que sea necesaria.
		switch (opcion) {
			case 1:
				crearEscuela();
				break;
	
			case 2:
				editarEscuela();
				break;
	
			case 3:
				eliminarEscuela();
				break;
	
			case 4:
				LogicaMenuNexo.gestionarRelacion();
				break;
	
			case 0:
				LogicaUtil.salir();
				break;
		}
	}

    public static boolean ejecutarOpcionMenuCrearEscuela(int opcion, Escuela escuela) {
    	// Realizar la opción que sea necesaria.
    	switch (opcion) {
    		case 1:
    			LogicaMenuEscuela.modificarId(escuela);
    			break;
    
    		case 2:
    			LogicaMenuEscuela.modificarNombre(escuela);
    			break;
    
    		case 3:
    			LogicaMenuEscuela.modificarProvincia(escuela);
    			break;
    
    		case 4:
    			LogicaMenuEscuela.modificarTelefono(escuela);
    			break;
    
    		case 5:
    			return LogicaMenuEscuela.terminar(escuela);
    
    		case 0:
    			return true;
    	}
    
    	return false;
    }

    public static boolean ejecutarOpcionMenuEditarEscuela(int opcion, Escuela escuela) {
    	// Realizar la opción que sea necesaria.
    	switch (opcion) {
    		case 1:
    			LogicaMenuEscuela.modificarNombre(escuela);
    			break;
    
    		case 2:
    			LogicaMenuEscuela.modificarProvincia(escuela);
    			break;
    
    		case 3:
    			LogicaMenuEscuela.modificarTelefono(escuela);
    			break;
    
    		case 4:
    			return LogicaMenuEscuela.terminarEditar(escuela);
    
    		case 0:
    			return true;
    	}
    
    	return false;
    }

    public static boolean ejecutarOpcionMenuGestionarAlumno(int opcion, Escuela escuela) {
    	switch (opcion) {
    		case 1:
    			LogicaGestionarAlumno.crearAlumno(escuela);
    			break;
    
    			case 2:
    			LogicaGestionarAlumno.editarAlumno();
    				break;
    
    			case 3:
    			LogicaGestionarAlumno.eliminarAlumno();
    				break;
    
    		case 0:
    			return true;
    	}
    
    	return false;
    }


}
