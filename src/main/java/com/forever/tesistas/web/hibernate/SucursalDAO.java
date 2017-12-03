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
}