package logica;

import logica.menu.LogicaMenuNexo;
import logica.opcion.LogicaGestionarAlumno;
import logica.opcion.LogicaGestionarRelacion;
import logica.opcion.LogicaMenuDirector;
import logica.opcion.LogicaMenuEscuela;
import logica.opcion.LogicaGestionarEscuela;
import logica.util.LogicaUtil;
import tablas.Director;
import tablas.Escuela;

public class LogicaGeneral {

	public static void ejecutarOpcionMenuGestionarEscuela(int opcion) {
		// Realizar la opción que sea necesaria.
		switch (opcion) {
			case 1:
				LogicaGestionarEscuela.crearEscuela();
				break;

			case 2:
				LogicaGestionarEscuela.editarEscuela();
				break;

			case 3:
				LogicaGestionarEscuela.eliminarEscuela();
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



	public static boolean ejecutarOpcionMenuRelacionEscuela(int opcion, Escuela escuela) {
		switch (opcion) {
			case 1:
				try {
					LogicaUtil.comprobarDirector(escuela);
					LogicaMenuNexo.gestionarDirector(escuela);
				} catch(Exception e) {
					LogicaGestionarRelacion.crearDirector(escuela);
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

    public static boolean ejecutarOpcionMenuGestionarDirector(int opcion, Escuela escuela) {
        return false;
    }

    public static boolean ejecutarOpcionMenuGestionarProfesor(int opcion, Escuela escuela) {
        return false;
    }

}
