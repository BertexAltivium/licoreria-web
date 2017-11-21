package com.forever.tesistas.web.hibernate;

//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;

//import com.forever.tesistas.web.pojo.RegistroDireccion;
import java.util.List;

public class AddressDAO extends BaseHibernateDAO {
   
	
	public List<Object> getAllAddress() {
        return findAll(Address.class);
    }

	public Object getAddressById(int id) {
		return findById(Address.class, id);
	}
	
    public void saveAddress(Address address) {
        super.save(address);
    }

    public void updateAddress(Address address) {
        super.saveOrUpdate(address);
    }
}