package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Modulo;
import Persistencia.ORM.DAOInterface.IModulo;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:28 p.m.
 */
public class ModuloDAO extends GenericDAO<Modulo, Integer> implements IModulo {

    public List<Modulo> getTodos() {
        Session session = getHibernateTemplate();
        List<Modulo> objetos = new ArrayList<Modulo>();
        try {
            objetos = session.createQuery("from Modulo").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<Modulo> enUso(int id) {
        Session session = getHibernateTemplate();
        List<Modulo> objetos = new ArrayList<Modulo>();
        try {
            String sql = "select * from Modulo m inner join plan p ON m.id = p.id WHERE m.id LIKE :id ";
            objetos = session.createSQLQuery(sql).addEntity(Modulo.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<Modulo> buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<Modulo> objetos = new ArrayList<Modulo>();
        try {
            String sql = "from Modulo where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end ModuloDAO
