package com.forever.tesistas.web.action;

import com.forever.tesistas.web.hibernate.Licor;
import com.forever.tesistas.web.hibernate.LicorDAO;

public class AlcoholAction extends BaseAction {
	

	private static final long serialVersionUID = 1L;
	private Licor licor;
	private Integer licorId;
	
	public String deleteLicor() {
		if (!isAdmin()) {
			return "noAdmin";
		}
		LicorDAO licorDAO = new LicorDAO();
		licor = licorDAO.getById(licorId);
		if (licor == null || licor.getId() == null) {
			return "nothingToDelete";
		}
		else {
			licorDAO.deleteLicor(licor);
			addActionMessage("Licor eliminado!");
			return "success";
		}
	}
	
	public String showLicor() {
		LicorDAO licorDAO = new LicorDAO();
		licor = licorDAO.getById(licorId);
		if (licor == null || licor.getId() == null) {
			return "notFound";
		}
		else {
			return "success";
		}
	}
	
	
	public Licor getLicor() {
		return licor;
	
	}
	
	public void setLicor(Licor licor) {
		this.licor = licor;
	}

	public Integer getLicorId() {
		return licorId;
	}
	
	public void setLicorId(Integer licorId) {
		this.licorId = licorId;
	}
	
}
