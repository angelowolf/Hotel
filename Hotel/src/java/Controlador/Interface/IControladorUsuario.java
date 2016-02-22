/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Usuario;
import Persistencia.ORM.DAOImplementacion.TipoUsuarioDAO;
import Persistencia.ORM.DAOImplementacion.UsuarioDAO;
import Persistencia.ORM.DAOInterface.ITipoUsuario;
import Persistencia.ORM.DAOInterface.IUsuario;

/**
 *
 * @author flore
 */
public interface IControladorUsuario {

    final IUsuario USUARIODAO = new UsuarioDAO();
    final ITipoUsuario TIPOUSUARIODAO = new TipoUsuarioDAO();

    /**
     * Guarda un nuevo usuario en la BD.
     *
     * @param clave
     * @param nick
     * @param email
     * @param idTipoUsuario
     */
    public void guardar(String clave, String nick, String email, int idTipoUsuario);

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
    public void actualizar(int idUsuario, String clave, String nick, String email, int idTipoUsuario);

    /**
     * Elimina un usuario.
     *
     * @param u El usuario.
     */
    public void eliminar(Usuario u);

    /**
     * Elimina un usuario.
     *
     * @param idUsuario EL id del usuario.
     */
    public void eliminar(int idUsuario);

    /**
     * Verifica si el nombre su usuario se encuentra disponible o no.
     *
     * @param nick
     * @return True si es posible utilizarlo.
     */
    public boolean isNickDisponible(String nick);

    /**
     * Verifica si el email ya se encuentra ocupado por algun usuario.
     *
     * @param email
     * @return True si es posible utilizarlo.
     */
    public boolean isEmailDisponible(String email);

    /**
     * Busca un usuario por email o por nick.
     *
     * @param emailONick
     * @return usuario
     */
    public Usuario getUsuario(String emailONick);

    /**
     * Verifica si los datos ingresados pertenecen a un usuario registrado. Si
     * el usuario es NULL, se devolvera false. Si el usuario existe, pero la
     * contraseña no coincide devolvera false.
     *
     * @param u El usuario que esta intentando logearse.
     * @param password La clave.
     * @return True si existe y coincide la contraseña.
     */
    public boolean iniciarSesion(Usuario u, String password);

    /**
     * Verifica que el usuario que esta por iniciar sesion es ROOT.
     *
     * @param u EL usuario que esta iniciando sesion.
     * @return true si lo es.
     */
    public boolean usuarioIsRoot(Usuario u);
    
}
