package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:24 p.m.
 */
public abstract class EstadoReserva {

    private int id;
    private String nombre;

    public EstadoReserva() {

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

    public void confirmar() {

    }

    public void registrarIngreso() {

    }

    public void registrarEgreso() {

    }

    public void cancelar() {

    }

    public boolean isPendiente() {
        return false;
    }

    public boolean isConfirmada() {
        return false;
    }

    public boolean isCancelada() {
        return false;
    }

    public boolean isCheckOut() {
        return false;
    }

    public boolean isCheckIn() {
        return false;
    }
}//end EstadoReserva
