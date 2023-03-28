package logica.menu;

import interfaz.InterfazMenuAlumno;
import interfaz.InterfazMenuDirector;
import interfaz.InterfazMenuEscuela;
import interfaz.InterfazMenuProfesor;
import logica.conector.LogicaCRUD;
import logica.opcion.LogicaGestionarAlumno;
import logica.opcion.LogicaGestionarDirector;
import logica.opcion.LogicaGestionarEscuela;
import logica.opcion.LogicaGestionarProfesor;
import logica.opcion.LogicaGestionarRelacion;
import logica.util.LogicaUtil;
import tablas.Director;
import tablas.Escuela;

public class LogicaMenuNexo {

	public static void gestionarBaseDatos() {
		System.out.println("Gestor de la base de datos: " + "ParaHibernate" + "\n");
		while (true) {
			InterfazMenuEscuela.mostrarEscuelas();
			InterfazMenuEscuela.mostrarOpcionesEscuela();
			LogicaGestionarEscuela.ejecutarOpcionMenuGestionarEscuela(LogicaUtil.introducirOpcionNumero(0, 4));
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
			opcion = LogicaUtil.introducirIdExistente(opcion);
			Escuela escuela = LogicaCRUD.buscarEscuela(opcion);
			do {
				InterfazMenuEscuela.mostrarGestionarEscuela(escuela);
				opcion = LogicaUtil.introducirOpcionNumero(0, 4);
				terminar = LogicaGestionarRelacion.ejecutarOpcionMenuRelacionEscuela(opcion, escuela);
			} while (!terminar);
		}
	}

	public static void gestionarAlumnos(Escuela escuela) {
		int opcion;
		boolean terminar;
		do {
			InterfazMenuAlumno.mostrarAlumnos(escuela);
			InterfazMenuAlumno.mostrarGestionarAlumno();
			opcion = LogicaUtil.introducirOpcionNumero(0, 5);
			terminar = LogicaGestionarAlumno.ejecutarOpcionMenuGestionarAlumno(opcion, escuela);
		} while (!terminar);
	}

	public static void gestionarDirector(Escuela escuela) {
		int opcion;
		boolean terminar;
		Director director = escuela.getDirector();
		do {
			InterfazMenuDirector.mostrarDirector(director);
			InterfazMenuDirector.mostrarGestionarDirector();
			opcion = LogicaUtil.introducirOpcionNumero(0, 2);
			terminar = LogicaGestionarDirector.ejecutarOpcionMenuGestionarDirector(opcion, escuela, director);
		} while (!terminar);
	}

	public static void gestionarProfesores(Escuela escuela) {
		int opcion;
		boolean terminar;
		do {
			InterfazMenuProfesor.mostrarProfesores(escuela);
			InterfazMenuProfesor.mostrarGestionarProfesor();
			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
			terminar = LogicaGestionarProfesor.ejecutarOpcionMenuGestionarProfesor(opcion, escuela);
		} while (!terminar);
	}

}
