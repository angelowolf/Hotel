package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Plan;
import Persistencia.ORM.Util.GenericDAO;
import Persistencia.ORM.DAOInterface.IPlan;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class PlanDAO extends GenericDAO<Plan, Integer> implements IPlan {

    public List<Plan> getTodos() {
        Session session = getHibernateTemplate();
        List<Plan> objetos = new ArrayList<Plan>();
        try {
            objetos = session.createQuery("from Plan").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<Plan> enUso(int id) {
        Session session = getHibernateTemplate();
        List<Plan> objetos = new ArrayList<Plan>();
        try {
            String sql = "select * from Plan p inner join hotel h ON p.id = h.id_plan WHERE p.id LIKE :id ";
            objetos = session.createSQLQuery(sql).addEntity(Plan.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    public List<Plan> buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<Plan> objetos = new ArrayList<Plan>();
        try {
            String sql = "from Plan where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end PlanDAO
