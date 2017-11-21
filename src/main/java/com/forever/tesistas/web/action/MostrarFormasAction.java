package com.forever.tesistas.web.action;

import java.util.List;
import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Usuario;
import com.forever.tesistas.web.hibernate.Address;
import com.forever.tesistas.web.hibernate.AddressDAO;
import com.forever.tesistas.web.pojo.CambioPassword;
import com.forever.tesistas.web.pojo.Login;
import com.forever.tesistas.web.pojo.RegistroSucursal;
import com.forever.tesistas.web.pojo.RegistroDistribuidor;




/**
 * @author Gabriel Gonzalez
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
	private Boolean admin;
	private List<Address> direcciones;

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

	public String showChangePasswordForm() {
		logger.info("showChangePasswordForm()");
		cambioPassword = new CambioPassword();
		return "success";
	}

	public String showHome() {

		admin = (Boolean) getSession().get("isAdmin");
		if (admin == null) {
			admin = false;
		}
		return "success";
	}
	
	public String showAddLicorForm() {
		admin = (Boolean) getSession().get("isAdmin");
		if (admin == null) {
			admin = false;
			return "noAdmin";
		}
		return "success";
	}

	public String showDireccionForm() {
		admin = (Boolean) getSession().get("isAdmin");
		if (admin == null) {
			admin = false;
			return "noAdmin";
		}
        return "success";
    }

    /**
     * Inicia seccion correspondiente a Sucursales
   	*/
    public String showSucursalForm() {
        admin = (Boolean) getSession().get("isAdmin");
		if (admin == null) {
			admin = false;
			return "noAdmin";
		}
        logger.info("showSucursalForm()");
        logger.debug("Instanciando POJO para la forma sucursal");
        RegistroSucursal registroSucursal = new RegistroSucursal();
        AddressDAO addressDAO = new AddressDAO();
		direcciones = (List<Address>)(Object)addressDAO.getAllAddress();
        //logger.info("Cantidad de objetos recuperados: "+direcciones.size());
        //logger.info("direccion 1:"+direcciones.get(0).getCalle());
        
        return "success";
    }
    
    /**
     * @return the address list
     */
    public List<Address> getDirecciones() {
        return direcciones;
    }

    /**
     * @param direcciones the List<Address> to set
     */
    public void setDirecciones(List<Address> direcciones) {
        this.direcciones = direcciones;
    }

    /*
    * Termina seccion correspondiente a Sucursales
    */

     /**
     * Inicia seccion correspondiente a Distribuidores
   	*/
    public String showDistribuidorForm() {
        admin = (Boolean) getSession().get("isAdmin");
		if (admin == null) {
			admin = false;
			return "noAdmin";
		}
        logger.info("showDistribuidorForm()");
        logger.debug("Instanciando POJO para la forma distribuidor");
        RegistroDistribuidor registroDistribuidor = new RegistroDistribuidor();
        AddressDAO addressDAO = new AddressDAO();
		direcciones = (List<Address>)(Object)addressDAO.getAllAddress();
        //logger.info("Cantidad de objetos recuperados: "+direcciones.size());
        //logger.info("direccion 1:"+direcciones.get(0).getCalle());
        
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

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
