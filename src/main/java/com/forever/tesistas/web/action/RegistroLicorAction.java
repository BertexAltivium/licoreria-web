package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Licor;
import com.forever.tesistas.web.hibernate.LicorDAO;

public class RegistroLicorAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroLicorAction.class);

	private Licor licor;
	

	private Integer licorId;

	public String addLicor() {
		logger.info("addLicor()");

		logger.info("Licor: " + licor);
		
		Boolean admin = isAdmin();
		if (!admin) {
			return "noAdmin";
		}
		LicorDAO licorDAO = new LicorDAO();
		if (licor.getId()!= null) {
			licorDAO.updateLicor(licor);
			logger.info("Licor actualizado");

		} else {
			licorDAO.saveLicor(licor);
			logger.info("Licor agregado");

		}
		logger.info("Licor Id" + licor.getId());
		return "success";
	}
	
	
	public String editLicor() {
		
		
		
		logger.info("editLicor()");

		logger.info("Licor: " + licor);
		logger.info("id as param" + licorId);
		
		Boolean admin = isAdmin();
		if (!admin) {
			return "noAdmin";
		}
		if (licor.getId()== null) {
			licor.setId(licorId);
		}
		LicorDAO licorDAO = new LicorDAO();
		licorDAO.updateLicor(licor);
		logger.info("Licor agregado");
		logger.info("Licor Id" + licor.getId());
		return "success";
	}
	
	public String deleteLicor() {
		if (licor == null || licor.getId() == null) {
			return "nothingToDelete";
		}
		else {
			LicorDAO licorDAO = new LicorDAO();
			licorDAO.deleteLicor(licor);
			return "success";
		}
	}
	

	/**
	 * @return the licor
	 */
	public Licor getLicor() {
		return licor;
	}

	/**
	 * @param licor
	 *            the licor to set
	 */
	public void setLicor(Licor licor) {
		
		
		this.licor = licor;
	}

	public void validate() {
		if (licor.getAnio() == 0) {
			addFieldError("usuario.anio", "El año es requerido");
		}
	}

	public Integer getLicorId() {
		return licorId;
	}

	public void setLicorId(Integer licorId) {
		this.licorId = licorId;
	}

}
