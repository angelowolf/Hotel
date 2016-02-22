package Controlador.Implementacion;

import Controlador.Interface.IControladorHabitacion;
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
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        h.setNombre(nombre);
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
        h.setTipoHabitacion(th);
        HABITACIONDAO.guardar(h);
    }

    @Override
    public void actualizar(int id, String nombre, int capacidad, int id_tipohabitacion) {
        Habitacion h = HABITACIONDAO.buscar(id);
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        h.setNombre(nombre);
        h.setCapacidad(capacidad);
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id_tipohabitacion);
        h.setTipoHabitacion(th);
        HABITACIONDAO.actualizar(h);
    }

    @Override
    public void eliminar(int id) {
        Habitacion h = new Habitacion();
        h.setId(id);
        IBloqueo bloqueoDAO = new BloqueoDAO();
        bloqueoDAO.eliminarTodos(id);
        IDetalleMantenimiento detalleMantenimientoDAO = new DetalleMantenimientoDAO();
        detalleMantenimientoDAO.eliminarTodos(id);
        HABITACIONDAO.eliminar(h);
    }

    @Override
    public boolean existe(int id, String nombre, int id_hotel) {
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
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

}//end ControladorHabitacion
