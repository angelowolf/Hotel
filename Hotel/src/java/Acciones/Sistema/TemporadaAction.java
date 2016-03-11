/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorTemporada;
import Controlador.Interface.IControladorTemporada;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Temporada;
import static com.opensymphony.xwork2.Action.INPUT;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class TemporadaAction extends Accion {

    private final IControladorTemporada ct = new ControladorTemporada();

    private int id;
    private String nombre, fechaInicio, fechaFin;
    private List<Temporada> lista = new ArrayList<Temporada>();

    public TemporadaAction() {
        h = (Hotel) sesion.get("hotel");
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addActionError(Soporte.Mensaje.INGRESENOMBRETEMPORADA);
            flag = false;
        } else if (ct.existe(id, nombre, h.getId())) {
            addActionError(Soporte.Mensaje.getLaExiste(Soporte.Mensaje.TEMPORADA));
            flag = false;
        }
        if (StringUtils.isBlank(fechaInicio)) {
            addActionError(Soporte.Mensaje.INGRESEFECHAINICIO);
            flag = false;
        }
        if (StringUtils.isBlank(fechaFin)) {
            addActionError(Soporte.Mensaje.INGRESEFECHAFIN);
            flag = false;
        }
        return flag;
    }

    public String registrar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            ct.guardar(nombre, fechaInicio, fechaFin, h.getId());
        } catch (ParseException ex) {
            addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            codigo = 200;
            return INPUT;
        }
        addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.TEMPORADA));
        codigo = 400;
        return SUCCESS;
    }

    public String modificar() {
        if (!validarRegistrar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            ct.actualizar(id, nombre, fechaInicio, fechaFin, h.getId());
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
        addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.TEMPORADA));
        codigo = 400;
        return SUCCESS;
    }

    public String listar() {
        lista = ct.getTodos(h.getId());
        codigo = 400;
        return SUCCESS;
    }

    public String eliminar() {
        try {
            if (ct.eliminar(id, h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminada(Soporte.Mensaje.TEMPORADA));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadaPorUna(Soporte.Mensaje.TEMPORADA, Soporte.Mensaje.TARIFA));
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

    public String editar() {
        try {
            Temporada temporada = ct.getUno(id,h.getId());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            nombre = temporada.getNombre();
            fechaFin = sdf.format(temporada.getFechaFin());
            fechaInicio = sdf.format(temporada.getFechaInicio());
            id = temporada.getId();
            codigo = 400;
            return SUCCESS;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ObjetoNoEncontrado ex) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Temporada> getLista() {
        return lista;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

}
