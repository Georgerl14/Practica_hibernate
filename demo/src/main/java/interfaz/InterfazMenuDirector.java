package interfaz;

import tablas.Director;

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

    public static void mostrarEditarDirector(Director dirAntigua, Director dirNueva) {
        System.out.println("-----------------");
        System.out.println("Editar director");
        System.out.println(".....");

        if (dirAntigua.getNombre().equals(dirNueva.getNombre()))
            System.out.println("1. Nombre: " + dirAntigua.getNombre());
        else
            System.out.println("1. Nombre actual: " + dirNueva.getNombre() + " antiguo: " + dirAntigua.getNombre());

        if (dirAntigua.getApellido().equals(dirNueva.getApellido()))
            System.out.println("2. Apellido: " + dirAntigua.getApellido());
        else
            System.out.println(
                    "2. Apellido actual: " + dirNueva.getApellido() + " antigua: "
                            + dirAntigua.getApellido());

        if (dirAntigua.getTelefono() == dirNueva.getTelefono())
            System.out.println("3. Telefono: " + dirAntigua.getTelefono());
        else
            System.out.println(
                    "3. Telefono actual: " + dirNueva.getTelefono() + " antigua: "
                            + dirAntigua.getTelefono());

        System.out.println(".....");
        System.out.println("4. Terminar editar el director");
        System.out.println("0. Volver");
    }

    public static void mostrarGestionarDirector() {
        System.out.println(".....");
        System.out.println("1. Editar director");
        System.out.println("2. Eliminar director");
        System.out.println(".....");
        System.out.println("0. Salir");
    }

    public static void mostrarDirector(Director director) {
        System.out.println(director.toString());
    }

}
