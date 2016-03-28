<%@taglib uri="/struts-tags" prefix="s"%>
<div class="row temporada-<s:property value="temporada.id"/>">
    <hr class="divisor">
    <div class="col-md-6 col-xs-12">
        <form class="form-horizontal form-temporada-<s:property value="temporada.id"/>">
            <div class="well">
                <fieldset>
                    <legend>Temporada</legend>                   
                    <input type="hidden" name="id" value="<s:property value="temporada.id"/>"/>                
                    <div class="form-group">
                        <label for="nombre" class="col-xs-12 col-md-2 control-label">Nombre</label>
                        <div class="col-xs-12 col-md-10">              
                            <input type="text" class="form-control" name="nombre" value="<s:property value="temporada.nombre"/>"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fechaInicio" class="col-xs-12 col-md-2 control-label">Inicio</label>
                        <div class="col-xs-12 col-md-10">
                            <input type="text" name="fechaInicio" class="form-control" value="<s:property value="temporada.fechaInicio"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fechaFin" class="col-xs-12 col-md-2 control-label">Fin</label>
                        <div class="col-xs-12 col-md-10">
                            <input type="text" name="fechaFin" class="form-control" value="<s:property value="temporada.fechaFin"/>">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 pull-left">
                            <button value="<s:property value="temporada.id"/>" class="btn btn-sm btn-success editar-temporada"><i class="fa fa-save"></i></button>
                            <button value="<s:property value="temporada.id"/>" class="btn btn-sm btn-danger eliminar-temporada"><i class="fa fa-close"></i></button>
                        </div>
                    </div>
                </fieldset>
            </div>

        </form>
    </div>
</div>