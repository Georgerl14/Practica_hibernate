package logica.opcion;

import java.util.List;
import interfaz.InterfazMenuAlumno;
import logica.conector.LogicaCRUD;
import logica.opcionMenu.LogicaMenuAlumno;
import logica.util.LogicaUtil;
import tablas.Alumno;
import tablas.Escuela;

public class LogicaGestionarAlumno {

    public static void crearAlumno(Escuela escuela) {
        Alumno alumno = new Alumno();
        int opcion;
        boolean terminar;
        do {
            InterfazMenuAlumno.mostrarCrearAlumno(alumno);
            opcion = LogicaUtil.introducirOpcionNumero(0, 5);
            terminar = LogicaGestionarAlumno.ejecutarOpcionMenuCrearAlumno(opcion, escuela, alumno);
        } while (!terminar);
    }

    public static void editarAlumno(Escuela escuela) {
        boolean terminar;

        System.out.println("¿Qué alumno quiere editar?");
        System.out.println("n. Id del alumno a editar");
        System.out.println(".....");
        System.out.println("0. Volver");

        int idEscuela = escuela.getEscuelaId().getIdEscuela();
        int idAlumno = LogicaUtil.introducirOpcionNumero(0, 9999999);
        if (idAlumno != 0) {
            idAlumno = LogicaUtil.introducirIdAlumno(idEscuela, idAlumno);
            Alumno alumAntigua = buscarAlumno(escuela, idAlumno);
            Alumno alumNueva = LogicaUtil.clonarAlumno(alumAntigua);
            do {
                InterfazMenuAlumno.mostrarEditarAlumno(alumAntigua, alumNueva);
                int opcion = LogicaUtil.introducirOpcionNumero(0, 5);
                terminar = LogicaGestionarAlumno.ejecutarOpcionMenuEditarAlumno(opcion, alumNueva);
            } while (!terminar);
        }
    }

    public static void eliminarAlumno(Escuela escuela) {
        System.out.println("¿Qué alumno quiere eliminar?");
        System.out.println("n. Id del alumno a eliminar");
        System.out.println(".....");
        System.out.println("0. Volver");

        int idEscuela = escuela.getEscuelaId().getIdEscuela();
        int idAlumno = LogicaUtil.introducirOpcionNumero(0, 9999999);
        if (idAlumno != 0) {
            idAlumno = LogicaUtil.introducirIdAlumno(idEscuela, idAlumno);
            if (LogicaUtil.estarSeguro()) {
                Alumno alumno = buscarAlumno(escuela, idAlumno);

                LogicaCRUD.eliminarAlgo(alumno);
                System.out.println("Se ha elimido correctemente.");
                LogicaUtil.pulsarEnter();
            }
        }
    }

    private static Alumno buscarAlumno(Escuela escuela, int idAlumno) {
        for (Alumno alumno : escuela.getListaAlumno()) {
            if (alumno.getId() == idAlumno) {
                return alumno;
            }
        }
        return null;
    }

    public static boolean ejecutarOpcionMenuGestionarAlumno(int opcion, Escuela escuela) {
        switch (opcion) {
            case 1:
                crearAlumno(escuela);
                break;

            case 2:
                editarAlumno(escuela);
                break;

            case 3:
                eliminarAlumno(escuela);
                break;

            case 0:
                return true;
        }

        return false;
    }

    public static boolean ejecutarOpcionMenuCrearAlumno(int opcion, Escuela escuela, Alumno alumno) {
        // Realizar la opción que sea necesaria.
        switch (opcion) {
            case 1:
                LogicaMenuAlumno.modificarNombre(alumno);
                break;

            case 2:
                LogicaMenuAlumno.modificarPrimerApellido(alumno);
                break;

            case 3:
                LogicaMenuAlumno.modificarSegundoApellido(alumno);
                break;

            case 4:
                LogicaMenuAlumno.modificarCodigoPostal(alumno);
                break;

            case 5:
                return LogicaMenuAlumno.terminar(escuela, alumno);

            case 0:
                return true;
        }

        return false;
    }

    public static boolean ejecutarOpcionMenuEditarAlumno(int opcion, Alumno alumNueva) {
        // Realizar la opción que sea necesaria.
        switch (opcion) {
            case 1:
                LogicaMenuAlumno.modificarNombre(alumNueva);
                break;

            case 2:
                LogicaMenuAlumno.modificarPrimerApellido(alumNueva);
                break;

            case 3:
                LogicaMenuAlumno.modificarSegundoApellido(alumNueva);
                break;

            case 4:
                LogicaMenuAlumno.modificarCodigoPostal(alumNueva);
                break;

            case 5:
                return LogicaMenuAlumno.terminarEditar(alumNueva);

            case 0:
                return true;
        }

        return false;
    }
}
