package logica;

import java.util.List;
import interfaz.Interfaz;
import tablas.Alumno;
import tablas.Director;
import tablas.Escuela;
import tablas.Profesor;

public class LogicaGeneral {

	public static void ejecutarOpcionMenuPrincipal(int opcion) {
		// Realizar la opción que sea necesaria.
		switch (opcion) {
			case 1:
				LogicaPrincipalOpcion.crearEscuela();
				break;

			case 2:
				LogicaPrincipalOpcion.editarEscuela();
				break;

			case 3:
				LogicaPrincipalOpcion.eliminarEscuela();
				break;

			case 4:
				LogicaPrincipalOpcion.gestionarEscuela();
				break;

			case 0:
				salir();
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

	private static boolean ejecutarOpcionMenuCrearDirector(int opcion, Escuela escuela, Director director) {
		switch (opcion) {
			case 1:
				modificarNombre(director);
				break;

			case 2:
				modificarApellido(director);
				break;

			case 3:
				modificarTelefono(director);
				break;

			case 4:
				return terminar(escuela,director);

			case 0:
				return true;
		}

		return false;
	}

	private static boolean terminar(Escuela escuela, Director director) {
		return false;
	}

	private static void modificarTelefono(Director director) {
	}

	private static void modificarApellido(Director director) {
	}

	private static void modificarNombre(Director director) {
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

	static boolean ejecutarOpcionMenuGestionarEscuela(int opcion, Escuela escuela) {
		switch (opcion) {
			case 1:
				crearDirector(escuela);
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

	private static void crearDirector(Escuela escuela) {
		Director director = new Director();

		int opcion;
		boolean terminar;
		do {
			Interfaz.mostrarCrearDirector(director);
			opcion = LogicaUtil.introducirOpcionNumero(0, 4);
			terminar = ejecutarOpcionMenuCrearDirector(opcion, escuela, director);
		} while (!terminar);
	}

	public static void logicaMostrarEscuelas() {
		List<Escuela> listaEscuelas = LogicaHQL.insertarListaEscuelas();

		for (Escuela escuela : listaEscuelas) {
			Interfaz.datosListaEscuelas(escuela);
		}
	}

	public static void logicaMostrarAlumnos(Escuela escuela) {
		List<Alumno> listaAlumnos = LogicaHQL.insertarListaAlumnos(escuela);

		for (Alumno alumno : listaAlumnos) {
			Interfaz.datosListaAlumnos(alumno);
		}
	}

	public static void logicaMostrarProfesor(Escuela escuela) {
		List<Profesor> listaProfesores = LogicaHQL.insertarListaProfesores(escuela);

		for (Profesor profesor : listaProfesores) {
			Interfaz.datosListaProfesores(profesor);
		}
	}

	public static void salir() {
		if (LogicaUtil.estarSeguro()) {
			System.out.println("Programa cerrado correctamente");
			System.exit(0);
		}
	}

}
