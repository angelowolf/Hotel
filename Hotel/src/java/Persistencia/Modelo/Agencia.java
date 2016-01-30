package Persistencia.Modelo;

import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:20 p.m.
 */
public class Agencia implements ICliente {

    private int id;
    private int legajo;
    private String telefono;
    private String nombre;
    private List<Persona> contactos;
    private Localidad localidad;
    private String email;

    public Agencia() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     *
     * @param newVal
     */
    public void setLocalidad(Localidad newVal) {
        localidad = newVal;
    }

    public int getLegajo() {
        return legajo;
    }

    /**
     *
     * @param newVal
     */
    public void setLegajo(int newVal) {
        legajo = newVal;
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
}//end Agencia
