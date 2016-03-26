<%@taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <s:if test="%{listaTipoHabitacion != null}">
        <div class="col-md-12 panel">
            <ul class="nav nav-tabs">
                <s:iterator var="tipo" value="listaTipoHabitacion" status="stat">
                    <s:if test="#stat.index == 0">
                        <li class="active th-<s:property value="#tipo.id" />" data-id="<s:property value="#tipo.id" />"><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
                        </s:if>
                        <s:else>
                        <li class="th-<s:property value="#tipo.id" />" data-id="<s:property value="#tipo.id" />"><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
                        </s:else>
                    </s:iterator>                
            </ul>
            <div id="contenidoTiposHabitaciones" class="tab-content">
                <s:iterator var="cadatipohabitacion" value="listaTipoHabitacion" status="stat">
                    <s:if test="#stat.index == 0">
                        <div class="tab-pane fade active in" id="tipo-<s:property value="#cadatipohabitacion.id" />">
                            <s:action name="capacidadPorTipoHabitacion" executeResult="true">
                                <s:param name="id_tipoHabitacion"><s:property value="#cadatipohabitacion.id" /></s:param>
                            </s:action>
                        </div>
                    </s:if>
                    <s:else>
                        <div class="tab-pane fade" id="tipo-<s:property value="#cadatipohabitacion.id" />">
                            <s:action name="capacidadPorTipoHabitacion" executeResult="true">
                                <s:param name="id_tipoHabitacion"><s:property value="#cadatipohabitacion.id" /></s:param>
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
</div>