/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorModulo;
import Persistencia.Modelo.Modulo;
import Soporte.Mensaje;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class ModuloAction extends ActionSupport {

    private List<Modulo> lista = new ArrayList<Modulo>();
    private final ControladorModulo controladorModulo = new ControladorModulo();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private String nombre, caracteristica;
    private int id;

    private boolean validar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addFieldError("nombre", Mensaje.ingreseNombre);
            flag = false;
        } else if (controladorModulo.existe(id, nombre)) {
            addFieldError("nombre", Mensaje.getElExiste(Mensaje.modulo));
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (id != 0) {
            controladorModulo.actualizar(id, nombre, caracteristica);
            sesion.put("mensaje", Mensaje.getModificado(Mensaje.modulo));
        } else {
            controladorModulo.guardar(nombre, caracteristica);
            sesion.put("mensaje", Mensaje.getAgregado(Mensaje.modulo));
        }
        return SUCCESS;
    }

    public String list() {
        lista = controladorModulo.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        String alerta = (String) sesion.get("alerta");
        addActionError(alerta);
        sesion.put("mensaje", "");
        sesion.put("alerta", "");
        return SUCCESS;
    }

    public String eliminar() {
        if (controladorModulo.enUso(id)) {
            sesion.put("alerta", Mensaje.getUsado(Mensaje.modulo, Mensaje.plan));
        } else {
            controladorModulo.eliminar(id);
            sesion.put("mensaje", Mensaje.getEliminado(Mensaje.modulo));
        }
        return SUCCESS;
    }

    public String editar() {
        Modulo modulo = controladorModulo.getUno(id);
        nombre = modulo.getNombre();
        caracteristica = modulo.getCaracteristica();
        id = modulo.getId();
        return SUCCESS;
    }

    public List<Modulo> getLista() {
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

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
}
