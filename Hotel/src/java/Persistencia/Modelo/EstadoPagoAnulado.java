package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:24 p.m.
 */
public class EstadoPagoAnulado extends EstadoPago {

    private String nombre = "anulado";

    public EstadoPagoAnulado() {

    }

    public void confirmar() {

    }

    public void verificarMonto() {

    }

    public void anular() {

    }

    public boolean isPendiente() {
        return false;
    }

    public boolean isConfirmado() {
        return false;
    }

    public boolean isAnulado() {
        return false;
    }

    public boolean isIncompleto() {
        return false;
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
}//end EstadoPagoAnulado
