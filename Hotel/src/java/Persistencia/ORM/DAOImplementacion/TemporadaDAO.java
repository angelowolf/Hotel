package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Temporada;
import Persistencia.ORM.Util.GenericDAO;
import Persistencia.ORM.DAOInterface.ITemporada;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class TemporadaDAO extends GenericDAO<Temporada, Integer> implements ITemporada {

    @Override
    public Temporada buscar(String nombre, int id) {
        Session session = getHibernateTemplate();
        List<Temporada> objetos = new ArrayList<Temporada>();
        try {
            String sql = "select * from Temporada t WHERE t.id_hotel = :id AND t.nombre = :nombre";
            objetos = session.createSQLQuery(sql).addEntity(Temporada.class).setParameter("id", id).setParameter("nombre", nombre).list();
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
    public Temporada enUso(int id) {
        Session session = getHibernateTemplate();
        List<Temporada> objetos = new ArrayList<Temporada>();
        try {
            String sql = "select * from Temporada t inner join tarifa ta ON t.id = ta.id_temporada WHERE ta.id_temporada = :id ";
            objetos = session.createSQLQuery(sql).addEntity(Temporada.class).setParameter("id", id).list();
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
    public List<Temporada> getTodos(int id) {
        Session session = getHibernateTemplate();
        List<Temporada> objetos = new ArrayList<Temporada>();
        try {
            String sql = "select * from Temporada t WHERE t.id_hotel = :id ";
            objetos = session.createSQLQuery(sql).addEntity(Temporada.class).setParameter("id", id).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }
}//end TemporadaDAO
