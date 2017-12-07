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
	private boolean edit = false;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	private HttpServletRequest servletRequest;

	/**
	 * Add a new Licor to the database, if it exist update it.
	 * 
	 * @return
	 */
	public String addLicor() {
		logger.info("addLicor()");

		logger.info("Licor: " + licor);

		if (!isAdmin()) {
			return "noAdmin";
		}

		logger.info("file " + userImage);

		if (userImage != null) {
			saveLicorImage();

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

	/**
	 * Save Licor image and replace the old file if it exists.
	 */
	private void saveLicorImage() {
		try {
			String filePath = ImageAction.IMAGE_PATH;
			logger.info("Server path: " + filePath);
			this.userImageFileName = UUID.randomUUID() + this.userImageFileName;
			File fileToCreate;
			if (licor.getImage() != null && !licor.getImage().isEmpty()) {
				fileToCreate = new File(filePath, licor.getImage());
			} else {
				fileToCreate = new File(filePath, this.userImageFileName);
				licor.setImage(filePath + this.userImageFileName);
			}
			FileUtils.copyFile(this.userImage, fileToCreate);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
	}

	/**
	 * Delete a licor from the database, also delete his image if it exists.
	 * 
	 * @return
	 */
	public String deleteLicor() {
		if (!isAdmin()) {
			return "noAdmin";
		}

		if (licor == null || licor.getId() == null) {
			return "nothingToDelete";
		} else {
			if (licor.getImage() != null) {
				FileUtils.deleteQuietly(new File(licor.getImage()));
			}
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

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

}
