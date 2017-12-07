package com.forever.tesistas.web.action;


import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.forever.tesistas.web.action.utils.ImageAction;
import com.forever.tesistas.web.hibernate.Producto;
import com.forever.tesistas.web.hibernate.ProductoDAO;
import com.forever.tesistas.web.hibernate.Sucursal;
import com.forever.tesistas.web.hibernate.SucursalDAO;


public class RegistroProductoAction extends BaseAction implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(RegistroProductoAction.class);

	private Producto producto;
	private Integer productoId;
	private boolean edit = false;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private List<String> sucursales;
	private int sucursalIdx;

	private HttpServletRequest servletRequest;

	public void prepare() throws Exception {
		logger.info("prepare");
		SucursalDAO sucursalDAO = new SucursalDAO();
		//sucursales = sucursalDAO.getAllSucursalesStrings();
		
		Object tipo = getSession().get("sucursal");
		
		logger.info("sucursal: " + getSession().values());

		if (tipo != null) {
			sucursalIdx = Collections.binarySearch(sucursales, (String)tipo);

		}
	}


	/**
	 * Add a new Producto to the database, if it exist update it.
	 * 
	 * @return
	 */
	public String addProducto() {
		logger.info("addProducto()");

		logger.info("Producto: " + producto.toString());

		if (!isAdmin()) {
			return "noAdmin";
		}

		//logger.info("file " + userImage);

		/*
		if (userImage != null) {
			saveProductoImage();

		}
		*/

		ProductoDAO productoDAO = new ProductoDAO();
		if (producto.getId() != null) {
			productoDAO.updateProducto(producto);
			logger.info("Producto actualizado");

		} else {
			logger.info("factura "+producto.getFactura().getId());

			productoDAO.saveProducto(producto);
			logger.info("Producto agregado");

		}
		logger.info("Producto Id" + producto.getId());
		return "success";
	}

	/**
	 * Save Producto image and replace the old file if it exists.
	 */
	/*
	private void saveProductoImage() {
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
	*/

	/**
	 * Delete a licor from the database, also delete his image if it exists.
	 * 
	 * @return
	 */
	public String deleteProducto() {
		if (!isAdmin()) {
			return "noAdmin";
		}

		if (producto == null || producto.getId() == null) {
			return "nothingToDelete";
		} else {
			/*
			if (producto.getImage() != null) {
				FileUtils.deleteQuietly(new File(producto.getImage()));
			}
			*/
			ProductoDAO productoDAO = new ProductoDAO();
			productoDAO.deleteProducto(producto);
			return "success";
		}
	}

/*
	public void validate() {
		logger.info("validate()");
		//logger.info("Información de licor a registrar: " + licor.getNombre());
		
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
		
		if (licor.getImage() == null || licor.getImage().isEmpty()) {
			logger.warn("No se recibió imagen");
			addFieldError("userImage", "La imagen es requerida");
		}else{
		
			if (!licor.getImage().matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]{1,2083}$")) {
            logger.warn("Solo admite valores alfanumericos y {+&@#/%?=~_|!:,.;}");
            addFieldError("userImage", "El campo imagen solo admite valores alfanumericos");
        	}	
		}

	}
*/

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto
	 *            the producto to set
	 */
	public void setProducto(Producto producto) {

		this.producto = producto;
	}

	public Integer getProductoId() {
		return productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
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
