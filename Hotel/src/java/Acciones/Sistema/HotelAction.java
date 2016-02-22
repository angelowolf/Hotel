/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorHotel;
import Controlador.Implementacion.ControladorPlan;
import Controlador.Implementacion.ControladorUsuario;
import Controlador.Interface.IControladorHotel;
import Controlador.Interface.IControladorPlan;
import Controlador.Interface.IControladorUsuario;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author ang_2
 */
public class HotelAction extends Accion {

    private String nombreHotel, nick, email, clave, nombre, apellido;
    private int id_planSeleccionado;
    private final IControladorHotel ch = new ControladorHotel();
    private final IControladorUsuario cu = new ControladorUsuario();
    private final IControladorPlan cp = new ControladorPlan();

    public boolean validarCrearHotel() {
        boolean flag = true;
        if (!cu.isNickDisponible(nick)) {
            flag = false;
            addActionError(Soporte.Mensaje.NICKNODISPONIBLE);
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            flag = false;
            addActionError(Soporte.Mensaje.EMAILNOVALIDO);
        } else {
            if (!cu.isEmailDisponible(email)) {
                flag = false;
                addActionError(Soporte.Mensaje.EMAILNODISPONIBLE);
            }
        }
        if (!cp.isPlanExistente(id_planSeleccionado)) {
            flag = false;
            addActionError(Soporte.Mensaje.PLANNOEXISTE);
        }
        return flag;
    }

    public String registrarHotel() {
        if (!validarCrearHotel()) {
            return INPUT;
        }
        ch.registrarHotel(nombreHotel, id_planSeleccionado, nick, email, clave, nombre, apellido);
        return SUCCESS;
    }

    public String crearHotel() {
        nombreHotel = "nombre hotel";
        id_planSeleccionado = 1;
        nick = "sistema";
        email = "sistema2@sistema2.com";
        clave = "clave";
        nombre = "nombre";
        apellido = "apellido";
        return registrarHotel();
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    @Override
    public int getCodigo() {
        return codigo;
    }

}
