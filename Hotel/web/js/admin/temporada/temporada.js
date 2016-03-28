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

})(jQuery);
