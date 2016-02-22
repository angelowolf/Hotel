/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.Usuario;
import Persistencia.ORM.DAOImplementacion.DueñoDAO;
import Persistencia.ORM.DAOImplementacion.HotelDAO;
import Persistencia.ORM.DAOImplementacion.MembresiaDAO;
import Persistencia.ORM.DAOInterface.IDueño;
import Persistencia.ORM.DAOInterface.IHotel;
import Persistencia.ORM.DAOInterface.IMembresia;

/**
 *
 * @author flore
 */
public interface IControladorHotel {

    final IHotel HOTELDAO = new HotelDAO();
    final IMembresia MEMBRESIADAO = new MembresiaDAO();
    final IDueño DUEÑODAO = new DueñoDAO();

    /**
     * Registra un nuevo hotel, crea la cuenta de usuario del dueño, y se crea
     * la membresia del hotel con el plan que selecciono.
     *
     * @param nombreHotel
     * @param id_planSeleccionado
     * @param nick
     * @param email
     * @param clave
     * @param nombre
     * @param apellido
     */
    public void registrarHotel(String nombreHotel, int id_planSeleccionado, String nick, String email, String clave, String nombre, String apellido);

    /**
     * Devuelve el hotel al que pertenece este usuario.
     *
     * @param u
     * @return Hotel
     */
    public Hotel getHotel(Usuario u);

    /**
     * Verifica que la membresia del hotel este todavia sin vencer, es decir que
     * pueda seguir iniciando sesion.
     *
     * @param hotel El hotel al que peretence el usuario.
     * @return true si puede logear.
     */
    public boolean verificarCuentaActiva(Hotel hotel);

    /**
     * Verifica si la membresia del hotel se encuentra en su ultima semana antes
     * de que sea colocada como vencida.
     *
     * @param hotel El hotel al que peretence el usuario.
     * @return true si se encuentra en esta semana.
     */
    public boolean verificarCuentaAviso(Hotel hotel);

    /**
     * Crea un mensaje con la fecha de vencimiento de la cuenta para ser
     * mostrado al usuario cuando inice sesion.
     *
     * @param hotel El hotel al que peretence el usuario.
     * @return El mensaje a msotrar.
     */
    public String getMensajeAviso(Hotel hotel);
}
