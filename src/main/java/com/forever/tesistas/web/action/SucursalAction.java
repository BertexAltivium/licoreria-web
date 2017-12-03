package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;
import com.forever.tesistas.web.pojo.RegistroSucursal;
import com.forever.tesistas.web.hibernate.SucursalDAO;
import com.forever.tesistas.web.hibernate.Sucursal;
import com.forever.tesistas.web.hibernate.AddressDAO;
import com.forever.tesistas.web.hibernate.Address;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.Hibernate;

public class SucursalAction extends BaseAction{


	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(SucursalAction.class);
	
	private String nombre;
	//private String direccion;
	private RegistroSucursal registroSucursal;
	//private String idAddressSeleccionado;
	
	public String addSucursal() {
		
		logger.info("addSucursal()");
		logger.info("registroSucursal: "+registroSucursal.toString());
		//logger.info("id direccion seleccionado: "+idAddressSeleccionado);
		logger.info("nombre: "+nombre);
		registroSucursal.setnombre(nombre);
		AddressDAO addressDAO = new AddressDAO();
		Sucursal sucursal = new Sucursal();
		sucursal.setNombre(nombre);
		//Sucursal sucursal = new Sucursal((Address)addressDAO.getAddressById(Integer.parseInt(registroSucursal.getDireccion())), registroSucursal.getNombre());
		SucursalDAO sucursalDAO = new SucursalDAO();
		sucursalDAO.saveSucursal(sucursal);
		logger.info("Sucursal guardada exitosamente");	
		//getSession().put("nombre", sucursal.getNombre());
        //getSession().put("address", sucursal.getAddress());

        //getSession().put("isAdmin", usuario.getAdmin());
		
		return "success";
	}


	public void validate() {
        logger.info("validate()");

        logger.info("Información de sucursal a registrar: " + nombre);

        if (nombre == null || nombre.isEmpty()) {
            logger.warn("No se recibió nombre");
            addFieldError("nombre", "El nombre es requerido");
        }

        if (registroSucursal.getDireccion() == null || registroSucursal.getDireccion() == "0" || registroSucursal.getDireccion().isEmpty()) {
            addFieldError("registroSucursal.direccion", "Elige una direccion");
        }
        
    }


	/**
	 * @return the registroSucursal
	 */
	public RegistroSucursal getRegistroSucursal() {
		return registroSucursal;
	}

	/**
	 * @param registroSucursal the RegistroSucursal to set
	 */
	public void setRegistroSucursal(RegistroSucursal registroSucursal) {
		this.registroSucursal = registroSucursal;
	}
	
	
	/**
	 * @return the id of the address selected
	 */
	//public String getIdAddressSeleccionado() {
	//	return idAddressSeleccionado;
	//}

	/**
	 * @param idAddressSeleccionado of the sucursal to set
	 */
	//public void setIdAddressSeleccionado(String idAddressSeleccionado) {
	//	this.idAddressSeleccionado = idAddressSeleccionado;
	//}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	
	public String getDireccion() {
		return direccion;
	}

	public void setdireccion(String direccion) {
		this.direccion = direccion;
	}
	*/

}