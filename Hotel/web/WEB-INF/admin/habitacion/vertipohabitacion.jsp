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
                    <div class="row">
                        <div class="col-xs-12 pull-left">
                            <button class="btn btn-sm btn-success"><i class="fa fa-save"></i></button>
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
            <s:iterator var="habitacion" value="#accion.habitaciones">
                <s:include value="/WEB-INF/admin/habitacion/vertipohabitacion-habitacion.jsp">
                    <s:param name="habitacion" value="#habitacion"/>
                </s:include>
            </s:iterator>
        </div>
    </div>
</div>

<div class="modal fade" id="modal-editar" tabindex="-1" role="dialog" aria-labelledby="Editar" aria-hidden="true">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Editar habitación</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form id="form-editar">
                        <input type="hidden" name="id" value="">
                        <input type="hidden" name="id_tipohabitacion" value="">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="nombre" class="label-control">Nombre</label>
                                <input type="text" name="nombre" class="form-control" value="">
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="capacidad" class="label-control">Capacidad</label>
                                <input type="text" name="capacidad" class="form-control" value="">
                            </div>
                        </div>
                </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" data-toggle="modal" data-target="#modal-eliminar" class="btn btn-default pull-left" id="eliminar">Eliminar</button>
                <button type="button" class="btn btn-success" id="editar">Guardar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modal-agregar" tabindex="-1" role="dialog" aria-labelledby="Agregar" aria-hidden="true">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Agregar habitación</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form id="form-agregar">
                        <input type="hidden" name="id_tipohabitacion" value="">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="nombre" class="label-control">Nombre</label>
                                <input type="text" name="nombre" class="form-control" value="">
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="capacidad" class="label-control">Capacidad</label>
                                <input type="text" name="capacidad" class="form-control" value="">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="agregar">Guardar</button>
            </div>
        </div>
    </div>
</div>
                        
<div class="modal fade" id="modal-eliminar" tabindex="-1" role="dialog" aria-labelledby="Eliminar" aria-hidden="true">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Eliminar habitación</h4>
            </div>
            <div class="modal-body">
                <p>¿Está seguro de que desea eliminar la habitación?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" id="eliminarh">Confirmar</button>
            </div>
        </div>
    </div>
</div>