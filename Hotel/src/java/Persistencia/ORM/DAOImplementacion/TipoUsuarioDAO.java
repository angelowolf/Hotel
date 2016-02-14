package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.TipoUsuario;
import Persistencia.ORM.DAOInterface.ITipoUsuario;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoUsuarioDAO extends GenericDAO<TipoUsuario, Integer> implements ITipoUsuario {

    public TipoUsuario getTipoOwner() {
        Session session = getHibernateTemplate();
        List<TipoUsuario> objetos = new ArrayList<TipoUsuario>();
        try {
            String sql = "from TipoUsuario where nombre = :owner";
            objetos = session.createQuery(sql).setParameter("owner", "owner").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

}//end TipoUsuarioDAO
