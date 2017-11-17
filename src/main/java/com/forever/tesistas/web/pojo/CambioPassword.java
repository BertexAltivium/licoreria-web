package com.forever.tesistas.web.pojo;

/**
 * POJO para almacenar los parámetros de la forma de
 * cambio de contraseña
 *
 * @author Gabriel Gonzalez
 */
public class CambioPassword {
    private String passwdAnterior;
    private String passwdNuevo;
    private String passwdConfirmacion;

    /**
     * @return the passwdAnterior
     */
    public String getPasswdAnterior() {
        return passwdAnterior;
    }

    /**
     * @param passwdAnterior the passwdAnterior to set
     */
    public void setPasswdAnterior(String passwdAnterior) {
        this.passwdAnterior = passwdAnterior;
    }

    /**
     * @return the passwdNuevo
     */
    public String getPasswdNuevo() {
        return passwdNuevo;
    }

    /**
     * @param passwdNuevo the passwdNuevo to set
     */
    public void setPasswdNuevo(String passwdNuevo) {
        this.passwdNuevo = passwdNuevo;
    }

    /**
     * @return the passwdConfirmacion
     */
    public String getPasswdConfirmacion() {
        return passwdConfirmacion;
    }

    /**
     * @param passwdConfirmacion the passwdConfirmacion to set
     */
    public void setPasswdConfirmacion(String passwdConfirmacion) {
        this.passwdConfirmacion = passwdConfirmacion;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CambioPassword [passwdAnterior=");
        stringBuilder.append(passwdAnterior);
        stringBuilder.append(", passwdNuevo=");
        stringBuilder.append(passwdNuevo);
        stringBuilder.append(", passwdConfirmacion=");
        stringBuilder.append(passwdConfirmacion);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}
