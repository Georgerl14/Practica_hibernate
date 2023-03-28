package logica.menu;

import interfaz.InterfazMenuAlumno;
import interfaz.InterfazMenuDirector;
import interfaz.InterfazMenuEscuela;
import interfaz.InterfazMenuProfesor;
import logica.LogicaGeneral;
import logica.conector.LogicaCRUD;
import logica.util.LogicaUtil;
import tablas.Escuela;

public class LogicaMenuNexo {

	public static void gestionarBaseDatos() {
		System.out.println("Gestor de la base de datos: " + "ParaHibernate" + "\n");
		while (true) {
			InterfazMenuEscuela.mostrarEscuelas();
			InterfazMenuEscuela.mostrarOpcionesEscuela();
			LogicaGeneral.ejecutarOpcionMenuGestionarEscuela(LogicaUtil.introducirOpcionNumero(0, 4));
		}
	}

	public static void gestionarRelacion() {
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
				InterfazMenuEscuela.mostrarGestionarEscuela(escuela);
				opcion = LogicaUtil.introducirOpcionNumero(0, 4);
				terminar = LogicaGeneral.ejecutarOpcionMenuRelacionEscuela(opcion, escuela);
			} while (!terminar);
		}
	}

	public static void gestionarAlumnos(Escuela escuela) {
		int opcion;
		boolean terminar;
		do {
			InterfazMenuAlumno.mostrarAlumnos(escuela);
			InterfazMenuAlumno.mostrarGestionarAlumno();
			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
			terminar = LogicaGeneral.ejecutarOpcionMenuGestionarAlumno(opcion, escuela);
		} while (!terminar);
	}

	public static void gestionarDirector(Escuela escuela) {
		int opcion;
		boolean terminar;
		do {
			InterfazMenuDirector.mostrarDirector(escuela);
			InterfazMenuDirector.mostrarGestionarDirector(escuela);
			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
			terminar = LogicaGeneral.ejecutarOpcionMenuGestionarDirector(opcion, escuela);
		} while (!terminar);
	}

	public static void gestionarProfesores(Escuela escuela) {
		int opcion;
		boolean terminar;
		do {
			InterfazMenuProfesor.mostrarProfesores(escuela);
			InterfazMenuProfesor.mostrarGestionarProfesor();
			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
			terminar = LogicaGeneral.ejecutarOpcionMenuGestionarProfesor(opcion, escuela);
		} while (!terminar);
	}

}
