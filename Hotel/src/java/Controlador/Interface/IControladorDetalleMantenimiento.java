/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.DetalleMantenimiento;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.ORM.DAOImplementacion.DetalleMantenimientoDAO;
import Persistencia.ORM.DAOInterface.IDetalleMantenimiento;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorDetalleMantenimiento {

    final IDetalleMantenimiento DETALLEMANTENIMIENTODAO = new DetalleMantenimientoDAO();

    /**
     * crea un detalle que no ha sido resuelto.
     *
     * @param descripcion
     * @param fecha
     * @param id_habitacion
     * @throws java.text.ParseException
     */
    public void guardar(String descripcion, String fecha, int id_habitacion)throws ParseException;

    /**
     * Actualiza los datos de un detalle. El id_hotel es utilizado para
     * cuestiones de validaciones, que solo puedan ser modificadas objetos
     * propios del hotel.
     *
     * @param id
     * @param descripcion
     * @param id_hotel
     * @param fecha
     * @param id_habitacion
     * @throws java.text.ParseException
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void actualizar(int id,String descripcion, String fecha, int id_habitacion, int id_hotel) throws AccesoIlegal,ParseException,ObjetoNoEncontrado;

    /**
     * Elimina un detalle. El id_hotel es utilizado para cuestiones de
     * validaciones, que solo puedan ser eliminados objetos propios del hotel.
     *
     * @param id
     * @param id_hotel
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void eliminar(int id, int id_hotel) throws AccesoIlegal,ObjetoNoEncontrado;

    /**
     * Busca todos los detalles existentes de una habitacion.
     *
     * @param id_habitacion
     * @param id_hotel
     * @return
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public List<DetalleMantenimiento> getTodos(int id_habitacion, int id_hotel) throws AccesoIlegal,ObjetoNoEncontrado;

    /**
     * recupera un detalle de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @param id_hotel
     * @return el objeto o nulo.
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public DetalleMantenimiento getUno(int id, int id_hotel)throws AccesoIlegal,ObjetoNoEncontrado;

}
