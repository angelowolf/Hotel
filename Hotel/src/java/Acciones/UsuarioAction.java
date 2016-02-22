package Acciones;

import Controlador.Implementacion.ControladorHotel;
import Controlador.Implementacion.ControladorUsuario;
import Controlador.Interface.IControladorHotel;
import Controlador.Interface.IControladorUsuario;
import Persistencia.Modelo.Hotel;
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
        Usuario u = controladorUsuario.getUsuario(email);
        if (controladorUsuario.iniciarSesion(u, clave)) {
            if (controladorUsuario.usuarioIsRoot(u)) {
                sesion.put("user", u);
                return "root";
            }
            IControladorHotel controladorHotel = new ControladorHotel();
            Hotel hotel = controladorHotel.getHotel(u);
            if (controladorHotel.verificarCuentaActiva(hotel)) {
                if (controladorHotel.verificarCuentaAviso(hotel)) {
                    addActionMessage(controladorHotel.getMensajeAviso(hotel));
                }
                sesion.put("hotel", hotel);
                sesion.put("user", u);
                return SUCCESS;
            } else {
                addActionError("Cuenta vencida");
                return INPUT;
            }
        } else {
            addActionError(Mensaje.USERCLAVEINCORRECTO);
            return INPUT;
        }
    }

    public String logout() {
        sesion.remove("user");
        return SUCCESS;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}
