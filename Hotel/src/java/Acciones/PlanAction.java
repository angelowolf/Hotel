/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.ControladorModulo;
import Controlador.ControladorPlan;
import Persistencia.Modelo.Modulo;
import Persistencia.Modelo.Plan;
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
public class PlanAction extends ActionSupport {

    private List<Plan> lista = new ArrayList<Plan>();
    private final ControladorPlan controladorPlan = new ControladorPlan();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private String nombre, caracteristica;
    private int id, precio;
    private List<Modulo> modulos = new ArrayList<Modulo>();

    private boolean validar() {
        boolean flag = true;
        if (StringUtils.isBlank(nombre)) {
            addFieldError("nombre", Mensaje.ingreseNombre);
            flag = false;
        } else if (controladorPlan.existe(id, nombre)) {
            addFieldError("nombre", Mensaje.getElExiste(Mensaje.plan));
            flag = false;
        }
        if (StringUtils.isBlank(caracteristica)) {
            addFieldError("caracteristica", Mensaje.ingreseCaracteristica);
            flag = false;
        }
        if (precio < 0) {
            addFieldError("precio", Mensaje.precioNoValido);
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (id != 0) {
            controladorPlan.actualizar(id, nombre, precio, caracteristica);
            sesion.put("mensaje", Mensaje.getModificado(Mensaje.plan));
        } else {
            controladorPlan.guardar(nombre, precio, caracteristica);
            sesion.put("mensaje", Mensaje.getAgregado(Mensaje.plan));
        }
        return SUCCESS;
    }

    public String list() {
        lista = controladorPlan.getTodos();
        for (Plan plan : lista) {
            System.out.println(plan.toString());
        }
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        String alerta = (String) sesion.get("alerta");
        addActionError(alerta);
        sesion.put("mensaje", "");
        sesion.put("alerta", "");
        return SUCCESS;
    }

    public String eliminar() {
        if (controladorPlan.enUso(id)) {
            sesion.put("alerta", Mensaje.getUsadoPorUn(Mensaje.plan, Mensaje.hotel));
        } else {
            controladorPlan.eliminar(id);
            sesion.put("mensaje", Mensaje.getEliminado(Mensaje.plan));
        }
        return SUCCESS;
    }

    public String editar() {
        Plan plan = controladorPlan.getUno(id);
        nombre = plan.getNombre();
        caracteristica = plan.getCaracteristica();
        precio = plan.getPrecio();
        id = plan.getId();
        return SUCCESS;
    }
    
    public String nuevo() {
        ControladorModulo cm = new ControladorModulo();
        modulos = cm.getTodos();
        return SUCCESS;
    }

    public List<Plan> getLista() {
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }
}
