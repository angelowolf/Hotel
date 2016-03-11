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
    public void guardar(String fechaInicio, String fechaFin, float precio, int id_temporada, List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ParseException, ObjetoNoEncontrado, AccesoIlegal {
        Tarifa t = new Tarifa();
        if (id_temporada == 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
            t.setFechaInicio(sdf.parse(fechaInicio));
            t.setFechaFin(sdf.parse(fechaFin));
        } else {
            IControladorTemporada ct = new ControladorTemporada();
            Temporada temp;
            try {
                temp = ct.getUno(id_temporada, id_hotel);
                t.setTemporada(temp);
                t.setFechaInicio((temp.getFechaInicio()));
                t.setFechaFin(temp.getFechaFin());
            } catch (AccesoIlegal ex) {
                Logger.getLogger(ControladorTarifa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        t.setPrecio(precio);
        t.setTipoHabitaciones(this.crearLista(tiposHabitacionesSeleccionados, id_hotel));
        TARIFADAO.guardar(t);
    }

    @Override
    public void actualizar(int id, String fechaInicio, String fechaFin, float precio, int id_temporada, List<Integer> tiposHabitacionesSeleccionados, int id_hotel) throws ParseException, ObjetoNoEncontrado, AccesoIlegal {
        boolean flag = true;
        Tarifa t = getUno(id);
        try {
            Set<TipoHabitacion> set = t.getTipoHabitaciones();
            for (TipoHabitacion tipoHabitacion : set) {
                flag = tipoHabitacion.getId_hotel() == id_hotel;
                break;
            }
        } catch (NullPointerException e) {
            throw new IllegalAccessError();
        }
        if (flag) {
            if (id_temporada == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
                t.setFechaInicio(sdf.parse(fechaInicio));
                t.setFechaFin(sdf.parse(fechaFin));
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
        } else {
            throw new IllegalAccessError();
        }
    }

    @Override
    public boolean eliminar(int id, int id_hotel) throws IllegalAccessError {
        boolean flag = true;
        Tarifa t = getUno(id);
        try {
            Set<TipoHabitacion> set = t.getTipoHabitaciones();
            for (TipoHabitacion tipoHabitacion : set) {
                flag = tipoHabitacion.getId_hotel() == id_hotel;
                break;
            }
        } catch (NullPointerException e) {
            throw new IllegalAccessError();
        }
        if (flag) {
            if (enUso(id)) {
                return false;
            } else {
                TARIFADAO.eliminar(t);
                return true;
            }
        } else {
            throw new IllegalAccessError();
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
    public Tarifa getUno(int id) {
        Tarifa t = TARIFADAO.buscar(id);
        try {
            t.getFechaFin();
            return t;
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }
}//end ControladorTarifa
