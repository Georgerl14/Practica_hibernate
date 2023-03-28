package interfaz;

import logica.LogicaGeneral;
import tablas.Alumno;
import tablas.Director;
import tablas.Escuela;
import tablas.Profesor;

public class Interfaz {
    public static void mostrarOpcionesEscuela() {
        System.out.println("Selecciona una opción");
        System.out.println(".....");
        System.out.println("1. Crear escuela");
        System.out.println("2. Editar escuela");
        System.out.println("3. Eliminar escuela");
        System.out.println("4. Gestionar escuela");
        System.out.println(".....");
        System.out.println("0. Salir");
    }

    public static void mostrarEscuelas() {
        System.out.println("Lista de escuelas:" + "\n");
        LogicaGeneral.logicaMostrarEscuelas();
    }

    public static void datosListaEscuelas(Escuela escuela) {
        System.out.println(escuela.toString());
        System.out.println(escuela.informacionExtra());
        System.out.println();
    }

    public static void mostrarAlumnos(Escuela escuela) {
        System.out.println("Lista de alumnos:" + "\n");
        LogicaGeneral.logicaMostrarAlumnos(escuela);
    }

    public static void datosListaAlumnos(Alumno alumno) {
        System.out.println(alumno.toString());
    }

    public static void mostrarProfesores(Escuela escuela) {
        System.out.println("Lista de profesores:" + "\n");
        LogicaGeneral.logicaMostrarProfesor(escuela);
    }

    public static void datosListaProfesores(Profesor profesor) {
        System.out.println(profesor.toString());
    }

    public static void mostrarCrearEscuela(Escuela escuela) {
        System.out.println("-----------------");
        System.out.println("Crear escuela");
        System.out.println(".....");
        try {
            System.out.println("1. Id: " + escuela.getEscuelaId().getIdEscuela());
        } catch (Exception e) {
            System.out.println("1. Id: VACIO");
        }

        if (escuela.getNombre().isBlank())
            System.out.println("2. Nombre: VACIO");
        else
            System.out.println("2. Nombre: " + escuela.getNombre());

        if (escuela.getProvincia().isBlank())
            System.out.println("3. Provincia: VACIO");
        else
            System.out.println("3. Provincia: " + escuela.getProvincia());

        if (escuela.getTelefono() == 0)
            System.out.println("4. Telefono: VACIO");
        else
            System.out.println("4. Telefono: " + escuela.getTelefono());

        System.out.println(".....");
        System.out.println("5. Terminar creación de escuela");
        System.out.println("0. Salir");
    }

    public static void mostrarCrearDirector(Director director) {
        System.out.println("-----------------");
        System.out.println("Crear director");
        System.out.println(".....");

        if (director.getNombre().isBlank())
            System.out.println("1. Nombre: VACIO");
        else
            System.out.println("1. Nombre: " + director.getNombre());

        if (director.getApellido().isBlank())
            System.out.println("2. Apellido: VACIO");
        else
            System.out.println("2. Apellido: " + director.getApellido());

        if (director.getTelefono() == 0)
            System.out.println("3. Telefono: VACIO");
        else
            System.out.println("3. Telefono: " + director.getTelefono());

        System.out.println(".....");
        System.out.println("4. Terminar creación de director");
        System.out.println("0. Salir");
    }

    public static void mostrarEditarEscuela(Escuela escAntigua, Escuela escNueva) {
        System.out.println("-----------------");
        System.out.println("Editar escuela");
        System.out.println(".....");

        if (escAntigua.getNombre().equals(escNueva.getNombre()))
            System.out.println("1. Nombre: " + escAntigua.getNombre());
        else
            System.out.println("1. Nombre actual: " + escNueva.getNombre() + " antiguo: " + escAntigua.getNombre());

        if (escAntigua.getProvincia().equals(escNueva.getProvincia()))
            System.out.println("2. Provincia: " + escAntigua.getProvincia());
        else
            System.out.println(
                    "2. Provincia actual: " + escNueva.getProvincia() + " antigua: " + escAntigua.getProvincia());

        if (escAntigua.getTelefono() == escNueva.getTelefono())
            System.out.println("3. Telefono: " + escAntigua.getTelefono());
        else
            System.out.println(
                    "3. Telefono actual: " + escNueva.getTelefono() + " antigua: " + escAntigua.getTelefono());

        System.out.println(".....");
        System.out.println("4. Terminar editar la escuela");
        System.out.println("0. Volver");
    }

    public static void mostrarGestionarEscuela(Escuela escuela) {
        System.out.println("-----------------");
        System.out.println("Gestionar escuela");
        System.out.println(".....");
        
        try {
            escuela.getDirector();
            System.out.println("1. Añadir director");
        } catch (Exception e) {
            System.out.println("1. Gestionar director: " + escuela.getDirector().getNombre());
        }
        
        System.out.println("2. Gestionar alumnos");
        System.out.println("3. Gestionar profesores");    
        System.out.println(".....");
        System.out.println("0. Volver");
    }

}
