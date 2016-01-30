package Persistencia.Modelo;

import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:27 p.m.
 */
public class Lavanderia {

    private int id;
    private String email;
    private String telefono;
    private String nombre;
    private Domicilio domicillio;
    private List<Persona> contactos;

    public Lavanderia() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Domicilio getDomicillio() {
        return domicillio;
    }

    /**
     *
     * @param newVal
     */
    public void setDomicillio(Domicilio newVal) {
        domicillio = newVal;
    }

    public List<Persona> getContactos() {
        return contactos;
    }

    /**
     *
     * @param newVal
     */
    public void setContactos(List<Persona> newVal) {
        contactos = newVal;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param newVal
     */
    public void setNombre(String newVal) {
        nombre = newVal;
    }

    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param newVal
     */
    public void setTelefono(String newVal) {
        telefono = newVal;
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
}//end Lavanderia
