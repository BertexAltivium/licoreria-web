package com.forever.tesistas.web.hibernate;

import org.hibernate.Session;

/**
 * @author Gabriel Gonzalez
 */
public interface IBaseHibernateDAO {
    public Session getSession();
}
