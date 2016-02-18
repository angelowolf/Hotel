package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Modulo;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IModulo extends IGenericDAO<Modulo, Integer> {

    /**
     * Trae todos modulos.
     *
     * @return Lista de modulos.
     */
    public List<Modulo> getTodos();

    /**
     * Verifica si el modulo está siendo usado por algun plan.
     *
     * @param id
     * @return El modulo si está en uso. NULL si no lo está.
     */
    public Modulo enUso(int id);

    /**
     * Busca un modulo por nombre.
     *
     * @param nombre
     * @return Modulo encontrado, o NULL.
     */
    public Modulo buscar(String nombre);
}
