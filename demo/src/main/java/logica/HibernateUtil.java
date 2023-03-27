package logica;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){
		//Elimana la información 'INFO' de la terminal.
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		try{
			//Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory(
		new StandardServiceRegistryBuilder().configure().build());
		}
		catch(Throwable ex){
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed."+ex);
		throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}