<%@taglib uri="/struts-tags" prefix="s"%>
<div class="row">
    <hr class="divisor">
    <div class="col-md-6 col-xs-12">
        <form class="form-horizontal form-th-<s:property value="id_tipoHabitacion"/>">
            <input type="hidden" name="id_tipoHabitacion" value="<s:property value="id_tipoHabitacion"/>"/>
            <div class="well">
                <fieldset>
                    <input type="radio" name="tipofecha" value="especifico" checked>Fechas
                    <input type="radio" name="tipofecha" value="temporada">Temporadas
                    <div class="form-group">
                        <label for="desde" class="col-xs-12 col-md-3 control-label">Desde:</label>
                        <div class="col-xs-12 col-md-9">              
                            <input type="text" class="form-control" placeholder="fecha inicio" name="fechaInicio" value=""/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="hasta" class="col-xs-12 col-md-3 control-label">Hasta:</label>
                        <div class="col-xs-12 col-md-9">              
                            <input type="text" class="form-control" placeholder="fecha fin" name="fechaFin" value=""/>
                        </div>
                    </div>
                    <div class="form-group" style="display: none;">
                        <label class="col-xs-12 col-md-3 control-label">Temporada:</label>
                        <div class="col-xs-12 col-md-9">
                            <s:select name="id_temporada" disabled="true" cssClass="form-control" list="temporadas" listValue="nombre" listKey="id"/>                            
                        </div>
                    </div>
                    <s:iterator var="capacidad" value="capacidadPorTipoHabitacion" status="stat">
                        <div class="form-group">
                            <label for="capacidad" class="col-xs-12 col-md-3 control-label">Capacidad: <s:property value="capacidad"/></label>
                            <div class="col-xs-12 col-md-9">              
                                <input type="text" class="form-control" placeholder="Ingrese el precio" name="capacidad<s:property value="capacidad"/>" value=""/>
                            </div>
                        </div>                        
                    </s:iterator>
                    <div class="row">
                        <div class="col-xs-12 pull-left">
                            <button value="<s:property value="id_tipoHabitacion"/>" class="btn btn-sm btn-success"><i class="fa fa-save"></i></button>
                        </div>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</div>