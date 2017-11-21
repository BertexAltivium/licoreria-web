package com.forever.tesistas.web.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class LicorDAO extends BaseHibernateDAO {
	@SuppressWarnings("unchecked")
	public List<Licor> getAllLicors() {
		return (List<Licor>)(Object)findAll(Licor.class);
	}

	public List<Object> getByMarca(String marca) {
		Criteria criteria = getSession().createCriteria(Licor.class).add(Restrictions.eq("marca", marca));
		return findByCriteria(criteria);
	}

	public List<Object> getByMarcaAprox(String marca) {
		Criteria criteria = getSession().createCriteria(Licor.class)
				.add(Restrictions.ilike("marca", marca, MatchMode.ANYWHERE));

		return findByCriteria(criteria);
	}

	public void saveLicor(Licor licor) {
		super.save(licor);
	}
	
	public void updateLicor(Licor licor) {
		super.saveOrUpdate(licor);
	}
	
}
