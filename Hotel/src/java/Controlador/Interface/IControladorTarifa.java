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
import java.util.Date;
import java.util.HashMap;
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
     * @param id_tipoHabitacion
     * @param precioPorCapacidad
     * @param id_hotel
     * @throws Persistencia.Modelo.ObjetoNoEncontrado
     * @throws Persistencia.Modelo.AccesoIlegal
     */
    public void guardar(Date fechaInicio, Date fechaFin, int id_tipoHabitacion, HashMap<Integer, Float> precioPorCapacidad, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal;

}
