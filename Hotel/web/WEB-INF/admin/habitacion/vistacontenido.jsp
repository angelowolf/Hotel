<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<display:table name="habitaciones" class="table">
    <display:column property="id" title="Número"/>
    <display:column property="nombre" title="Nombre"/>
    <display:column property="capacidad" title="Capacidad"/>          
</display:table>

<input type="text" value="<s:property value="nombre"/>"/>

