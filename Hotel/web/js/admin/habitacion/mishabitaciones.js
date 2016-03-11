(function ($) {
    setAgregarHabitacionOnClick();
    setAgregarTipoHabitacionOnClick();
    setHabitacionesOnClick();
    setTipoHabitacionesOnClick();
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
        })
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
                    alert('exito');
                } else {
                    mostrarErrores(data);
                    alert('error');
                }
                $modal.modal('hide');
            }
        })
    });
}

function setHabitacionesOnClick() {
    $('button.bloque-habitacion').click(function (e) {
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
        })

    });
}

function editar($modal, $bloque, nombre) {
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
                limpiarErrores('#form-editar');
            } else {
                mostrarErrores('#form-editar',data);
            }
        }
    })
}