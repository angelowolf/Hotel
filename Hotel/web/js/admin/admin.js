function mostrarErrores(formId, data) {
    limpiarErrores(formId);
    
    if (data.actionErrors) {
        var errores = data.actionErrors;
        for (var input in errores) {
            var error = errores[input];
            $(formId).append('<p class="error">'+error+'</p>');
        }
    }
    if (data.fieldErrors) {
        var errores = data.fieldErrors;
        for (var input in errores) {
            var error = errores[input];
            $(formId+' [name='+input+']').after('<p class="error">'+error+'</p>').parents('.form-group').addClass('has-error');
        }
    }
}

function limpiarErrores(formId) {
    $(formId + ' .error').remove();
    $(formId + ' .has-error').removeClass('has-error');
}