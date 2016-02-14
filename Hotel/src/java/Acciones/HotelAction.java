/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorHotel;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author ang_2
 */
public class HotelAction extends ActionSupport {

    private String nombreHotel, nick, email, ckave, nombre, apellido;
    private int id_planSeleccionado;
    private final ControladorHotel ch = new ControladorHotel();

    public String crearHotel() {
        ch.registrarHotel("tu caquita3", 1, "qweqwe", "qweqwe", "clave3", "nombre3", "apellido3");
        return SUCCESS;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCkave() {
        return ckave;
    }

    public void setCkave(String ckave) {
        this.ckave = ckave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_planSeleccionado() {
        return id_planSeleccionado;
    }

    public void setId_planSeleccionado(int id_planSeleccionado) {
        this.id_planSeleccionado = id_planSeleccionado;
    }

}
