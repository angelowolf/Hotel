package Controlador.Implementacion;

import Controlador.Interface.IControladorHabitacion;
import Controlador.Interface.IControladorTarifa;
import Controlador.Interface.IControladorTipoHabitacion;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Tarifa;
import Persistencia.Modelo.TipoHabitacion;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTarifa implements IControladorTarifa {

    @Override
    public void guardar(Date fechaInicio, Date fechaFin, int id_tipoHabitacion, HashMap<Integer, Float> precioPorCapacidad, int id_hotel) throws ObjetoNoEncontrado, AccesoIlegal {
        IControladorHabitacion ch = new ControladorHabitacion();
        IControladorTipoHabitacion cth = new ControladorTipoHabitacion();
        TipoHabitacion th = cth.getUno(id_tipoHabitacion, id_hotel);
        long cantidadDeDias = calcuarDiasEntre(fechaInicio, fechaFin);
        for (Map.Entry<Integer, Float> entrySet : precioPorCapacidad.entrySet()) {
            Integer capacidad = entrySet.getKey();
            Float precio = entrySet.getValue();
            Calendar c = Calendar.getInstance();
            c.setTime(fechaInicio);
            for (int i = 0; i <= cantidadDeDias; i++) {
                Tarifa tarifa = new Tarifa();
                tarifa.setTipoHabitacion(th);
                tarifa.setPrecio(precio);
                tarifa.setCapacidad(capacidad);
                Date fecha = c.getTime();
                Tarifa t = TARIFADAO.getUno(th, fecha, capacidad);
                if (t == null) {
                    tarifa.setFecha(fecha);
                    TARIFADAO.guardar(tarifa);
                } else {
                    t.setPrecio(precio);
                    TARIFADAO.actualizar(t);
                }
                c.add(Calendar.DATE, 1);
            }
        }
    }

    private long calcuarDiasEntre(Date fechaInicio, Date fechaFin) {
        long resta = fechaFin.getTime() - fechaInicio.getTime();
        return TimeUnit.DAYS.convert(resta, TimeUnit.MILLISECONDS);
    }
}//end ControladorTarifa
