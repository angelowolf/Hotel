package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.TipoDocumento;
import Persistencia.ORM.DAOInterface.ITipoDocumento;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoDocumentoDAO extends GenericDAO<TipoDocumento, Integer> implements ITipoDocumento {

    @Override
    public List<TipoDocumento> getTodos() {
        Session session = getHibernateTemplate();
        List<TipoDocumento> objetos = new ArrayList<TipoDocumento>();
        try {
            objetos = session.createQuery("from TipoDocumento").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    @Override
    public TipoDocumento enUso(int id) {
        Session session = getHibernateTemplate();
        List<TipoDocumento> objetos = new ArrayList<TipoDocumento>();
        try {
            String sql = "select * from TipoDocumento td inner join persona p ON td.id = p.id WHERE td.id LIKE :id ";
            objetos = session.createSQLQuery(sql).addEntity(TipoDocumento.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (objetos.isEmpty()) {
            return null;
        } else {
            return objetos.get(0);
        }
    }

    @Override
    public TipoDocumento buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<TipoDocumento> objetos = new ArrayList<TipoDocumento>();
        try {
            String sql = "from TipoDocumento where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (objetos.isEmpty()) {
            return null;
        } else {
            return objetos.get(0);
        }
    }

}//end TipoDocumentoDAO
