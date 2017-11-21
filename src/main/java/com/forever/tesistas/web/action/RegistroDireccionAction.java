package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;
import com.forever.tesistas.web.hibernate.AddressDAO;
import com.forever.tesistas.web.hibernate.Address;
import com.opensymphony.xwork2.ActionSupport;


public class RegistroDireccionAction extends BaseAction{


	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroDireccionAction.class);
	
	private Address address;
	//private String ;
	
	public String addAddress() {
		logger.info("addDireccion()");
		logger.info("Address: " + address);
		AddressDAO addressDAO = new AddressDAO();
	
		addressDAO.saveAddress(address);
		logger.info("Address guardada exitosamente");

        getSession().put("numero", address.getNumero());
        getSession().put("calle", address.getCalle());
        getSession().put("colonia", address.getColonia());

        //getSession().put("isAdmin", usuario.getAdmin());
		
		return "success";
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param addres to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	

}