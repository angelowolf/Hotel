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
public class TipoHabitacionAction extends Accion {

    private final IControladorTipoHabitacion cth = new ControladorTipoHabitacion();

    private String nombre, contenido;
    private int id;
    private List<TipoHabitacion> lista = new ArrayList<TipoHabitacion>();
    private List<Habitacion> habitaciones = new ArrayList<Habitacion>();

    private boolean validarRegistrar() {
        boolean flag = true;
        Hotel h = (Hotel) sesion.get("hotel");
        if (StringUtils.isBlank(nombre)) {
            addActionError(Soporte.Mensaje.INGRESENOMBRETIPOHABITACION);
            flag = false;
        } else if (cth.existe(id, nombre, h.getId())) {
            addActionError(Soporte.Mensaje.getElExiste(Soporte.Mensaje.TIPOHABITACION));
            flag = false;
        }
        return flag;
    }

    public String registrar() {
        Hotel h = (Hotel) sesion.get("hotel");
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        cth.guardar(nombre, h.getId());
        addActionMessage(Soporte.Mensaje.getAgregado(Soporte.Mensaje.TIPOHABITACION));
        return SUCCESS;
    }

    public String modificar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        Hotel h = (Hotel) sesion.get("hotel");
        try {
            cth.actualizar(id, nombre, h.getId());
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getModificado(Soporte.Mensaje.TIPOHABITACION));
        codigo = 400;
        return SUCCESS;
    }

    public String listar() {
        Hotel hotel = (Hotel) sesion.get("hotel");
        lista = cth.getTodos(hotel.getId());
        codigo = 400;
        return SUCCESS;
    }

    public String eliminar() {
        Hotel h = (Hotel) sesion.get("hotel");
        try {
            if (cth.eliminar(id, h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminado(Soporte.Mensaje.TIPOHABITACION));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadoPorUna(Soporte.Mensaje.TIPOHABITACION, Soporte.Mensaje.HABITACION));
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
        TipoHabitacion th = cth.getUno(id);
        if (th != null) {
            nombre = th.getNombre();
            id = th.getId();
            codigo = 400;
            return SUCCESS;
        } else {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    public String getHabitacionesByTipo() {
        IControladorHabitacion ch = new ControladorHabitacion();
        Hotel h = (Hotel) sesion.get("hotel");
        try {
            habitaciones = ch.getHabitacionesByTipoHabitacion(id, h.getId());
            codigo = 400;
            return SUCCESS;
        } catch (IllegalAccessError e) {
            codigo = 200;
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            return INPUT;
        }
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
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

    public List<TipoHabitacion> getLista() {
        return lista;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}
