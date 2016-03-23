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
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.TipoHabitacion;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import Acciones.IAccionABMC;

/**
 *
 * @author ang_2
 */
public class TipoHabitacionAction extends Accion implements IAccionABMC, ModelDriven<TipoHabitacion> {

    private final IControladorTipoHabitacion cth = new ControladorTipoHabitacion();

    private TipoHabitacion tipohabitacion = new TipoHabitacion();
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
        if (StringUtils.isEmpty(tipohabitacion.getNombre())) {
            addFieldError("nombre", Soporte.Mensaje.INGRESENOMBRETIPOHABITACION);
            flag = false;
        } else if (cth.existe(tipohabitacion.getId(), tipohabitacion.getNombre(), h.getId())) {
            addFieldError("nombre", Soporte.Mensaje.getElExiste(Soporte.Mensaje.TIPOHABITACION));
            flag = false;
        }
        return flag;
    }

    @Override
    public String registrar() {
        if (!validarRegistrar()) {
            return INPUT;
        }
        codigo = 400;
        tipohabitacion.setId(cth.guardar(tipohabitacion.getNombre(), h.getId()));
        addActionMessage(Soporte.Mensaje.getAgregado(Soporte.Mensaje.TIPOHABITACION));
        return SUCCESS;
    }

    @Override
    public String modificar() {
        if (validarRegistrar()) {
            try {
                cth.actualizar(tipohabitacion.getId(), tipohabitacion.getNombre(), h.getId());
                addActionMessage(Soporte.Mensaje.getModificado(Soporte.Mensaje.TIPOHABITACION));
                codigo = 400;
                return SUCCESS;
            } catch (AccesoIlegal e) {
                addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            } catch (ObjetoNoEncontrado ex) {
                addActionError(Soporte.Mensaje.IDINVALIDO);
            }
        }
        return INPUT;
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
            if (cth.eliminar(tipohabitacion.getId(), h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminado(Soporte.Mensaje.TIPOHABITACION));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadoPorUna(Soporte.Mensaje.TIPOHABITACION, Soporte.Mensaje.HABITACION));
            }
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        }
        return INPUT;
    }

    @Override
    public String editar() {
        try {
            tipohabitacion = cth.getUno(tipohabitacion.getId(), h.getId());
            codigo = 400;
            return SUCCESS;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        }
        return INPUT;
    }

    public String getModeloCompleto() {
        IControladorHabitacion ch = new ControladorHabitacion();
        try {
            tipohabitacion = cth.getUno(tipohabitacion.getId(), h.getId());
            habitaciones = ch.getHabitacionesByTipoHabitacion(tipohabitacion.getId(), h.getId());
            codigo = 400;
            return SUCCESS;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        }
        return INPUT;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<TipoHabitacion> getLista() {
        return lista;
    }

    public void setTipohabitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public TipoHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public TipoHabitacion getModel() {
        return tipohabitacion;
    }
}
