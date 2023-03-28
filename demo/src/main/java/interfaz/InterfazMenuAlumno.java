package interfaz;

import logica.LogicaGeneral;
import tablas.Alumno;
import tablas.Escuela;

public class InterfazMenuAlumno {

    public static void mostrarCrearAlumno(Alumno alumno) {
        System.out.println("-----------------");
        System.out.println("Crear alumno");
        System.out.println(".....");
    
        if (alumno.getNombre().isBlank())
            System.out.println("1. Nombre: VACIO");
        else
            System.out.println("1. Nombre: " + alumno.getNombre());
    
        if (alumno.getPrimerApellido().isBlank())
            System.out.println("2. Primer apellido: VACIO");
        else
            System.out.println("2. Primer apellido: " + alumno.getPrimerApellido());
    
        if (alumno.getSegundoApellido().isBlank())
            System.out.println("3. Segundo apellido: VACIO");
        else
            System.out.println("3. Segundo apellido: " + alumno.getSegundoApellido());
    
        if (alumno.getCodigoPostal() == 0)
            System.out.println("4. Código postal: VACIO");
        else
            System.out.println("4. Código postal: " + alumno.getCodigoPostal());
    
    
        System.out.println(".....");
        System.out.println("5. Terminar creación de alumno");
        System.out.println("0. Salir");
    }

    public static void mostrarAlumnos(Escuela escuela) {
        System.out.println("Lista de alumnos:" + "\n");
        LogicaGeneral.logicaMostrarAlumnos(escuela);
    }

    public static void datosListaAlumnos(Alumno alumno) {
        System.out.println(alumno.toString());
    }

    public static void mostrarGestionarAlumno(Escuela escuela) {
        System.out.println("1. Crear alumno");
        System.out.println("2. Editar alumno");
        System.out.println("3. Eliminar alumno");
        System.out.println("4. Editar global");
        System.out.println(".....");
        System.out.println("0. Salir");
    }
    
}
