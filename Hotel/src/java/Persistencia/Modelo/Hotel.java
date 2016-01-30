package Persistencia.Modelo;

import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class Hotel {

    private int id;
    private Dueño dueño;
    private Membresia membresia;
    private List<Pago> pagos;
    private Plan plan;
    private String nombre;
    private List<Reserva> reservas;
    private List<TipoHabitacion> tipoHabitaciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TipoHabitacion> getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    public void setTipoHabitaciones(List<TipoHabitacion> tipoHabitaciones) {
        this.tipoHabitaciones = tipoHabitaciones;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    private List<Empleado> empleados;
    private List<ICliente> clientes;
    private List<Lavado> lavados;
    private Domicilio domicilio;
    private String telefonos;
    private List<Usuario> usuarios;
    private String email;
    private String web;
    private Pais pais;

    public Hotel() {

    }

    public void finalize() throws Throwable {

    }

    public Dueño getDueño() {
        return dueño;
    }

    /**
     *
     * @param newVal
     */
    public void setDueño(Dueño newVal) {
        dueño = newVal;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    /**
     *
     * @param newVal
     */
    public void setMembresia(Membresia newVal) {
        membresia = newVal;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     *
     * @param newVal
     */
    public void setPagos(List<Pago> newVal) {
        pagos = newVal;
    }

    public Plan getPlan() {
        return plan;
    }

    /**
     *
     * @param newVal
     */
    public void setPlan(Plan newVal) {
        plan = newVal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     *
     * @param newVal
     */
    public void setReservas(List<Reserva> newVal) {
        reservas = newVal;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     *
     * @param newVal
     */
    public void setEmpleados(List<Empleado> newVal) {
        empleados = newVal;
    }

    public List<ICliente> getClientes() {
        return clientes;
    }

    /**
     *
     * @param newVal
     */
    public void setClientes(List<ICliente> newVal) {
        clientes = newVal;
    }

    public List<Lavado> getLavados() {
        return lavados;
    }

    /**
     *
     * @param newVal
     */
    public void setLavados(List<Lavado> newVal) {
        lavados = newVal;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param newVal
     */
    public void setUsuarios(List<Usuario> newVal) {
        usuarios = newVal;
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

    public String getTelefonos() {
        return telefonos;
    }

    /**
     *
     * @param newVal
     */
    public void setTelefonos(String newVal) {
        telefonos = newVal;
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

    public String getWeb() {
        return web;
    }

    /**
     *
     * @param newVal
     */
    public void setWeb(String newVal) {
        web = newVal;
    }

    public boolean isMembresiaActiva() {
        return this.membresia.isActiva();
    }

    public boolean isMembresiaVencida() {
        return this.membresia.isVencida();
    }

    public boolean isMembresiaAviso() {
        return this.membresia.isAviso();
    }
}//end Hotel
