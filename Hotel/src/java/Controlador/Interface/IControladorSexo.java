/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.Sexo;
import Persistencia.ORM.DAOImplementacion.SexoDAO;
import Persistencia.ORM.DAOInterface.ISexo;
import java.util.List;

/**
 *
 * @author flore
 */
public interface IControladorSexo {

    final ISexo SEXODAO = new SexoDAO();

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio dexo devolvera true.
     *
     * @param id
     * @param nombre
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre);

    /**
     * actualiza los datos del sexo.
     *
     * @param id
     * @param nombre
     */
    public void actualizar(int id, String nombre);

    /**
     * guarda un nuevo sexo.
     *
     * @param nombre
     */
    public void guardar(String nombre);

    /**
     * verifica si el sexo esta asociado a alguna persona.
     *
     * @param id el sexo a verificar
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * Busca todos los sexos existentes.
     *
     * @return
     */
    public List<Sexo> getTodos();

    /**
     * elimina el sexo.
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
    public Sexo getUno(int id);
}
