package com.forever.tesistas.web.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.forever.tesistas.web.pojo.RegistroSucursal;

public class SucursalDAO extends BaseHibernateDAO {

	public List<Sucursal> getAllSucursales() {
		return (List<Sucursal>) (Object) findAll(Sucursal.class);
	}

    public void saveSucursal(Sucursal sucursal) {
        super.save(sucursal);
    }

    public void updateSucursal(Sucursal sucursal) {
        super.saveOrUpdate(sucursal);
    }
    
    public void deleteSucursal(Sucursal sucursal) {
    	super.delete(sucursal);
    }
    
	public Sucursal getById(Integer id) {
		Criteria criteria = getSession().createCriteria(Sucursal.class).add(Restrictions.eq("id", id.intValue()));
		return (Sucursal) criteria.uniqueResult();
	}
}