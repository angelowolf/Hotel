(function ($) {
    setAgregarTipoHabitacionOnClick();
    setEditarTipoHabitacionOnClick();
    setHabitacionesOnClick();

    $('body').on('click','#eliminar', function (e) {
        var $boton = $(this);
        eliminar($boton);
    });

})(jQuery);

function setEditarTipoHabitacionOnClick() {
    $('body').on('click', '.editar-th', function (e) {
        e.preventDefault();

        var data = $(this).parents('form').serialize();
        $.ajax({
            url: '/tipohabitacion/modificar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (datos) {
                if (datos.codigo === 400) {
                    $('li.th-'+datos.model.id+' a').html( datos.model.nombre);
                    erroresM.mostrarAlertError(datos.actionMessages, 'success');
                } else {
                    erroresM.mostrarErrores('.form-th-'+datos.model.id, datos);
                }
            }
        });
    });

    $('body').on('click','.eliminar-th', function (e) {
        e.preventDefault();

        var $modal = $('.modal.eliminar[data-modelo=tipohabitacion]');
        $modal.find('#id').val($(this).val());
        $modal.find('#model').val('tipohabitacion');

        $modal.modal('show');
    });
}

function setAgregarTipoHabitacionOnClick() {
    $('body').on('click', '#agregarth', function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar-th');
        var data = $modal.find('#form-agregar-th').serialize();
        erroresM.limpiarErrores('#form-agregar-th');
        $.ajax({
            url: '/tipohabitacion/registrar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (datos) {
                if (datos.codigo === 400) {
                    $.ajax({
                        url: '/tipohabitacion/vistatipohabitacion',
                        data: {id: datos.model.id},
                        type: 'POST',
                        success: function (dataa) {
                            $("<li class='th-"+datos.model.id+"' data-id='"+datos.model.id+"'><a class='capitalize' href='#tipo-" + datos.model.id + "' data-toggle='tab'>" + datos.model.nombre + "</a></li>").insertBefore('.nav.nav-tabs li:last');
                            $('#contenidoTiposHabitaciones').append('<div class="tab-pane fade" id="tipo-' + datos.model.id + '">' + dataa + '</div>');
                            $('li a[href=#tipo-' + datos.model.id + ']').click();
                        }
                    });
                    $modal.find('#form-agregar-th')[0].reset();
                    $modal.modal('hide');
                } else {
                    erroresM.mostrarErrores('#form-agregar-th', datos);
                }
            }
        });
    });
}

function setHabitacionesOnClick() {
    $('body').on('click', '#agregar', function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar');
        var idTipo = $('.nav-tabs .active').data('id');
        $modal.find('input[name="tipoHabitacion.id"]').val(idTipo);

        var data = $modal.find('#form-agregar').serialize();

        $.ajax({
            url: '/habitacion/registrar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (data) {
                if (data.codigo === 400) {
                    $modal.modal('hide');
                    $.ajax({
                        url: '/habitacion/vistahabitacion',
                        data: {id: data.model.id},
                        type: 'POST',
                        success: function (datos) {
                            var $div = $(datos).hide();
                            $('#tipo-' + idTipo + ' .row.habitaciones').append($div);
                            $div.fadeIn();
                            erroresM.limpiarErrores('#form-agregar');
                        }
                    });
                } else {
                    erroresM.mostrarErrores('#form-agregar', data);
                }
            }
        })
    });

    $('body').on('click', '.bloque-habitacion button', function (e) {
        e.preventDefault();
        var id = this.value;
        var $bloque = $(this);
        var $modal = $('#modal-editar');
        $modal.find('form')[0].reset();

        $.ajax({
            url: '/habitacion/editar',
            type: 'POST',
            dataType: 'JSON',
            data: {id: id},
            success: function (data) {
                if (data.codigo === 400) {
                    $('#modal-eliminar-habitacion #id').val(data.model.id);
                    $modal.find('input[name="nombre"]').val(data.model.nombre);
                    $modal.find('input[name="id"]').val(id);
                    $modal.find('input[name="tipoHabitacion.id"]').val(data.model.tipoHabitacion.id);
                    $modal.find('input[name="capacidad"]').val(data.model.capacidad);
                    $('#editar').off('click').click(function (e) {
                        e.preventDefault();
                        editar($modal, $bloque);
                    });
                    $modal.modal('show');
                } else {
                    erroresM.mostrarErrores('', data);
                }
            }
        });
    });

    $('body').on('click','#eliminar-habitacion', function (e) {
        e.preventDefault();
        var $modalEditar = $('#modal-editar');
        var id = $modalEditar.find('form [name=id]').val();
        var $modal = $('.modal.eliminar[data-modelo=habitacion]');
        $modal.find('#id').val(id);
        $modal.find('#model').val('habitacion');

        $modal.modal('show');
    });
}

function editar($modal, $bloque) {
    var data = $('#form-editar').serialize();

    $.ajax({
        url: '/habitacion/modificar',
        type: 'POST',
        dataType: 'JSON',
        data: data,
        success: function (data) {
            if (data.codigo === 400) {
                $bloque.html($modal.find('input[name="nombre"]').val());
                $modal.modal('hide');

                erroresM.limpiarErrores('#form-editar');
            } else {
                erroresM.mostrarErrores('#form-editar', data);
            }
        }
    });
}

function eliminar($boton) {
    var $dialog = $boton.parents('.modal.eliminar');
    
    var url = '';
    
    switch ($boton.val()) {
        case 'tipohabitacion': url = '/tipohabitacion/eliminar'; break;
        case 'habitacion': url = '/habitacion/eliminar'; break;
    }

    var id = $dialog.find('#id').val();
    
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'JSON',
        data: {id: id},
        success: function (data) {
            nolimpiar = false;
            if (data.codigo === 400) {
                $dialog.modal('hide');
                var $modalEditar = $('#modal-editar');
                
                switch ($boton.val()) {
                    case 'tipohabitacion': {
                        $('.nav-tabs li:first a').click();
                                
                        $('.th-' + id).fadeOut(function () {
                            $('.th-' + id).remove();
                        });
                        nolimpiar = true;
                    }; break;
                    case 'habitacion': {
                        $modalEditar.find('form')[0].reset();
                        $modalEditar.modal('hide');
                        $('.hab-' + id).fadeOut(function () {
                            $(this).remove;
                        });
                    }; break;
                }

                erroresM.mostrarAlertError(data.actionMessages, 'success');
                
            } else {
                erroresM.mostrarAlertError(data.actionErrors, 'danger', nolimpiar);
            }
        }
    });
}