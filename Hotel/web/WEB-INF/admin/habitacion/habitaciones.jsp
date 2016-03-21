<%@taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <s:if test="%{lista != null}">
        <div class="col-md-12 panel">
            <ul class="nav nav-tabs">
                <s:iterator var="tipo" value="lista" status="stat">
                    <s:if test="#stat.index == 0">
                        <li class="active th-<s:property value="#tipo.id" />" data-id="<s:property value="#tipo.id" />"><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
                        </s:if>
                        <s:else>
                        <li class="th-<s:property value="#tipo.id" />" data-id="<s:property value="#tipo.id" />"><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
                        </s:else>
                    </s:iterator>
                <li><a href="#nuevo-tipo" data-toggle="modal" data-target="#modal-agregar-th" ><i class="fa fa-plus"></i></a></li>
            </ul>
            <div id="contenidoTiposHabitaciones" class="tab-content">
                <s:iterator var="cadatipohabitacion" value="lista" status="stat">
                    <s:if test="#stat.index == 0">
                        <div class="tab-pane fade active in" id="tipo-<s:property value="#cadatipohabitacion.id" />">
                            <s:action name="vistatipohabitacion" executeResult="true">
                                <s:param name="id"><s:property value="#cadatipohabitacion.id" /></s:param>
                            </s:action>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="tab-pane fade" id="tipo-<s:property value="#cadatipohabitacion.id" />">
                            <s:action name="vistatipohabitacion" executeResult="true">
                                <s:param name="id"><s:property value="#cadatipohabitacion.id" /></s:param>
                            </s:action>
                        </div>
                    </s:else>
                </s:iterator>
            </div>
        </div>
    </s:if>
    <s:else>
        <div class="col-md-12 panel">
            <div id="agregarTH" class="sin-datos" data-toggle="modal" data-target="#modal-agregar-th">
                Crear un tipo de habitación
            </div>
        </div>
    </s:else>
    <div class="modal fade" id="modal-agregar-th" tabindex="-1" role="dialog" aria-labelledby="Agregar" aria-hidden="true">
        <div class="modal-dialog modal-dialog-center">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Agregar tipo de habitación</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form id="form-agregar-th">
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label for="nombre" class="label-control">Nombre</label>
                                    <input type="text" name="nombre" class="form-control" value="">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="agregarth">Guardar</button>
                </div>
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
                        <input type="hidden" name="tipoHabitacion.id" value="">
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
                        <input type="hidden" name="tipoHabitacion.id" value="">
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
                <button type="button" data-toggle="modal" data-target="#modal-eliminar-habitacion" class="btn btn-default pull-left" id="eliminar">Eliminar</button>
                <button type="button" class="btn btn-success" id="editar">Guardar</button>
            </div>
        </div>
    </div>
</div>
<s:action name="modaleliminar" namespace="/modal" executeResult="true">
    <s:param name="titulo"><%out.println(Soporte.Mensaje.HABITACION);%></s:param>
    <s:param name="mensaje"><%out.println(Soporte.Mensaje.getPreguntaEliminarLa(Soporte.Mensaje.HABITACION));%></s:param>
    <s:param name="modelo">habitacion</s:param>
</s:action>
<s:action name="modaleliminar" namespace="/modal" executeResult="true">
    <s:param name="titulo"><%out.println(Soporte.Mensaje.TIPOHABITACION);%></s:param>
    <s:param name="mensaje"><%out.println(Soporte.Mensaje.getPreguntaEliminarLa(Soporte.Mensaje.TIPOHABITACION));%></s:param>
    <s:param name="modelo">tipohabitacion</s:param>
</s:action>