package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Distribuidor;
import com.forever.tesistas.web.hibernate.DistribuidorDAO;

public class RegistroDistribuidorAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroDistribuidorAction.class);

	private Distribuidor distribuidor;

	private String idDireccion;

	public String addDistribuidor() {

		logger.info("addDistribuidor()");
		logger.info("Distribuidor a guardar: " + distribuidor);

		DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
		if (distribuidor.getId() != null) {
			distribuidorDAO.updateDistribuidor(distribuidor);
		} else {
			distribuidorDAO.saveDistribuidor(distribuidor);
		}
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