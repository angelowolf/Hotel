$(document).ready(function () {
    $('select').multiselect({
        nonSelectedText: 'Seleccionar',
        nSelectedText: 'seleccionado',
        allSelectedText: 'Todos seleccionados',
        enableFiltering: true,
        selectAllText: ' Elegir todo',
        buttonClass: 'btn btn-primary',
        includeSelectAllOption: true
    });
});