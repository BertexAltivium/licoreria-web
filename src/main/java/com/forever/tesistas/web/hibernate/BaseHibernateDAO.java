package com.forever.tesistas.web.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gabriel Gonzalez
 */
public abstract class BaseHibernateDAO implements IBaseHibernateDAO {
    private static final Logger logger = Logger.getLogger(BaseHibernateDAO.class);
    private Session session;
    private Transaction tx;

    public BaseHibernateDAO() {
        session = getSession();
    }

    public Session getSession() {
        return HibernateSessionFactory.getSession();
    }


    protected List<Object> findByCriteria(Criteria criteria) {
        logger.debug("findByCriteria()");

        logger.debug("Criterio de búsqueda: " + criteria.toString());

        return criteria.list();
    }

    protected Object findById(Class<?> clazz, Object id) {
        logger.debug("findById()");
        Object obj = null;
        startOperation();
        obj = session.load(clazz, (Serializable) id);
        tx.commit();
        return obj;
    }

    protected List<Object> findAll(Class<?> clazz) {
        logger.debug("findAll()");
        Criteria criteria = getSession().createCriteria(clazz);
        return criteria.list();
    }

    protected void saveOrUpdate(Object obj) throws RuntimeException {
        logger.debug("saveOrUpdate()");
        try {
            startOperation();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            logger.error(e);
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            logger.debug("Cerrando la conexión");
            session.clear();
            session.close();
        }
    }

    protected void save(Object obj) throws RuntimeException {
        logger.debug("save()");
        try {
            startOperation();
            session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            logger.error(e);
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            logger.debug("Cerrando la conexión");
            session.clear();
            session.close();
        }
    }
    

    protected void delete(Object obj) throws RuntimeException {
        logger.debug("save()");
        try {
            startOperation();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            logger.error(e);
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            logger.debug("Cerrando la conexión");
            session.clear();
            session.close();
        }
    }

    protected void startOperation() throws HibernateException {
        logger.debug("startOperation()");

        //session = getSession();
        tx = session.beginTransaction();
    }

}