angular.module('myApp', [])
.controller('UserCtrl', function($rootScope,$scope, $http,$q) {
 $scope.showLoading = true;
 $scope.modalConfirmar = false; 
 $scope.podologoSeleccionado = {};
 $scope.urlRuta = null;
 $scope.selectedDescuento = -1;

 
 $scope.obtenerDatosPodologos = function(idComuna){
	 return $http.get('/servicesAgendar/getPodologosPorComuna?idComuna='+idComuna);
}
$scope.obtenerDatosPaciente = function(){
	 return $http.get('/servicesAgendar/getPaciente');
}
 
 $scope.setPromesaPaciente=function(){	   
	  var promesas=[];
	  promesas.push($scope.obtenerDatosPaciente());
	  return $q.all(promesas);
}
 $scope.setPromesasPodologos=function(idComuna){	   
	  var promesas=[];
	  promesas.push( $scope.obtenerDatosPodologos(idComuna));
	  return $q.all(promesas);
}

	
	$scope.obtenerPresupuesto  = function(idPatologia,index,kilometros){
		var url = "http://maps.googleapis.com/maps/api/staticmap?sensor=false&"+
		"&zoom=$zoomParam&size=850x650&markers=color:blue%7&path=enc:"+encodeURI(currentPointsResult);	
		$scope.urlRuta=url;
 
	      $http.get('/servicesAgendar/getPresupuesto?idPatologia='+idPatologia+'&rutPodologo='+$scope.podologos[index].rut+'&kilometros='+kilometros).
		    then(function(response) {
		    	 $scope.podologoSeleccionado=$scope.podologos[index];
		        $scope.presupuesto = response.data;
		      }),
		      function(response) {
		        $scope.data = response.data || 'Request failed';
		        $scope.status = response.status;
		      };
		}
	
	$scope.confirmarPresupuesto= function(){
		window.scrollTo(0,document.body.scrollHeight);		     		 
	 }
 
	$scope.setHorarioSeleccionado=function(horario){
		$scope.horarioSeleccionado=horario;
	}
	//CODIGO PARA IMAGEN DINÁMICA
	var divMapa2 = document.getElementById('mapa2');
	
	$scope.obtenerDireccionDinamica=function() {
		//Coordenadas ORIGEN
		var latitud = $scope.paciente.ubicacion.latitud;
		var longitud =$scope.paciente.ubicacion.longitud;
		
	var gLatLon = new google.maps.LatLng(latitud,longitud);
		
		//configuracion de mapa
		var objConfig = {
			zoom: 13,
			center: gLatLon
		}
		//pintar el mapa en el DIV con la configuracion de objConfig
		gMapa = new google.maps.Map(divMapa2, objConfig);
		
		//MARKER = MARCA DENTRO DEL MAPA
		//EL MARCADOR EXISTA EN LA POSICION DEL USUARIO Y DENTRO DEL MAPA
		var objConfigMarker = {
			position: gLatLon,
			map: gMapa,
			title: "Direccion ORIGEN"
		}
		//SE AGREGA AL MAPA el MARKER "objConfigMarker"
		var gMarker = new google.maps.Marker(objConfigMarker);
		$scope.setearMarcadores(gMapa, gLatLon);	
	}
	
		
	var gMapa = null;
 
	 
		var arrayDR = [];
		var arrayInfoMarkers = [];
		var currentMarker = null;
		var currentPointsResult = null;
		
		$scope.setearMarcadores=function(gMapa, gLatLonOrigin) {
			
			for (var i = 0; i < $scope.podologos.length; i++) {
				var podologo = $scope.podologos[i];
				var gLatLon = new google.maps.LatLng(podologo.ubicacion.latitud, podologo.ubicacion.longitud);
 
				//creando icono
				var icono = {
						url: 'data:image/png;base64,'+podologo.foto, // url
							scaledSize: new google.maps.Size(35, 35), // scaled size
						    origin: new google.maps.Point(0,0), // origin
							anchor: new google.maps.Point(0, 0) // anchor
					};
				
				var gMarkerDin = new google.maps.Marker({
				  position: gLatLon,
				  map: gMapa,
				  icon: icono,
				  title: podologo.nombres+ " "+ podologo.apellidos,
				  zIndex: i//index
				});
			 
	 
				var objHtml = {
					content: '<div align="center" class="table-responsive" style="height:165px; width:165px;">Pod&oacute;logo(a):'+
						 '<h6>'+podologo.nombres+ ' '+ podologo.apellidos+'</h6> <img style="height:60px; width:60px;" '+
						 'class="img-responsive" src="data:image/png;base64,'+podologo.foto+'" />'+
						 '<table><tr><td><strong>Cantidad atenciones:</strong></td><td><strong>'+podologo.cantidadAtenciones+'</strong></td></tr><tr><td><strong>Promedio Evaluaci&oacute;n:&nbsp;'+podologo.evaluacion+'</strong></td><td><img style="height:10px; width:10px;" class="img-responsive" src="http://icons.iconarchive.com/icons/paomedia/small-n-flat/96/star-icon.png"/></td></tr></table></div>'
				}

				var gInfoWindow = new google.maps.InfoWindow(objHtml);
				arrayInfoMarkers[i] = gInfoWindow;
				
				google.maps.event.addListener(gMarkerDin,'click', (function(gMarkerDin,objHtml,gInfoWindow){
					return function() {
						arrayDR.forEach(function(entry) {
							entry.setMap(null);
						});
						arrayInfoMarkers.forEach(function(entry) {
							entry.close();
						});
						
					    gInfoWindow.open(gMapa,gMarkerDin);
						currentMarker = gMarkerDin;
			 
						var objConfigDR = {
							map: gMapa,
							supressMarkers: true
						};
							
						var objConfigDS = {
							origin: gLatLonOrigin,
							destination: gMarkerDin.getPosition(),
							travelMode: google.maps.TravelMode.DRIVING,
							drivingOptions: {
								departureTime: new Date(Date.now())
							}
						};
						//obtener coordenadas
						var ds = new google.maps.DirectionsService( );
						//traduce coordenadas a ruta visible
						var dr = new google.maps.DirectionsRenderer(objConfigDR );
						arrayDR[i] = dr;
						ds.route(objConfigDS, rutear);	
						function rutear(resultados,status) {
							if(status == 'OK') {
								dr.setDirections(resultados);
								var total = 0;
								var myroute = resultados.routes[0];
								currentPointsResult = resultados.routes[0].overview_polyline;
								for (var i = 0; i < myroute.legs.length; i++) {
									total += myroute.legs[i].distance.value;
								}
								total = total / 1000;
								var url_string = window.location.href
								var url = new URL(url_string);
								var id = url.searchParams.get("id");
								$scope.obtenerPresupuesto(id,currentMarker.zIndex,total);
								//document.getElementById('detalleKilometros').innerHTML = total;
							} else{
								alert('Error: '+status);
							}
						}	
					};
				})(gMarkerDin,objHtml,gInfoWindow));
				
			}
		}
		
	function obtenerImagen() {
		document.getElementById('error').innerHTML = "";
		if(currentPointsResult == null){
			document.getElementById('error').innerHTML = "No ha seleccionado destino.";
		}else {
			var url = "http://maps.googleapis.com/maps/api/staticmap?sensor=false&"+
					"&zoom=14&size=700x500&markers=color:blue%7&path=enc:"+encodeURI(currentPointsResult);	
			document.getElementById('mapa').innerHTML = '<img src="'+url+'" />';
		}
			
						
	}					
	function geoDinError() {
		divMapa2.innerHTML = 'GPS No autorizado.'
	}
	 $scope.buscarPodologos=function(idComuna){
		  $scope.setPromesasPodologos(idComuna).then(
		  function(response){
		   $scope.podologos = response[0].data;
		   $scope.obtenerDireccionDinamica();
		  })
    } 
	 
	//FIN CODIGO PARA IMAGEN DINÁMICA
	  $scope.buscarPaciente=function(){
		  $scope.setPromesaPaciente().then(
		  function(response){		
			  $scope.paciente=response[0].data
			  $scope.buscarPodologos($scope.paciente.ubicacion.comuna.id);
		  })
     } 
	 
	  $scope.buscarPaciente();
	  
	  $scope.calcularPresupuesto=function(descuentoID){
		  $scope.selectedDescuento=descuentoID;
	      for (var i = 0; i < $scope.paciente.descuentos.length; i++) {
				if($scope.paciente.descuentos[i].id==descuentoID){		
					  $scope.presupuesto.descuento=parseInt($scope.presupuesto.total*parseFloat(parseFloat($scope.paciente.descuentos[i].descuento)/100));
					  $scope.presupuesto.totalConDescuento= $scope.presupuesto.total-$scope.presupuesto.descuento;
				}
			} 
     }   
})
 

