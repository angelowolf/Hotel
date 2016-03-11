package Controlador.Implementacion;

import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.ObjetoNoEncontrado;
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
        nombre = (WordUtils.capitalize(nombre));
        th.setNombre(nombre);
        th.setId_hotel(id_hotel);
        TIPOHABITACIONDAO.guardar(th);
    }

    @Override
    public void actualizar(int id, String nombre, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        nombre = (WordUtils.capitalize(nombre));
        TipoHabitacion th = getUno(id, id_hotel);
        th.setNombre(nombre);
        TIPOHABITACIONDAO.actualizar(th);
    }

    @Override
    public boolean eliminar(int id, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        TipoHabitacion th = getUno(id, id_hotel);
        if (enUso(id)) {
            return false;
        } else {
            TIPOHABITACIONDAO.eliminar(th);
            return true;
        }
    }

    @Override
    public boolean existe(int id, String nombre, int id_hotel) {
        nombre = (WordUtils.capitalize(nombre));
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
    public TipoHabitacion getUno(int id, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        TipoHabitacion th = TIPOHABITACIONDAO.buscar(id);
        try {
            if (th.getId_hotel() == id_hotel) {
                return th;
            } else {
                throw new AccesoIlegal();
            }
        } catch (org.hibernate.ObjectNotFoundException e) {
            throw new ObjetoNoEncontrado();
        }
    }

}//end ControladorTipoHabitacion
