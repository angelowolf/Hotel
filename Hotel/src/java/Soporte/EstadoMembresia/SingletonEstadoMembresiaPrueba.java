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
public class SingletonEstadoMembresiaPrueba {

    private static EstadoMembresia estado;
    private static SingletonEstadoMembresiaPrueba singleton;

    public static SingletonEstadoMembresiaPrueba getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoMembresiaPrueba();
        }
        return singleton;
    }

    private SingletonEstadoMembresiaPrueba() {
        EstadoMembresiaDAO estadoMembresiaDAO = new EstadoMembresiaDAO();
        estado = estadoMembresiaDAO.buscar("prueba");
    }

    public EstadoMembresia getEstadoMembresiaPrueba(){
        return estado;
    }
    
}
