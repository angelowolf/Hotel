(function($){
	//getHabitaciones();
})(jQuery);

function getHabitaciones() {
	$.ajax({
		url : '/tipohabitacion/listar',
		dataType: 'JSON',
		type: 'POST',
		success: function(data) {
			data.codigo == 400 ? initTabsHabitaciones(data) : showError(data);
		},
		error:function(error) {
			alert('Error al comunicarse con el servidor.');
		}
	});
}

function initTabsHabitaciones(data) {
	var stringNav = '<ul class="nav nav-tabs">';
	var stringContenido = '<div id="tiposHabitaciones" class="tab-content">';
	var flag = true;
	for (var i = 0; i < data.lista.length; i++) {
	 	stringNav += '<li'+( flag ? ' class="active"' : '' )+'"><a href="#tipo-'+data.lista[i].id+'" data-toggle="tab" aria-expanded="'+flag+'">'+data.lista[i].nombre+'</a></li>';
	 	stringContenido += '<div class="tab-pane fade'+( flag ? ' active in': '' )+'" id="#tipo-'+data.lista[i].id+'"></div>';
		flag = false;
	}
	stringNav += '</ul>';
	stringContenido += '</div>';

	getContenido(data.lista[0].id, function(contenido) {
		$('.container').append(stringNav+stringContenido);
		$(document.getElementById('#tipo-'+data.lista[0].id)).append(contenido);
	});

	setTabOnClickEvents();
}

function getContenido(id, callback) {
	$.ajax({
		url : '/tipohabitacion/contenido2',
		dataType: 'html',
		type: 'POST',
		data: {id:id},
		success: function(data) {
			console.log(data);
			$('.container').html(data);
			//data.codigo == 400 ? callback(data.contenido) : showError(data);
		},
		error:function(error) {
			alert('Error al comunicarse con el servidor.');
		}
	});
}

function showError(data) {

}