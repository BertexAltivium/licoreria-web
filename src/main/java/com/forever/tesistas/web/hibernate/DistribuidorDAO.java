package com.forever.tesistas.web.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.forever.tesistas.web.pojo.RegistroSucursal;

public class DistribuidorDAO extends BaseHibernateDAO {
    /*
    public Sucursal login(RegistroSucursal sucursal) {
        Criteria criteria = getSession().createCriteria(Sucursal.class)
                .add(Restrictions.eq("email", sucursal.getNombre()));
                //.add(Restrictions.eq("password", login.getPassword()));
        return (Sucursal) criteria.uniqueResult();
    }
    */

    public void saveDistribuidor(Distribuidor distribuidor) {
        super.save(distribuidor);
    }

    public void updateDistribuidor(Distribuidor distribuidor) {
        super.saveOrUpdate(distribuidor);
    }
}