package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Licor;
import com.forever.tesistas.web.hibernate.LicorDAO;

public class RegistroLicorAction extends BaseAction{


	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroLicorAction.class);
	
	private Licor licor;
	
	public String addLicor() {
		logger.info("addLicor()");
		
		logger.info("Licor: " + licor);
		LicorDAO licorDAO = new LicorDAO();
		licorDAO.saveLicor(licor);
		logger.info("Licor agregado");
		logger.info("Licor Id" + licor.getId());
		return "success";
	}

	/**
	 * @return the licor
	 */
	public Licor getLicor() {
		return licor;
	}

	/**
	 * @param licor the licor to set
	 */
	public void setLicor(Licor licor) {
		this.licor = licor;
	}
	
	
	public void validate() {
		if (licor.getAnio() == 0 ) {
            addFieldError("usuario.anio", "El año es requerido");
		}
	}



	
}
