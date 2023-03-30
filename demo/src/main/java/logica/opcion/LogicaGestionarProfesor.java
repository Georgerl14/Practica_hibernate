package logica.opcion;

import interfaz.InterfazMenuProfesor;
import logica.conector.LogicaCRUD;
import logica.opcionMenu.LogicaMenuProfesor;
import logica.util.LogicaUtil;
import tablas.Escuela;
import tablas.Profesor;

public class LogicaGestionarProfesor {

    public static void crearProfesor(Escuela escuela) {
        Profesor profesor = new Profesor();
        int opcion;
        boolean terminar;
        do {
            InterfazMenuProfesor.mostrarCrearProfesor(profesor);
            opcion = LogicaUtil.introducirOpcionNumero(0, 5);
            terminar = LogicaGestionarProfesor.ejecutarOpcionMenuCrearProfesor(opcion, escuela, profesor);
        } while (!terminar);
    }


    public static void eliminarProfesor(Escuela escuela) {
        System.out.println("¿Qué Profesor quiere eliminar?");
        System.out.println("n. Id del Profesor a eliminar");
        System.out.println(".....");
        System.out.println("0. Volver");

        int idEscuela = escuela.getEscuelaId().getIdEscuela();
        int idProfesor = LogicaUtil.introducirOpcionNumero(0, 9999999);
        if (idProfesor != 0) {
            idProfesor = LogicaUtil.introducirIdAlumno(idEscuela, idProfesor);
            if (LogicaUtil.estarSeguro()) {
                Profesor profesor = buscarProfesor(escuela, idProfesor);

                LogicaCRUD.eliminarAlgo(profesor);
                System.out.println("Se ha elimido correctemente.");
                LogicaUtil.pulsarEnter();
            }
        }
    }

    private static Profesor buscarProfesor(Escuela escuela, int idProfesor) {
        for (Profesor profesor : escuela.getProfesores()) {
            if (profesor.getId() == idProfesor) {
                return profesor;
            }
        }
        return null;
    }

    public static boolean ejecutarOpcionMenuGestionarProfesor(int opcion, Escuela escuela) {
        switch (opcion) {
            case 1:
                crearProfesor(escuela);
                break;

            case 2:
                //editarProfesor(profesor);
                break;

            case 3:
                eliminarProfesor(escuela);
                break;

            case 0:
                return true;
        }
        return false;
    }
    
    
    private static boolean ejecutarOpcionMenuCrearProfesor(int opcion, Escuela escuela, Profesor profesor) {
        switch (opcion) {
            case 1:
                LogicaMenuProfesor.modificarId(profesor);
                break;

            case 2:
                LogicaMenuProfesor.modificarNombre(profesor);
                break;

            case 3:
                LogicaMenuProfesor.modificarApellido(profesor);
                break;

            case 4:
                LogicaMenuProfesor.modificarSalario(profesor);
                break;

            case 5:
                return LogicaMenuProfesor.terminar(escuela, profesor);

            case 0:
                return true;
        }

        return false;
    }

}   
