package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.Tarifa;
import Persistencia.Modelo.TipoHabitacion;
import Persistencia.ORM.Util.GenericDAO;
import Persistencia.ORM.DAOInterface.ITarifa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class TarifaDAO extends GenericDAO<Tarifa, Integer> implements ITarifa {

    @Override
    public List<Tarifa> getTodos(int id_hotel) {
        Session session = getHibernateTemplate();
        List<Tarifa> objetos = new ArrayList<Tarifa>();
        try {
            String sql = "select * from Tarifa t inner join temporada temp on t.id_temporada = temp.id WHERE temp.id_hotel = :id ";
            objetos = session.createSQLQuery(sql).addEntity(Tarifa.class).setParameter("id", id_hotel).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    @Override
    public Tarifa getUno(TipoHabitacion th, Date fecha, Integer capacidad){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sfecha = sdf.format(fecha);
        Session session = getHibernateTemplate();
        List<Tarifa> objetos = new ArrayList<Tarifa>();
        try {
            String sql = "select * from Tarifa t inner join tipoHabitacion th on t.id_tipoHabitacion = th.id WHERE th.id = :id and t.fecha = :fecha and t.capacidad = :capacidad";
            objetos = session.createSQLQuery(sql).addEntity(Tarifa.class).setParameter("id", th.getId()).setParameter("fecha", sfecha).setParameter("capacidad", capacidad).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (objetos.isEmpty()) {
            return null;
        } else {
            return objetos.get(0);
        }
    }

}//end TarifaDAO
