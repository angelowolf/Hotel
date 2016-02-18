/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Root;

import Acciones.Accion;
import Controlador.Implementacion.ControladorTipoDocumento;
import Controlador.Interface.IControladorTipoDocumento;
import Persistencia.Modelo.TipoDocumento;
import Soporte.Mensaje;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class TipoDocumentoAction extends Accion {

    private List<TipoDocumento> lista = new ArrayList<TipoDocumento>();
    private final IControladorTipoDocumento controladorTipoDocumento = new ControladorTipoDocumento();
    private String nombre;
    private int id;

    private boolean validar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addFieldError("nombre", Mensaje.ingreseNombre);
            flag = false;
        } else if (controladorTipoDocumento.existe(id, nombre)) {
            addFieldError("nombre", Mensaje.getElExiste(Mensaje.tipoDocumento));
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (id != 0) {
            controladorTipoDocumento.actualizar(id, nombre);
            sesion.put("mensaje", Mensaje.getModificado(Mensaje.tipoDocumento));
        } else {
            controladorTipoDocumento.guardar(nombre);
            sesion.put("mensaje", Mensaje.getAgregado(Mensaje.tipoDocumento));
        }
        return SUCCESS;
    }

    public String list() {
        lista = controladorTipoDocumento.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        String alerta = (String) sesion.get("alerta");
        addActionError(alerta);
        sesion.put("mensaje", "");
        sesion.put("alerta", "");
        return SUCCESS;
    }

    public String eliminar() {
        if (controladorTipoDocumento.enUso(id)) {
            sesion.put("alerta", Mensaje.getUsadoPorUna(Mensaje.tipoDocumento, Mensaje.persona));
        } else {
            controladorTipoDocumento.eliminar(id);
            sesion.put("mensaje", Mensaje.getEliminado(Mensaje.tipoDocumento));
        }
        return SUCCESS;
    }

    public String editar() {
        TipoDocumento tipoDocumento = controladorTipoDocumento.getUno(id);
        if (tipoDocumento != null) {
            nombre = tipoDocumento.getNombre();
            id = tipoDocumento.getId();
            return SUCCESS;
        } else {
            sesion.put("alerta", Mensaje.idInvalido);
            return ERROR;
        }
    }

    public List<TipoDocumento> getLista() {
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
}
