/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

import java.util.List;

/**
 *
 * @author ang_2
 */
public class RowBuilder {

    /**
     * Crea una String con codigo html de las filas de la tabla.
     *
     * @param parametros
     * @return
     */
    public static String rowBuilder(List parametros) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        for (Object parametro : parametros) {
            sb.append("<td>").append(parametro).append("</td>");
        }
        sb.append("/<tr>");
        return sb.toString();
    }
}
