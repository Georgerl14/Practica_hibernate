package gestor;

import interfaz.Interfaz;
import logica.LogicaGeneral;
import logica.LogicaUtil;


public class App {
    public static void main(String[] args) throws Exception {
        menuEscuelas();
    }

    private static void menuEscuelas() {
        System.out.println("Gestor de la base de datos: "+"ParaHibernate"+"\n");
        while (true) {
            Interfaz.mostrarEscuelas();
            Interfaz.mostrarOpcionesEscuela();
            LogicaGeneral.ejecutarOpcionMenuPrincipal(LogicaUtil.introducirOpcionNumero(0, 3));
        }
    }
}
