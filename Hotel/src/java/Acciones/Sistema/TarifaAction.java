/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorTarifa;
import Controlador.Implementacion.ControladorTemporada;
import Controlador.Implementacion.ControladorTipoHabitacion;
import Controlador.Interface.IControladorTarifa;
import Controlador.Interface.IControladorTemporada;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Tarifa;
import Persistencia.Modelo.Temporada;
import Persistencia.Modelo.TipoHabitacion;
import Soporte.TipoHabitacionMultiselect;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import Acciones.IAccionABMC;

/**
 *
 * @author ang_2
 */
public class TarifaAction extends Accion implements IAccionABMC{

    private final IControladorTarifa ct = new ControladorTarifa();
    private final IControladorTemporada controladorTemporada = new ControladorTemporada();

    private List<Tarifa> lista = new ArrayList<Tarifa>();
    private int id;
    private String fechaInicio, fechaFin;
    private float precio;
    private Temporada temporada = new Temporada();
    private List<Integer> tipoHabitacionesSeleccionados;

    private final List<TipoHabitacionMultiselect> tipoHabitaciones = new ArrayList<TipoHabitacionMultiselect>();
    private List<Temporada> temporadas = new ArrayList<Temporada>();

    public TarifaAction() {
        h = (Hotel) sesion.get("hotel");
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (tipoHabitacionesSeleccionados.isEmpty()) {
            flag = false;
            addActionError(Soporte.Mensaje.SELECCIONEUNTIPODEHABITACION);
        }
        if (temporada.getId() == 0) {
            if (StringUtils.isBlank(fechaInicio)) {
                flag = false;
                addActionError(Soporte.Mensaje.INGRESEFECHAINICIO);
            }
            if (StringUtils.isBlank(fechaFin)) {
                flag = false;
                addActionError(Soporte.Mensaje.INGRESEFECHAFIN);
            }
        } else {
            try {
                Temporada t = controladorTemporada.getUno(temporada.getId(), h.getId());
            } catch (AccesoIlegal e) {
                flag = false;
                addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            } catch (ObjetoNoEncontrado ex) {
                flag = false;
                addActionError(Soporte.Mensaje.LATEMPORADANOESVALIDO);
            }
            if (precio <= 0) {
                flag = false;
                addActionError(Soporte.Mensaje.PRECIONOVALIDO);
            }
        }
        return flag;
    }

    @Override
    public String registrar() {
        if (!validarRegistrar()) {
            cargarListaTiposHabitacionValidacion();
            cargarListaTemporada();
            codigo = 200;
            return INPUT;
        }
        try {
            ct.guardar(fechaInicio, fechaFin, precio, temporada.getId(), tipoHabitacionesSeleccionados, h.getId());
        } catch (ParseException ex) {
            addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.TARIFA));
        codigo = 400;
        return SUCCESS;
    }

    @Override
    public String modificar() {
        if (!validarRegistrar()) {
            cargarListaTiposHabitacionValidacion();
            cargarListaTemporada();
            codigo = 200;
            return INPUT;
        }
        try {
            ct.actualizar(id, fechaInicio, fechaFin, precio, temporada.getId(), tipoHabitacionesSeleccionados, id);
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ParseException e) {
            addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.TARIFA));
        codigo = 400;
        return SUCCESS;
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
            if (ct.eliminar(id, h.getId())) {
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
            codigo = 200;
            return INPUT;
        }
    }

    @Override
    public String editar() {
        Tarifa tarifa = ct.getUno(id);
        if (tarifa != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            fechaFin = sdf.format(temporada.getFechaFin());
            fechaInicio = sdf.format(temporada.getFechaInicio());
            id = temporada.getId();
            temporada = tarifa.getTemporada();
            precio = tarifa.getPrecio();
            Map<Integer, TipoHabitacion> mapTipoHabitacionQuePosee = new HashMap<Integer, TipoHabitacion>();
            for (TipoHabitacion i : tarifa.getTipoHabitaciones()) {
                mapTipoHabitacionQuePosee.put(i.getId(), i);
            }
            cargarListaTipoHabitacion(mapTipoHabitacionQuePosee, true);
            cargarListaTemporada();
            codigo = 400;
            return SUCCESS;
        } else {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        }
    }

    public String nuevo() {
        cargarListaTipoHabitacion(null, false);
        cargarListaTemporada();
        codigo = 400;
        return SUCCESS;
    }

    private void cargarListaTemporada() {
        temporadas = controladorTemporada.getTodos(h.getId());
    }

    private void cargarListaTiposHabitacionValidacion() {
        Map<Integer, Integer> objetosSeleccionados = new HashMap<Integer, Integer>();
        for (Integer i : tipoHabitacionesSeleccionados) {
            if (i > 0) {
                objetosSeleccionados.put(i, i);
            }
        }
        IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
        List<TipoHabitacion> tipoHabitacionTodos = cth.getTodos(h.getId());
        for (TipoHabitacion cadaTipoHabitacionQueExiste : tipoHabitacionTodos) {
            TipoHabitacionMultiselect ms = new TipoHabitacionMultiselect();
            ms.setId(cadaTipoHabitacionQueExiste.getId());
            ms.setNombre(cadaTipoHabitacionQueExiste.getNombre());
            if (!objetosSeleccionados.isEmpty()) {
                if (objetosSeleccionados.containsKey(cadaTipoHabitacionQueExiste.getId())) {
                    ms.setSeleccionado(true);
                } else {
                    ms.setSeleccionado(false);
                }
            } else {
                ms.setSeleccionado(false);
            }
            tipoHabitaciones.add(ms);
        }
    }

    private void cargarListaTipoHabitacion(Map<Integer, TipoHabitacion> mapTipoHabitacionQuePosee, boolean flag) {
        IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
        List<TipoHabitacion> tipoHabitacionTodos = cth.getTodos(h.getId());
        for (TipoHabitacion cadaTipoHabitacionQueExiste : tipoHabitacionTodos) {
            TipoHabitacionMultiselect ms = new TipoHabitacionMultiselect();
            ms.setId(cadaTipoHabitacionQueExiste.getId());
            ms.setNombre(cadaTipoHabitacionQueExiste.getNombre());
            if (flag && mapTipoHabitacionQuePosee.containsKey(cadaTipoHabitacionQueExiste.getId())) {
                ms.setSeleccionado(true);
            } else {
                ms.setSeleccionado(false);
            }
            tipoHabitaciones.add(ms);
        }
    }

    public void setTipoHabitacionesSeleccionados(List<Integer> tipoHabitacionesSeleccionados) {
        this.tipoHabitacionesSeleccionados = tipoHabitacionesSeleccionados;
        cargarListaTiposHabitacionValidacion();
    }

    public List<Tarifa> getLista() {
        return lista;
    }

    public List<TipoHabitacionMultiselect> getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

}
