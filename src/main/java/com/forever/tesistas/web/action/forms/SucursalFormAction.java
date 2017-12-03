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
	private Boolean admin;
	private boolean edit = false;
	private boolean logged = false;
	private Sucursal sucursal;
	private List<Sucursal> sucursales;

	private Integer sucursalId;

	public String showSucursalForm() {
		logger.info("showSucursalForm()");
		admin = isAdmin();

		if (!admin) {
			return "noAdmin";
		}

		if (sucursalId != null) {
			edit = true;
			SucursalDAO sucursalDAO = new SucursalDAO();
			sucursal = sucursalDAO.getById(sucursalId);
			logger.info("Sucursal " + sucursal);
		}
		admin = (Boolean) getSession().get("isAdmin");

		return "success";
	}

	public String showSucursalList() {
		logger.info("showSucursalList");
		SucursalDAO sucursalDAO = new SucursalDAO();
		sucursales = sucursalDAO.getAllSucursales();
		admin = isAdmin();
		SessionMap<String, Object> session = getSession();
		Object objectSession = getSession().get("logged");
		if (objectSession != null) {
			logged = (Boolean) objectSession;
		}
		return "success";
	}

	public String deleteSucursal() {
		logger.info("addSucursal()");

		admin = isAdmin();
		if (!admin) {
			return "noAdmin";
		}

		SucursalDAO sucursalDAO = new SucursalDAO();
		sucursal = sucursalDAO.getById(sucursalId);
		if (sucursal == null || sucursal.getId() == null) {
			return "nothingToDelete";
		} else {
			sucursalDAO.deleteSucursal(sucursal);
			return "success";
		}
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
