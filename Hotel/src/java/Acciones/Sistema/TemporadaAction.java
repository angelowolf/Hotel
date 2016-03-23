/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones.Sistema;

import Acciones.Accion;
import Controlador.Implementacion.ControladorTemporada;
import Controlador.Interface.IControladorTemporada;
import Persistencia.Modelo.AccesoIlegal;
import Persistencia.Modelo.Hotel;
import Persistencia.Modelo.ObjetoNoEncontrado;
import Persistencia.Modelo.Temporada;
import static com.opensymphony.xwork2.Action.INPUT;
import com.opensymphony.xwork2.ModelDriven;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class TemporadaAction extends Accion implements ModelDriven<Temporada> {

    private final IControladorTemporada ct = new ControladorTemporada();

    private Temporada temporada = new Temporada();
    private List<Temporada> lista = new ArrayList<Temporada>();

    public TemporadaAction() {
        h = (Hotel) sesion.get("hotel");
    }

    private boolean validarRegistrar() {
        boolean flag = true;
        if (StringUtils.isBlank(temporada.getNombre())) {
            addActionError(Soporte.Mensaje.INGRESENOMBRETEMPORADA);
            flag = false;
        } else if (ct.existe(temporada.getId(), temporada.getNombre(), h.getId())) {
            addActionError(Soporte.Mensaje.getLaExiste(Soporte.Mensaje.TEMPORADA));
            flag = false;
        }
        if (temporada.getFechaInicio() == null) {
            addActionError(Soporte.Mensaje.INGRESEFECHAINICIO);
            flag = false;
        }
        if (temporada.getFechaFin() == null) {
            addActionError(Soporte.Mensaje.INGRESEFECHAFIN);
            flag = false;
        }
        return flag;
    }

    public String registrar() {
        if (validarRegistrar()) {
            try {
                temporada.setId(ct.guardar(temporada.getNombre(), temporada.getFechaInicio(), temporada.getFechaFin(), h.getId()));
                addActionMessage(Soporte.Mensaje.getAgregada(Soporte.Mensaje.TEMPORADA));
                codigo = 400;
                return SUCCESS;
            } catch (ParseException ex) {
                addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            }
        }
        return INPUT;
    }

    public String modificar() {
        if (validarRegistrar()) {
            try {
                ct.actualizar(temporada.getId(), temporada.getNombre(), temporada.getFechaInicio(), temporada.getFechaFin(), h.getId());
                addActionMessage(Soporte.Mensaje.getModificada(Soporte.Mensaje.TEMPORADA));
                codigo = 400;
                return SUCCESS;
            } catch (AccesoIlegal e) {
                addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
            } catch (ParseException e) {
                addActionError(Soporte.Mensaje.FORMATOFECHANOCORRECTO);
            } catch (ObjetoNoEncontrado ex) {
                addActionError(Soporte.Mensaje.IDINVALIDO);
            }
        }
        return INPUT;
    }

    public String listar() {
        lista = ct.getTodos(h.getId());
        codigo = 400;
        return SUCCESS;
    }

    public String eliminar() {
        try {
            if (ct.eliminar(temporada.getId(), h.getId())) {
                addActionMessage(Soporte.Mensaje.getEliminada(Soporte.Mensaje.TEMPORADA));
                codigo = 400;
                return SUCCESS;
            } else {
                addActionError(Soporte.Mensaje.getUsadaPorUna(Soporte.Mensaje.TEMPORADA, Soporte.Mensaje.TARIFA));
            }
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDHOTELINVALIDO);
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        }
        return INPUT;
    }

    public String editar() {
        try {
            temporada = ct.getUno(temporada.getId(), h.getId());
            codigo = 400;
            return SUCCESS;
        } catch (AccesoIlegal e) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        } catch (ObjetoNoEncontrado ex) {
            addActionError(Soporte.Mensaje.IDINVALIDO);
        }
        return INPUT;
    }

    public List<Temporada> getLista() {
        return lista;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Temporada getModel() {
        return temporada;
    }

}
