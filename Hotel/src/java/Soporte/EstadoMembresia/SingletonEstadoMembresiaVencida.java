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
public class SingletonEstadoMembresiaVencida {

    private static SingletonEstadoMembresiaVencida singleton;
    private static EstadoMembresia estado;

    private SingletonEstadoMembresiaVencida() {
        EstadoMembresiaDAO estadoMembresiaDAO = new EstadoMembresiaDAO();
        estado = estadoMembresiaDAO.buscar("vencida");
    }

    public EstadoMembresia getEstadoMembresiaVencida() {
        return estado;
    }

    public static SingletonEstadoMembresiaVencida getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoMembresiaVencida();
        }
        return singleton;
    }
}
