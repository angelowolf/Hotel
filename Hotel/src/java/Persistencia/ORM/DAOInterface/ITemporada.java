package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Temporada;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ITemporada extends IGenericDAO<Temporada, Integer> {

    /**
     * Busca una Temporada por nombre.
     *
     * @param nombre
     * @param id el id del hotel al que pertenecela Temporada a buscar.
     * @return Temporada encontrado, o NULL.
     */
    public Temporada buscar(String nombre, int id);

    /**
     * Verifica si la Temporada está siendo usado por alguna entidad.
     *
     * @param id
     * @return La Temporada si está en uso. NULL si no lo está.
     */
    public Temporada enUso(int id);

    /**
     * Trae todos las Temporada del hotel.
     *
     * @param id el id del hotel.
     * @return Lista de Temporada
     */
    public List<Temporada> getTodos(int id);
}
