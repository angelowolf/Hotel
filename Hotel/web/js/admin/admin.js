(function ($) {
    $('.modal.fade').on('hidden.bs.modal', function (e) {
        var $form = $(this).find('form');
        if($form.length > 0) $form[0].reset();
    })
})(jQuery);


var erroresM = (function () {
    var modulo = this;

    var defaultConfig = {
        ApplicationName: 'Gestion Hotelera'
    };

    var alert = {
        SUCCESS: 'success',
        DANGER: 'danger',
        WARNING: 'warning',
        INFO: 'info'
    };

    modulo.getConfig = defaultConfig;

    modulo.setConfig = function (config) {
        defaultConfig.ApplicationName = config.ApplicationName;
    };

    modulo.mostrarErrores = function (formId, data, nolimpiar) {
        if (!nolimpiar) {
            modulo.limpiarErrores(formId);
        }

        if (data.actionErrors) {
            modulo.mostrarAlertError(data.actionErrors, alert.DANGER);
        }
        if (data.fieldErrors) {
            var errores = data.fieldErrors;
            for (var input in errores) {
                var error = errores[input];
                $(formId + ' [name=' + input + ']').after('<p class="error">' + error + '</p>').parents('.form-group').addClass('has-error');
            }
        }
        if (data.actionMessages) {
            var mensajes = data.actionMessages;
            for (var dato in mensajes) {
                var mensaje = mensajes[dato];
                $(formId).append('<p class="info">' + mensaje + '</p>');
            }
        }
    };

    modulo.limpiarErrores = function (formId) {
        $(formId + ' .error').remove();
        $(formId + ' .has-error').removeClass('has-error');
        $.notifyClose();
    };

    modulo.mostrarAlertError = function (actionErrors, tipo) {
        for (var input in actionErrors) {
            $.notify({
                message: actionErrors[input]
            }, {
                animate: {
                    enter: 'animated fadeInDown',
                    exit: 'animated fadeOutLeft'
                },
                delay: 0,
                offset: {
                    y: 0
                },
                placement: {
                    align: "center",
                    from: "bottom"
                },
                type: tipo
            });
        }
    }

    return modulo;
})();