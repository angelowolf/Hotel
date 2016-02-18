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
public class SingletonEstadoMembresiaAviso {

    private static SingletonEstadoMembresiaAviso singleton;
    private static EstadoMembresia estado;

    private SingletonEstadoMembresiaAviso() {
        EstadoMembresiaDAO estadoMembresiaDAO = new EstadoMembresiaDAO();
        estado = estadoMembresiaDAO.buscar("aviso");
    }

    public EstadoMembresia getEstadoMembresiaAviso() {
        return estado;
    }

    public static SingletonEstadoMembresiaAviso getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoMembresiaAviso();
        }
        return singleton;
    }
}
