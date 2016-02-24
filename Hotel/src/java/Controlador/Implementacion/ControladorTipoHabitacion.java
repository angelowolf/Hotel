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
    public void actualizar(int id, String nombre, int id_hotel) {
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        TipoHabitacion th = getUno(id);
        if (th != null && th.getId_hotel() == id_hotel) {
            th.setNombre(nombre);
            TIPOHABITACIONDAO.actualizar(th);
        } else {
            throw new IllegalAccessError();
        }
    }

    @Override
    public boolean eliminar(int id, int id_hotel) {
        TipoHabitacion th = getUno(id);
        if (th != null && th.getId_hotel() == id_hotel) {
            if (enUso(id)) {
                return false;
            } else {
                TIPOHABITACIONDAO.eliminar(th);
                return true;
            }
        } else {
            throw new IllegalAccessError();
        }
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
