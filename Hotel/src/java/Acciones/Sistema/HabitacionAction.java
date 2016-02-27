/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorHabitacion;
import Controlador.Implementacion.ControladorTipoHabitacion;
import Controlador.Interface.IControladorHabitacion;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.TipoHabitacion;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class HabitacionAction extends Accion {

    private final IControladorHabitacion ch = new ControladorHabitacion();
    private final IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
    private final Hotel h = (Hotel) sesion.get("hotel");

    private int id, capacidad, id_tipohabitacion;
    private TipoHabitacion tipoHabitacion;
    private String nombre;
    private List<Habitacion> lista = new ArrayList<Habitacion>();

    private boolean validarRegistrar() {
        boolean flag = true;
        if (capacidad <= 0) {
            addActionError(Soporte.Mensaje.INGRESECAPACIDAD);
            flag = false;
        }
        if (StringUtils.isBlank(nombre)) {
            addActionError(Soporte.Mensaje.INGRESENOMBREHABITACION);
            flag = false;
        } else if (ch.existe(id, nombre, h.getId())) {
            addActionError(Soporte.Mensaje.getLaExiste(Soporte.Mensaje.HABITACION));
            flag = false;
        }
        if (!validarTipoHabitacion()) {
            flag = false;
        }
        return flag;
    }

    private boolean validarTipoHabitacion() {
        TipoHabitacion th = cth.getUno(id_tipohabitacion);
        if (th != null && th.getId_hotel() != h.getId()) {
            addActionError(Soporte.Mensaje.ELTIPOHABITACIONNOESVALIDO);
            return false;
        }
        return true;
    }

    public String registrar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        ch.guardar(nombre, capacidad, id_tipohabitacion);
        addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.HABITACION));
        codigo = 400;
        return SUCCESS;
    }

    public String modificar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            ch.actualizar(id, nombre, capacidad, id_tipohabitacion, h.getId());
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.HABITACION));
        codigo = 400;
        return SUCCESS;
    }

    public String modificartipohabitacion() {
        if (!validarTipoHabitacion()) {
            codigo = 200;
            return INPUT;
        }
        try {
            ch.actualizar(id, id_tipohabitacion, h.getId());
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.HABITACION));
        codigo = 400;
        return SUCCESS;
    }

    public String listar() {
        lista = ch.getTodos(h.getId());
        codigo = 400;
        return SUCCESS;
    }

    public String eliminar() {
        try {
            if (ch.eliminar(id, h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminada(Soporte.Mensaje.HABITACION));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadaPorUna(Soporte.Mensaje.HABITACION, Soporte.Mensaje.RESERVA));
                codigo = 200;
                return INPUT;
            }
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    public String editar() {
        Habitacion habitacion = ch.getUno(id);
        if (habitacion != null) {
            nombre = habitacion.getNombre();
            capacidad = habitacion.getCapacidad();
            id = habitacion.getId();
            id_tipohabitacion = habitacion.getTipoHabitacion().getId();
            tipoHabitacion = habitacion.getTipoHabitacion();
            codigo = 400;
            return SUCCESS;
        } else {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId_tipohabitacion() {
        return id_tipohabitacion;
    }

    public void setId_tipohabitacion(int id_tipohabitacion) {
        this.id_tipohabitacion = id_tipohabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Habitacion> getLista() {
        return lista;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}
