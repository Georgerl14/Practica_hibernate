package interfaz;

import logica.LogicaGeneral;
import tablas.Escuela;
import tablas.Profesor;

public class InterfazMenuProfesor {

    public static void mostrarProfesores(Escuela escuela) {
        System.out.println("Lista de profesores:" + "\n");
        LogicaGeneral.logicaMostrarProfesor(escuela);
    }

    public static void datosListaProfesores(Profesor profesor) {
        System.out.println(profesor.toString());
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
    
}
