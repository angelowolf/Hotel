<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="form-group">   
    <h2 class="page-header">Tipos de Pago</h2>
    <div class=" col-md-12">
        <display:table name="lista" pagesize="10" requestURI="${listar}" uid="row">
            <display:setProperty name="basic.msg.empty_list" >Aún no hay tipos de pagos registrados. Puede crear uno desde <a href="<s:url action='nuevo' namespace='/root/tipopago'/>">aquí</a>.</display:setProperty>
            <display:column property="id" title="Numero Tipo Pago"/>
            <display:column sortable="true" property="nombre" title="Nombre"/>
            <display:column sortable="true" property="porcentajeRecargo" title="Recargo"/>
            <display:column title="Funciones">
                <s:form action="editar" id="editURL" style="display:inline-block;">
                    <s:hidden name="id" value="%{#attr.row.id}"/>
                    <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-sm btn-info"/>
                </s:form>
                <s:submit value="Eliminar" data-id="%{#attr.row.id}" data-deleteURL="%{deleteURL}" data-toggle="modal" data-target="#modal-delete" cssClass="btn btn-sm btn-danger"/>
            </display:column>
        </display:table>

    </div>
</div>