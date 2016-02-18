package Soporte.EstadoMembresia;

import Persistencia.Modelo.Membresia;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class EstadoMembresiaActiva extends EstadoMembresia {

    private String nombre = "activa";

    @Override
    public void activar(Membresia membresia) {
       
    }

    @Override
    public void registrarAviso(Membresia membresia) {
        membresia.setEstadoMembresia(SingletonEstadoMembresiaAviso.getInstancia().getEstadoMembresiaAviso());
    }

    @Override
    public void registrarVencimiento(Membresia membresia) {
        throw new IllegalStateException("Se accedio a un metodo de un estado no valido.");
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
        return true;
    }

    @Override
    public boolean isPrueba() {
        return false;
    }

    @Override
    public boolean isVencida() {
        return false;
    }

    @Override
    public boolean isAviso() {
        return false;
    }
}//end EstadoMembresiaActiva
