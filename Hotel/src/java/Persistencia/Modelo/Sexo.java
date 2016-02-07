package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Sexo {

    private int id;
    private String nombre;

    public Sexo() {

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
        return "Sexo{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}//end Sexo
