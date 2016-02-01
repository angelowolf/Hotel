package Controlador;

import Persistencia.Modelo.TipoPago;
import Persistencia.ORM.DAOImplementacion.TipoPagoDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoPago {

    private TipoPagoDAO tipoPagoDAO;

    public ControladorTipoPago() {
        tipoPagoDAO = new TipoPagoDAO();
    }

    public List<TipoPago> getTodos() {
        return tipoPagoDAO.getTodos();
    }

    public boolean tipoPagoEnUso(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizar(int id, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void guardar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean existe(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TipoPago getUno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}//end ControladorTipoPago
