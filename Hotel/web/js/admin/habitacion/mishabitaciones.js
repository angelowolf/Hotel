(function($){
	getHabitaciones();
})(jQuery);

function getHabitaciones() {
	$.ajax({
		url : '/tipohabitacion/listar',
		dataType: 'JSON',
		type: 'POST',
		success: function(data) {
			data.codigo == 400 ? initTabsHabitaciones() : showError();
		},
		error:function(error) {
			alert('Error al comunicarse con el servidor.');
		}
	});
}

function initTabsHabitaciones() {

}

function showError() {
	
}