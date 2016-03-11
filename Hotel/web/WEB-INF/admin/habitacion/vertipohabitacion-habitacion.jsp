<%@taglib uri="/struts-tags" prefix="s"%>
<div class="col-xs-4 col-md-2 hab-<s:property value='id'/>">
    <div class="bloque-habitacion" data-toggle="modal" data-target="#modal-editar">
        <button value="<s:property value='id'/>" class="btn btn-lg btn-default btn-block">
            <s:property value="nombre"/>
        </button>
    </div>
</div>