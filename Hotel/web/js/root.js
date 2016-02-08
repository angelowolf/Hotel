$(function() {
    $('input[data-target="#modal-delete"]').click(function(){
        var id = $(this).data('id');
        var deleteURL = $(this).data('deleteURL');
        if (id >= 0) {
            $('#modal-delete #deleteURL_id').val(id);
            $('#modal-delete input[type=submit]').attr('action', deleteURL);
            $('#modal-delete .modal-body').html('¿Está seguro de que desea eliminar?');
        } else {
            $('#modal-delete .modal-body').html(id);
        }
    });
});