package Controlador;

import Persistencia.Modelo.EstadoReserva;
import Persistencia.Modelo.Reserva;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorEstadoReserva implements IControlador<EstadoReserva> {

    public ControladorEstadoReserva() {

    }

    public void finalize() throws Throwable {

    }

    /**
     *
     * @param k
     */
    public void guardar(EstadoReserva k) {

    }

    /**
     *
     * @param k
     */
    public void actualizar(EstadoReserva k) {

    }

    /**
     *
     * @param k
     */
    public void eliminar(EstadoReserva k) {

    }

    /**
     *
     * @param id
     */
    public int eliminar(int id) {
        return 0;
    }

    @Override
    public EstadoReserva getUno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstadoReserva> getTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//end ControladorEstadoReserva
