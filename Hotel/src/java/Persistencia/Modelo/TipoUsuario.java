package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoUsuario {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param newVal
     */
    public void setNombre(String newVal) {
        nombre = newVal;
    }

    /**
     * Verifica si el usuario es ROOT del sitio.
     *
     * @return true si lo es.
     */
    public boolean isRoot() {
        return nombre.equals("root");
    }

    /**
     * Verifica si el usuario es ADMINISTRADOR de su hotel.
     *
     * @return true si lo es.
     */
    public boolean isOwner() {
        return nombre.equals("owner");
    }
}//end TipoUsuario
