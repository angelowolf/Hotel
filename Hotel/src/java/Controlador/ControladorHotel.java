package Controlador;

import Persistencia.Modelo.Hotel;
import Persistencia.ORM.DAOImplementacion.HotelDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorHotel {
    
    private final HotelDAO hotelDAO = new HotelDAO();
    
    public ControladorHotel() {

    }

    /**
     *
     * @param k
     */
    public void guardar(Hotel k) {

    }

    /**
     *
     * @param k
     */
    public void actualizar(Hotel k) {

    }

    /**
     *
     * @param k
     */
    public void eliminar(Hotel k) {

    }

    /**
     *
     * @param id
     * @return 
     */
    public int eliminar(int id) {
        return 0;
    }

    /**
     *
     * @param id
     * @return 
     */
    public Hotel getUno(int id) {
        return null;
    }

    public List<Hotel> getTodos() {
        return null;
    }
}//end ControladorHotel
