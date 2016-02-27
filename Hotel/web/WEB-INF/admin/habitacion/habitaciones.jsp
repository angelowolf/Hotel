<%@taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <div class="col-md-12 panel">
        <ul class="nav nav-tabs">
            <s:iterator var="tipo" value="lista" status="stat">
                <s:if test="#stat.index == 0">
                    <li class="active"><a href="#tipo-<s:property value="#tipo.id" />" data-toggle="tab"><s:property value="#tipo.nombre" /></a></li>
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
                        <s:action name="contenido2" var="accion">
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
                        <s:action name="contenido2" var="accion">
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
</div>