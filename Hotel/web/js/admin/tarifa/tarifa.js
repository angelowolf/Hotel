(function ($) {
    $('body').on('click', 'form button', function (e) {
        e.preventDefault();
        var $boton = $(this);
        var $form = $boton.parents('form');
        var data = $form.serialize();
        console.log(data);
        $.ajax({
            url: '/tarifa/registrar',
            data: data,
            type: 'POST',
            dataType: 'JSON',
            success: function (response) {
                if (response.codigo === 400) {
                    erroresM.mostrarAlertError(response.actionMessages, 'success');
                } else {
                    erroresM.mostrarErrores('.form-th-' + $boton.val(), response);
                }
            }
        });
    })
    $('body').on('change', 'input[type=radio]', function () {
        var $radio = $(this);
        var $form = $radio.parents('form');
        if ($radio.prop('checked')) {
            switch ($radio.val()) {
                case 'especifico':
                    {
                        ocultar($form, 'select[name=id_temporada]', true);
                        ocultar($form, 'input[name=fechaInicio]', false);
                        ocultar($form, 'input[name=fechaFin]', false);
                    }
                    break;
                case 'temporada':
                    {
                        ocultar($form, 'select[name=id_temporada]', false);
                        ocultar($form, 'input[name=fechaInicio]', true);
                        ocultar($form, 'input[name=fechaFin]', true);
                    }
                    break;
            }
        }
    });
})(jQuery);


function ocultar(form, inputname, ocultar) {
    if (ocultar) {
        form.find(inputname).prop('disabled', ocultar).parents('.form-group').hide();
    } else {
        form.find(inputname).prop('disabled', ocultar).parents('.form-group').show();
    }
}