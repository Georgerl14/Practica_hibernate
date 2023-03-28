package interfaz;

import tablas.Director;
import tablas.Escuela;

public class InterfazMenuDirector {

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

    public static void mostrarEditarDirector(Director alumAntigua, Director alumNueva) {
        System.out.println("-----------------");
        System.out.println("Editar Director");
        System.out.println(".....");

        if (alumAntigua.getNombre().equals(alumNueva.getNombre()))
            System.out.println("1. Nombre: " + alumAntigua.getNombre());
        else
            System.out.println("1. Nombre actual: " + alumNueva.getNombre() + " antiguo: " + alumAntigua.getNombre());

        if (alumAntigua.getApellido().equals(alumNueva.getApellido()))
            System.out.println("2. Apellido: " + alumAntigua.getApellido());
        else
            System.out.println(
                    "2. Apellido actual: " + alumNueva.getApellido() + " antigua: "
                            + alumAntigua.getApellido());

        if (alumAntigua.getTelefono() == alumNueva.getTelefono())
            System.out.println("3. Telefono: " + alumAntigua.getTelefono());
        else
            System.out.println(
                    "3. Telefono actual: " + alumNueva.getTelefono() + " antigua: "
                            + alumAntigua.getTelefono());

        System.out.println(".....");
        System.out.println("4. Terminar editar el director");
        System.out.println("0. Volver");
    }

    public static void mostrarGestionarDirector(Escuela escuela) {
        System.out.println("1. Editar director");
        System.out.println("2. Eliminar director");
        System.out.println(".....");
        System.out.println("0. Salir");
    }

    public static void mostrarDirector(Escuela escuela) {
        System.out.println(escuela.getDirector().toString());
    }

}
