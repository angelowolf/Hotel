package Persistencia.ORM.DAOImplementacion;

import Persistencia.Modelo.Usuario;
import Persistencia.ORM.DAOInterface.IUsuario;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class UsuarioDAO extends GenericDAO<Usuario, Integer> implements IUsuario {

    public Usuario buscarNick(String username) {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<Usuario>();
        try {
            String sql = "from Usuario where nick = :nick";
            objetos = session.createQuery(sql).setParameter("nick", username).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

    public Usuario buscarEmail(String email) {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<Usuario>();
        try {
            String sql = "from Usuario where email = :email";
            objetos = session.createQuery(sql).setParameter("email", email).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }
}//end UsuarioDAO
