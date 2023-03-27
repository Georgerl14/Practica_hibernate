package logica;

import java.util.List;
import interfaz.Interfaz;
import tablas.Escuela;
import tablas.EscuelaId;

public class LogicaGeneral {

	public static void ejecutarOpcionMenuPrincipal(int opcion) {
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

			case 0:
				salir();
				break;
		}
	}

	public static boolean ejecutarOpcionMenuCrearEscuela(int opcion, Escuela escuela) {
		// Realizar la opción que sea necesaria.
		switch (opcion) {
			case 1:
				modificarId(escuela);
				break;

			case 2:
				modificarNombre(escuela);
				break;

			case 3:
				modificarProvincia(escuela);
				break;

			case 4:
				modificarTelefono(escuela);
				break;

			case 5:
				return terminar(escuela);

			case 0:
				return true;
		}

		return false;
	}

	private static void modificarId(Escuela escuela) {
		System.out.println("Modificar id: ");
		EscuelaId id = new EscuelaId(LogicaUtil.introducirOpcionIdDublicada(1, 999999));
		escuela.setEscuelaId(id);
	}

	private static void modificarNombre(Escuela escuela) {
		System.out.println("Modificar nombre: ");
		escuela.setNombre(LogicaUtil.introducirOpcionTexto());
	}

	private static void modificarProvincia(Escuela escuela) {
		System.out.println("Modificar provincia: ");
		escuela.setProvincia(LogicaUtil.introducirOpcionTexto());
	}

	private static void modificarTelefono(Escuela escuela) {
		System.out.println("Modificar telefono: ");
		escuela.setTelefono(LogicaUtil.introducirOpcionTelefono());
	}

	private static boolean terminar(Escuela escuela) {
		// Comprobar si los campos estan vacios
		if (escuela.getNombre().isBlank() || escuela.getProvincia().isBlank() || escuela.getTelefono() == 0
				|| escuela.getEscuelaId() == null) {
			System.out.println("Faltan datos por rellenar.");
			return false;
		} else {
			try {
				LogicaCRUD.agregarAlgo(escuela);
				System.out.println("La escuela se creo correctamente");
				LogicaUtil.pulsarEnter();
			} catch (Exception e) {
				System.out.println("No se pudo crear la escuela.");
			}
			return true;
		}
	}

	public static void editarEscuela() {

	}

	public static void eliminarEscuela() {
		System.out.println("¿Qué escuela quiere eliminar?");
		System.out.println("n. Id de la escuela a eliminar");
		System.out.println("0. Volver");

		int opcion = LogicaUtil.introducirOpcionNumero(0, 9999999);
		if (opcion != 0) {
			opcion = LogicaUtil.introducirOpcionIdExistente(opcion);
			
			Escuela escuela = LogicaCRUD.buscarEscuela(opcion);
			if (LogicaUtil.estarSeguro()){
				LogicaCRUD.eliminarAlgo(escuela);
				System.out.println("Se ha elimido correctemente.");
				LogicaUtil.pulsarEnter();
			}
		}

	}

	public static void crearEscuela() {
		Escuela escuela = new Escuela();
		int opcion;
		boolean terminar;
		do {
			Interfaz.mostrarCrearEscuela(escuela);
			opcion = LogicaUtil.introducirOpcionNumero(0, 5);
			terminar = ejecutarOpcionMenuCrearEscuela(opcion, escuela);
		} while (!terminar);
	}

	public static void logicaMostrarEscuelas() {
		List<Escuela> listaEscuelas = LogicaHQL.insertarListaEscuelas();

		for (Escuela escuela : listaEscuelas) {
			Interfaz.datosListaEscuelas(escuela);
		}
	}

	public static void salir() {
		System.out.println("Programa cerrado correctamente");
		System.exit(0);
	}

}
