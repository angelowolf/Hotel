package Controlador;

import Persistencia.Modelo.TipoUsuario;
import Persistencia.Modelo.Usuario;
import Persistencia.ORM.DAOImplementacion.TipoUsuarioDAO;
import Persistencia.ORM.DAOImplementacion.UsuarioDAO;
import Soporte.Encriptar;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.lang.WordUtils;

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
        u.setIdUsuario(idUsuario);
        usuarioDAO.eliminar(u);
    }

    //***********************************************************************************************************
    /**
     * Busca un usuario por su nick.
     *
     * @param username El nick.
     * @return EL usuario.
     */
    public Usuario getUsuarioByNick(String username) {
        return usuarioDAO.buscar(username);
    }

    /**
     * Busca un usuario por su email.
     *
     * @param email El email.
     * @return El usuario.
     */
    public Usuario getUsuarioByEmail(String email) {
        return usuarioDAO.buscarEmail(email);
    }

    /**
     * Verifica si los datos ingresados pertenecen a un usuario registrado.
     *
     * @param username El nick.
     * @param password La clave.
     * @return True si existe.
     */
    public boolean iniciarSesion(String username, String password) {
        Usuario usuario = usuarioDAO.buscar(username);
        String claveMD5 = Encriptar.encriptaEnMD5(password);
        return usuario != null && usuario.getNick().equals(username) && usuario.getClave().equals(claveMD5);
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
        return !u.getHotel().isMembresiaVencida();
    }

    /**
     * Verifica si la membresia del hotel se encuentra en su ultima semana antes
     * de que sea colocada como vencida.
     *
     * @param u El usuario que esta iniciando sesion.
     * @return true si se encuentra en esta semana.
     */
    public boolean verificarCuentaAviso(Usuario u) {
        return u.getHotel().isMembresiaAviso();
    }

    /**
     * Crea un mensaje con la fecha de vencimiento de la cuenta para ser
     * mostrado al usuario cuando inice sesion.
     *
     * @param u El usuario que esta iniciando sesion.
     * @return El mensaje a msotrar.
     */
    public String getMensajeAviso(Usuario u) {
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(u.getHotel().getMembresia().getFechaVencimiento());
        return Soporte.Mensaje.getAviso(fecha);
    }
}//end ControladorUsuario
