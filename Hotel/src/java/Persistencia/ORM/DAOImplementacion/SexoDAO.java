package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Sexo;
import Persistencia.ORM.Util.GenericDAO;
import Persistencia.ORM.DAOInterface.ISexo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class SexoDAO extends GenericDAO<Sexo, Integer> implements ISexo {

    @Override
    public List<Sexo> getTodos() {
        Session session = getHibernateTemplate();
        List<Sexo> objetos = new ArrayList<Sexo>();
        try {
            objetos = session.createQuery("from Sexo").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    @Override
    public Sexo enUso(int id) {
        Session session = getHibernateTemplate();
        List<Sexo> objetos = new ArrayList<Sexo>();
        try {
            String sql = "select * from Sexo s inner join persona p ON s.id = p.id WHERE s.id LIKE :id ";
            objetos = session.createSQLQuery(sql).addEntity(Sexo.class).setParameter("id", id).list();
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
    public Sexo buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<Sexo> objetos = new ArrayList<Sexo>();
        try {
            String sql = "from Sexo where nombre = :nombre";
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

}//end SexoDAO
