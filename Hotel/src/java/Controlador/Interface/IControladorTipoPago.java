/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.TipoPago;
import Persistencia.ORM.DAOImplementacion.TipoPagoDAO;
import Persistencia.ORM.DAOInterface.ITipoPago;
import java.util.List;

/**
 *
 * @author flore
 */
public interface IControladorTipoPago {

    final ITipoPago TIPOPAGODAO = new TipoPagoDAO();

    /**
     * Busca todos los tipos de pagos existenes.
     *
     * @return
     */
    public List<TipoPago> getTodos();

    /**
     * verifica si el tipo de pago esta asociado a algun pago.
     *
     * @param id el tipo de pago a verificar
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * actualiza los datos.
     *
     * @param id
     * @param nombre
     * @param recargo
     */
    public void actualizar(int id, String nombre, float recargo);

    /**
     * guarda un nuevo tipo de pago.
     *
     * @param nombre
     * @param recargo
     */
    public void guardar(String nombre, float recargo);

    /**
     * verifica si el nombre esta disponible, en caso de que el nombre sea el
     * del propio tipo de pago devolvera true.
     *
     * @param id
     * @param nombre
     * @return true si esta disponible.
     */
    public boolean existe(int id, String nombre);

    /**
     * elimina el tipo de pago.
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
    public TipoPago getUno(int id);
}
