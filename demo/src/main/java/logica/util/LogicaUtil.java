package logica.util;

import java.util.Scanner;

import logica.conector.LogicaHQL;
import tablas.Escuela;

public class LogicaUtil {

    public static int introducirOpcionNumero(int minimo, int maximo) {
        // Introduce un número entre el valor minimo y maximo.
        int opcion;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros.");
            }
        } while (opcion < minimo || opcion > maximo);

        return opcion;
    }

    public static int introducirIdDublicada(int minimo, int maximo) {
        // Introduce un número entre el valor minimo y maximo.
        int opcion;
        Scanner sc = new Scanner(System.in);
        Boolean dublicado = false;
        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
                dublicado = LogicaHQL.comprobarIdEscuela(opcion);

                if (dublicado) {
                    System.out.println("El número de id ya ha sido utilizado.");
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros.");
            }
        } while ((opcion < minimo || opcion > maximo) || dublicado);

        return opcion;
    }

    public static int introducirIdExistente(int minimo, int maximo) {
        // Introduce un número entre el valor minimo y maximo.
        int opcion;
        Scanner sc = new Scanner(System.in);
        Boolean existente = true;
        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
                existente = LogicaHQL.comprobarIdEscuela(opcion);

                if (!existente) {
                    System.out.println("El número de id no existe.");
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros.");
            }
        } while ((opcion < minimo || opcion > maximo) || !existente);

        return opcion;
    }

    public static int introducirIdExistente(int opcion) {
        Boolean existente = true;
        do {
            try {
                existente = LogicaHQL.comprobarIdEscuela(opcion);

                if (!existente) {
                    System.out.println("El número de id no existe.");
                    opcion = introducirOpcionNumero(1, 9999999);
                    existente = LogicaHQL.comprobarIdEscuela(opcion);
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros.");
            }
        } while (!existente);

        return opcion;
    }

    public static int introducirIdAlumno(int idEscuela, int idAlumno) {
        Boolean existente = true;
        do {
            try {
                existente = LogicaHQL.comprobarIdAlumno(idEscuela, idAlumno);

                if (!existente) {
                    System.out.println("El número de id no existe.");
                    idAlumno = introducirOpcionNumero(1, 9999999);
                    existente = LogicaHQL.comprobarIdAlumno(idEscuela, idAlumno);
                }

            } catch (Exception e) {
                idEscuela = -1;
                System.out.println("Solo se permiten numeros.");
            }
        } while (!existente);

        return idAlumno;
    }

    public static int introducirTelefono() {
        // Introduce un número entre el valor de un telefono.
        Integer opcion;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());

                if (String.valueOf(opcion).length() != 9) {
                    System.out.println("Solo se permiten numeros de 9 digitos.");
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros.");
            }
        } while (String.valueOf(opcion).length() != 9);

        return opcion;
    }

    public static String introducirTexto() {
        // Introduce una cadena de caracteres con ciertos estandares.
        String cadena;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Introduce: ");
            cadena = sc.nextLine();

            // No puede estar vacia.
        } while (cadena.isBlank());

        return cadena;
    }

    public static boolean estarSeguro() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("¿Esta seguro de que quiere realizar esta acción?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = introducirOpcionNumero(1, 2);

        if (opcion == 1)
            return true;
        else
            return false;
    }

    public static void pulsarEnter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pulsa enter para continuar: ");
        try {
            sc.nextLine();
        } catch (Exception e) {
        }
    }

    public static Escuela clonarEscuela(Escuela escuela){
        return new Escuela(escuela.getEscuelaId(), escuela.getNombre(), escuela.getProvincia(),
        escuela.getTelefono(), escuela.getDirector(), escuela.getListaAlumno(),
        escuela.getProfesores());
    }

    public static void comprobarDirector(Escuela escuela) {
        if(escuela.getDirector().equals(null));
    }

    public static void salir() {
    	if (estarSeguro()) {
    		System.out.println("Programa cerrado correctamente");
    		System.exit(0);
    	}
    }
}
