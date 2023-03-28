package gestor;

import interfaz.InterfazMenuEscuela;
import logica.LogicaGeneral;
import logica.LogicaUtil;


public class App {
    public static void main(String[] args) throws Exception {
        gestorBaseDatos();
    }

    private static void gestorBaseDatos() {
        System.out.println("Gestor de la base de datos: "+"ParaHibernate"+"\n");
        while (true) {
            InterfazMenuEscuela.mostrarEscuelas();
            InterfazMenuEscuela.mostrarOpcionesEscuela();
            LogicaGeneral.ejecutarOpcionMenuPrincipal(LogicaUtil.introducirOpcionNumero(0, 4));
        }
    }
}
