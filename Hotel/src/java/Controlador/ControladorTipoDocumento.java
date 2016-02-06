package Controlador;

import Persistencia.Modelo.TipoDocumento;
import Persistencia.ORM.DAOImplementacion.TipoDocumentoDAO;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorTipoDocumento {

    private final TipoDocumentoDAO tipoDocumentoDAO;

    public ControladorTipoDocumento() {
        tipoDocumentoDAO = new TipoDocumentoDAO();
    }

    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        List<TipoDocumento> lista = tipoDocumentoDAO.buscar(nombre);
        for (TipoDocumento m : lista) {
            if (m.getNombre().equals(nombre)) {
                return m.getId() != id;
            }
        }
        return false;
    }

    public void actualizar(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        TipoDocumento t = tipoDocumentoDAO.buscar(id);
        t.setNombre(nombre);
        tipoDocumentoDAO.actualizar(t);
    }

    public void guardar(String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        TipoDocumento t = new TipoDocumento();
        t.setNombre(nombre);
        tipoDocumentoDAO.guardar(t);
    }

    public boolean enUso(int id) {
        return !tipoDocumentoDAO.enUso(id).isEmpty();
    }

    public List<TipoDocumento> getTodos() {
        return tipoDocumentoDAO.getTodos();
    }

    public void eliminar(int id) {
        TipoDocumento t = new TipoDocumento();
        t.setId(id);
        tipoDocumentoDAO.eliminar(t);
    }

    public TipoDocumento getUno(int id) {
        return tipoDocumentoDAO.buscar(id);
    }
}//end ControladorTipoDocumento
