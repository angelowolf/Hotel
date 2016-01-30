package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class DetalleLavado {

    private int id;
    private int cantidad;
    private float precio;
    private Item item;

    public DetalleLavado() {

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    /**
     *
     * @param newVal
     */
    public void setItem(Item newVal) {
        item = newVal;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param newVal
     */
    public void setCantidad(int newVal) {
        cantidad = newVal;
    }

    public float getPrecio() {
        return precio;
    }

    /**
     *
     * @param newVal
     */
    public void setPrecio(float newVal) {
        precio = newVal;
    }
}//end DetalleLavado
