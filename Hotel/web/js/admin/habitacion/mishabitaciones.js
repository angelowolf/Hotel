(function ($) {
    setAgregarHabitacionOnClick();
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
        var $boton = $(this);
        var data = $boton.parents('form').serialize();
        var id = $boton.parents('form').find('[name=id]').val();
        $.ajax({
            url: '/tipohabitacion/eliminar',
            type: 'POST',
            dataType: 'JSON',
            data: data,
            success: function (datos) {
                console.log(datos);
                if (datos.codigo === 400) {
                    $('.th-'+id).fadeOut(function(){
                        $('.nav-tabs li:first a').click();
                        $(this).remove();
                    });
                } else {
                    erroresM.mostrarErrores($boton.parents('form'), datos, true);
                }
            }, error: function (datos) {
                console.log(datos);
            }
        });
    });
}

function setAgregarTipoHabitacionOnClick() {
    $('#agregarth').off('click').click(function (e) {
        e.preventDefault();
        var $modal = $('#modal-agregar-th');
        var data = $modal.find('#form-agregar-th').serialize();
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
                            $("<li><a class='capitalize' href='#tipo-"+datos.model.id+"' data-toggle='tab'>"+datos.model.nombre+"</a></li>").insertBefore('.nav.nav-tabs li:last');
                            $('#contenidoTiposHabitaciones').append('<div class="tab-pane fade" id="tipo-'+datos.model.id+'">'+dataa+'</div>');
                            
                            setAgregarHabitacionOnClick();
                            setEditarTipoHabitacionOnClick();
                            setHabitacionesOnClick();
                            
                            $('li a[href=#tipo-'+datos.model.id+']').click();
                        }
                    });
                } else {
                    alert('error');
                }
                $modal.find('#form-agregar-th')[0].reset();
                $modal.modal('hide');
            }
        });
    });
}

function setAgregarHabitacionOnClick() {
    $('#agregar').off('click').click(function (e) {
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
    $('.bloque-habitacion button').off('click').click(function (e) {
        e.preventDefault();
        var id = this.value;
        var $bloque = $(this);
        var $modal = $('#modal-editar');
        $modal[0].reset();

        $.ajax({
            url: '/habitacion/editar',
            type: 'POST',
            dataType: 'JSON',
            data: {id: id},
            success: function (data) {
                if (data.codigo == 400) {
                    $modal.find('input[name="nombre"]').val(data.model.nombre);
                    $modal.find('input[name="id"]').val(id);
                    $modal.find('input[name="tipoHabitacion.id"]').val(data.model.id_tipohabitacion);
                    $modal.find('input[name="capacidad"]').val(data.model.capacidad);
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
                    $modalEditar[0].reset();
                    $modalEditar.modal('hide');
                    $('.hab-' + id).fadeOut(function () {
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