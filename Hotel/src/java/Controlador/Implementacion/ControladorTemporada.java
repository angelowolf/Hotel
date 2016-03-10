package Controlador.Implementacion;

import Controlador.Interface.IControladorTemporada;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Temporada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTemporada implements IControladorTemporada {

    @Override
    public void guardar(String nombre, String fechaInicio, String fechaFin, int id_hotel) throws ParseException {
        Temporada t = new Temporada();
        nombre = (WordUtils.capitalize(nombre));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        t.setId_hotel(id_hotel);
        t.setNombre(nombre);
        t.setFechaInicio(sdf.parse(fechaInicio));
        t.setFechaFin(sdf.parse(fechaFin));
        TEMPORADADAO.guardar(t);
    }

    @Override
    public void actualizar(int id, String nombre, String fechaInicio, String fechaFin, int id_hotel) throws ParseException, ObjetoNoEncontrado, AccesoIlegal {
        Temporada t = getUno(id, id_hotel);
        nombre = (WordUtils.capitalize(nombre));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        t.setNombre(nombre);
        t.setFechaInicio(sdf.parse(fechaInicio));
        t.setFechaFin(sdf.parse(fechaFin));
        TEMPORADADAO.actualizar(t);
    }

    @Override
    public boolean eliminar(int id, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Temporada t = getUno(id, id_hotel);
        if (enUso(id)) {
            return false;
        } else {
            TEMPORADADAO.eliminar(t);
            return true;
        }
    }

    @Override
    public boolean existe(int id, String nombre, int id_hotel) {
        nombre = (WordUtils.capitalize(nombre));
        Temporada h = TEMPORADADAO.buscar(nombre, id_hotel);
        if (h != null) {
            return h.getId() != id;
        }
        return false;
    }

    @Override
    public boolean enUso(int id) {
        return !(TEMPORADADAO.enUso(id) == null);
    }

    @Override
    public List<Temporada> getTodos(int id_hotel) {
        return TEMPORADADAO.getTodos(id_hotel);
    }

    @Override
    public Temporada getUno(int id, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        Temporada t = TEMPORADADAO.buscar(id);
        try {
            if (t.getId_hotel() == id_hotel) {
                return t;
            } else {
                throw new AccesoIlegal();
            }
        } catch (org.hibernate.ObjectNotFoundException e) {
            throw new ObjetoNoEncontrado();
        }
    }
}//end ControladorTemporada
