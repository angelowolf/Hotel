package Controlador.Implementacion;

import Controlador.Interface.IControladorModulo;
import Persistencia.Modelo.Modulo;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorModulo implements IControladorModulo {

    @Override
    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Modulo modulo = MODULODAO.buscar(nombre);
        if (modulo != null) {
            return modulo.getId() != id;
        }
        return false;
    }

    @Override
    public void actualizar(int id, String nombre, String caracteristica) {
        nombre = (WordUtils.capitalize(nombre));
        Modulo t = MODULODAO.buscar(id);
        t.setNombre(nombre);
        t.setCaracteristica(caracteristica);
        MODULODAO.actualizar(t);
    }

    @Override
    public void guardar(String nombre, String caracteristica) {
        nombre = (WordUtils.capitalize(nombre));
        Modulo t = new Modulo();
        t.setNombre(nombre);
        t.setCaracteristica(caracteristica);
        MODULODAO.guardar(t);
    }

    @Override
    public List<Modulo> getTodos() {
        return MODULODAO.getTodos();
    }

    @Override
    public boolean enUso(int id) {
        return !(MODULODAO.enUso(id) == null);
    }

    @Override
    public void eliminar(int id) {
        Modulo t = new Modulo();
        t.setId(id);
        MODULODAO.eliminar(t);
    }
    
    @Override
    public Modulo getUno(int id) {
        try {
            return MODULODAO.buscar(id);
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }

}//end ControladorModulo
