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

    public static int introducirOpcionId(int minimo, int maximo) {
        // Introduce un número entre el valor minimo y maximo.
        int opcion;
        Scanner sc = new Scanner(System.in);
        Boolean dublicado = false;
        do {
            try {
                System.out.print("Introduce: ");
                opcion = Integer.parseInt(sc.nextLine());
                dublicado = LogicaHQL.comprobarIdDublicada(opcion);

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

}
