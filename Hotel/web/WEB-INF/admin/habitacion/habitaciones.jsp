<%@taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <s:if test="%{lista != null}">
        <div class="col-md-12 panel">
            <ul class="nav nav-tabs">
                <s:iterator var="tipo" value="lista" status="stat">
                    <s:if test="#stat.index == 0">
                        <li class="active" data-id="<s:property value="#tipo.id" />"><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
                        </s:if>
                        <s:else>
                        <li><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
                        </s:else>
                    </s:iterator>
            </ul>
            <div id="contenidoTiposHabitaciones" class="tab-content">
                <s:iterator var="tipo" value="lista" status="stat">
                    <s:if test="#stat.index == 0">
                        <div class="tab-pane fade active in" id="tipo-<s:property value="#tipo.id" />">
                            <s:action name="contenido" var="accion">
                                <s:param name="id"><s:property value="#tipo.id" /></s:param>
                            </s:action>
                            <s:include value="/WEB-INF/admin/habitacion/vertipohabitacion.jsp">
                                <s:param name="tipo" value="#tipo"/>
                                <s:param name="habitaciones" value="#accion.habitaciones"/>
                            </s:include>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="tab-pane fade" id="tipo-<s:property value="#tipo.id" />">
                            <s:action name="contenido" var="accion">
                                <s:param name="id"><s:property value="#tipo.id" /></s:param>
                            </s:action>
                            <s:include value="/WEB-INF/admin/habitacion/vertipohabitacion.jsp">
                                <s:param name="tipo" value="#tipo"/>
                                <s:param name="habitaciones" value="#accion.habitaciones"/>
                            </s:include>
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
    </s:else>
</div>