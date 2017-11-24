package com.forever.tesistas.web.hibernate;

//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;

//import com.forever.tesistas.web.pojo.RegistroDireccion;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class AddressDAO extends BaseHibernateDAO {

	public List<Object> getAllAddress() {
		return findAll(Address.class);
	}

	public Address getAddressById(int id) {
		Criteria criteria = getSession().createCriteria(Address.class).add(Restrictions.eq("id", id));
		return (Address) criteria.uniqueResult();
	}

	public void saveAddress(Address address) {
		super.save(address);
	}

	public void updateAddress(Address address) {
		super.saveOrUpdate(address);
	}
}