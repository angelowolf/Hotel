package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoDocumento {

    private int id;
    private String nombre;

    public TipoDocumento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "TipoDocumento{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}//end TipoDocumento
