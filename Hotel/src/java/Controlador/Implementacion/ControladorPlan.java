package Controlador.Implementacion;

import Controlador.Interface.IControladorPlan;
import Persistencia.Modelo.Modulo;
import Persistencia.Modelo.Plan;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.WordUtils;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:22 p.m.
 */
public class ControladorPlan implements IControladorPlan {

    @Override
    public boolean existe(int id, String nombre) {
        nombre = (WordUtils.capitalize(nombre));
        Plan plan = PLANDAO.buscar(nombre);
        if (plan != null) {
            return plan.getId() != id;
        }
        return false;
    }

    @Override
    public void actualizar(int id, String nombre, int precio, String caracteristica, List<Integer> modulos) {
        nombre = (WordUtils.capitalize(nombre));
        Plan t = PLANDAO.buscar(id);
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
        PLANDAO.actualizar(t);
    }

    @Override
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
        PLANDAO.guardar(t);
    }

    @Override
    public List<Plan> getTodos() {
        return PLANDAO.getTodos();
    }

    @Override
    public boolean enUso(int id) {
        return !(PLANDAO.enUso(id) == null);
    }

    @Override
    public void eliminar(int id) {
        Plan t = new Plan();
        t.setId(id);
        PLANDAO.eliminar(t);
    }

    @Override
    public Plan getUno(int id) {
        try {
            return PLANDAO.buscar(id);
        } catch (org.hibernate.ObjectNotFoundException e) {
            return null;
        }
    }

    @Override
    public List<Integer> getModulosByID(Plan plan) {
        List<Integer> lista = new ArrayList();
        List<Modulo> listaModulos = plan.getModulos();
        for (Modulo modulo : listaModulos) {
            lista.add(modulo.getId());
        }
        return lista;
    }

    @Override
    public boolean isPlanExistente(int id_planSeleccionado) {
        Plan p = PLANDAO.buscar(id_planSeleccionado);
        try {
            p.getCaracteristica();
            return true;
        } catch (org.hibernate.ObjectNotFoundException e) {
            return false;
        }
    }
}//end ControladorPlan
