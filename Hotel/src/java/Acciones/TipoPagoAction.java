/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorTipoPago;
import Persistencia.Modelo.TipoPago;
import Soporte.Mensaje;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author angelo
 */
public class TipoPagoAction extends ActionSupport {

    private List<TipoPago> lista = new ArrayList<TipoPago>();
    private final ControladorTipoPago controladorTipoPago = new ControladorTipoPago();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private String nombre;
    private int id;
    private float recargo;

    private boolean validar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addFieldError("nombre", Mensaje.ingreseNombre);
            flag = false;
        } else if (controladorTipoPago.existe(id, nombre)) {
            addFieldError("nombre", Mensaje.getElExiste(Mensaje.tipoPago));
            flag = false;
        }
        if (recargo < 0) {
            addFieldError("recargo", Mensaje.ingreseRecargo);
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (id != 0) {
            controladorTipoPago.actualizar(id, nombre, recargo);
            sesion.put("mensaje", Mensaje.getModificado(Mensaje.tipoPago));
        } else {
            controladorTipoPago.guardar(nombre, recargo);;
            sesion.put("mensaje", Mensaje.getAgregado(Mensaje.tipoPago));
        }
        return SUCCESS;
    }

    public String list() {
        lista = controladorTipoPago.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        String alerta = (String) sesion.get("alerta");
        addActionError(alerta);
        sesion.put("mensaje", "");
        sesion.put("alerta", "");
        return SUCCESS;
    }

    public String eliminar() {
        if (controladorTipoPago.enUso(id)) {
            sesion.put("alerta", Mensaje.getUsadoPorUna(Mensaje.tipoPago, Mensaje.pago));
        } else {
            controladorTipoPago.eliminar(id);
            sesion.put("mensaje", Mensaje.getEliminado(Mensaje.tipoPago));
        }
        return SUCCESS;
    }

    public String editar() {
        TipoPago tp = controladorTipoPago.getUno(id);
        if (tp != null) {
            nombre = tp.getNombre();
            recargo = tp.getPorcentajeRecargo();
            id = tp.getId();
            return SUCCESS;
        } else {
            sesion.put("alerta", Mensaje.idInvalido);
            return ERROR;
        }
    }

    public List<TipoPago> getLista() {
        return lista;
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

    public float getRecargo() {
        return recargo;
    }

    public void setRecargo(float recargo) {
        this.recargo = recargo;
    }

}
