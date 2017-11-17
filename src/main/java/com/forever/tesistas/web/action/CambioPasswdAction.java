package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Usuario;
import com.forever.tesistas.web.hibernate.UsuarioDAO;
import com.forever.tesistas.web.pojo.CambioPassword;
import com.forever.tesistas.web.pojo.Login;

/**
 * Acciones que un usuario con sesión iniciada puede hacer sobre ella:<br/>
 * <ul>
 * <li>Cambiar contraseña</li>
 * <li>Cerrar sesión</li>
 * </ul>
 *
 * @author Gabriel Gonzalez
 */
public class CambioPasswdAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(CambioPasswdAction.class);

    private CambioPassword cambioPassword;

    public String cambiarPassword() {
        logger.debug("cambiarPassword()");

        String mail = getSession().get("mail").toString();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.login(new Login(mail, cambioPassword.getPasswdAnterior()));

        try {
            if (usuario != null) {
                usuario.setPassword(cambioPassword.getPasswdNuevo());
                logger.debug("Actualizando contraseña");
                usuarioDAO.updateUsuario(usuario);
                addActionMessage("Contraseña cambiada exitosamente");
                return "success";
            } else {
                addActionError("La contraseña anterior no es correcta");
                return "passwd-no-cambiado";
            }
        } catch (Exception e) {
            addActionError(e.getMessage());
            return "error";
        }
    }

    public void validate() {
        logger.debug("validate()");

        logger.debug("Evaluando el POJO: " + cambioPassword);

        if (cambioPassword.getPasswdAnterior() == null || cambioPassword.getPasswdAnterior().isEmpty()) {
            addFieldError("cambioPassword.passwdAnterior", "Contraseña anterior requerida");
        }

        if (cambioPassword.getPasswdNuevo() == null || cambioPassword.getPasswdNuevo().isEmpty()) {
            addFieldError("passwordConfirn", "Contraseña nueva requerida");
        }

        // Si la contraseña y su confirmación no coinciden
        if (!cambioPassword.getPasswdNuevo().equals(cambioPassword.getPasswdConfirmacion())) {
            addFieldError("usuario.password", "La contraseña y su confirmación no coinciden");
        }
    }

    /**
     * @return the cambioPassword
     */
    public CambioPassword getCambioPassword() {
        return cambioPassword;
    }

    /**
     * @param cambioPassword the cambioPassword to set
     */
    public void setCambioPassword(CambioPassword cambioPassword) {
        this.cambioPassword = cambioPassword;
    }
}
