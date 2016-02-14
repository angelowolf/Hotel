package Persistencia.ORM.DAOImplementacion;

import Soporte.EstadoMembresia.EstadoMembresia;
import Persistencia.ORM.DAOInterface.IEstadoMembresia;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:24 p.m.
 */
public class EstadoMembresiaDAO extends GenericDAO<EstadoMembresia, Integer> implements IEstadoMembresia {

    public EstadoMembresia buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<EstadoMembresia> objetos = new ArrayList<EstadoMembresia>();
        try {
            String sql = "from EstadoMembresia where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos.get(0);
    }

}//end EstadoMembresiaDAO
