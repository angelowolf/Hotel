/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Plan;
import Persistencia.ORM.DAOImplementacion.PlanDAO;
import Persistencia.ORM.DAOInterface.IPlan;
import java.util.List;

/**
 *
 * @author flore
 */
public interface IControladorPlan {

    final IPlan PLANDAO = new PlanDAO();

    /**
     * Verifica si el nombre del plan a crear está en uso.
     *
     * @param id
     * @param nombre
     * @return True si existe o false en caso contrario.
     */
    public boolean existe(int id, String nombre);

    /**
     * Actualiza un plan.
     *
     * @param id
     * @param nombre
     * @param precio
     * @param caracteristica
     * @param modulos
     */
    public void actualizar(int id, String nombre, int precio, String caracteristica, List<Integer> modulos);

    /**
     * Guarda un plan nuevo.
     *
     * @param nombre
     * @param precio
     * @param caracteristica
     * @param modulos
     */
    public void guardar(String nombre, int precio, String caracteristica, List<Integer> modulos);

    /**
     * Trae todos los planes de la base de datos.
     *
     * @return Lista de planes.
     */
    public List<Plan> getTodos();

    /**
     * Indica si un plan está siendo usado por algun hotel.
     *
     * @param id
     * @return True si es utilizado o false en caso contrario.
     */
    public boolean enUso(int id);

    /**
     * Elimina un plan de acuerdo al id.
     *
     * @param id
     */
    public void eliminar(int id);

    /**
     * Devuelve un plan de acuerdo al id.
     *
     * @param id
     * @return Plan
     */
    public Plan getUno(int id);

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param plan
     * @return el objeto o nulo.
     */
    public List<Integer> getModulosByID(Plan plan);

    /**
     * Verifica si el id pasado por parametro corresponde a un plan alamcenado
     * en la base de datos.
     *
     * @param id_planSeleccionado
     * @return True si el plan existe.
     */
    public boolean isPlanExistente(int id_planSeleccionado);
}
