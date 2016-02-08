<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2 class="page-header">Sexo</h2>
<div class="well col-md-8 col-md-offset-2">
    <s:form action="guardarOModificar" theme="bootstrap" cssClass="form-horizontal" validate="true" enctype="multipart/form-data">
        <s:hidden name="id"/>
        <div class="col-md-8 col-md-offset-2 input">
            <s:textfield name="nombre" label="Nombre" placeholder="Ingrese el nombre" />
        </div>
        <div class="col-md-8 col-md-offset-2 input">
            <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        </div>
    </s:form>
</div>