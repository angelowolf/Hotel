/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Acciones.AccionABMC;
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
public class TipoHabitacionAction extends Accion implements AccionABMC {

    private final IControladorTipoHabitacion cth = new ControladorTipoHabitacion();

    private String nombre, contenido;
    private int id;
    private List<TipoHabitacion> lista = new ArrayList<TipoHabitacion>();
    private List<Habitacion> habitaciones = new ArrayList<Habitacion>();

    public TipoHabitacionAction() {
        h = (Hotel) sesion.get("hotel");
        if (h == null) {
            throw new NullPointerException();
        }
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addActionError(Soporte.Mensaje.INGRESENOMBRETIPOHABITACION);
            flag = false;
        } else if (cth.existe(id, nombre, h.getId())) {
            addActionError(Soporte.Mensaje.getElExiste(Soporte.Mensaje.TIPOHABITACION));
            flag = false;
        }
        return flag;
    }

    @Override
    public String registrar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        cth.guardar(nombre, h.getId());
        addActionMessage(Soporte.Mensaje.getAgregado(Soporte.Mensaje.TIPOHABITACION));
        return SUCCESS;
    }

    @Override
    public String modificar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            cth.actualizar(id, nombre, h.getId());
            addActionMessage(Soporte.Mensaje.getModificado(Soporte.Mensaje.TIPOHABITACION));
            codigo = 400;
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = cth.getTodos(h.getId());
        codigo = 400;
        return SUCCESS;
    }

    @Override
    public String eliminar() {
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

    @Override
    public String editar() {
        try {
            TipoHabitacion th = cth.getUno(id,h.getId());
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
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    public String getHabitacionesByTipo() {
        IControladorHabitacion ch = new ControladorHabitacion();
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
