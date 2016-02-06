package Controlador;

import Persistencia.Modelo.Sexo;
import Persistencia.ORM.DAOImplementacion.SexoDAO;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorSexo {

    private final SexoDAO sexoDAO;

    public ControladorSexo() {
        sexoDAO = new SexoDAO();
    }

    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        List<Sexo> lista = sexoDAO.buscar(nombre);
        for (Sexo m : lista) {
            if (m.getNombre().equals(nombre)) {
                return m.getId() != id;
            }
        }
        return false;
    }

    public void actualizar(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Sexo t = sexoDAO.buscar(id);
        t.setNombre(nombre);
        sexoDAO.actualizar(t);
    }

    public void guardar(String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Sexo t = new Sexo();
        t.setNombre(nombre);
        sexoDAO.guardar(t);
    }

    public boolean enUso(int id) {
        return !sexoDAO.enUso(id).isEmpty();
    }

    public List<Sexo> getTodos() {
        return sexoDAO.getTodos();
    }

    public void eliminar(int id) {
        Sexo t = new Sexo();
        t.setId(id);
        sexoDAO.eliminar(t);
    }

    public Sexo getUno(int id) {
        return sexoDAO.buscar(id);
    }
}//end ControladorSexo
