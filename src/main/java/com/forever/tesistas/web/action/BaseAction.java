package com.forever.tesistas.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Acción que implementa caracteristicas generales empleadas por cualquier
 * acción definida en el controlador: <br/>
 * <ul>
 * <li>Herencia de {@link ActionSupport}</li>
 * <li>Implementación de {@link SessionAware}</li>
 * </ul>
 *
 * @author Gabriel Gonzalez
 */
public class BaseAction extends ActionSupport implements SessionAware {
	/**
	 * Expresión regular para verificar la fortaleza de la contraseña
	 */
	public static final String PASSWD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$";
	/**
	 * Expresión regular para validar el correo electrónico
	 */
	public static final String EMAIL_REGEX = "(?i)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	/**
	 * Expresión regular para validar que la cadena sean letras de la A a la Z
	 * incluyendo ñ y acentos
	 */
	public static final String SOLO_TEXTO_REGEX = "^[\\pL\\pM\\p{Zs}.-]+$";
	private static final long serialVersionUID = 1L;
	// variable para almacenar el objeto session
	private SessionMap<String, Object> session;
	

	protected SessionMap<String, Object> getSession() {
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	protected void cerrarrSesion() {
		for (Map.Entry<String, Object> entry : session.entrySet()) {
			session.remove(entry.getKey());
		}
		session.invalidate();
	}

	public boolean isAdmin() {
		Boolean admin = (Boolean) session.get("isAdmin");
		return admin != null && admin;
	}
	
	public boolean isLogged() {
		Boolean logged = (Boolean) session.get("logged");
		return logged != null && logged;
	}
}
