<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row th-<s:property value="tipohabitacion.id"/>">
    <hr class="divisor">
    <div class="col-md-6 col-xs-12">
        <form class="form-horizontal form-th-<s:property value="tipohabitacion.id"/>">
            <div class="well">
                <fieldset>
                    <legend>Tipo de Habitación</legend>                   
                    <input type="hidden" name="id" value="<s:property value="tipohabitacion.id"/>"/>                
                    <div class="form-group">
                        <label for="nombre" class="col-xs-12 col-md-2 control-label">Nombre</label>
                        <div class="col-xs-12 col-md-10">              
                            <input type="text" class="form-control" name="nombre" value="<s:property value="tipohabitacion.nombre"/>"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 pull-left">
                            <button value="<s:property value="tipohabitacion.id"/>" class="btn btn-sm btn-success editar-th"><i class="fa fa-save"></i></button>
                            <button value="<s:property value="tipohabitacion.id"/>" class="btn btn-sm btn-danger eliminar-th"><i class="fa fa-close"></i></button>
                        </div>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
    <div class="col-md-2 hidden-xs">
        <div class="panel panel-primary">
            <div class="panel-heading">Acciones</div>
            <div class="panel-body">
                <button class="btn btn-sm btn-success btn-block">Guardar <i class="fa fa-save"></i></button>
            </div>
        </div>
    </div>
    <div class="col-xs-12 col-md-12">
        <div class="row">
            <div class="col-md-12">
                <h4>Habitaciones</h4>
                <button data-toggle="modal" data-target="#modal-agregar" class="btn btn-sm btn-success">Agregar habitación <i class="fa fa-plus"></i></button>
            </div>
        </div>

        <div class="row habitaciones">           
            <s:iterator var="habitacion" value="habitaciones">
                <s:include value="/WEB-INF/admin/habitacion/vertipohabitacion-habitacion.jsp">
                    <s:param name="habitacion" value="#habitacion"/>
                </s:include>
            </s:iterator>       
        </div>
    </div>
</div>