package Controlador.Implementacion;

import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.Hotel;
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
    public void guardar(String nombre, Hotel hotel) {
        TipoHabitacion th = new TipoHabitacion();
        th.setNombre(nombre);
        hotel.agregarTipoHabitacion(th);
        HOTELDAO.actualizar(hotel);
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
    public boolean existe(int id, String nombre, Hotel hotel) {
        try {
            nombre = (WordUtils.capitalize(nombre));
        } catch (Exception e) {
        }
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(nombre, hotel.getId());
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
    public List<TipoHabitacion> getTodos(Hotel hotel) {
        return TIPOHABITACIONDAO.getTodos(hotel.getId());
    }

    @Override
    public TipoHabitacion getUno(int id) {
        return TIPOHABITACIONDAO.buscar(id);
    }

}//end ControladorTipoHabitacion
