package com.forever.tesistas.web.action;

import org.apache.log4j.Logger;

import com.forever.tesistas.web.hibernate.Usuario;
import com.forever.tesistas.web.hibernate.UsuarioDAO;
import com.forever.tesistas.web.pojo.Login;

public class LoginAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginAction.class);
    private Login login;


    public String loginUsuario() {
        logger.info("loginUsuario()");

        logger.info("Información recibida: " + login);

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.login(login);

            logger.debug("usuario encontrado" + usuario);
            if (usuario == null) { // usuario no encontrado
                addActionError("Usuario y/o contraseña inválidos");
                return "not-found";
            }
            // creación de la sesión de usuario
            getSession().put("nombreCompleto", usuario.nombreCompleto());
            getSession().put("isAdmin", usuario.getAdmin());
            getSession().put("mail", usuario.getEmail());

            logger.info("Usuario encontrado: " + usuario);
            return "success";
        } catch (Exception e) {
            logger.debug("Error en login usuario" + e);
            addActionError(e.getMessage());
            return "error";
        }
    }

    public String logoutUsuario() {
        logger.info("Cerrando sesión de usuario");
        cerrarrSesion();
        addActionMessage("Su sesión ha sido cerrada");
        return "success";
    }

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }


    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }


}
