package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.TipoPago;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ITipoPago extends IGenericDAO<TipoPago, Integer> {

    /**
     * Trae todos los tipos pago
     *
     * @return Lista de TipoPago
     */
    public List<TipoPago> getTodos();

    /**
     * Busca un tipo pago por nombre.
     *
     * @param nombre
     * @return Tipo pago encontrado, o NULL.
     */
    public TipoPago buscar(String nombre);

    /**
     * Verifica si el tipo pago está siendo usado por algun pago.
     *
     * @param id
     * @return El Tipo pago si está en uso. NULL si no lo está.
     */
    public TipoPago pagoEnUso(int id);
}
