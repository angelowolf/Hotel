/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorTarifa;
import Controlador.Implementacion.ControladorTemporada;
import Controlador.Interface.IControladorTarifa;
import Controlador.Interface.IControladorTemporada;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Tarifa;
import Persistencia.Modelo.Temporada;
import java.util.ArrayList;
import java.util.List;
import Acciones.IAccionABMC;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author ang_2
 */
public class TarifaAction extends Accion implements IAccionABMC, ModelDriven<Tarifa> {

    private final IControladorTarifa ct = new ControladorTarifa();
    private final IControladorTemporada controladorTemporada = new ControladorTemporada();
    private Tarifa tarifa = new Tarifa();

    private List<Tarifa> lista = new ArrayList<Tarifa>();
    private List<Integer> tipoHabitacionesSeleccionados;

    public TarifaAction() {
        h = (Hotel) sesion.get("hotel");
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (tipoHabitacionesSeleccionados.isEmpty()) {
            flag = false;
            addFieldError("tipohabitacion", Soporte.Mensaje.SELECCIONEUNTIPODEHABITACION);
        }
        if (tarifa.getTemporada().getId() == 0) {
            if (tarifa.getFechaInicio() == null) {
                flag = false;
                addFieldError("fechaInicio", Soporte.Mensaje.INGRESEFECHAINICIO);
            }
            if (tarifa.getFechaFin() == null) {
                flag = false;
                addFieldError("fechaFin", Soporte.Mensaje.INGRESEFECHAFIN);
            }
        } else {
            try {
                Temporada t = controladorTemporada.getUno(tarifa.getTemporada().getId(), h.getId());
            } catch (AccesoIlegal e) {
                flag = false;
                addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            } catch (ObjetoNoEncontrado ex) {
                flag = false;
                addActionError(Soporte.Mensaje.LATEMPORADANOESVALIDO);
            }
            if (tarifa.getPrecio() <= 0) {
                flag = false;
                addActionError(Soporte.Mensaje.PRECIONOVALIDO);
            }
        }
        return flag;
    }

    @Override
    public String registrar() {
        if (validarRegistrar()) {
            try {
                tarifa.setId(ct.guardar(tarifa.getFechaInicio(), tarifa.getFechaFin(), tarifa.getPrecio(), tarifa.getTemporada().getId(), tipoHabitacionesSeleccionados, h.getId()));
                addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.TARIFA));
                codigo = 400;
                return SUCCESS;
            } catch (ObjetoNoEncontrado ex) {
                addActionError(Soporte.Mensaje.IDINVALIDO);
            } catch (AccesoIlegal e) {
                addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            }
        }
        return INPUT;
    }

    @Override
    public String modificar() {
        if (validarRegistrar()) {
            try {
                ct.actualizar(tarifa.getId(), tarifa.getFechaInicio(), tarifa.getFechaFin(), tarifa.getPrecio(), tarifa.getTemporada().getId(), tipoHabitacionesSeleccionados, h.getId());
                addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.TARIFA));
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
        lista = ct.getTodos(h.getId());
        codigo = 400;
        return SUCCESS;
    }

    @Override
    public String eliminar() {
        try {
            if (ct.eliminar(tarifa.getId(), h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminada(Soporte.Mensaje.TARIFA));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadaPorUna(Soporte.Mensaje.TARIFA, Soporte.Mensaje.TARIFA));
                codigo = 200;
                return INPUT;
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
            tarifa = ct.getUno(tarifa.getId(), h.getId());
            codigo = 400;
            return SUCCESS;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        }
        return INPUT;
    }

    public List<Tarifa> getLista() {
        return lista;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setTipoHabitacionesSeleccionados(List<Integer> tipoHabitacionesSeleccionados) {
        this.tipoHabitacionesSeleccionados = tipoHabitacionesSeleccionados;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Tarifa getModel() {
        return tarifa;
    }

}
