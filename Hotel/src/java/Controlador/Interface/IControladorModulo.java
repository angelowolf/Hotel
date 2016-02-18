/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Modulo;
import Persistencia.ORM.DAOImplementacion.ModuloDAO;
import Persistencia.ORM.DAOInterface.IModulo;
import java.util.List;

/**
 *
 * @author flore
 */
public interface IControladorModulo {

    final IModulo MODULODAO = new ModuloDAO();

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio modulo devolvera true.
     *
     * @param id
     * @param nombre
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre);

    /**
     * Actualiza los datos.
     *
     * @param id
     * @param nombre
     * @param caracteristica
     */
    public void actualizar(int id, String nombre, String caracteristica);

    /**
     * guarda un nuevo modulo.
     *
     * @param nombre
     * @param caracteristica
     */
    public void guardar(String nombre, String caracteristica);

    /**
     * Busca todos los modulos existenes.
     *
     * @return
     */
    public List<Modulo> getTodos();

    /**
     * Verifica si el modulo esta asociado a algun plan.
     *
     * @param id el modulo a verificar
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * elimina elmodulo.
     *
     * @param id
     */
    public void eliminar(int id);

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public Modulo getUno(int id);
}
