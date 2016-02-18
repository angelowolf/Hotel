package Controlador.Implementacion;

import Persistencia.Modelo.Pago;
import Persistencia.ORM.DAOImplementacion.PagoDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorPago  {

    private final PagoDAO pagoDAO;

    public ControladorPago() {
        pagoDAO = new PagoDAO();
    }

    
}//end ControladorPago
