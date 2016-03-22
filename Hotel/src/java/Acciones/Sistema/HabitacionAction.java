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
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import Acciones.IAccionABMC;

/**
 *
 * @author ang_2
 */
public class HabitacionAction extends Accion implements IAccionABMC, ModelDriven<Habitacion> {

    private final IControladorHabitacion ch = new ControladorHabitacion();
    private final IControladorTipoHabitacion cth = new ControladorTipoHabitacion();

    private Habitacion habitacion = new Habitacion();
    private List<Habitacion> lista = new ArrayList<Habitacion>();

    public HabitacionAction() {
        h = (Hotel) sesion.get("hotel");
        if (h == null) {
            throw new NullPointerException();
        }
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (habitacion.getCapacidad() <= 0) {
            addActionError(Soporte.Mensaje.INGRESECAPACIDAD);
            flag = false;
        }
        if (StringUtils.isBlank(habitacion.getNombre())) {
            addActionError(Soporte.Mensaje.INGRESENOMBREHABITACION);
            flag = false;
        } else if (ch.existe(habitacion.getId(), habitacion.getNombre(), h.getId())) {
            addActionError(Soporte.Mensaje.getLaExiste(Soporte.Mensaje.HABITACION));
            flag = false;
        }
        if (!validarTipoHabitacion()) {
            flag = false;
        }
        return flag;
    }

    private boolean validarTipoHabitacion() {
        try {
            TipoHabitacion th = cth.getUno(habitacion.getTipoHabitacion().getId(), h.getId());
            return true;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            return false;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.ELTIPOHABITACIONNOESVALIDO);
            return false;
        }
    }

    @Override
    public String registrar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        habitacion.setId(ch.guardar(habitacion.getNombre(), habitacion.getCapacidad(), habitacion.getTipoHabitacion().getId()));
        addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.HABITACION));
        codigo = 400;
        return SUCCESS;
    }

    @Override
    public String modificar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            ch.actualizar(habitacion.getId(), habitacion.getNombre(), habitacion.getCapacidad(), habitacion.getTipoHabitacion().getId(), h.getId());
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
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
            ch.actualizar(habitacion.getId(), habitacion.getTipoHabitacion().getId(), h.getId());
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.HABITACION));
        codigo = 400;
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = ch.getTodos(h.getId());
        codigo = 400;
        return SUCCESS;
    }

    @Override
    public String eliminar() {
        try {
            if (ch.eliminar(habitacion.getId(), h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminada(Soporte.Mensaje.HABITACION));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadaPorUna(Soporte.Mensaje.HABITACION, Soporte.Mensaje.RESERVA));
                codigo = 200;
                return INPUT;
            }
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    @Override
    public String editar() {
        try {
            habitacion = ch.getUno(habitacion.getId(), h.getId());
            codigo = 400;
            return SUCCESS;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    public List<Habitacion> getLista() {
        return lista;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Habitacion getModel() {
        return habitacion;
    }
}
