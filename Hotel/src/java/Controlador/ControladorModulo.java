package Controlador;

import Persistencia.Modelo.Modulo;
import Persistencia.ORM.DAOImplementacion.ModuloDAO;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorModulo {

    private final ModuloDAO moduloDAO;

    public ControladorModulo() {
        moduloDAO = new ModuloDAO();
    }

    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        List<Modulo> lista = moduloDAO.buscar(nombre);
        for (Modulo m : lista) {
            if (m.getNombre().equals(nombre)) {
                return m.getId() != id;
            }
        }
        return false;
    }

    public void actualizar(int id, String nombre, String caracteristica) {
        nombre = (WordUtils.capitalize(nombre));
        Modulo t = moduloDAO.buscar(id);
        t.setNombre(nombre);
        t.setCaracteristica(caracteristica);
        moduloDAO.actualizar(t);
    }

    public void guardar(String nombre, String caracteristica) {
        nombre = (WordUtils.capitalize(nombre));
        Modulo t = new Modulo();
        t.setNombre(nombre);
        t.setCaracteristica(caracteristica);
        moduloDAO.guardar(t);
    }

    public List<Modulo> getTodos() {
        return moduloDAO.getTodos();
    }

    public boolean enUso(int id) {
        return !moduloDAO.enUso(id).isEmpty();
    }

    public void eliminar(int id) {
        Modulo t = new Modulo();
        t.setId(id);
        moduloDAO.eliminar(t);
    }

    /**
     * recupera un tipo de pago de la bd. si no existe devuelve nulo.
     *
     * @param id
     * @return el objeto o nulo.
     */
    public Modulo getUno(int id) {
        try {
            return moduloDAO.buscar(id);
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }

}//end ControladorModulo
