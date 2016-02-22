package Controlador.Implementacion;

import Controlador.Interface.IControladorHotel;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.Usuario;
import java.text.SimpleDateFormat;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorHotel implements IControladorHotel {

    @Override
    public void registrarHotel(String nombreHotel, int id_planSeleccionado, String nick, String email, String clave, String nombre, String apellido) {
        Hotel hotel = new Hotel();
        //creo la membresia y la guardo en la bd
        hotel.crearMembresia();
        MEMBRESIADAO.guardar(hotel.getMembresia());

        //creo el dueño y su usuario y lo guardo
        hotel.crearDueño(nombre, apellido, hotel.crearUsuario(Soporte.Encriptar.encriptaEnMD5(clave), email, nick));
        DUEÑODAO.guardar(hotel.getDueño());

        hotel.setEmail(email);
        hotel.setNombre(nombreHotel);
        hotel.setPlan(id_planSeleccionado);
        hotel.agregarUsuario(hotel.getDueño().getUsuario());
        HOTELDAO.guardar(hotel);
    }

    @Override
    public Hotel getHotel(Usuario u) {
        return HOTELDAO.getHotelByUsuario(u.getId());
    }

    @Override
    public boolean verificarCuentaActiva(Hotel hotel) {
        return !hotel.isMembresiaVencida();
    }

    @Override
    public boolean verificarCuentaAviso(Hotel hotel) {
        return hotel.isMembresiaAviso();
    }

    @Override
    public String getMensajeAviso(Hotel hotel) {
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(hotel.getMembresia().getFechaVencimiento());
        return Soporte.Mensaje.getAviso(fecha);
    }

}//end ControladorHotel
