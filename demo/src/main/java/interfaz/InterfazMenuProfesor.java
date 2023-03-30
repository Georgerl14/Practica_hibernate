package interfaz;

import logica.mostrar.LogicaMostrar;
import tablas.Escuela;
import tablas.Profesor;

public class InterfazMenuProfesor {

    public static void mostrarGestionarProfesor() {
        System.out.println("1. Crear profesor");
        System.out.println("2. Editar profesor");
        System.out.println("3. Eliminar profesor");
        System.out.println(".....");
        System.out.println("0. Salir");
    }

    public static void mostrarCrearProfesor(Profesor profesor) {
        System.out.println("-----------------");
        System.out.println("Crear Profesor");
        System.out.println(".....");
    
        if (profesor.getId() == 0)
            System.out.println("1. Id: VACIO");
        else 
            System.out.println("1. Id: " + profesor.getId());
    
        if (profesor.getNombre().isBlank())
            System.out.println("2. Nombre: VACIO");
        else
            System.out.println("2. Nombre: " + profesor.getNombre());
    
        if (profesor.getApellido().isBlank())
            System.out.println("3. Apellido: VACIO");
        else
            System.out.println("3. Apellido: " + profesor.getApellido());
    
        if (profesor.getSueldo() == 0)
            System.out.println("4. Sueldo: VACIO");
        else
            System.out.println("4. Sueldo: " + profesor.getSueldo());
    
        System.out.println(".....");
        System.out.println("5. Terminar creación de Profesor");
        System.out.println("0. Salir");
    }
    
    public static void mostrarEditarProfesor(Profesor profAntigua, Profesor profNueva) {
        System.out.println("-----------------");
        System.out.println("Editar profesor");
        System.out.println(".....");

        if (profAntigua.getNombre().equals(profNueva.getNombre()))
            System.out.println("1. Nombre: " + profAntigua.getNombre());
        else
            System.out.println("1. Nombre actual: " + profNueva.getNombre() + " antiguo: " + profAntigua.getNombre());

        if (profAntigua.getApellido().equals(profNueva.getApellido()))
            System.out.println("2. Apellido: " + profAntigua.getApellido());
        else
            System.out.println(
                    "2. Apellido actual: " + profNueva.getApellido() + " antigua: "
                            + profAntigua.getApellido());

        if (profAntigua.getSueldo() == profNueva.getSueldo())
            System.out.println("3. Sueldo: " + profAntigua.getSueldo());
        else
            System.out.println(
                    "3. Sueldo actual: " + profNueva.getSueldo() + " antigua: "
                            + profAntigua.getSueldo());

        System.out.println(".....");
        System.out.println("4. Terminar editar la profesor");
        System.out.println("0. Volver");
    }

    public static void mostrarProfesores(Escuela escuela) {
        System.out.println("Lista de profesores:" + "\n");
        LogicaMostrar.logicaMostrarProfesor(escuela);
    }

    public static void datosListaProfesores(Profesor profesor) {
        System.out.println(profesor.toString());
    }
}
