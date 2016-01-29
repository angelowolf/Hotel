package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:30 p.m.
 */
public class Usuario {

    private int idUsuario;
    private String clave;
    private String email;
    private String nick;
    private TipoUsuario tipoUsuario;
    private Hotel hotel;

    public Usuario() {

    }

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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
}//end Usuario
