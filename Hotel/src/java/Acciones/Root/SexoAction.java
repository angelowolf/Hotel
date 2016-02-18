/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Root;

import Acciones.Accion;
import Controlador.Implementacion.ControladorSexo;
import Controlador.Interface.IControladorSexo;
import Persistencia.Modelo.Sexo;
import Soporte.Mensaje;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class SexoAction extends Accion {

    private List<Sexo> lista = new ArrayList<Sexo>();
    private final IControladorSexo controladorSexo = new ControladorSexo();
    private String nombre;
    private int id;

    private boolean validar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addFieldError("nombre", Mensaje.ingreseNombre);
            flag = false;
        } else if (controladorSexo.existe(id, nombre)) {
            addFieldError("nombre", Mensaje.getElExiste(Mensaje.sexo));
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (id != 0) {
            controladorSexo.actualizar(id, nombre);
            sesion.put("mensaje", Mensaje.getModificado(Mensaje.sexo));
        } else {
            controladorSexo.guardar(nombre);
            sesion.put("mensaje", Mensaje.getAgregado(Mensaje.sexo));
        }
        return SUCCESS;
    }

    public String list() {
        lista = controladorSexo.getTodos();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        String alerta = (String) sesion.get("alerta");
        addActionError(alerta);
        sesion.put("mensaje", "");
        sesion.put("alerta", "");
        return SUCCESS;
    }

    public String eliminar() {
        if (controladorSexo.enUso(id)) {
            sesion.put("alerta", Mensaje.getUsadoPorUna(Mensaje.sexo, Mensaje.persona));
        } else {
            controladorSexo.eliminar(id);
            sesion.put("mensaje", Mensaje.getEliminado(Mensaje.sexo));
        }
        return SUCCESS;
    }

    public String editar() {
        Sexo sexo = controladorSexo.getUno(id);
        if (sexo != null) {
            nombre = sexo.getNombre();
            id = sexo.getId();
            return SUCCESS;
        } else {
            sesion.put("alerta", Mensaje.idInvalido);
            return ERROR;
        }
    }

    public List<Sexo> getLista() {
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
