package com.forever.tesistas.web.action;

import com.forever.tesistas.web.hibernate.Usuario;
import com.forever.tesistas.web.hibernate.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

/**
 * @author Gabriel Gonzalez
 */
public class RegistroAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(RegistroAction.class);

    private Usuario usuario;
    private String passwordConfirn;

    public String registroUsuario() {
        logger.info("registroUsuario()");
        logger.info(usuario.toString());
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.saveUsuario(usuario);
        logger.info("Usuario guardado exitosamente");

        getSession().put("mail", usuario.getEmail());
        getSession().put("nombreCompleto", usuario.getNombreCompleto());
        getSession().put("isAdmin", usuario.isAdmin());

        return "success";
    }

    /**
     * Forma más básica para la validación de los campos de una forma.
     * Struts ejecutará de forma automática esta función, si alguno de los
     * valores recibidos no cumple con los criterios de validez requeridos,
     * entonces es necesario llamar a la función {@link ActionSupport#addFieldError(String, String)}.
     * Si se agrego algún error, Struts no continuará con el procesamiento de la forma y
     * en vez de eso, regresara el valor de <code>input</code> indicando que
     * hay un error en los datos de entrada.<br/>
     * Para manejar este evento, es necesario que en el archivo de configuración
     * <code>struts.xml</code> se agregue el resultado a la acción de la siguiente
     * forma <br/>
     * <pre><result name="input">/registro.jsp</result></pre>
     */
    public void validate() {
        logger.info("validate()");

        logger.info("Información de usuario a registrar: " + usuario.getEmail());

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            logger.warn("No se recibió correo");
            addFieldError("usuario.mail", "El correo es requerido");
        }

        if (!usuario.getEmail().matches(EMAIL_REGEX)) {
            logger.warn("Correo mal formado");
            addFieldError("usuario.mail", "Correo electrónico inválido");
        }

        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            addFieldError("usuario.nombre", "Nombre es requerido");
        }

        // Si el nombre tiene caracteres especiales o números
        if (!usuario.getNombre().matches(SOLO_TEXTO_REGEX)) {
            addFieldError("usuario.nombre", "Nombre inválido");
        }

        if (usuario.getApPaterno() == null || usuario.getApPaterno().isEmpty()) {
            addFieldError("usuario.apPaterno", "Apellido paterno requerido");
        }

        if (!usuario.getApPaterno().matches(SOLO_TEXTO_REGEX)) {
            addFieldError("usuario.apPaterno", "Apellido paterno inválido");
        }

        if ((usuario.getApMaterno() != null && !usuario.getApMaterno().isEmpty()) &&
                !usuario.getApMaterno().matches(SOLO_TEXTO_REGEX)) {
            addFieldError("usuario.apMaterno", "Apellido materno inválido");
        }

        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            addFieldError("usuario.password", "Contraseña requerida");
        }

        if (getPasswordConfirn() == null || getPasswordConfirn().isEmpty()) {
            addFieldError("passwordConfirn", "Confirmación de la contraseña requerida");
        }

        // Si la contraseña y su confirmación no coinciden
        if (!usuario.getPassword().equals(getPasswordConfirn())) {
            addFieldError("usuario.password", "La contraseña y su confirmación no coinciden");
        }
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the passwordConfirn
     */
    public String getPasswordConfirn() {
        return passwordConfirn;
    }

    /**
     * @param passwordConfirn the passwordConfirn to set
     */
    public void setPasswordConfirn(String passwordConfirn) {
        this.passwordConfirn = passwordConfirn;
    }
}
