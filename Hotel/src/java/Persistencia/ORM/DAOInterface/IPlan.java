package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Plan;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IPlan extends IGenericDAO<Plan, Integer> {

    /**
     * Trae todos los planes
     *
     * @return Lista de planes
     */
    public List<Plan> getTodos();

    /**
     * Verifica si el plan está siendo usado por algun hotel.
     *
     * @param id
     * @return El plan si está en uso. NULL si no lo está.
     */
    public Plan enUso(int id);

    /**
     * Busca un plan por nombre.
     *
     * @param nombre
     * @return Plan encontrado, o NULL.
     */
    public Plan buscar(String nombre);
}
