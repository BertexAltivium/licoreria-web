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
			addFieldError("distribuidor.nombre", "El nombre es requerido");
		}else{
			if (!distribuidor.getNombre().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("distribuidor.nombre", "El campo nombre solo admite valores alfanumericos");
        	}	
		}
		if (distribuidor.getAddress().getNumero() == null || distribuidor.getAddress().getNumero().isEmpty()) {
			logger.warn("No se recibió número de la dirección");
			addFieldError("distribuidor.address.numero", "El número es requerido");
		}else{
			if (!distribuidor.getAddress().getNumero().matches("^[A-Za-z0-9\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("distribuidor.address.numero", "El campo número solo admite valores alfanumericos sin acentos");
        	}
		}
		if (distribuidor.getAddress().getCalle() == null || distribuidor.getAddress().getCalle().isEmpty()) {
			logger.warn("No se recibió la calle de la dirección");
			addFieldError("distribuidor.address.calle", "La calle es requerida");
		}else{
			if (!distribuidor.getAddress().getCalle().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("distribuidor.address.calle", "El campo calle solo admite valores alfanumericos");
        	}	
		}
		if (distribuidor.getAddress().getColonia() == null || distribuidor.getAddress().getColonia().isEmpty()) {
			logger.warn("No se recibió la colonia de la dirección");
			addFieldError("distribuidor.address.colonia", "La colonia es requerida");
		}else{
			if (!distribuidor.getAddress().getColonia().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("distribuidor.address.colonia", "El campo colonia solo admite valores alfanumericos");
        	}	
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