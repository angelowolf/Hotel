package Acciones;

import Controlador.ControladorUsuario;
import Persistencia.Modelo.Usuario;
import Soporte.Mensaje;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author flore
 */
public class UsuarioAction extends ActionSupport {
    
    private String email, clave;
    private final ControladorUsuario controladorUsuario = new ControladorUsuario();
    private final Map<String,Object> sesion = ActionContext.getContext().getSession();
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String login() {
        if(controladorUsuario.iniciarSesion(email, clave)) {
            Usuario u = controladorUsuario.getUsuario(email);
            if(controladorUsuario.usuarioIsRoot(u)) {
                sesion.put("user", u);
                return "root";
            }
            
            if(controladorUsuario.verificarCuentaActiva(u)) {
                if(controladorUsuario.verificarCuentaAviso(u)) {
                    addActionMessage(controladorUsuario.getMensajeAviso(u));
                }
                sesion.put("user", u);
                return SUCCESS;
            } else {
                addActionError("Cuenta vencida");
                return INPUT;
            }
        } else {
            addActionError(Mensaje.userClaveIncorrecto);
            return INPUT;
        }
    }
}