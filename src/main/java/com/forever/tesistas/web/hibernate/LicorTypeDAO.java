package com.forever.tesistas.web.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class LicorTypeDAO extends BaseHibernateDAO {
	@SuppressWarnings("unchecked")
	public List<LicorType> getAllLicorsTypes() {
		return (List<LicorType>) (Object) findAll(LicorType.class);
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllLicorsTypesStrings() {
		Criteria cr = getSession().createCriteria(LicorType.class)
				.setProjection(Projections.property("licorType"));
		return cr.list();

	}

	public void saveLicorType(LicorType licorType) {
		super.save(licorType);
	}

	public void updateLicorType(LicorType licorType) {
		super.saveOrUpdate(licorType);
	}

	public void deleteLicorType(LicorType licorType) {
		super.delete(licorType);
	}
}
