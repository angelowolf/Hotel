var erroresM = (function () {
    var modulo = this;

    var defaultConfig = {
        ApplicationName: 'Gestion Hotelera'
    };

    modulo.getConfig = defaultConfig;

    modulo.setConfig = function (config) {
        defaultConfig.ApplicationName = config.ApplicationName;
    };

    modulo.validateAge = function (age) {
        return (parseInt(age) > 20);
    };
    
    modulo.mostrarErrores = function (formId, data) {
        modulo.limpiarErrores(formId);
    
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
    };
    
    modulo.limpiarErrores = function (formId) {
        $(formId + ' .error').remove();
        $(formId + ' .has-error').removeClass('has-error');
    };

    return modulo;
})();