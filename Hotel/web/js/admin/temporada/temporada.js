(function ($) {
    $('body').on('click', '#agregartemporada', function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar-temporada');
        var data = $modal.find('#form-agregar-temporada').serialize();
        erroresM.limpiarErrores('#form-agregar-temporada');
        $.ajax({
            url: '/temporada/registrar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (response) {
                if (response.codigo === 400) {
                    $.ajax({
                        url: '/temporada/vistatemporada',
                        data: {id: response.model.id},
                        type: 'POST',
                        success: function (response2) {
                            $("<li class='temporada-" + response.model.id + "' data-id='" + response.model.id + "'><a class='capitalize' href='#temporada-" + response.model.id + "' data-toggle='tab'>" + response.model.nombre + "</a></li>").insertBefore('.nav.nav-tabs li:last');
                            $('#contenidoTemporada').append('<div class="tab-pane fade" id="temporada-' + response.model.id + '">' + response2 + '</div>');
                            $('li a[href=#temporada-' + response.model.id + ']').click();
                        }
                    });
                    $modal.find('#form-agregar-temporada')[0].reset();
                    $modal.modal('hide');
                    erroresM.mostrarAlertError(response.actionMessages, 'success');
                } else {
                    erroresM.mostrarErrores('#form-agregar-temporada', response);
                }
            }
        });
    });

    $('body').on('click', '.editar-temporada', function (e) {
        e.preventDefault();
        var data = $(this).parents('form').serialize();
        $.ajax({
            url: '/temporada/modificar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (response) {
                if (response.codigo === 400) {
                    $('li.temporada-' + response.model.id + ' a').html(response.model.nombre);
                    erroresM.limpiarErrores('.form-temporada-' + response.model.id);
                    erroresM.mostrarAlertError(response.actionMessages, 'success');
                } else {
                    erroresM.mostrarErrores('.form-temporada-' + response.model.id, response);
                }
            }
        });
    });

    $('body').on('click', '#eliminar', function (e) {
        var $boton = $(this);
        var $dialog = $boton.parents('.modal.eliminar');
        var id = $dialog.find('#id').val();
        $.ajax({
            url: '/temporada/eliminar',
            data: {id: id},
            type: 'POST',
            dataType: 'JSON',
            success: function (response) {
                if (response.codigo === 400) {
                    $dialog.modal('hide');
                    $('.nav-tabs li:first a').click();
                    $('.temporada-' + id).fadeOut(function () {
                        $('.temporada-' + id).remove();
                    });
                    erroresM.mostrarAlertError(response.actionMessages, 'success');

                } else {
                    erroresM.mostrarAlertError(response.actionErrors, 'danger', true);
                }
            }
        });
    });


    $('body').on('click', '.eliminar-temporada', function (e) {
        e.preventDefault();
        var $modal = $('.modal.eliminar[data-modelo=temporada]');
        $modal.find('#id').val($(this).val());
        $modal.find('#model').val('temporada');
        $modal.modal('show');
    });
})(jQuery);
