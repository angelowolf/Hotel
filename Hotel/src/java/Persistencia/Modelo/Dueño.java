package Persistencia.Modelo;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class Dueño extends Persona {

    private int id;
    private Usuario usuario;

    public Dueño(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dueño() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param newVal
     */
    public void setUsuario(Usuario newVal) {
        usuario = newVal;
    }
}//end Dueño
