package Persistencia.ORM.Util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}//end HibernateUtil
