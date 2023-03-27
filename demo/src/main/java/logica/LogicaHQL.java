package logica;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tablas.Escuela;

public class LogicaHQL {

    public static List<Escuela> insertarListaEscuelas() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Escuela> query = session.createQuery("SELECT e FROM Escuela e", Escuela.class);
        List<Escuela> listaEscuelas = query.list();
        return listaEscuelas;
    }

    public static boolean comprobarIdDublicada(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query<Object> query = session.createQuery("SELECT e.escuelaId.idEscuela FROM Escuela e where e.escuelaId.idEscuela = :ident");
            query.setParameter("ident", id);

            Integer idEscuela = (Integer) query.uniqueResult();
            if (idEscuela != null)
                return true;
            else
                return false;
                
        } catch (Exception e) {
            return true;
        }
    }
}
