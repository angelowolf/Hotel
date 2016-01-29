package Persistencia.ORM.Util;

import java.io.Serializable;

/**
 * @author Angelo
 * @version 1.0
 * @param <Entity>
 * @param <PK>
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IGenericDAO<Entity, PK extends Serializable> {

    /**
     *
     * @param t
     * @return
     */
    public Integer guardar(Entity t);

    /**
     *
     * @param t
     */
    public void actualizar(Entity t);

    /**
     *
     * @param id
     * @return
     */
    public Entity buscar(PK id);

    /**
     *
     * @param t
     */
    public void eliminar(Entity t);

}
