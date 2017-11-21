package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;
import com.forever.tesistas.web.pojo.RegistroDistribuidor;
import com.forever.tesistas.web.hibernate.DistribuidorDAO;
import com.forever.tesistas.web.hibernate.Distribuidor;
import com.forever.tesistas.web.hibernate.AddressDAO;
import com.forever.tesistas.web.hibernate.Address;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.Hibernate;

public class RegistroDistribuidorAction extends BaseAction{


	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroDistribuidorAction.class);
	
	private String nombre;
	//private String direccion;
	private RegistroDistribuidor registroDistribuidor;
	//private String idAddressSeleccionado;
	
	public String addDistribuidor() {
		
		logger.info("addDistribuidor()");
		logger.info("registroDistribuidor: "+registroDistribuidor.toString());
		//logger.info("id direccion seleccionado: "+idAddressSeleccionado);
		logger.info("nombre: "+nombre);
		registroDistribuidor.setnombre(nombre);
		AddressDAO addressDAO = new AddressDAO();
		Distribuidor distribuidor = new Distribuidor();
		distribuidor.setNombre(nombre);
		//Sucursal sucursal = new Sucursal((Address)addressDAO.getAddressById(Integer.parseInt(registroSucursal.getDireccion())), registroSucursal.getNombre());
		DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
		distribuidorDAO.saveDistribuidor(distribuidor);
		logger.info("Distribuidor guardada exitosamente");	
		//getSession().put("nombre", sucursal.getNombre());
        //getSession().put("address", sucursal.getAddress());

        //getSession().put("isAdmin", usuario.getAdmin());
		
		return "success";
	}


	public void validate() {
        logger.info("validate()");

        logger.info("Información de distribuidor a registrar: " + nombre);

        if (nombre == null || nombre.isEmpty()) {
            logger.warn("No se recibió nombre");
            addFieldError("nombre", "El nombre es requerido");
        }

        if (registroDistribuidor.getDireccion() == null || registroDistribuidor.getDireccion() == "0" || registroDistribuidor.getDireccion().isEmpty()) {
            addFieldError("registroDistribuidor.direccion", "Elige una direccion");
        }
        
    }


	/**
	 * @return the registroDistribuidor
	 */
	public RegistroDistribuidor getRegistroDistribuidor() {
		return registroDistribuidor;
	}

	/**
	 * @param registroDistribuidor the RegistroDistribuidor to set
	 */
	public void setRegistroDistribuidor(RegistroDistribuidor registroDistribuidor) {
		this.registroDistribuidor = registroDistribuidor;
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