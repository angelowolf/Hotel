package Soporte.EstadoMembresia;

import Persistencia.Modelo.Membresia;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:24 p.m.
 */
public class EstadoMembresiaPrueba extends EstadoMembresia {

    private String nombre = "prueba";

    @Override
    public void activar(Membresia membresia) {
        membresia.setEstadoMembresia(SingletonEstadoMembresiaActiva.getInstancia().getEstadoMembresiaActiva());
    }

    @Override
    public void registrarAviso(Membresia membresia) {
        membresia.setEstadoMembresia(SingletonEstadoMembresiaAviso.getInstancia().getEstadoMembresiaAviso());
    }

    @Override
    public void registrarVencimiento(Membresia membresia) {
        membresia.setEstadoMembresia(SingletonEstadoMembresiaVencida.getInstancia().getEstadoMembresiaVencida());
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
