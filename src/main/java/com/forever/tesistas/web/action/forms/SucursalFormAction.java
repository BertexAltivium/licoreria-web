package com.forever.tesistas.web.action.forms;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;

import com.forever.tesistas.web.action.BaseAction;
import com.forever.tesistas.web.hibernate.Sucursal;
import com.forever.tesistas.web.hibernate.SucursalDAO;

public class SucursalFormAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SucursalFormAction.class);
	private boolean edit = false;
	private Sucursal sucursal;
	private List<Sucursal> sucursales;

	private Integer sucursalId;

	public String showSucursalForm() {
		logger.info("showSucursalForm()");

		if (!isAdmin()) {
			return "noAdmin";
		}

		if (sucursalId != null) {
			edit = true;
			SucursalDAO sucursalDAO = new SucursalDAO();
			sucursal = sucursalDAO.getById(sucursalId);
			logger.info("Sucursal " + sucursal);
		}

		return "success";
	}

	public String showSucursalList() {
		logger.info("showSucursalList");
		SucursalDAO sucursalDAO = new SucursalDAO();
		sucursales = sucursalDAO.getAllSucursales();
		return "success";
	}

	public String deleteSucursal() {
		logger.info("addSucursal()");

		if (!isAdmin()) {
			return "noAdmin";
		}

		SucursalDAO sucursalDAO = new SucursalDAO();
		sucursal = sucursalDAO.getById(sucursalId);
		if (sucursal == null || sucursal.getId() == null) {
			return "nothingToDelete";
		} else {
			sucursalDAO.deleteSucursal(sucursal);
			addActionMessage("Sucursal " + sucursal.getNombre() + " eliminada!");

			return "success";
		}
	}
	
	public void validate() {
		logger.info("validate()");

	}


	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

}
