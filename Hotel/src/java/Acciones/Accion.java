/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author flore
 */
public abstract class Accion extends ActionSupport {

    protected final Map<String, Object> sesion = ActionContext.getContext().getSession();
    protected int codigo;

    public abstract int getCodigo();

}
