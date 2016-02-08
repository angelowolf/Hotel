package Controlador;

import Persistencia.Modelo.Modulo;
import Persistencia.Modelo.Plan;
import Persistencia.ORM.DAOImplementacion.PlanDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorPlan {

    private final PlanDAO planDAO;

    public ControladorPlan() {
        planDAO = new PlanDAO();
    }

    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        List<Plan> lista = planDAO.buscar(nombre);
        for (Plan m : lista) {
            if (m.getNombre().equals(nombre)) {
                return m.getId() != id;
            }
        }
        return false;
    }

    public void actualizar(int id, String nombre, int precio, String caracteristica, List<Integer> modulos) {
        nombre = (WordUtils.capitalize(nombre));
        Plan t = planDAO.buscar(id);
        t.setNombre(nombre);
        t.setCaracteristica(caracteristica);
        t.setPrecio(precio);
        ControladorModulo cm = new ControladorModulo();
        List<Modulo> lista = new ArrayList<Modulo>();
        for (Integer id_s : modulos) {
            System.out.println(id_s);
            Modulo m = cm.getUno(id_s);
            lista.add(m);
        }
        t.setModulos(lista);
        planDAO.actualizar(t);
    }

    public void guardar(String nombre, int precio, String caracteristica, List<Integer> modulos) {
        nombre = (WordUtils.capitalize(nombre));
        Plan t = new Plan();
        t.setNombre(nombre);
        t.setCaracteristica(caracteristica);
        t.setPrecio(precio);
        ControladorModulo cm = new ControladorModulo();
        List<Modulo> lista = new ArrayList<Modulo>();
        for (Integer id : modulos) {
            Modulo m = cm.getUno(id);
            lista.add(m);
        }
        t.setModulos(lista);
        planDAO.guardar(t);
    }

    public List<Plan> getTodos() {
        return planDAO.getTodos();
    }

    public boolean enUso(int id) {
        return !planDAO.enUso(id).isEmpty();
    }

    public void eliminar(int id) {
        Plan t = new Plan();
        t.setId(id);
        planDAO.eliminar(t);
    }

    public Plan getUno(int id) {
        return planDAO.buscar(id);
    }

    public List<Integer> getModulosByID(Plan plan) {
        List<Integer> lista = new ArrayList();
        List<Modulo> listaModulos = plan.getModulos();
        for (Modulo modulo : listaModulos) {
            lista.add(modulo.getId());
        }
        return lista;
    }
}//end ControladorPlan
