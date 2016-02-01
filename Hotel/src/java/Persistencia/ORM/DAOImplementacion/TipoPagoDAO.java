package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.TipoPago;
import Persistencia.ORM.DAOInterface.ITipoPago;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class TipoPagoDAO extends GenericDAO<TipoPago, Integer> implements ITipoPago {

    public List<TipoPago> getTodos() {
        Session session = getHibernateTemplate();
        List<TipoPago> objetos = new ArrayList<TipoPago>();
        try {
            objetos = session.createQuery("from TipoPago").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

}//end TipoPagoDAO
