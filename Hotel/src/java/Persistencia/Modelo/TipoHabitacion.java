package Persistencia.Modelo;


/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoHabitacion {

    private int id, id_hotel;
    private String nombre;

    public TipoHabitacion() {

    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
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
        return "TipoHabitacion{" + "id=" + id + ", id_hotel=" + id_hotel + ", nombre=" + nombre + '}';
    }

}//end TipoHabitacion
