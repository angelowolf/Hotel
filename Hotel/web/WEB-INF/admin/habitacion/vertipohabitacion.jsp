<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
<hr class="divisor">
    <div class="col-md-6 col-xs-12">
        <form class="form-horizontal">
            <div class="well">
                <fieldset>
                    <legend>Tipo de Habitación</legend>
                    <div class="form-group">
                        <label for="nombre" class="col-xs-12 col-md-2 control-label">Nombre</label>
                        <div class="col-xs-12 col-md-10">
                            <input type="text" class="form-control" name="nombre" value="${tipo.nombre}"/>
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
        <div class="page-heading"><h4>Habitaciones</h4></div>
        <c:forEach var="habitacion" items="${accion.habitaciones}" >
            <div class="col-xs-3">
                <button class="btn btn-lg btn-default btn-block bloque-habitacion">
                    ${habitacion.nombre}
                </button>
            </div>
            <div style="display:none;">
                <fieldset>
                    <legend>Habitación ${habitacion.nombre}</legend>
                    <div class="form-group">
                        <label for="nombre" class="col-xs-12 col-md-2 control-label">Nombre</label>
                        <div class="col-xs-12 col-md-10">
                            <input type="text" class="form-control" name="nombre" value="${habitacion.nombre}"/>
                        </div>
                    </div>
                </fieldset>
            </div>
        </c:forEach>
    </div>
</div>