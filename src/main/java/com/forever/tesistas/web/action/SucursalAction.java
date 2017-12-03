package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Distribuidor;
import com.forever.tesistas.web.hibernate.DistribuidorDAO;
import com.forever.tesistas.web.hibernate.Sucursal;
import com.forever.tesistas.web.hibernate.SucursalDAO;

public class SucursalAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(SucursalAction.class);

	private Boolean admin;
	private Sucursal sucursal;
	private Boolean logged;
	private Integer sucursalId;

	public String addSucursal() {
		logger.info("addSucursal()");

		admin = isAdmin();
		if (!admin) {
			return "noAdmin";
		}
		logger.info("addSucursal()");
		SucursalDAO sucursalDAO = new SucursalDAO();
		if (sucursal.getId() != null) {
			sucursalDAO.updateSucursal(sucursal);
		} else {
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
			addFieldError("nombre", "El nombre es requerido");
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