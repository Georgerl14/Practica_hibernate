package logica;

import java.util.Scanner;

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
                System.out.println("Solo se permiten numeros");
            }
        } while (opcion < minimo || opcion > maximo);

        return opcion;
    }

    public static int introducirOpcionIdDublicada(int minimo, int maximo) {
        // Introduce un número entre el valor minimo y maximo.
        int opcion;
        Scanner sc = new Scanner(System.in);
        Boolean dublicado = false;
        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
                dublicado = LogicaHQL.comprobarId(opcion);

                if (dublicado) {
                    System.out.println("El número de id ya ha sido utilizado");
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros");
            }
        } while ((opcion < minimo || opcion > maximo) || dublicado);

        return opcion;
    }

    public static int introducirOpcionIdExistente(int minimo, int maximo) {
        // Introduce un número entre el valor minimo y maximo.
        int opcion;
        Scanner sc = new Scanner(System.in);
        Boolean existente = true;
        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
                existente = LogicaHQL.comprobarId(opcion);

                if (!existente) {
                    System.out.println("El número de id no existe.");
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros");
            }
        } while ((opcion < minimo || opcion > maximo) || !existente);

        return opcion;
    }

    public static int introducirOpcionIdExistente(int opcion) {
        Boolean existente = true;
        do {
            try {
                existente = LogicaHQL.comprobarId(opcion);

                if (!existente) {
                    System.out.println("El número de id no existe.");
                    opcion = introducirOpcionNumero(1, 9999999);
                    existente = LogicaHQL.comprobarId(opcion);
                }

            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros");
            }
        } while (!existente);

        return opcion;
    }

    public static int introducirOpcionTelefono() {
        // Introduce un número entre el valor de un telefono.
        Integer opcion;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcion = -1;
                System.out.println("Solo se permiten numeros");
            }
        } while (String.valueOf(opcion).length() != 9);

        return opcion;
    }

    public static String introducirOpcionTexto() {
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

        System.out.println("¿Esta seguro de que quiere realizar este procedimiento?");
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
        System.out.print("Pulsa enter para continuar");
        try {
            sc.nextLine();
        } catch (Exception e) {
        }
    }
}
