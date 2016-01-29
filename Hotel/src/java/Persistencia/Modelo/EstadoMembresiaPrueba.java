package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:24 p.m.
 */
public class EstadoMembresiaPrueba extends EstadoMembresia {

    private String nombre = "prueba";

    public EstadoMembresiaPrueba() {

    }

    @Override
    public void activar() {

    }

    @Override
    public void registrarAviso() {

    }

    @Override
    public void registrarVencimiento() {

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param newVal
     */
    @Override
    public void setNombre(String newVal) {
        nombre = newVal;
    }

    @Override
    public boolean isActiva() {
        return false;
    }

    @Override
    public boolean isPrueba() {
        return true;
    }

    @Override
    public boolean isVencida() {
        return false;
    }

    @Override
    public boolean isAviso() {
        return false;
    }
}//end EstadoMembresiaPrueba
