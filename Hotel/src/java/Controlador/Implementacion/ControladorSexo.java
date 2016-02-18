package Controlador.Implementacion;

import Controlador.Interface.IControladorSexo;
import Persistencia.Modelo.Sexo;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorSexo implements IControladorSexo {

    @Override
    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Sexo sexo = SEXODAO.buscar(nombre);
        if (sexo != null) {
            return sexo.getId() != id;
        }
        return false;
    }

    @Override
    public void actualizar(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Sexo t = SEXODAO.buscar(id);
        t.setNombre(nombre);
        SEXODAO.actualizar(t);
    }

    @Override
    public void guardar(String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Sexo t = new Sexo();
        t.setNombre(nombre);
        SEXODAO.guardar(t);
    }

    @Override
    public boolean enUso(int id) {
        return !(SEXODAO.enUso(id) == null);
    }

    @Override
    public List<Sexo> getTodos() {
        return SEXODAO.getTodos();
    }

    @Override
    public void eliminar(int id) {
        Sexo t = new Sexo();
        t.setId(id);
        SEXODAO.eliminar(t);
    }

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public Sexo getUno(int id) {
        try {
            return SEXODAO.buscar(id);
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }
}//end ControladorSexo
