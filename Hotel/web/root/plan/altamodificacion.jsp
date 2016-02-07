<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2 class="page-header">Plan</h2>
<div class="well col-md-8 col-md-offset-2">
    <s:form action="guardarOModificar" theme="bootstrap" cssClass="form-horizontal" validate="true" enctype="multipart/form-data">
        <s:hidden name="id"/>
        <div class="col-md-8 col-md-offset-2 input">
            <s:textfield name="nombre" label="Nombre" placeholder="Ingrese el nombre" />
        </div>
        <div class="col-md-8 col-md-offset-2 input">
            <s:textfield name="precio" label="Precio" placeholder="Ingrese el precio" />
        </div>
        <div class="col-md-8 col-md-offset-2 input">
            <div class="form-group ">
                <label class="col-sm-3 control-label" for="modulos">Módulos</label>
                <div class="col-sm-9 controls">
                    <select name="modulos" multiple="multiple">
                        <s:iterator var="cadaModulo" value="modulos">
                            <option value="<s:property value="%{#cadaModulo.id}"/>"><s:property value="%{#cadaModulo.nombre}"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-md-8 col-md-offset-2 input">
            <s:textarea name="caracteristica" label="Caracteristica" placeholder="Ingrese la caracteristica" />
        </div>
        <div class="col-md-8 col-md-offset-2 input">
            <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        </div>
    </s:form>
</div>
<script src="/../bower_components/jquery/dist/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $('select').multiselect({
            nonSelectedText: 'Seleccionar',
            nSelectedText: 'seleccionado',
            allSelectedText: 'Todos seleccionados',
            enableFiltering: true,
            selectAllText: ' Elegir todo',
            buttonClass: 'btn btn-primary',
            includeSelectAllOption: true,
        });
    });
</script>
