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
    
}
