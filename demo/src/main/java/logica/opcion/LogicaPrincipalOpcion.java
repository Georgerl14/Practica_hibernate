package logica.opcion;

import interfaz.Interfaz;
import logica.LogicaCRUD;
import logica.LogicaGeneral;
import logica.LogicaUtil;
import tablas.Escuela;

public class LogicaPrincipalOpcion {

    public static void crearEscuela() {
    	Escuela escuela = new Escuela();
    	int opcion;
    	boolean terminar;
    	do {
    		Interfaz.mostrarCrearEscuela(escuela);
    		opcion = LogicaUtil.introducirOpcionNumero(0, 5);
    		terminar = LogicaGeneral.ejecutarOpcionMenuCrearEscuela(opcion, escuela);
    	} while (!terminar);
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
    			Interfaz.mostrarEditarEscuela(escAntigua, escNueva);
    			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
    			terminar = LogicaGeneral.ejecutarOpcionMenuEditarEscuela(opcion, escNueva);
    		} while (!terminar);
    
    	}
    }

    public static void gestionarEscuela() {
    	boolean terminar = false;
    
    	System.out.println("¿Qué escuela quiere gestionar?");
    	System.out.println("n. Id de la escuela a gestionar");
    	System.out.println(".....");
    	System.out.println("0. Volver");
    
    	int opcion = LogicaUtil.introducirOpcionNumero(0, 9999999);
    	if (opcion != 0) {
    		opcion = LogicaUtil.introducirOpcionIdExistente(opcion);
    		Escuela escuela = LogicaCRUD.buscarEscuela(opcion);
    		do {
    			Interfaz.mostrarGestionarEscuela(escuela);
    			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
    			terminar = LogicaGeneral.ejecutarOpcionMenuGestionarEscuela(opcion, escuela);
    		} while (!terminar);
    
    	}
    }
    
}
