package interfaz;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import logica.HibernateUtil;
import logica.LogicaGeneral;
import tablas.Director;
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

    public static void mostrarModificarNombre(Escuela escuela) {
        System.out.println("Modificar el nombre de la escuela");
        System.out.println("Nombre actual: " + escuela.getNombre());
        System.out.println(".....");
        System.out.println("1. Modificar nombre");
        System.out.println(".....");
        System.out.println("0. Volver");
    }

    public static void mostrarModificarProvincia(Escuela escuela) {
        System.out.println("Modificar la provincia de la escuela");
        System.out.println("Provincia actual: " + escuela.getProvincia());
        System.out.println(".....");
        System.out.println("1. Modificar provincia");
        System.out.println(".....");
        System.out.println("0. Volver");
    }

    public static void mostrarModificarTelefono(Escuela escuela) {
        System.out.println("Modificar el telefono de la escuela");
        System.out.println("Telefono actual: " + escuela.getTelefono());
        System.out.println(".....");
        System.out.println("1. Modificar telefono");
        System.out.println(".....");
        System.out.println("0. Volver");
    }
}
