package Controlador.Implementacion;

import Controlador.Interface.IControladorDueño;
import Persistencia.Modelo.Dueño;
import Persistencia.Modelo.Usuario;
import java.util.Date;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorDueño implements IControladorDueño {

    @Override
    public void guardar(String apellido, String nombre, String email, String telefono, Date fechaNacimiento,
            String clave, String nick) {
        Usuario u = new Usuario();
        u.setClave(clave);
        u.setEmail(email);
        u.hacerOwner();
        Dueño d = new Dueño(u);
        d.setApellido(apellido);
        d.setNombre(nombre);
        d.setEmail(email);
        d.setTelefono(telefono);
        d.setFechaNacimiento(fechaNacimiento);
    }
}//end ControladorDueño
