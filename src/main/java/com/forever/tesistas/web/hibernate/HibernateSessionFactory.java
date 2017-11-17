package com.forever.tesistas.web.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Gabriel Gonzalez
 */
@SuppressWarnings("deprecation")
public class HibernateSessionFactory {
    private static final Logger logger = Logger.getLogger(HibernateSessionFactory.class);

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static org.hibernate.SessionFactory sessionFactory;

    private static Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Error en el manejo de la sesión con hibernate");
            e.printStackTrace();
            logger.error("Error en el manejo de la sesión con hibernate", e);
        }
    }

    private HibernateSessionFactory() {
    }

    /**
     * Regresa el Thread Local con la instancia de sesión. La inicialización es de forma Lazy
     * para <code>SessionFactory</code> si es que se necesita.
     *
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() {
        //logger.debug("getSession()");
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            //logger.debug("Sesión nula o cerrada");
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            //logger.debug("Reconstruyendo la sesión");
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }
        return session;
    }

    /**
     * Reconstruye la sesión
     *
     * @throws DatabaseOperationException
     */
    public static void rebuildSessionFactory() {
        try {
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Error en la reconstrucción de la sesión");
            e.printStackTrace();
            logger.error("Error en la reconstrucción de la sesión", e);
        }
    }

    /**
     * Cierre del thread con la sesión actual de hibernate
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * return session factory
     */
    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * return hibernate configuration
     */
    public static Configuration getConfiguration() {
        return configuration;
    }

}
