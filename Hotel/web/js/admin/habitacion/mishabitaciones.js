(function ($) {
    setAgregarTipoHabitacionOnClick();
    setEditarTipoHabitacionOnClick();
    setHabitacionesOnClick();
})(jQuery);

function setEditarTipoHabitacionOnClick() {
    $('.editar-th').off('click').click(function (e) {
        e.preventDefault();
        var data = $(this).parents('form').serialize();
        $.ajax({
            url: '/tipohabitacion/editar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (datos) {
                if (datos.codigo === 400) {
                    alert('exito');
                } else {
                    erroresM.mostrarErrores();
                }
            }
        });
    });

    $('.eliminar-th').off('click').click(function (e) {
        e.preventDefault();

        var $modal = $('#modal-eliminar-tipohabitacion');

        $modal.find('#id').val($(this).val());
        $modal.modal('show');
    });

    $('#eliminar-tipohabitacion').click(function (e) {
        e.preventDefault();
        var $boton = $(this);
        var id = $boton.parents('.modal-content').find('#id').val();
        erroresM.limpiarErrores();
        $.ajax({
            url: '/tipohabitacion/eliminar',
            type: 'POST',
            dataType: 'JSON',
            data: {id: id},
            success: function (datos) {
                if (datos.codigo === 400) {
                    $('.th-' + id).fadeOut(function () {
                        $('.nav-tabs li:first a').click();
                        $(this).remove();
                    });
                } else {
                    erroresM.mostrarErrores('', datos, true);
                }
                $('#modal-eliminar-tipohabitacion').modal('hide');
            }, error: function (datos) {
                $('#modal-eliminar-tipohabitacion').modal('hide');
                erroresM.mostrarErrores('', datos);
            }
        });
    });
}

function setAgregarTipoHabitacionOnClick() {
    $('#agregarth').off('click').click(function (e) {
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
                            $("<li data-id='"+datos.model.id+"'><a class='capitalize' href='#tipo-" + datos.model.id + "' data-toggle='tab'>" + datos.model.nombre + "</a></li>").insertBefore('.nav.nav-tabs li:last');
                            $('#contenidoTiposHabitaciones').append('<div class="tab-pane fade" id="tipo-' + datos.model.id + '">' + dataa + '</div>');

                            setEditarTipoHabitacionOnClick();
                            setHabitacionesOnClick();
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
    $('#agregar').off('click').click(function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar');
        var idTipo = $('.nav-tabs .active').data('id');
        $modal.find('input[name="tipoHabitacion.id"]').val(idTipo);

        var data = $modal.find('#form-agregar').serialize();
        $modal.find('form')[0].reset();

        $.ajax({
            url: '/habitacion/registrar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (data) {
                if (data.codigo == 400) {
                    $modal.modal('hide');
                    $.ajax({
                        url: '/habitacion/vistahabitacion',
                        data: {id: data.model.id},
                        type: 'POST',
                        success: function (datos) {
                            var $div = $(datos).hide();
                            $('#tipo-' + idTipo + ' .row.habitaciones').append($div);
                            $div.fadeIn();
                        }
                    });
                } else {
                    erroresM.mostrarErrores('#form-agregar', data);
                }
            }
        })
    });

    $('.bloque-habitacion button').off('click').click(function (e) {
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
                if (data.codigo == 400) {
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

    $('#eliminarh').off('click').click(function (e) {
        e.preventDefault();
        var $modalEditar = $('#modal-editar');
        var id = $modalEditar.find('form [name=id]').val();
        var $modal = $('#modal-eliminar');

        $.ajax({
            url: '/habitacion/eliminar',
            type: 'POST',
            dataType: 'JSON',
            data: {id: id},
            success: function (data) {
                if (data.codigo == 400) {
                    $modal.modal('hide');
                    $modalEditar.find('form')[0].reset();
                    $modalEditar.modal('hide');
                    $('.hab-' + id).fadeOut(function () {
                        $(this).remove;
                    });
                } else {
                    erroresM.mostrarErrores('', data);
                }
            }
        })

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
    })
}