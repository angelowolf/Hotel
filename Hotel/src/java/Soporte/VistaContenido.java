/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

import Persistencia.Modelo.Habitacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang_2
 */
public class VistaContenido {

    public static String crearTabla(List<Habitacion> lista) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table><thead><th>Numero</th><th>Nombre</th><th>Id</th></thead><tbody>");
        for (Habitacion habitacion : lista) {
            List temporal = new ArrayList();
            temporal.add(habitacion.getCapacidad());
            temporal.add(habitacion.getNombre());
            sb.append(RowBuilder.rowBuilder(temporal));
        }
        sb.append("</tbody></table>");
        return sb.toString();
    }
}
