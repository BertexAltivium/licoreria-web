package com.forever.tesistas.web.action;

import com.forever.tesistas.web.hibernate.Licor;
import com.forever.tesistas.web.hibernate.LicorDAO;

public class AlcoholAction extends BaseAction {
	
	private Licor licor;
	private Integer licorId;
	
	public String deleteLicor() {
		LicorDAO licorDAO = new LicorDAO();
		licor = licorDAO.getById(licorId);
		if (licor == null || licor.getId() == null) {
			return "nothingToDelete";
		}
		else {
			licorDAO.deleteLicor(licor);
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
