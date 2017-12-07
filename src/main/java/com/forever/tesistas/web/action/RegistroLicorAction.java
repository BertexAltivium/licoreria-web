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

	public void validate() {
		logger.info("validate()");
		//logger.info("Información de licor a registrar: " + licor.getNombre());
		/*
		if (licor.getNombre() == null || licor.getNombre().isEmpty()) {
			logger.warn("No se recibió nombre");
			addFieldError("licor.nombre", "El nombre es requerido");
		}else{
			if (!licor.getNombre().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ&\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("licor.nombre", "El campo nombre solo admite valores alfanumericos");
        	}	
		}
		*/
		if (licor.getTipo() == null || licor.getTipo().isEmpty()) {
			logger.warn("No se recibió tipo");
			addFieldError("licor.tipo", "El tipo es requerido");
		}else{
			if (!licor.getTipo().matches("^[A-Za-z0-9\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("licor.tipo", "El campo tipo solo admite valores alfanumericos sin acentos");
        	}
		}
		if (licor.getMarca() == null || licor.getMarca().isEmpty()) {
			logger.warn("No se recibió marca");
			addFieldError("licor.marca", "La marca es requerida");
		}else{
			if (!licor.getMarca().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("licor.marca", "El campo marca solo admite valores alfanumericos");
        	}	
		}
		if (licor.getSubtipo() == null || licor.getSubtipo().isEmpty()) {
			logger.warn("No se recibió suptipo");
			addFieldError("licor.suptipo", "El suptipo es requerido");
		}else{
			if (!licor.getSubtipo().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("licor.suptipo", "El campo suptipo solo admite valores alfanumericos");
        	}	
		}
		if (licor.getDenominacion() == null || licor.getDenominacion().isEmpty()) {
			logger.warn("No se recibió denominación");
			addFieldError("licor.denominacion", "La denominacion es requerida");
		}else{
			if (!licor.getDenominacion().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("licor.denominacion", "El campo denominacion solo admite valores alfanumericos");
        	}	
		}
		if (licor.getContenidoNeto() == null || licor.getContenidoNeto().isEmpty()) {
			logger.warn("No se recibió contenido neto");
			addFieldError("licor.contenidoNeto", "El contenido neto es requerido");
		}else{
			if (!licor.getContenidoNeto().matches("^[A-Za-z0-9ñÑáéíóúÁÉÍÓÚ\\s]*{1,45}$")) {
            logger.warn("Solo admite valores alfanumericos");
            addFieldError("licor.contenidoNeto", "El campo contenido neto solo admite valores alfanumericos");
        	}	
		}
		if (licor.getAnio() == null || licor.getAnio().toString().isEmpty()) {
			logger.warn("No se recibió año");
			addFieldError("licor.anio", "El año es requerido");
		}else{
			if (!licor.getAnio().toString().matches("^[0-9]*{1,11}$")) {
            logger.warn("Solo admite valores numéricos");
            addFieldError("licor.anio", "El campo año solo admite valores numéricos");
        	}	
		}
		/*
		if (licor.getImage() == null || licor.getImage().isEmpty()) {
			logger.warn("No se recibió imagen");
			addFieldError("userImage", "La imagen es requerida");
		}else{
		
			if (!licor.getImage().matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]{1,2083}$")) {
            logger.warn("Solo admite valores alfanumericos y {+&@#/%?=~_|!:,.;}");
            addFieldError("userImage", "El campo imagen solo admite valores alfanumericos");
        	}	
		}*/

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
