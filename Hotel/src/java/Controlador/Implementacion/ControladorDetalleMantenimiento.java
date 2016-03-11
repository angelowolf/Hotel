package Controlador.Implementacion;

import Controlador.Interface.IControladorDetalleMantenimiento;
import Controlador.Interface.IControladorHabitacion;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.DetalleMantenimiento;
import Persistencia.Modelo.Habitacion;
import Persistencia.Modelo.ObjetoNoEncontrado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:21 p.m.
 */
public class ControladorDetalleMantenimiento implements IControladorDetalleMantenimiento {

    @Override
    public void guardar(String descripcion, String fecha, int id_habitacion) throws ParseException {
        DetalleMantenimiento dm = new DetalleMantenimiento();
        dm.setDescripcion(descripcion);
        dm.setId_habitacion(id_habitacion);
        dm.setResuelto(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        dm.setFecha(sdf.parse(fecha));
        DETALLEMANTENIMIENTODAO.guardar(dm);
    }

    @Override
    public void actualizar(int id, String descripcion, String fecha, int id_habitacion, int id_hotel) throws AccesoIlegal, ParseException, ObjetoNoEncontrado {
        DetalleMantenimiento dm = getUno(id, id_hotel);
        dm.setDescripcion(descripcion);
        dm.setId_habitacion(id_habitacion);
        dm.setResuelto(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        dm.setFecha(sdf.parse(fecha));
        DETALLEMANTENIMIENTODAO.actualizar(dm);
    }

    @Override
    public void eliminar(int id, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado {
        DetalleMantenimiento dm = getUno(id, id_hotel);
        DETALLEMANTENIMIENTODAO.eliminar(dm);
    }

    @Override
    public List<DetalleMantenimiento> getTodos(int id_habitacion, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado {
        IControladorHabitacion ch = new ControladorHabitacion();
        Habitacion h = ch.getUno(id_habitacion, id_hotel);
        return DETALLEMANTENIMIENTODAO.getTodos(id_habitacion);
    }

    @Override
    public DetalleMantenimiento getUno(int id, int id_hotel) throws AccesoIlegal, ObjetoNoEncontrado {
        DetalleMantenimiento dm = DETALLEMANTENIMIENTODAO.buscar(id);
        try {
            IControladorHabitacion ch = new ControladorHabitacion();
            Habitacion h = ch.getUno(dm.getId_habitacion(), id_hotel);
            return dm;
        } catch (org.hibernate.ObjectNotFoundException e) {
            throw new ObjetoNoEncontrado();
        }
    }

}//end ControladorDetalleMantenimiento
