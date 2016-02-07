package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class Modulo {

    private int id;
    private String nombre;
    private String caracteristica;

    public Modulo() {

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

    public String getCaracteristica() {
        return caracteristica;
    }

    /**
     *
     * @param newVal
     */
    public void setCaracteristica(String newVal) {
        caracteristica = newVal;
    }

    @Override
    public String toString() {
        return "Modulo{" + "id=" + id + ", nombre=" + nombre + ", caracteristica=" + caracteristica + '}';
    }
    
}//end Modulo
