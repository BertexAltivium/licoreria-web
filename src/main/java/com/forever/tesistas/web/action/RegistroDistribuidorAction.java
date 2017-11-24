package com.forever.tesistas.web.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Address;
import com.forever.tesistas.web.hibernate.AddressDAO;
import com.forever.tesistas.web.hibernate.Distribuidor;
import com.forever.tesistas.web.hibernate.DistribuidorDAO;
import com.forever.tesistas.web.pojo.RegistroDistribuidor;

public class RegistroDistribuidorAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroDistribuidorAction.class);

	private Distribuidor distribuidor;
	// private String direccion;
	// private String idAddressSeleccionado;


	private String idDireccion;

	public String addDistribuidor() {

		logger.info("addDistribuidor()");
		logger.info("Distribuidor a guardar: " + distribuidor);

		AddressDAO direccionDAO = new AddressDAO();

		Address direccion = direccionDAO.getAddressById(Integer.parseInt(idDireccion));
		distribuidor.setAddress(direccion);

		DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
		distribuidorDAO.saveDistribuidor(distribuidor);
		logger.info("Distribuidor guardada exitosamente");

		return "success";
	}

	public void validate() {
		logger.info("validate()");

		logger.info("Información de distribuidor a registrar: " + distribuidor.getNombre());

		if (distribuidor.getNombre() == null || distribuidor.getNombre().isEmpty()) {
			logger.warn("No se recibió nombre");
			addFieldError("nombre", "El nombre es requerido");
		}

	}


	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}



}