package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Licor;

public class RegistroLicorAction extends BaseAction{


	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroLicorAction.class);
	
	private Licor licor;
	private String idGeneroSeleccionado;
	
	public String addLicor() {
		logger.info("addLicor()");
		
		logger.info("Licor: " + licor);
		
		
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



	
}
