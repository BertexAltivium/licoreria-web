package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Sucursal;
import com.forever.tesistas.web.hibernate.SucursalDAO;

public class SucursalAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(SucursalAction.class);

	private Sucursal sucursal;
	private Integer sucursalId;

	public String addSucursal() {
		logger.info("addSucursal()");

		if (!isAdmin()) {
			return "noAdmin";
		}
		logger.info("addSucursal()");
		SucursalDAO sucursalDAO = new SucursalDAO();
		if (sucursal.getId() != null) {
			sucursalDAO.updateSucursal(sucursal);
		} else {
			addActionMessage("Sucursal " + sucursal.getNombre() + " agregada correctamente!!");
			sucursalDAO.saveSucursal(sucursal);
		}
		logger.info("Sucursal guardada exitosamente");

		return "success";
	}

	public void validate() {
		logger.info("validate()");
		logger.info("Información de sucursal a registrar: " + sucursal.getNombre());

		if (sucursal.getNombre() == null || sucursal.getNombre().isEmpty()) {
			logger.warn("No se recibió nombre");
			addFieldError("sucursal.nombre", "El nombre es requerido");
		}else{
			if (!sucursal.getNombre().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("sucursal.nombre", "El campo nombre solo admite valores alfanumericos");
        	}	
		}
		if (sucursal.getAddress().getNumero() == null || sucursal.getAddress().getNumero().isEmpty()) {
			logger.warn("No se recibió número de la dirección");
			addFieldError("sucursal.address.numero", "El número es requerido");
		}else{
			if (!sucursal.getAddress().getNumero().matches("^[A-Za-z0-9\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("sucursal.address.numero", "El campo número solo admite valores alfanumericos sin acentos");
        	}
		}
		if (sucursal.getAddress().getCalle() == null || sucursal.getAddress().getCalle().isEmpty()) {
			logger.warn("No se recibió la calle de la dirección");
			addFieldError("sucursal.address.calle", "La calle es requerida");
		}else{
			if (!sucursal.getAddress().getCalle().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("sucursal.address.calle", "El campo calle solo admite valores alfanumericos");
        	}	
		}
		if (sucursal.getAddress().getColonia() == null || sucursal.getAddress().getColonia().isEmpty()) {
			logger.warn("No se recibió la colonia de la dirección");
			addFieldError("sucursal.address.colonia", "La colonia es requerida");
		}else{
			if (!sucursal.getAddress().getColonia().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("sucursal.address.colonia", "El campo colonia solo admite valores alfanumericos");
        	}	
		}
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}

}