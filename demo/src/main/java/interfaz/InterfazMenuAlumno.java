package interfaz;

import logica.mostrar.LogicaMostrar;
import tablas.Alumno;
import tablas.Escuela;

public class InterfazMenuAlumno {

    public static void mostrarGestionarAlumno() {
        System.out.println(".....");
        System.out.println("1. Crear alumno");
        System.out.println("2. Editar alumno");
        System.out.println("3. Eliminar alumno");
        System.out.println("4. Editar global");
        System.out.println(".....");
        System.out.println("0. Salir");
    }

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

    public static void mostrarEditarAlumno(Alumno alumAntigua, Alumno alumNueva) {
        System.out.println("-----------------");
        System.out.println("Editar Alumno");
        System.out.println(".....");

        if (alumAntigua.getNombre().equals(alumNueva.getNombre()))
            System.out.println("1. Nombre: " + alumAntigua.getNombre());
        else
            System.out.println("1. Nombre actual: " + alumNueva.getNombre() + " antiguo: " + alumAntigua.getNombre());

        if (alumAntigua.getPrimerApellido().equals(alumNueva.getPrimerApellido()))
            System.out.println("2. Primer apellido: " + alumAntigua.getPrimerApellido());
        else
            System.out.println(
                    "2. Primer apellido actual: " + alumNueva.getPrimerApellido() + " antigua: "
                            + alumAntigua.getPrimerApellido());

        if (alumAntigua.getSegundoApellido().equals(alumNueva.getSegundoApellido()))
            System.out.println("3. Segundo apellido: " + alumAntigua.getSegundoApellido());
        else
            System.out.println(
                    "3. Segundo apellido actual: " + alumNueva.getSegundoApellido() + " antigua: "
                            + alumAntigua.getSegundoApellido());

        if (alumAntigua.getCodigoPostal() == alumNueva.getCodigoPostal())
            System.out.println("4. Código postal: " + alumAntigua.getCodigoPostal());
        else
            System.out.println(
                    "4. Código postal actual: " + alumNueva.getCodigoPostal() + " antigua: "
                            + alumAntigua.getCodigoPostal());

        System.out.println(".....");
        System.out.println("5. Terminar editar la alumno");
        System.out.println("0. Volver");
    }

    public static void mostrarAlumnos(Escuela escuela) {
        System.out.println("Lista de alumnos:" + "\n");
        LogicaMostrar.logicaMostrarAlumnos(escuela);
    }

    public static void datosListaAlumnos(Alumno alumno) {
        System.out.println(alumno.toString());
    }

}
