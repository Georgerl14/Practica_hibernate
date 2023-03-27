package logica;

import javax.persistence.PersistenceException;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tablas.Alumno;
import tablas.Director;
import tablas.Escuela;
import tablas.EscuelaId;
import tablas.Profesor;

public class LogicaCRUD {

    public static void agregarAlgo(Object objeto){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		try {
			seccion.save(objeto);
		} catch (PersistenceException e) {
            e.printStackTrace();
			System.out.println("Error persistencia");
		} catch (Exception e) {
			System.out.println("Error generico");
			tx.rollback();
		}
		tx.commit();
	}

    public static void eliminarAlgo(Object regalo) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		seccion.delete(regalo);

		tx.commit();
	}

    
	private static void agregarAlumno() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Escuela escuela01 = new Escuela("Rey Pelayo", "Asturias", 127746789);
		EscuelaId escuelaId = new EscuelaId(2);
		Director director = new Director("Rey", "Pelayo", 15243567);

		escuela01.setEscuelaId(escuelaId);
		escuela01.setDirector(director);
		escuela01.getListaAlumno().add(new Alumno("San", "Meteo", "Rito", 12206, escuela01));

		try {
			seccion.save(escuela01);
		} catch (PersistenceException e) {
			System.out.println("Error persistencia");
		} catch (Exception e) {
			System.out.println("Error generico");
			tx.rollback();
		}

		tx.commit();
	}

	private static void agregarDirector() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		seccion.save(new Director("a", "b", 45));

		tx.commit();
	}

	public static void leerAlumno() {
		// Obtenemos el SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Abrimos la sesión mediante el SessionFactory
		Session session = sessionFactory.openSession();

		try {
			Alumno alumno = (Alumno) session.load(Alumno.class, 1);
			System.out.println("Alumno: " + alumno.getNombre());

			Alumno alumno01 = (Alumno) session.load(Alumno.class, 34);
			System.out.println("Alumno: " + alumno01.getNombre());

		} catch (ObjectNotFoundException e) {
			System.out.println("No se ha encontrado el alumno");
		}

		session.close();
	}

	public static void leerAlumnoGet() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Alumno alumno = (Alumno) session.get(Alumno.class, 1);

		if (alumno == null)
			System.out.println("No se ha encontrado el producto");
		else
			System.out.println("Alumno: " + alumno.getNombre());

		session.close();
	}

	public static void actualizarAlumno() {
		// Obtenemos el SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Abrimos la sesión mediante el SessionFactory
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			Alumno alumno = (Alumno) session.load(Alumno.class, 1);
			System.out.println("Alumno: " + alumno.getNombre());

			alumno.setNombre("Eduardo");

			session.update(alumno);
			tx.commit();
		} catch (Exception e) {
			System.out.println("No se ha encontrado el alumno");
			tx.rollback();
		}

		session.close();
	}

	private static void agregarAlumnoEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Naranco", "España", 987787878);

		Alumno alumno02 = new Alumno("Paco", "Alfonso", "Laria", 1200, escuela01);
		Alumno alumno01 = new Alumno("Javier", "Martin", "Sotem", 2200, escuela01);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		escuela01.getListaAlumno().add(alumno01);
		escuela01.getListaAlumno().add(alumno02);

		seccion.save(escuela01);

		tx.commit();
	}

	private static void eliminarAlumnoEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Naranco", "España", 987787878);

		Alumno alumno02 = new Alumno("Paco", "Alfonso", "Laria", 1200, escuela01);
		Alumno alumno01 = new Alumno("Javier", "Martin", "Sotem", 2200, escuela01);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		escuela01.getListaAlumno().add(alumno01);
		escuela01.getListaAlumno().add(alumno02);

		seccion.delete(escuela01);

		tx.commit();
	}

	private static void actualizarAlumnoEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Naranco", "Oviedo", 987787878);

		Alumno alumno02 = new Alumno(1, "Paco", "Alfonso", "Laria", 12002, escuela01);
		Alumno alumno01 = new Alumno(2, "Javier", "Tolmaren", "Sotem", 22450, escuela01);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		escuela01.getListaAlumno().add(alumno01);
		escuela01.getListaAlumno().add(alumno02);

		seccion.update(escuela01);

		tx.commit();
	}

	private static void agregarProfesorEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Profesor profesor02 = new Profesor(12, "Alfonso", "Laria", 1200);
		Profesor profesor01 = new Profesor(13, "Martin", "Sotem", 2200);

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Naranco", "España", 987787878);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		profesor01.getEscuelas().add(escuela01);
		profesor02.getEscuelas().add(escuela01);

		escuela01.getProfesores().add(profesor01);
		escuela01.getProfesores().add(profesor02);

		seccion.save(escuela01);

		tx.commit();
	}

	private static void eliminarProfesorEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Profesor profesor02 = new Profesor(12, "Alfonso", "Laria", 1200);
		Profesor profesor01 = new Profesor(13, "Martin", "Sotem", 2200);

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Naranco", "España", 987787878);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		profesor01.getEscuelas().add(escuela01);
		profesor02.getEscuelas().add(escuela01);

		escuela01.getProfesores().add(profesor01);
		escuela01.getProfesores().add(profesor02);

		seccion.delete(escuela01);

		tx.commit();
	}

	private static void actualizarProfesorEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Profesor profesor02 = new Profesor(12, "Alfonso", "Laria", 1200);
		Profesor profesor01 = new Profesor(13, "Martin", "Olman", 2900);

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Naranco", "España", 987787878);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		profesor01.getEscuelas().add(escuela01);
		profesor02.getEscuelas().add(escuela01);

		escuela01.getProfesores().add(profesor01);
		escuela01.getProfesores().add(profesor02);

		seccion.update(escuela01);

		tx.commit();
	}

	private static void agregarDirectorEscuela() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Director director01 = new Director("Director", "Director", 100000000);

		EscuelaId escuelaId = new EscuelaId();
		Escuela escuela01 = new Escuela("Monte Naranco", "España", 987787878);

		escuelaId.setIdEscuela(95);
		escuela01.setDirector(director01);
		escuela01.setEscuelaId(escuelaId);

		seccion.save(escuela01);

		tx.commit();
	}

	private static void eliminarDirector() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session seccion = sessionFactory.openSession();
		Transaction tx = seccion.beginTransaction();

		Director director01 = new Director("Director", "Director", 100000000);

		seccion.delete(director01);

		tx.commit();
	}
}
