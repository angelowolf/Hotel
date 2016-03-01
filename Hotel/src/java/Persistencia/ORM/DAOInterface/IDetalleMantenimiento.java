package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.DetalleMantenimiento;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IDetalleMantenimiento extends IGenericDAO<DetalleMantenimiento, Integer> {

    /**
     * Elimina todos los detalles de la habitacion.
     *
     * @param id La habitacion.
     */
    public void eliminarTodos(int id);

    public List<DetalleMantenimiento> getTodos(int id_habitacion);

}
