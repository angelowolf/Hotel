<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="form-group">   
    <h2 class="page-header">Planes</h2>
    <div class=" col-md-12">
        <display:table name="lista" pagesize="10" requestURI="${listar}" uid="row">
            <display:setProperty name="basic.msg.empty_list" >Aún no hay planes registrados. Puede crear uno desde <a href="<s:url action='nuevo' namespace='/root/modulo'/>">aquí</a>.</display:setProperty>
            <display:column property="id" title="Número Plan"/>
            <display:column sortable="true" property="nombre" title="Nombre"/>
            <display:column title="Módulos">
                <s:iterator var="cadaModulo" value="%{#attr.row.modulos}">
                    <s:property value="%{#cadaModulo.nombre}"/>
                </s:iterator>
            </display:column>
            <display:column sortable="true" property="precio" title="Precio"/>
            <display:column sortable="true" property="caracteristica" title="Característica"/>
            <display:column title="Funciones">
                <s:form action="editar" id="editURL" style="display:inline-block;">
                    <s:hidden name="id" value="%{#attr.row.id}"/>
                    <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-sm btn-info"/>
                </s:form>
                <s:form action="eliminar" id="deleteURL" style="display:inline-block;">
                    <s:hidden name="id" value="%{#attr.row.id}"/>
                    <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-sm btn-danger"/>
                </s:form>
            </display:column>
        </display:table>

    </div>
</div>