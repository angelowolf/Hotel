/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Acciones.AccionABMC;
import Controlador.Implementacion.ControladorDetalleMantenimiento;
import Controlador.Interface.IControladorDetalleMantenimiento;
import Persistencia.Modelo.DetalleMantenimiento;
import Persistencia.Modelo.Hotel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class DetalleMantenimientoAction extends Accion implements AccionABMC {

    private final IControladorDetalleMantenimiento cdm = new ControladorDetalleMantenimiento();

    private int id, id_habitacion;
    private String descripcion;
    private String fecha;
    private boolean resuelto;
    private List<DetalleMantenimiento> lista = new ArrayList<DetalleMantenimiento>();

    public DetalleMantenimientoAction() {
        h = (Hotel) sesion.get("hotel");
        if (h == null) {
            throw new NullPointerException();
        }
    }

    private boolean validar() {
        boolean flag = true;
        if (StringUtils.isBlank(descripcion)) {
            flag = false;
            addActionError(Soporte.Mensaje.INGRESEDESCRIPCION);
        }
        if (StringUtils.isBlank(fecha)) {
            flag = false;
            addActionError(Soporte.Mensaje.INGRESEFECHA);
        }
        return flag;
    }

    @Override
    public String registrar() {
        if (!validar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            cdm.guardar(descripcion, fecha, id_habitacion);
            addActionMessage(Soporte.Mensaje.getAgregado(Soporte.Mensaje.DETALLEMANTENIMIENTO));
            codigo = 400;
            return SUCCESS;
        } catch (ParseException e) {
            addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            codigo = 200;
            return INPUT;
        }
    }

    @Override
    public String modificar() {
        if (!validar()) {
            codigo = 200;
            return INPUT;
        }
        try {
            cdm.actualizar(id, descripcion, fecha, id_habitacion, h.getId());
            codigo = 400;
            addActionMessage(Soporte.Mensaje.getModificado(Soporte.Mensaje.DETALLEMANTENIMIENTO));
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        } catch (ParseException e) {
            addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            codigo = 200;
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public String editar() {
        try {
            DetalleMantenimiento dm = cdm.getUno(id, h.getId());
            if (dm != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
                descripcion = dm.getDescripcion();
                id = dm.getId();
                id_habitacion = dm.getId_habitacion();
                fecha = sdf.format(dm.getFecha());
                resuelto = dm.isResuelto();
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

    @Override
    public String listar() {
        try {
            lista = cdm.getTodos(id_habitacion, h.getId());
            codigo = 400;
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public String eliminar() {
        try {
            cdm.eliminar(id, h.getId());
            codigo = 400;
        } catch (IllegalAccessError e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            codigo = 200;
            return INPUT;
        }
        return SUCCESS;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public List<DetalleMantenimiento> getLista() {
        return lista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public void setResuelto(boolean resuelto) {
        this.resuelto = resuelto;
    }

}
