package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public abstract class EstadoMembresia {

    private String nombre;

    public EstadoMembresia() {

    }

    public void activar() {

    }

    public void registrarAviso() {

    }

    public void registrarVencimiento() {

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

    public boolean isActiva() {
        return false;
    }

    public boolean isPrueba() {
        return false;
    }

    public boolean isVencida() {
        return false;
    }

    public boolean isAviso() {
        return false;
    }
}//end EstadoMembresia
