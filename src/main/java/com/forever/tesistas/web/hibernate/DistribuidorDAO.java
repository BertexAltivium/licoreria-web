package com.forever.tesistas.web.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.forever.tesistas.web.pojo.RegistroSucursal;

public class DistribuidorDAO extends BaseHibernateDAO {
	public List<Distribuidor> getAllDistribuidores() {
		return (List<Distribuidor>) (Object) findAll(Distribuidor.class);
	}

    public void saveDistribuidor(Distribuidor distribuidor) {
        super.save(distribuidor);
    }

    public void updateDistribuidor(Distribuidor distribuidor) {
        super.saveOrUpdate(distribuidor);
    }
    
	public Distribuidor getById(Integer id) {
		Criteria criteria = getSession().createCriteria(Distribuidor.class).add(Restrictions.eq("id", id.intValue()));
		return (Distribuidor) criteria.uniqueResult();
	}
	
	public void deleteDistribuidor(Distribuidor distribuidor) {
		super.delete(distribuidor);
	}
}