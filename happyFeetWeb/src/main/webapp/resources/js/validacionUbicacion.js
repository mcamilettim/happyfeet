	$(document).ready(function () {
		$('#rut').rut(); 
		$(':input[type="submit"]').prop('disabled', true);
		var latitud="";
		var longitud="";
		function getLocale(address){
			console.log(address);
			var geocoder = new google.maps.Geocoder();
			 geocoder.geocode( { 'address': address}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK)
					{
					console.log(results);
					latitud=results[0].geometry.location.lat();
					longitud=results[0].geometry.location.lng();
					$("#latitud").val(results[0].geometry.location.lat());
					$("#longitud").val(results[0].geometry.location.lng());
					//console.log(results); 
				    $("#mensajeDirecion").html("Direcci&oacute;n [OK]");
				    console.log("Direcci&oacute;n [OK]");
				    $("#mensajeDirecion").css("color", "black");	
				    $("#ubicacion").val(results[0].formatted_address);	
				    validaComuna(results[0].address_components[2].short_name);
				   // console.log(results[0].address_components[2].short_name);
				  //  $("#ubicacion").val("");
					}else{
						console.log("NO ENCONTRADA");
						 $("#mensajeDirecion").html("Direcci&oacute;n [No encontrada]");
						 $("#mensajeDirecion").css("color", "red");				
					}
		   });
		}			
		$("#ubicacion" ).focusout(function() {
			var address = document.getElementById("ubicacion").value;
			//alert("FOCUS OUT");
			getLocale(address);
		 });	
		
		function validaComuna(address){
			console.log(address);
			address= address.replace("ú", "&uacute;");
			console.log(address);
			if(address==="Maip&uacute;"){
				$("#comunaID").val('1').change();;
				$("#comunaNombre").val(address);
				 $(':input[type="submit"]').prop('disabled', false);
			}else{
				if(address==="Pudahuel"){
					 $(':input[type="submit"]').prop('disabled', false);
					$("#comunaID").val('2').change();;
					$("#comunaNombre").val(address);
				}else{
					 $(':input[type="submit"]').prop('disabled', true);
					 $("#mensajeDirecion").css("color", "red");	
					 $("#mensajeDirecion").html("Direcci&oacute;n [ S&oacute;lo Pudahuel y Maip&uacute; ]");
				}
			}
		}
		
		
		$.datepicker.regional['es'] = {
				closeText : 'Cerrar',
				prevText : '<Ant',
					 nextText: 'Sig>',
				currentText : 'Hoy',
				monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
						'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
						'Diciembre' ],
				monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul',
						'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
				dayNames : [ 'Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves',
						'Viernes', 'Sabado' ],
				dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mie', 'Juv', 'Vie', 'Sab' ],
				dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa' ],
				weekHeader : 'Sm',
				dateFormat : 'dd/mm/yy',
				firstDay : 1,
				isRTL : false,
				showMonthAfterYear : false,
				yearSuffix : '',
				//beforeShow: function(i) { if ($('dp1').attr('readonly')) { return false; } }
			};
		$.datepicker.setDefaults($.datepicker.regional['es']);

		$("#datePicker").datepicker({
            //dateFormat: 'dd/mm/yy',
            inline: true
            //beforeShow: function(i) { if ($(i).attr('readonly')) { return false; } }
        });
	});