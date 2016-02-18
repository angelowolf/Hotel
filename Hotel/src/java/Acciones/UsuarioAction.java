package Acciones;

import Controlador.Implementacion.ControladorUsuario;
import Controlador.Interface.IControladorUsuario;
import Persistencia.Modelo.Usuario;
import Soporte.Mensaje;

/**
 *
 * @author flore
 */
public class UsuarioAction extends Accion {

    private String email, clave;
    private final IControladorUsuario controladorUsuario = new ControladorUsuario();

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
        if (controladorUsuario.iniciarSesion(email, clave)) {
            Usuario u = controladorUsuario.getUsuario(email);
            if (controladorUsuario.usuarioIsRoot(u)) {
                sesion.put("user", u);
                return "root";
            }

            if (controladorUsuario.verificarCuentaActiva(u)) {
                if (controladorUsuario.verificarCuentaAviso(u)) {
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

    public String logout() {
        sesion.remove("user");
        return SUCCESS;
    }
}
