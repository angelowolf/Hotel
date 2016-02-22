package Persistencia.Modelo;

import Persistencia.ORM.DAOImplementacion.TipoUsuarioDAO;
import Soporte.Encriptar;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class Usuario {

    private int id;
    private String clave;
    private String email;
    private String nick;
    private TipoUsuario tipoUsuario;

    /**
     * Verifica si el usuario es ROOT del sitio.
     *
     * @return true si lo es.
     */
    public boolean isRoot() {
        return tipoUsuario.isRoot();
    }

    /**
     * Verifica si el usuario es ADMINISTRADOR de su hotel.
     *
     * @return true si lo es.
     */
    public boolean isOwner() {
        return tipoUsuario.isOwner();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     *
     * @param newVal
     */
    public void setTipoUsuario(TipoUsuario newVal) {
        tipoUsuario = newVal;
    }

    public String getNick() {
        return nick;
    }

    /**
     *
     * @param newVal
     */
    public void setNick(String newVal) {
        nick = newVal;
    }

    public String getEmail() {
        return email;
    }

    /**
     *
     * @param newVal
     */
    public void setEmail(String newVal) {
        email = newVal;
    }

    public String getClave() {
        return clave;
    }

    /**
     *
     * @param newVal
     */
    public void setClave(String newVal) {
        clave = newVal;
    }

    public void hacerOwner() {
        TipoUsuarioDAO tipoUsuarioDAO = new TipoUsuarioDAO();
        TipoUsuario tp = tipoUsuarioDAO.getTipoOwner();
        this.tipoUsuario = tp;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", clave=" + clave + ", email=" + email + ", nick=" + nick + ", tipoUsuario=" + tipoUsuario + '}';
    }

    /**
     * Verifica que la calve para iniciar sesion coincida con la almacenada en
     * la base de datos
     *
     * @param password
     * @return True si coinciden los datos.
     */
    public boolean iniciarSesion(String password) {
        String claveMD5 = Encriptar.encriptaEnMD5(password);
        return this.getClave().equals(claveMD5);
    }
}//end Usuario
