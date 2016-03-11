/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Tarifa;
import Persistencia.ORM.DAOImplementacion.TarifaDAO;
import Persistencia.ORM.DAOInterface.ITarifa;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorTarifa {

    final ITarifa TARIFADAO = new TarifaDAO();

    /**
     * Crea una nueva tarifa. Si el id_temporada es igual a 0 se le asignara las
     * fechas pasadas por parametro, si es distinto de 0 se le asiganara las
     * fechas de la propia temporada.
     *
     * @param fechaInicio
     * @param fechaFin
     * @param precio
     * @param id_temporada
     * @param tiposHabitacionesSeleccionados
     * @param id_hotel
     * @throws java.text.ParseException Si la fecha no tiene el formato correcto
     * dd-mm-yy
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void guardar(String fechaInicio, String fechaFin, float precio, int id_temporada, List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ParseException, ObjetoNoEncontrado, AccesoIlegal;

    /**
     * Actualiza los datos de una tarifa. El id_hotel es utilizado para
     * cuestiones de validaciones, que solo puedan ser modificadas objetos
     * propios del hotel. Si el id_temporada es igual a 0 se le asignara las
     * fechas pasadas por parametro, si es distinto de 0 se le asiganara las
     * fechas de la propia temporada.
     *
     * @param id
     * @param fechaInicio
     * @param fechaFin
     * @param precio
     * @param id_temporada
     * @param tiposHabitacionesSeleccionados
     * @param id_hotel
     * @throws java.text.ParseException Si la fecha no tiene el formato correcto
     * dd-mm-yy
     * @throws Persistencia.Modelo.AccesoIlegal
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     */
    public void actualizar(int id, String fechaInicio, String fechaFin, float precio, int id_temporada,
            List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ParseException, AccesoIlegal, ObjetoNoEncontrado;

    /**
     * Elimina una tarifa. El id_hotel es utilizado para cuestiones de
     * validaciones, que solo puedan ser eliminados objetos propios del hotel.
     *
     * @param id
     * @param id_hotel
     * @return True si se elimino. Falso si esta siendo utilizado por otra
     * entidad.
     * @throws Persistencia.Modelo.AccesoIlegal
     */
    public boolean eliminar(int id, int id_hotel) throws AccesoIlegal;

    /**
     * verifica si la tarifa esta asociado a alguna entidad.
     *
     * @param id
     * @return true si lo esta.
     */
    public boolean enUso(int id);

    /**
     * trae todos las tarifas de un hotel.
     *
     * @param id_hotel
     * @return
     */
    public List<Tarifa> getTodos(int id_hotel);

    /**
     * recupera una tarifa de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public Tarifa getUno(int id);
}
