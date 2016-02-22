package Controlador.Implementacion;

import Controlador.Interface.IControladorUsuario;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.TipoUsuario;
import Persistencia.Modelo.Usuario;
import Soporte.Encriptar;
import java.text.SimpleDateFormat;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class ControladorUsuario implements IControladorUsuario {

    @Override
    public void guardar(String clave, String nick, String email, int idTipoUsuario) {
        Usuario u = new Usuario();
        u.setClave(Encriptar.encriptaEnMD5(clave));
        u.setNick(nick);
        u.setEmail(email);
        TipoUsuario tp = TIPOUSUARIODAO.buscar(idTipoUsuario);
        u.setTipoUsuario(tp);
        USUARIODAO.guardar(u);
    }

    @Override
    public void actualizar(int idUsuario, String clave, String nick, String email, int idTipoUsuario) {
        Usuario u = USUARIODAO.buscar(idUsuario);
        u.setClave(Encriptar.encriptaEnMD5(clave));
        u.setNick(nick);
        u.setEmail(email);
        TipoUsuario tp = TIPOUSUARIODAO.buscar(idTipoUsuario);
        u.setTipoUsuario(tp);
        USUARIODAO.actualizar(u);
    }

    @Override
    public void eliminar(Usuario u) {
        USUARIODAO.eliminar(u);
    }

    @Override
    public void eliminar(int idUsuario) {
        Usuario u = new Usuario();
        u.setId(idUsuario);
        USUARIODAO.eliminar(u);
    }

    @Override
    public boolean isNickDisponible(String nick) {
        Usuario u = getUsuarioByNick(nick);
        return u == null;
    }

    @Override
    public boolean isEmailDisponible(String email) {
        Usuario u = getUsuarioByEmail(email);
        return u == null;
    }

    @Override
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
        return USUARIODAO.buscarNick(username);
    }

    /**
     * Busca un usuario por su email.
     *
     * @param email El email.
     * @return El usuario.
     */
    private Usuario getUsuarioByEmail(String email) {
        return USUARIODAO.buscarEmail(email);
    }

    @Override
    public boolean iniciarSesion(Usuario usuario, String password) {
        return usuario != null && usuario.iniciarSesion(password);
    }

    @Override
    public boolean usuarioIsRoot(Usuario u) {
        return u.isRoot();
    }

   
}//end ControladorUsuario
