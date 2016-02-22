package Controlador.Implementacion;

import Controlador.Interface.IControladorTipoPago;
import Persistencia.Modelo.TipoPago;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoPago implements IControladorTipoPago {

    @Override
    public List<TipoPago> getTodos() {
        return TIPOPAGODAO.getTodos();
    }

    @Override
    public boolean enUso(int id) {
        return !(TIPOPAGODAO.pagoEnUso(id) == null);
    }

    @Override
    public void actualizar(int id, String nombre, float recargo) {
        nombre = (WordUtils.capitalize(nombre));
        TipoPago t = TIPOPAGODAO.buscar(id);
        t.setNombre(nombre);
        t.setPorcentajeRecargo(recargo);
        TIPOPAGODAO.actualizar(t);
    }

    @Override
    public void guardar(String nombre, float recargo) {
        nombre = (WordUtils.capitalize(nombre));
        TipoPago t = new TipoPago();
        t.setNombre(nombre);
        t.setPorcentajeRecargo(recargo);
        TIPOPAGODAO.guardar(t);
    }

    @Override
    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        TipoPago tipoPago = TIPOPAGODAO.buscar(nombre);
        if (tipoPago != null) {
            return tipoPago.getId() != id;
        }

        return false;
    }

    @Override
    public void eliminar(int id) {
        TipoPago t = new TipoPago();
        t.setId(id);
        TIPOPAGODAO.eliminar(t);
    }

    @Override
    public TipoPago getUno(int id) {
        TipoPago tp = TIPOPAGODAO.buscar(id);
        try {
            tp.getNombre();
            return tp;
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }
}//end ControladorTipoPago
