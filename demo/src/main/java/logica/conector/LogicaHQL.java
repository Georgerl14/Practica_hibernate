package logica.conector;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tablas.Alumno;
import tablas.Escuela;
import tablas.Profesor;

public class LogicaHQL {

    public static List<Escuela> insertarListaEscuelas() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Escuela> query = session.createQuery("SELECT e FROM Escuela e", Escuela.class);
        List<Escuela> listaEscuelas = query.list();
        return listaEscuelas;
    }

    public static List<Alumno> insertarListaAlumnos(Escuela escuela) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Alumno> query = session.createQuery("SELECT a FROM Alumno a where a.escuela.escuelaId.idEscuela = :ident", Alumno.class);
        query.setParameter("ident", escuela.getEscuelaId().getIdEscuela());

        List<Alumno> listaAlumnos = query.list();
        return listaAlumnos;
    }

    public static List<Profesor> insertarListaProfesores(Escuela escuela) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Profesor> query = session.createQuery("SELECT p FROM Profesor p, Escuela e where e.escuelaId.idEscuela = :ident", Profesor.class);
        query.setParameter("ident", escuela.getEscuelaId().getIdEscuela());

        List<Profesor> listaProfesores = query.list();
        return listaProfesores;
    }


    public static boolean comprobarIdEscuela(int id) {
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

    public static boolean comprobarNombreDirector(int id) {
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

    public static boolean comprobarIdProfesor(int id) {
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

    public static boolean comprobarIdAlumno(int idEscuela, int idAlumno) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query<Object> query = session.createQuery("SELECT a.id FROM Alumno a where a.id = :idAlumno and a.escuela.escuelaId.idEscuela = :idEscuela");
            query.setParameter("idEscuela", idEscuela);
            query.setParameter("idAlumno", idAlumno);

            Integer id = (Integer) query.uniqueResult();
            if (id != null)
                return true;
            else
                return false;
                
        } catch (Exception e) {
            return true;
        }
    }
}
