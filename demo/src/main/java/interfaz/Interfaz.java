package interfaz;

import logica.LogicaGeneral;
import tablas.Escuela;

public class Interfaz {
    public static void mostrarOpcionesEscuela() {
        System.out.println("Selecciona una opción");
        System.out.println(".....");
        System.out.println("1. Crear escuela");
        System.out.println("2. Editar escuela");
        System.out.println("3. Eliminar escuela");
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
}
