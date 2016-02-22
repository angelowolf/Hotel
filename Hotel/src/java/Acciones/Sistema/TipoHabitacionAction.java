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

    private String nombre;
    private int id;
    private List<TipoHabitacion> lista = new ArrayList<TipoHabitacion>();

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
        cth.actualizar(id, nombre);
        addActionMessage(Soporte.Mensaje.getModificado(Soporte.Mensaje.TIPOHABITACION));
        codigo = 400;
        return SUCCESS;
    }

    public String list() {
        Hotel hotel = (Hotel) sesion.get("hotel");
        lista = cth.getTodos(hotel.getId());
        codigo = 400;
        return SUCCESS;
    }

    public String eliminar() {
        if (cth.enUso(id)) {
            addActionError(Soporte.Mensaje.getUsadoPorUna(Soporte.Mensaje.TIPOHABITACION, Soporte.Mensaje.HABITACION));
            codigo = 200;
        } else {
            cth.eliminar(id);
            addActionError(Soporte.Mensaje.getEliminado(Soporte.Mensaje.TIPOHABITACION));
            codigo = 400;
        }
        return SUCCESS;
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
            return ERROR;
        }
    }

    public String creartipohabitacion() {
        nombre = "Superior2";
        return registrar();
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

    @Override
    public int getCodigo() {
        return codigo;
    }
}
