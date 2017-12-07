package com.forever.tesistas.web.action;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.forever.tesistas.web.action.utils.ImageAction;
import com.forever.tesistas.web.hibernate.Licor;
import com.forever.tesistas.web.hibernate.LicorDAO;

public class RegistroLicorAction extends BaseAction implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroLicorAction.class);

	private Licor licor;
	private Integer licorId;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	
	private HttpServletRequest servletRequest;



	public String addLicor() {
		logger.info("addLicor()");

		logger.info("Licor: " + licor);

		if (!isAdmin()) {
			return "noAdmin";
		}
		logger.info("file " + userImage);
		if (userImage != null) {
			try {
				String filePath = ImageAction.IMAGE_PATH;
				logger.info("Server path: " + filePath);
				this.userImageFileName = UUID.randomUUID() + this.userImageFileName;
				File fileToCreate = new File(filePath, this.userImageFileName );
				FileUtils.copyFile(this.userImage, fileToCreate);
				licor.setImage(filePath + this.userImageFileName);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
			}
		}


		LicorDAO licorDAO = new LicorDAO();
		if (licor.getId() != null) {
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
		if (licor.getId() == null) {
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
		} else {
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

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
