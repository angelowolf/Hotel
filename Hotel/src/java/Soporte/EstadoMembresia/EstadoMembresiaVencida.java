package Soporte.EstadoMembresia;

import Persistencia.ORM.DAOImplementacion.EstadoMembresiaDAO;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:24 p.m.
 */
public class EstadoMembresiaVencida extends EstadoMembresia {

    private String nombre = "vencida";

  

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
        return false;
    }

    @Override
    public boolean isVencida() {
        return true;
    }

    @Override
    public boolean isAviso() {
        return false;
    }
}//end EstadoMembresiaVencida
