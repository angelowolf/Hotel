package Persistencia.ORM.Util;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.lang.reflect.ParameterizedType;

/**
 * @author Angelo
 * @version 1.0
 * @param <Entity>
 * @param <K>
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class GenericDAO<Entity, K extends Serializable> implements IGenericDAO<Entity, K> {

    public Class<Entity> domainClass = getDomainClass();

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    protected Session getHibernateTemplate() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     *
     * @param t
     */
    @Override
    public Integer guardar(Entity t) {
        try {
            return (Integer) getHibernateTemplate().save(t);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    /**
     *
     * @param t
     */
    @Override
    public void actualizar(Entity t) {
        try {
            getHibernateTemplate().merge(t);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    /**
     *
     * @param id
     */
    @Override
    public Entity buscar(K id) {
        Entity returnValue;
        try {
            returnValue = (Entity) getHibernateTemplate().load(domainClass, id);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
        return returnValue;
    }

    /**
     *
     * @param t
     */
    @Override
    public void eliminar(Entity t) {
        try {
            Object temp = getHibernateTemplate().merge(t);
            getHibernateTemplate().delete(temp);
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

}//end GenericDAO
