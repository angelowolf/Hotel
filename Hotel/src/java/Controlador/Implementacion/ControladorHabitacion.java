package Controlador.Implementacion;

import Controlador.Interface.IControladorHabitacion;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.TipoHabitacion;
import Persistencia.ORM.DAOImplementacion.BloqueoDAO;
import Persistencia.ORM.DAOImplementacion.DetalleMantenimientoDAO;
import Persistencia.ORM.DAOInterface.IBloqueo;
import Persistencia.ORM.DAOInterface.IDetalleMantenimiento;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorHabitacion implements IControladorHabitacion {

    @Override
    public int guardar(String nombre, int capacidad, int id_tipohabitacion) {
        Habitacion h = new Habitacion();
        h.setCapacidad(capacidad);
        nombre = (WordUtils.capitalize(nombre));
        h.setNombre(nombre);
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
        h.setTipoHabitacion(th);
       return HABITACIONDAO.guardar(h);
    }

    @Override
    public void actualizar(int id, String nombre, int capacidad, int id_tipohabitacion, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Habitacion h = getUno(id, id_hotel);
        nombre = (WordUtils.capitalize(nombre));
        h.setNombre(nombre);
        h.setCapacidad(capacidad);
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
        h.setTipoHabitacion(th);
        HABITACIONDAO.actualizar(h);
    }

    @Override
    public void actualizar(int id, int id_tipohabitacion, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Habitacion h = getUno(id, id_hotel);
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
        h.setTipoHabitacion(th);
        HABITACIONDAO.actualizar(h);
    }

    @Override
    public boolean eliminar(int id, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Habitacion h = getUno(id, id_hotel);
        if (enUso(id)) {
            return false;
        } else {
            IBloqueo bloqueoDAO = new BloqueoDAO();
            bloqueoDAO.eliminarTodos(id);
            IDetalleMantenimiento detalleMantenimientoDAO = new DetalleMantenimientoDAO();
            detalleMantenimientoDAO.eliminarTodos(id);
            HABITACIONDAO.eliminar(h);
            return true;
        }
    }

    @Override
    public boolean existe(int id, String nombre, int id_hotel) {
        nombre = (WordUtils.capitalize(nombre));
        Habitacion h = HABITACIONDAO.buscar(nombre, id_hotel);
        if (h != null) {
            return h.getId() != id;
        }
        return false;
    }

    @Override
    public boolean enUso(int id) {
        return !(HABITACIONDAO.enUso(id) == null);
    }

    @Override
    public List<Habitacion> getTodos(int id_hotel) {
        return HABITACIONDAO.getTodos(id_hotel);
    }

    @Override
    public Habitacion getUno(int id, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Habitacion h = HABITACIONDAO.buscar(id);
        try {
            if (h.getTipoHabitacion().getId_hotel() == id_hotel) {
                return h;
            } else {
                throw new AccesoIlegal();
            }
        } catch (org.hibernate.ObjectNotFoundException e) {
            throw new ObjetoNoEncontrado();
        }
    }

    @Override
    public List<Habitacion> getHabitacionesByTipoHabitacion(int id_tipoHabitacion, int id_hotel) throws IllegalAccessError, ObjetoNoEncontrado, AccesoIlegal {
        List<Habitacion> lista;
        IControladorTipoHabitacion controladorTipoHabitacion = new ControladorTipoHabitacion();
        TipoHabitacion th = controladorTipoHabitacion.getUno(id_tipoHabitacion, id_hotel);
        lista = HABITACIONDAO.getTodosByTipoHabitacion(id_tipoHabitacion);
        return lista;
    }

}//end ControladorHabitacion
