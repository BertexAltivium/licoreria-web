package com.forever.tesistas.web.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Distribuidor;
import com.forever.tesistas.web.hibernate.DistribuidorDAO;
import com.forever.tesistas.web.hibernate.Licor;
import com.forever.tesistas.web.hibernate.LicorDAO;
import com.forever.tesistas.web.hibernate.Sucursal;
import com.forever.tesistas.web.hibernate.Usuario;
import com.forever.tesistas.web.pojo.CambioPassword;
import com.forever.tesistas.web.pojo.Login;

/**
 * @author Gabriel Gonzalez
 * @author bertex
 */
public class MostrarFormasAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(MostrarFormasAction.class);

	private Login login;
	private Usuario usuario;
	private CambioPassword cambioPassword;
	private boolean edit = false;

	private Integer licorId;
	private Integer distribuidorId;

	private List<Licor> licores;
	private List<Distribuidor> distribuidores;
	private Licor licor;
	private Distribuidor distribuidor;
	private Sucursal sucursal;


	/**
	 * Acción por defecto que preparará la forma web para el inicio de sesión del
	 * usuario.
	 * <p>
	 * Esta función que será ejecutada por la acción showLoginForm definida en el
	 * archivo de configuración struts.xml.
	 *
	 * @return
	 */
	public String showLoginForm() {
		logger.info("showLoginForm()");

		logger.debug("Instanciando POJO para la forma login");
		login = new Login();

		return "success";
	}

	public String showRegisterForm() {
		logger.info("showRegisterForm()");

		usuario = new Usuario();

		return "success";
	}

	public String showEditLicorForm() {
		logger.info("showEditAlcohol");

		if (licorId != null) {
			LicorDAO licorDAO = new LicorDAO();
			licor = licorDAO.getById(licorId);
			logger.info("licor " + licor);
		}
		if (!isAdmin() ) {
			return "noAdmin";
		}
		return "success";
	}

	public String showChangePasswordForm() {
		logger.info("showChangePasswordForm()");
		cambioPassword = new CambioPassword();
		return "success";
	}

	public String showHome() {
		logger.info("showHome");
		LicorDAO licorDAO = new LicorDAO();
		licores = licorDAO.getAllLicors();
		logger.info("hay " + licores.size() + " licores");
		logger.info("licores" + licores);
		return "success";
	}

	public String showAddLicorForm() {
		if (!isAdmin()) {
			return "noAdmin";
		}
		return "success";
	}



	/**
	 * Inicia sección correspondiente a Distribuidores
	 */
	public String showDistribuidorList() {
		logger.info("showDistribuidorList");
		DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
		distribuidores = distribuidorDAO.getAllDistribuidores();
		logger.info(distribuidores);
		return "success";
	}

	public String showDistribuidorForm() {
		logger.info("showDistribuidorForm()");
		if (!isAdmin()) {
			return "noAdmin";
		}

		if (distribuidorId != null) {
			edit = true;
			DistribuidorDAO distribuidorDAO = new DistribuidorDAO();
			distribuidor = distribuidorDAO.getById(distribuidorId);
			logger.info("Distribuidor " + distribuidor);
		}
		if (!isAdmin()) {
			return "noAdmin";
		}

		logger.debug("Instanciando POJO para la forma distribuidor");

		return "success";
	}

	/*
	 * Termina seccion Distribuidores
	 */

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the cambioPassword
	 */
	public CambioPassword getCambioPassword() {
		return cambioPassword;
	}

	/**
	 * @param cambioPassword
	 *            the cambioPassword to set
	 */
	public void setCambioPassword(CambioPassword cambioPassword) {
		this.cambioPassword = cambioPassword;
	}



	public List<Licor> getLicores() {
		return licores;
	}

	public void setLicores(List<Licor> licores) {
		this.licores = licores;
	}

	public Integer getLicorId() {
		return licorId;
	}

	public void setLicorId(Integer licorId) {
		this.licorId = licorId;
	}

	public Licor getLicor() {
		return licor;
	}

	public void setLicor(Licor licor) {
		this.licor = licor;
	}



	public Integer getDistribuidorId() {
		return distribuidorId;
	}

	public void setDistribuidorId(Integer distribuidorId) {
		this.distribuidorId = distribuidorId;
	}

	public List<Distribuidor> getDistribuidores() {
		return distribuidores;
	}

	public void setDistribuidores(List<Distribuidor> distribuidores) {
		this.distribuidores = distribuidores;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}
