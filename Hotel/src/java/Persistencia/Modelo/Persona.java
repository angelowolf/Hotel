package Persistencia.Modelo;

import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Persona {

    private int id;
    private String apellido;
    private Domicilio domicilio;
    private String email;
    private String nombre;
    private Sexo sexo;
    private String telefono;
    private TipoDocumento tipoDocumento;
    private Date fechaNacimiento;
    private Pais pais;

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     *
     * @param newVal
     */
    public void setDomicilio(Domicilio newVal) {
        domicilio = newVal;
    }

    public Sexo getSexo() {
        return sexo;
    }

    /**
     *
     * @param newVal
     */
    public void setSexo(Sexo newVal) {
        sexo = newVal;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     *
     * @param newVal
     */
    public void setTipoDocumento(TipoDocumento newVal) {
        tipoDocumento = newVal;
    }

    public Pais getPais() {
        return pais;
    }

    /**
     *
     * @param newVal
     */
    public void setPais(Pais newVal) {
        pais = newVal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaNacimiento(Date newVal) {
        fechaNacimiento = newVal;
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

    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param newVal
     */
    public void setApellido(String newVal) {
        apellido = newVal;
    }
}//end Persona
