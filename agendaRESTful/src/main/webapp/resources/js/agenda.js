$(document).ready(function(){
    
	url = 'http://localhost:8888/agendaRESTful/personas/';
	home = 'http://localhost:8888/agendaRESTful/resources/html/agenda.html';
	dialog = $( "#dialog-form" ).dialog({
	      autoOpen: false,
	      height: 400,
	      width: 450,
	      modal: true,
	      buttons: {
	        "Guardar": function() {
	          campos = $('#id,#nombres,#apellidos,#telefono');
	          obj = {};
	          campos.each(function() {
	        	  obj[this.id] = $(this).val();
	          });
	          jQuery.ajax({
	  			type: $(this).data('metodo'),
	  			url: url,
	  			contentType: "application/json; charset=utf-8",
	  			dataType: 'json',
	  			data: JSON.stringify(obj),
	  			success: function () {
	  				location.replace(home);
	  	      }
	  		});
	          dialog.dialog( "close" );
	        }
	      }
	    });
	
	//Obtener todas las personas despues de cargar el DOM
	jQuery.ajax({
		type: 'GET',
		url: url,
		success: function (data) {
			$.each(data,  function(i, persona){
				  $('#registros').append('<tr class="reg"><td>' + persona.nombres  + '</td><td>' + persona.apellidos  + '</td><td>' + persona.telefono  + '</td> <td><input type="button" id="'+ persona.id + '"class="borrar" value="Borrar"></td></tr>');
			  });
       }
	});

	//Eliminar una persona al hacer click
	$(document).on('click','.borrar',function(Event){
		jQuery.ajax({
			type: 'DELETE',
			url: url + $(this).attr('id'),
			success: function () {
				location.replace(home);
	      }
		});
	});

	//Crear una persona nueva
	$('#crear').click(function() {
		$('#id,#nombres,#apellidos,#telefono').val("");
		 dialog.data('metodo', 'POST').dialog( "open" );
	});

	//Actualizar datos de persona
	$(document).on('click','.reg',function(Event){
		$('#nombres').val($(this).children('td').eq(0).text());
		$('#apellidos').val($(this).children('td').eq(1).text());
		$('#telefono').val($(this).children('td').eq(2).text());
		$('#id').val($(this).children('td').eq(3).find('input[type=button]').filter(':visible:first').attr('id'));
		dialog.data('metodo', 'PUT').dialog( "open" );
	});
	
});
