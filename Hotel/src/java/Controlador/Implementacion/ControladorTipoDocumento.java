package Controlador.Implementacion;

import Controlador.Interface.IControladorTipoDocumento;
import Persistencia.Modelo.TipoDocumento;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoDocumento implements IControladorTipoDocumento {

    @Override
    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        TipoDocumento tipoDocumento = TIPODOCUMENTODAO.buscar(nombre);
        if (tipoDocumento != null) {
            return tipoDocumento.getId() != id;
        }
        return false;
    }

    @Override
    public void actualizar(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        TipoDocumento t = TIPODOCUMENTODAO.buscar(id);
        t.setNombre(nombre);
        TIPODOCUMENTODAO.actualizar(t);
    }

    @Override
    public void guardar(String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        TipoDocumento t = new TipoDocumento();
        t.setNombre(nombre);
        TIPODOCUMENTODAO.guardar(t);
    }

    @Override
    public boolean enUso(int id) {
        return !(TIPODOCUMENTODAO.enUso(id) == null);
    }

    @Override
    public List<TipoDocumento> getTodos() {
        return TIPODOCUMENTODAO.getTodos();
    }

    @Override
    public void eliminar(int id) {
        TipoDocumento t = new TipoDocumento();
        t.setId(id);
        TIPODOCUMENTODAO.eliminar(t);
    }

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    @Override
    public TipoDocumento getUno(int id) {
        TipoDocumento td = TIPODOCUMENTODAO.buscar(id);
        try {
            td.getNombre();
            return td;
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }
}//end ControladorTipoDocumento
