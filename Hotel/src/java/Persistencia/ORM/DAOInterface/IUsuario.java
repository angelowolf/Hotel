package Persistencia.ORM.DAOInterface;

import Persistencia.Modelo.Usuario;
import Persistencia.ORM.Util.IGenericDAO;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public interface IUsuario extends IGenericDAO<Usuario, Integer> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username
     * @return El usuario. NULL si no lo encuentra.
     */
    public Usuario buscarNick(String username);

    /**
     * Busca un usuario por su email.
     *
     * @param email
     * @return El usuario. NULL si no lo encuentra.
     */
    public Usuario buscarEmail(String email);

}
