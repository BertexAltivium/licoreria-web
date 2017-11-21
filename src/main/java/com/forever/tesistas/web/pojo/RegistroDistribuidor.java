package com.forever.tesistas.web.pojo;

/**
 * POJO empleado para recuperar la información de la
 * forma de registro de sucursal
 *
 * @author Ricardo Lopez
 */
public class RegistroDistribuidor {
    private String nombre;
    private String direccion;

    public RegistroDistribuidor() {
    }


    public RegistroDistribuidor(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Distribuidor [nombre=");
        stringBuilder.append(nombre);
        stringBuilder.append(", direccion=");
        stringBuilder.append(direccion);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}