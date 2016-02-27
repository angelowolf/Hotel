package Controlador.Implementacion;

import Controlador.Interface.IControladorHabitacion;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.Habitacion;
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
    public void guardar(String nombre, int capacidad, int id_tipohabitacion) {
        Habitacion h = new Habitacion();
        h.setCapacidad(capacidad);
        nombre = (WordUtils.capitalize(nombre));
        h.setNombre(nombre);
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
        h.setTipoHabitacion(th);
        HABITACIONDAO.guardar(h);
    }

    @Override
    public void actualizar(int id, String nombre, int capacidad, int id_tipohabitacion, int id_hotel) {
        Habitacion h = getUno(id);
        if (h != null && h.getTipoHabitacion().getId_hotel() == id_hotel) {
            nombre = (WordUtils.capitalize(nombre));
            h.setNombre(nombre);
            h.setCapacidad(capacidad);
            TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
            h.setTipoHabitacion(th);
            HABITACIONDAO.actualizar(h);
        } else {
            throw new IllegalAccessError();
        }
    }

    @Override
    public boolean eliminar(int id, int id_hotel) {
        Habitacion h = getUno(id);
        if (h != null && h.getTipoHabitacion().getId_hotel() == id_hotel) {
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
        } else {
            throw new IllegalAccessError();
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
    public Habitacion getUno(int id) {
        Habitacion h = HABITACIONDAO.buscar(id);
        try {
            h.getNombre();
            return h;
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }

    @Override
    public List<Habitacion> getHabitacionesByTipoHabitacion(int id_tipoHabitacion, int id_hotel) throws IllegalAccessError {
        List<Habitacion> lista;
        IControladorTipoHabitacion controladorTipoHabitacion = new ControladorTipoHabitacion();
        TipoHabitacion th = controladorTipoHabitacion.getUno(id_tipoHabitacion);
        if (th != null && th.getId_hotel() == id_hotel) {
            lista = HABITACIONDAO.getTodosByTipoHabitacion(id_tipoHabitacion);
        } else {
            throw new IllegalAccessError();
        }
        return lista;
    }

}//end ControladorHabitacion
