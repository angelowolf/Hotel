package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Sexo;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ISexo extends IGenericDAO<Sexo, Integer> {

    /**
     * Trae todos los sexo
     *
     * @return Lista de Sexo
     */
    public List<Sexo> getTodos();

    /**
     * Verifica si el sexo está siendo usado por alguna persona.
     *
     * @param id
     * @return El sexo si está en uso. NULL si no lo está.
     */
    public Sexo enUso(int id);

    /**
     * Busca un Sexo por nombre.
     *
     * @param nombre
     * @return Sexo encontrado, o NULL.
     */
    public Sexo buscar(String nombre);
}
