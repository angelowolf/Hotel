(function ($) {
    setAgregarHabitacionOnClick();
    setAgregarTipoHabitacionOnClick();
    setHabitacionesOnClick();
})(jQuery);

function setAgregarTipoHabitacionOnClick() {
    $('#agregarth').click(function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar-th');
        var data = $modal.find('#form-agregar-th').serialize();

        $.ajax({
            url: '/tipohabitacion/registrar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (data) {
                if (data.codigo == 400) {

                    alert('exito');
                } else {
                    alert('error');
                }
                $modal.modal('hide');
            }
        });
    });
}

function setAgregarHabitacionOnClick() {
    $('#agregar').click(function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar');
        var idTipo = $('.nav-tabs .active').data('id');
        $modal.find('input[name="id_tipohabitacion"]').val(idTipo);
        var data = $modal.find('#form-agregar').serialize();

        $.ajax({
            url: '/habitacion/registrar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (data) {
                if (data.codigo == 400) {
                    var id = data.id;
                    $modal.modal('hide');
                    $.ajax({
                        url: '/habitacion/vistahabitacion',
                        data: {id: id},
                        type: 'POST',
                        success: function (data) {
                            var $div = $(data).hide();
                            $('.row.habitaciones').append($div);
                            $div.fadeIn();
                        }
                    });
                } else {
                    erroresM.mostrarErrores(data);
                    alert('error');
                }

            }
        })
    });
}

function setHabitacionesOnClick() {
    $('.bloque-habitacion button').click(function (e) {
        e.preventDefault();
        var id = this.value;
        var $bloque = $(this);
        var $modal = $('#modal-editar');
        $modal[0].reset;

        $.ajax({
            url: '/habitacion/editar',
            type: 'POST',
            dataType: 'JSON',
            data: {id: id},
            success: function (data) {
                if (data.codigo == 400) {
                    $modal.find('input[name="nombre"]').val(data.nombre);
                    $modal.find('input[name="id"]').val(id);
                    $modal.find('input[name="id_tipohabitacion"]').val(data.id_tipohabitacion);
                    $modal.find('input[name="capacidad"]').val(data.capacidad);
                    $('#editar').off('click').click(function (e) {
                        e.preventDefault();
                        editar($modal, $bloque);
                    });
                    $modal.modal('show');
                } else {

                }
            }
        });

    });

    $('#eliminarh').click(function (e) {
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
                    $modalEditar[0].reset;
                    $modalEditar.modal('hide');
                    $('.hab-'+id).fadeOut(function(){
                        $(this).remove;
                    });
                } else {
                    console.log(data);
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
            if (data.codigo == 400) {
                $bloque.html($modal.find('input[name="nombre"]').val());
                $modal.modal('hide');
                erroresM.limpiarErrores('#form-editar');
            } else {
                erroresM.mostrarErrores('#form-editar', data);
            }
        }
    })
}