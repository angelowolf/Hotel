<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-eliminar-<s:property value="modelo"/>" tabindex="-1" role="dialog" aria-labelledby="Eliminar" aria-hidden="true">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Eliminar <s:property value="titulo"/></h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="id"/>
                <input type="hidden" id="model" value="<s:property value="modelo"/>"/>
                <p><s:property value="mensaje"/></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" id="eliminar-<s:property value="modelo"/>">Confirmar</button>
            </div>
        </div>
    </div>
</div>