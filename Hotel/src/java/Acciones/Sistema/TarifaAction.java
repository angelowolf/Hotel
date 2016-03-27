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
import Controlador.Implementacion.ControladorTipoHabitacion;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.TipoHabitacion;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.ParameterAware;

/**
 *
 * @author ang_2
 */
public class TarifaAction extends Accion implements ParameterAware {

    private final IControladorTarifa ct = new ControladorTarifa();
    private final IControladorTemporada controladorTemporada = new ControladorTemporada();
    private Tarifa tarifa = new Tarifa();

    private Date fechaInicio, fechaFin;
    private int id_tipoHabitacion;
    private int id_temporada;
    private Map<String, String[]> parametros;

    private final HashMap<Integer, Float> precioPorCapacidad = new HashMap<Integer, Float>();
    private List<Integer> capacidadPorTipoHabitacion = new ArrayList<Integer>();
    private List<TipoHabitacion> listaTipoHabitacion = new ArrayList<TipoHabitacion>();
    private List<Temporada> temporadas = new ArrayList<Temporada>();

    public TarifaAction() {
        h = (Hotel) sesion.get("hotel");
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (id_tipoHabitacion <= 0) {
            flag = false;
            addFieldError("tipohabitacion", Soporte.Mensaje.SELECCIONEUNTIPODEHABITACION);
        }
        if (id_temporada <= 0) {
            if (fechaInicio == null) {
                flag = false;
                addFieldError("fechaInicio", Soporte.Mensaje.INGRESEFECHAINICIO);
            }
            if (fechaFin == null) {
                flag = false;
                addFieldError("fechaFin", Soporte.Mensaje.INGRESEFECHAFIN);
            }
        } else {
            try {
                Temporada t = controladorTemporada.getUno(id_temporada, h.getId());
                fechaFin = t.getFechaFin();
                fechaInicio = t.getFechaInicio();
            } catch (AccesoIlegal e) {
                flag = false;
                addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            } catch (ObjetoNoEncontrado ex) {
                flag = false;
                addActionError(Soporte.Mensaje.LATEMPORADANOESVALIDO);
            }
        }
        boolean flagCapacidad = false;

        for (Map.Entry<String, String[]> entrySet : parametros.entrySet()) {
            String key = entrySet.getKey();
            String[] value = entrySet.getValue();
            if (key.contains("capacidad")) {
                String scapacidad = key.substring(9);
                int capacidad;
                float precio;
                try {
                    capacidad = Integer.parseInt(scapacidad);
                    precio = Float.parseFloat(value[0]);
                    precioPorCapacidad.put(capacidad, precio);
                    flagCapacidad = true;
                } catch (NumberFormatException e) {
                    addFieldError(key, Soporte.Mensaje.FORMATOCPACIDADNOCORRECTO);
                    flag = false;
                }
            }
        }
        if (!flagCapacidad) {
            flag = false;
            addActionError(Soporte.Mensaje.INGRESEPRECIOALGUNACAPACIDAD);
        }
        return flag;
    }

    public String registrar() {
        if (validarRegistrar()) {
            try {
                ct.guardar(fechaInicio, fechaFin, id_tipoHabitacion, precioPorCapacidad, h.getId());
                addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.TARIFA));
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

    public String capacidadPorTipoHabitacion() {
        try {
            IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
            capacidadPorTipoHabitacion = cth.getCapacidadesPorTipoHabitacion(id_tipoHabitacion, h.getId());
            temporadas = controladorTemporada.getTodos(h.getId());
            return SUCCESS;
        } catch (AccesoIlegal ex) {
        } catch (ObjetoNoEncontrado ex) {
        }
        return INPUT;
    }

    public String tarifa() {
        IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
        listaTipoHabitacion = cth.getTodos(h.getId());
        return SUCCESS;
    }

    public List<Integer> getCapacidadPorTipoHabitacion() {
        return capacidadPorTipoHabitacion;
    }

    public List<TipoHabitacion> getListaTipoHabitacion() {
        return listaTipoHabitacion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId_tipoHabitacion() {
        return id_tipoHabitacion;
    }

    public void setId_tipoHabitacion(int id_tipoHabitacion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
    }

    public int getId_temporada() {
        return id_temporada;
    }

    public void setId_temporada(int id_temporada) {
        this.id_temporada = id_temporada;
    }

    public Map<String, String[]> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String[]> parametros) {
        this.parametros = parametros;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setParameters(Map<String, String[]> parametros) {
        this.parametros = parametros;
    }

}
