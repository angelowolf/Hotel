package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.TipoDocumento;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface ITipoDocumento extends IGenericDAO<TipoDocumento, Integer> {

    /**
     * Trae todos los tipo documentos
     *
     * @return Lista de TipoDocumento
     */
    public List<TipoDocumento> getTodos();

    /**
     * Verifica si el tipo documento está siendo usado por alguna persona.
     *
     * @param id
     * @return El tipo documento si está en uso. NULL si no lo está.
     */
    public TipoDocumento enUso(int id);

    /**
     * Busca un Tipo documento por nombre.
     *
     * @param nombre
     * @return Tipo documento encontrado, o NULL.
     */
    public TipoDocumento buscar(String nombre);

}
