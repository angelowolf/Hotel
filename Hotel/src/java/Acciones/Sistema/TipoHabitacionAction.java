/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorTipoHabitacion;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.Hotel;

/**
 *
 * @author ang_2
 */
public class TipoHabitacionAction extends Accion {

    private final IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
    private Hotel hotel;
    private String nombre;
    private int id;

    public String registrarTipoHabitacion() {
        hotel = (Hotel) sesion.get("hotel");
        if (cth.existe(id, nombre, hotel)) {
            addActionError("YA EXISTE");
            return INPUT;
        } else {
            cth.guardar(nombre, hotel);
            addActionError("SE GUARDO");
            return SUCCESS;
        }
    }

    public String creartipohabitacion() {
        nombre = "Superior";
        return registrarTipoHabitacion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
