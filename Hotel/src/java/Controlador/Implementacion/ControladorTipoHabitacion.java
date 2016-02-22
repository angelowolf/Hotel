package Controlador.Implementacion;

import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.TipoHabitacion;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoHabitacion implements IControladorTipoHabitacion {

    @Override
    public void guardar(String nombre, int id_hotel) {
        TipoHabitacion th = new TipoHabitacion();
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        th.setNombre(nombre);
        th.setId_hotel(id_hotel);
        TIPOHABITACIONDAO.guardar(th);
    }

    @Override
    public void actualizar(int id, String nombre) {
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id);
        th.setNombre(nombre);
        TIPOHABITACIONDAO.actualizar(th);
    }

    @Override
    public void eliminar(int id) {
        TipoHabitacion th = new TipoHabitacion();
        th.setId(id);
        TIPOHABITACIONDAO.eliminar(th);
    }

    @Override
    public boolean existe(int id, String nombre, int id_hotel) {
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(nombre, id_hotel);
        if (th != null) {
            return th.getId() != id;
        }
        return false;
    }

    @Override
    public boolean enUso(int id) {
        return !(TIPOHABITACIONDAO.enUso(id) == null);
    }

    @Override
    public List<TipoHabitacion> getTodos(int id_hotel) {
        return TIPOHABITACIONDAO.getTodos(id_hotel);
    }

    @Override
    public TipoHabitacion getUno(int id) {
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id);
        try {
            th.getNombre();
            return th;
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }

}//end ControladorTipoHabitacion
