<%@taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <s:if test="%{lista != null}">
        <div class="col-md-12 panel">
            <ul class="nav nav-tabs">
                <s:iterator var="temporada" value="lista" status="stat">
                    <s:if test="#stat.index == 0">
                        <li class="active temporada-<s:property value="#temporada.id" />" data-id="<s:property value="#temporada.id" />"><a href="#temporada-<s:property value="#temporada.id" />" data-toggle="tab"><s:property value="#temporada.nombre" /></a></li>
                        </s:if>
                        <s:else>
                        <li class="th-<s:property value="#temporada.id" />" data-id="<s:property value="#temporada.id" />"><a href="#temporada-<s:property value="#temporada.id" />" data-toggle="tab"><s:property value="#temporada.nombre" /></a></li>
                        </s:else>
                    </s:iterator>                
                <li><a href="#nuevo-temporada" data-toggle="modal" data-target="#modal-agregar-temporada" ><i class="fa fa-plus"></i></a></li>
            </ul>
            <div id="contenidoTemporada" class="tab-content">
                <s:iterator var="temporada" value="lista" status="stat">
                    <s:if test="#stat.index == 0">
                        <div class="tab-pane fade active in" id="temporada-<s:property value="#temporada.id" />">
                            <s:action name="vistatemporada" executeResult="true">
                                <s:param name="id"><s:property value="#temporada.id" /></s:param>
                            </s:action>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="tab-pane fade" id="temporada-<s:property value="#temporada.id" />">
                            <s:action name="vistatemporada" executeResult="true">
                                <s:param name="id"><s:property value="#temporada.id" /></s:param>
                            </s:action>
                        </div>
                    </s:else>
                </s:iterator>
            </div>
        </div>
    </s:if>
    <s:else>
        sin temporadas
    </s:else>    
    <div class="modal fade" id="modal-agregar-temporada" tabindex="-1" role="dialog" aria-labelledby="Agregar" aria-hidden="true">
        <div class="modal-dialog modal-dialog-center">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Agregar Temporada</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <form id="form-agregar-temporada">
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label for="nombre" class="label-control">Nombre</label>
                                    <input type="text" name="nombre" class="form-control" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label for="fechaInicio" class="label-control">Fecha Inicio</label>
                                    <input type="text" name="fechaInicio" class="form-control" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label for="fechaFin" class="label-control">Fecha Fin</label>
                                    <input type="text" name="fechaFin" class="form-control" value="">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="agregartemporada">Guardar</button>
                </div>
            </div>
        </div>
    </div>
</div>