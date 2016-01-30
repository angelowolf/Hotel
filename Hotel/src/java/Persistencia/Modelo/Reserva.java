package Persistencia.Modelo;

import java.util.Date;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:29 p.m.
 */
public class Reserva {

    private int id;
    private ICliente cliente;
    private List<Cobro> cobros;
    private List<DetalleReserva> detalleReservas;
    private EstadoReserva estadoReserva;
    private Date fechaIngreso;
    private Date fechaReserva;
    private Date fechaSalida;
    private String descripcion;
    private List<Persona> pasajeros;
    private List<Cargo> cargos;
    private boolean checkIn;
    private boolean checkOut;

    public Reserva() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ICliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param newVal
     */
    public void setCliente(ICliente newVal) {
        cliente = newVal;
    }

    public List<Cobro> getCobros() {
        return cobros;
    }

    /**
     *
     * @param newVal
     */
    public void setCobros(List<Cobro> newVal) {
        cobros = newVal;
    }

    public List<DetalleReserva> getDetalleReservas() {
        return detalleReservas;
    }

    /**
     *
     * @param newVal
     */
    public void setDetalleReservas(List<DetalleReserva> newVal) {
        detalleReservas = newVal;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    /**
     *
     * @param newVal
     */
    public void setEstadoReserva(EstadoReserva newVal) {
        estadoReserva = newVal;
    }

    public List<Persona> getPasajeros() {
        return pasajeros;
    }

    /**
     *
     * @param newVal
     */
    public void setPasajeros(List<Persona> newVal) {
        pasajeros = newVal;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    /**
     *
     * @param newVal
     */
    public void setCargos(List<Cargo> newVal) {
        cargos = newVal;
    }

    public void confirmar() {

    }

    public void registrarIngreso() {

    }

    public void registrarEgreso() {

    }

    public void cancelar() {

    }

    public boolean isCheckOut() {
        return checkOut;
    }

    /**
     *
     * @param newVal
     */
    public void setCheckOut(boolean newVal) {
        checkOut = newVal;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    /**
     *
     * @param newVal
     */
    public void setCheckIn(boolean newVal) {
        checkIn = newVal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param newVal
     */
    public void setDescripcion(String newVal) {
        descripcion = newVal;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaSalida(Date newVal) {
        fechaSalida = newVal;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaReserva(Date newVal) {
        fechaReserva = newVal;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     *
     * @param newVal
     */
    public void setFechaIngreso(Date newVal) {
        fechaIngreso = newVal;
    }
}//end Reserva
