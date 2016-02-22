/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.ORM.DAOImplementacion.DueñoDAO;
import Persistencia.ORM.DAOInterface.IDueño;
import java.util.Date;

/**
 *
 * @author ang_2
 */
public interface IControladorDueño {

    final IDueño DUEÑODAO = new DueñoDAO();

    /**
     * Guarda una persona del tipo dueño.
     *
     * @param apellido
     * @param nombre
     * @param email
     * @param telefono
     * @param fechaNacimiento
     * @param clave
     * @param nick
     */
    public void guardar(String apellido, String nombre, String email, String telefono, Date fechaNacimiento,
            String clave, String nick);
}
