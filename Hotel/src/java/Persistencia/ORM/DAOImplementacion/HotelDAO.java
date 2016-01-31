package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.Usuario;
import Persistencia.ORM.DAOInterface.IHotel;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author flore
 */
public class HotelDAO extends GenericDAO<Hotel, Integer> implements IHotel {

    public Hotel getHotelByUsuario(Usuario u) {
        Session session = getHibernateTemplate();
        List<Hotel> objetos = new ArrayList<Hotel>();
        try {
            String sql = "select * from Hotel h inner join usuario u ON h.id = u.id_hotel WHERE u.id = :id";
            objetos = session.createSQLQuery(sql).addEntity(Hotel.class).setParameter("id",  u.getId()).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return objetos.get(0);
    }
    
}
