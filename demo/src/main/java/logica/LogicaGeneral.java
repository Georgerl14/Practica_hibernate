package logica;

import java.util.List;

import interfaz.InterfazMenuAlumno;
import interfaz.InterfazMenuEscuela;
import interfaz.InterfazMenuProfesor;
import logica.opcion.LogicaGestionarAlumno;
import logica.opcion.LogicaGestionarEscuela;
import logica.opcion.LogicaMenuDirector;
import logica.opcion.LogicaMenuEscuela;
import logica.opcion.LogicaPrincipalOpcion;
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

	public static boolean ejecutarOpcionMenuGestionarEscuela(int opcion, Escuela escuela) {
		switch (opcion) {
			case 1:
				try {
					LogicaUtil.comprobarDirector(escuela);
					LogicaGestionarEscuela.gestionarDirector(escuela);
				} catch(Exception e) {
					LogicaGestionarEscuela.crearDirector(escuela);
				}
				break;

			case 2:
				LogicaGestionarEscuela.gestionarAlumnos(escuela);
				break;

			case 3:
				LogicaGestionarEscuela.gestionarProfesores(escuela);
				break;

			case 4:
				return LogicaMenuEscuela.terminarEditar(escuela);

			case 0:
				return true;
		}

		return false;
	}

	public static void logicaMostrarEscuelas() {
		List<Escuela> listaEscuelas = LogicaHQL.insertarListaEscuelas();

		for (Escuela escuela : listaEscuelas) {
			InterfazMenuEscuela.datosListaEscuelas(escuela);
		}
	}

	public static void logicaMostrarAlumnos(Escuela escuela) {
		List<Alumno> listaAlumnos = LogicaHQL.insertarListaAlumnos(escuela);

		for (Alumno alumno : listaAlumnos) {
			InterfazMenuAlumno.datosListaAlumnos(alumno);
		}
	}

	public static void logicaMostrarProfesor(Escuela escuela) {
		List<Profesor> listaProfesores = LogicaHQL.insertarListaProfesores(escuela);

		for (Profesor profesor : listaProfesores) {
			InterfazMenuProfesor.datosListaProfesores(profesor);
		}
	}

	public static void salir() {
		if (LogicaUtil.estarSeguro()) {
			System.out.println("Programa cerrado correctamente");
			System.exit(0);
		}
	}

}
