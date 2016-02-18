package Controlador;

import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.TipoUsuario;
import Persistencia.Modelo.Usuario;
import Persistencia.ORM.DAOImplementacion.HotelDAO;
import Persistencia.ORM.DAOImplementacion.TipoUsuarioDAO;
import Persistencia.ORM.DAOImplementacion.UsuarioDAO;
import Soporte.Encriptar;
import java.text.SimpleDateFormat;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class ControladorUsuario {

    private final UsuarioDAO usuarioDAO;
    private final TipoUsuarioDAO tipoUsuarioDAO;

    public ControladorUsuario() {
        usuarioDAO = new UsuarioDAO();
        tipoUsuarioDAO = new TipoUsuarioDAO();
    }

    /**
     * Guarda un nuevo usuario en la BD.
     *
     * @param clave
     * @param nick
     * @param email
     * @param idTipoUsuario
     */
    public void guardar(String clave, String nick, String email, int idTipoUsuario) {
        Usuario u = new Usuario();
        u.setClave(Encriptar.encriptaEnMD5(clave));
        u.setNick(nick);
        u.setEmail(email);
        TipoUsuario tp = tipoUsuarioDAO.buscar(idTipoUsuario);
        u.setTipoUsuario(tp);
        usuarioDAO.guardar(u);
    }

    /**
     * Actualiza los datos del usuario. Encripta la clave en MD5. Actualiza el
     * tipo de usuario.
     *
     * @param idUsuario
     * @param clave
     * @param nick
     * @param email
     * @param idTipoUsuario
     */
    public void actualizar(int idUsuario, String clave, String nick, String email, int idTipoUsuario) {
        Usuario u = usuarioDAO.buscar(idUsuario);
        u.setClave(Encriptar.encriptaEnMD5(clave));
        u.setNick(nick);
        u.setEmail(email);
        TipoUsuario tp = tipoUsuarioDAO.buscar(idTipoUsuario);
        u.setTipoUsuario(tp);
        usuarioDAO.actualizar(u);
    }

    /**
     * Elimina un usuario.
     *
     * @param u El usuario.
     */
    public void eliminar(Usuario u) {
        usuarioDAO.eliminar(u);
    }

    /**
     * Elimina un usuario.
     *
     * @param idUsuario EL id del usuario.
     */
    public void eliminar(int idUsuario) {
        Usuario u = new Usuario();
        u.setId(idUsuario);
        usuarioDAO.eliminar(u);
    }

    //***********************************************************************************************************
    /**
     * Verifica si el nombre su usuario se encuentra disponible o no.
     *
     * @param nick
     * @return True si es posible utilizarlo.
     */
    public boolean isNickDisponible(String nick) {
        Usuario u = getUsuarioByNick(nick);
        return u == null;
    }

    /**
     * Verifica si el email ya se encuentra ocupado por algun usuario.
     *
     * @param email
     * @return True si es posible utilizarlo.
     */
    public boolean isEmailDisponible(String email) {
        Usuario u = getUsuarioByEmail(email);
        return u == null;
    }

    /**
     * Busca un usuario por email o por nick.
     *
     * @param emailONick
     * @return usuario
     */
    public Usuario getUsuario(String emailONick) {
        Usuario u = getUsuarioByNick(emailONick);
        if (u == null) {
            u = getUsuarioByEmail(emailONick);
        }
        return u;
    }

    /**
     * Busca un usuario por su nick.
     *
     * @param username El nick.
     * @return EL usuario.
     */
    private Usuario getUsuarioByNick(String username) {
        return usuarioDAO.buscarNick(username);
    }

    /**
     * Busca un usuario por su email.
     *
     * @param email El email.
     * @return El usuario.
     */
    private Usuario getUsuarioByEmail(String email) {
        return usuarioDAO.buscarEmail(email);
    }

    /**
     * Verifica si los datos ingresados pertenecen a un usuario registrado.
     *
     * @param emailONick El email o el nick.
     * @param password La clave.
     * @return True si existe.
     */
    public boolean iniciarSesion(String emailONick, String password) {
        Usuario usuario = usuarioDAO.buscarEmail(emailONick);
        if (usuario == null) {
            usuario = usuarioDAO.buscarNick(emailONick);
        }
        String claveMD5 = Encriptar.encriptaEnMD5(password);
        return usuario != null && (usuario.getEmail().equals(emailONick) || usuario.getNick().equals(emailONick)) && usuario.getClave().equals(claveMD5);
    }

    /**
     * Verifica que el usuario que esta por iniciar sesion es ROOT.
     *
     * @param u EL usuario que esta iniciando sesion.
     * @return true si lo es.
     */
    public boolean usuarioIsRoot(Usuario u) {
        return u.isRoot();
    }

    /**
     * Verifica que la membresia del hotel este todavia sin vencer, es decir que
     * pueda seguir iniciando sesion.
     *
     * @param u EL usuario que esta iniciando sesion.
     * @return true si puede logear.
     */
    public boolean verificarCuentaActiva(Usuario u) {
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.getHotelByUsuario(u);
        return !hotel.isMembresiaVencida();
    }

    /**
     * Verifica si la membresia del hotel se encuentra en su ultima semana antes
     * de que sea colocada como vencida.
     *
     * @param u El usuario que esta iniciando sesion.
     * @return true si se encuentra en esta semana.
     */
    public boolean verificarCuentaAviso(Usuario u) {
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.getHotelByUsuario(u);
        return hotel.isMembresiaAviso();
    }

    /**
     * Crea un mensaje con la fecha de vencimiento de la cuenta para ser
     * mostrado al usuario cuando inice sesion.
     *
     * @param u El usuario que esta iniciando sesion.
     * @return El mensaje a msotrar.
     */
    public String getMensajeAviso(Usuario u) {
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.getHotelByUsuario(u);
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(hotel.getMembresia().getFechaVencimiento());
        return Soporte.Mensaje.getAviso(fecha);
    }
}//end ControladorUsuario
