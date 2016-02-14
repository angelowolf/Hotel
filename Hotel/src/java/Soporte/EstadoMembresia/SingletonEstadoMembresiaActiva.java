/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte.EstadoMembresia;

import Persistencia.ORM.DAOImplementacion.EstadoMembresiaDAO;

/**
 *
 * @author ang_2
 */
public class SingletonEstadoMembresiaActiva {

    private static SingletonEstadoMembresiaActiva singleton;
    private static EstadoMembresia estado;

    private SingletonEstadoMembresiaActiva() {
        EstadoMembresiaDAO estadoMembresiaDAO = new EstadoMembresiaDAO();
        estado = estadoMembresiaDAO.buscar("activa");
    }

    public EstadoMembresia getEstadoMembresiaActiva() {
        return estado;
    }

    public static SingletonEstadoMembresiaActiva getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoMembresiaActiva();
        }
        return singleton;
    }

}
