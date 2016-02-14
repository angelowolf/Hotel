package Controlador;

import Persistencia.Modelo.Hotel;
import Persistencia.ORM.DAOImplementacion.DueñoDAO;
import Persistencia.ORM.DAOImplementacion.HotelDAO;
import Persistencia.ORM.DAOImplementacion.MembresiaDAO;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorHotel {

    private final HotelDAO hotelDAO;
    private final MembresiaDAO membresiaDAO;
    private final DueñoDAO dueñoDAO;

    public ControladorHotel() {
        hotelDAO = new HotelDAO();
        membresiaDAO = new MembresiaDAO();
        dueñoDAO = new DueñoDAO();
    }

    public void registrarHotel(String nombreHotel, int id_planSeleccionado, String nick, String email, String clave, String nombre, String apellido) {
        Hotel hotel = new Hotel();
        //creo la membresia y la guardo en la bd
        hotel.crearMembresia();
        membresiaDAO.guardar(hotel.getMembresia());

        //creo el dueño y su usuario y lo guardo
        hotel.crearDueño(nombre, apellido, hotel.crearUsuario(Soporte.Encriptar.encriptaEnMD5(clave), email, nick));
        dueñoDAO.guardar(hotel.getDueño());

        hotel.setEmail(email);
        hotel.setNombre(nombreHotel);
        hotel.setPlan(id_planSeleccionado);
        hotel.agregarUsuario(hotel.getDueño().getUsuario());
        hotelDAO.guardar(hotel);
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
