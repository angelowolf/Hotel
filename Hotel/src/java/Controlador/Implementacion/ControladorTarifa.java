package Controlador.Implementacion;

import Controlador.Interface.IControladorTarifa;
import Controlador.Interface.IControladorTemporada;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Tarifa;
import Persistencia.Modelo.Temporada;
import Persistencia.Modelo.TipoHabitacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTarifa implements IControladorTarifa {

    /**
     * Crea una lista con los objetos tipo habitacion, verifica que estos
     * objetos que son recuperados desde la base de datos sean del hotel, en
     * caso contrario salta la exception
     *
     * @param tiposHabitacionesSeleccionados
     * @param id_hotel
     * @return
     * @throws IllegalAccessError
     */
    private Set<TipoHabitacion> crearLista(List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
        Set<TipoHabitacion> set = new HashSet<TipoHabitacion>();
        for (Integer cadaUno : tiposHabitacionesSeleccionados) {
            TipoHabitacion th = cth.getUno(cadaUno, id_hotel);
            set.add(th);
        }
        return set;
    }

    @Override
    public int guardar(Date fechaInicio, Date fechaFin, float precio, int id_temporada, List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Tarifa t = new Tarifa();
        if (id_temporada == 0) {
            t.setFechaInicio(fechaInicio);
            t.setFechaFin(fechaFin);
            t.setTemporada(null);
        } else {
            IControladorTemporada ct = new ControladorTemporada();
            Temporada temp;
            temp = ct.getUno(id_temporada, id_hotel);
            t.setTemporada(temp);
            t.setFechaInicio((temp.getFechaInicio()));
            t.setFechaFin(temp.getFechaFin());
        }
        t.setPrecio(precio);
        t.setTipoHabitaciones(this.crearLista(tiposHabitacionesSeleccionados, id_hotel));
        return TARIFADAO.guardar(t);
    }

    @Override
    public void actualizar(int id, Date fechaInicio, Date fechaFin, float precio, int id_temporada, List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Tarifa t = getUno(id, id_hotel);
        if (id_temporada == 0) {
            t.setFechaInicio(fechaInicio);
            t.setFechaFin(fechaFin);
            t.setTemporada(null);
        } else {
            IControladorTemporada ct = new ControladorTemporada();
            Temporada temp = ct.getUno(id_temporada, id_hotel);
            t.setTemporada(temp);
            t.setFechaInicio((temp.getFechaInicio()));
            t.setFechaFin(temp.getFechaFin());
        }
        t.setPrecio(precio);
        t.setTipoHabitaciones(this.crearLista(tiposHabitacionesSeleccionados, id_hotel));
        TARIFADAO.actualizar(t);
    }

    @Override
    public boolean eliminar(int id, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado {
        Tarifa t = getUno(id, id_hotel);
        if (enUso(id)) {
            return false;
        } else {
            TARIFADAO.eliminar(t);
            return true;
        }
    }

    @Override
    public boolean enUso(int id) {
        return !(TARIFADAO.enUso(id) == null);
    }

    @Override
    public List<Tarifa> getTodos(int id_hotel) {
        return TARIFADAO.getTodos(id_hotel);
    }

    @Override
    public Tarifa getUno(int id, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado {
        Tarifa t = TARIFADAO.buscar(id);
        try {
            if (t.getTipoHabitaciones().iterator().next().getId_hotel() == id_hotel) {
                return t;
            } else {
                throw new AccesoIlegal();
            }
        } catch (org.hibernate.ObjectNotFoundException e) {
            throw new ObjetoNoEncontrado();
        }
    }
}//end ControladorTarifa
