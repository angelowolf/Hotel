package Controlador;

import Persistencia.Modelo.TipoPago;
import Persistencia.ORM.DAOImplementacion.TipoPagoDAO;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoPago {

    private final TipoPagoDAO tipoPagoDAO;

    public ControladorTipoPago() {
        tipoPagoDAO = new TipoPagoDAO();
    }

    /**
     * Busca todos los tipos de pagos existenes.
     *
     * @return
     */
    public List<TipoPago> getTodos() {
        return tipoPagoDAO.getTodos();
    }

    /**
     * verifica si el tipo de pago esta asociado a algun pago.
     *
     * @param id el tipo de pago a verificar
     * @return true si lo esta.
     */
    public boolean enUso(int id) {
        return !tipoPagoDAO.pagoEnUso(id).isEmpty();
    }

    /**
     * actualiza los datos.
     *
     * @param id
     * @param nombre
     * @param recargo
     */
    public void actualizar(int id, String nombre, float recargo) {
        nombre = (WordUtils.capitalize(nombre));
        TipoPago t = tipoPagoDAO.buscar(id);
        t.setNombre(nombre);
        t.setPorcentajeRecargo(recargo);
        tipoPagoDAO.actualizar(t);
    }

    /**
     * guarda un nuevo tipo de pago.
     *
     * @param nombre
     * @param recargo
     */
    public void guardar(String nombre, float recargo) {
        nombre = (WordUtils.capitalize(nombre));
        TipoPago t = new TipoPago();
        t.setNombre(nombre);
        t.setPorcentajeRecargo(recargo);
        tipoPagoDAO.guardar(t);
    }

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio tipo de pago devolvera true.
     *
     * @param id
     * @param nombre
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        List<TipoPago> lista = tipoPagoDAO.buscar(nombre);
        for (TipoPago m : lista) {
            if (m.getNombre().equals(nombre)) {
                return m.getId() != id;
            }
        }
        return false;
    }

    /**
     * elimina el tipo de pago.
     *
     * @param id
     */
    public void eliminar(int id) {
        TipoPago t = new TipoPago();
        t.setId(id);
        tipoPagoDAO.eliminar(t);
    }

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public TipoPago getUno(int id) {
        try {
            return tipoPagoDAO.buscar(id);
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }
}//end ControladorTipoPago
