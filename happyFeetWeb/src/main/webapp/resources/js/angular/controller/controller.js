angular.module('myApp', [])
.controller('UserCtrl', function($rootScope,$scope, $http,$q) {
 $scope.showLoading = true;
	 
 $scope.setPromesas=function(){
	   
	  var promesas=[];	
	  promesas.push($scope.obtenerDatosPodologos());
	  return $q.all(promesas);
}
	
	$scope.obtenerDatosPodologos = function(){
	 return $http.get('/servicesPodologo/podologo/getPodologosPorComuna?idComuna=1');
	}
	
	$scope.obtenerPresupuesto  = function(idPatologia,index,kilometros){
	      $http.get('/servicesPodologo/podologo/getPresupuesto?idPatologia='+idPatologia+'&rutPodologo='+$scope.podologos[index].rut+'&kilometros='+kilometros).
		    then(function(response) {
		        $scope.presupuesto = response.data;
	            console.log($scope.presupuesto);
		      }),
		      function(response) {
		        $scope.data = response.data || 'Request failed';
		        $scope.status = response.status;
		      };
		}
	
	 
 
	//CODIGO PARA IMAGEN DINÁMICA
	var divMapa2 = document.getElementById('mapa2');
	
	$scope.obtenerDireccionDinamica=function() {
	var gLatLon = new google.maps.LatLng(latitud,longitud);
		
		//configuracion de mapa
		var objConfig = {
			zoom: 15,
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
	
		//Coordenadas ORIGEN
	var latitud = "-33.5253895";
	var longitud = "-70.76047649999998";
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
							scaledSize: new google.maps.Size(40, 40), // scaled size
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
					content: '<div class="table-responsive" style="height:200px; width:250px;">Pod&oacute;logo(a):'+
						 '<h4>'+podologo.nombres+ ' '+ podologo.apellidos+'</h4> <img style="height:100px; width:100px;" '+
						 'class="img-responsive" src="data:image/png;base64,'+podologo.foto+'" />'+
						 '<table><tr><td>Evaluaci&oacute;n:&nbsp;'+podologo.evaluacion+'</td><td><img style="height:15px; width:15px;" class="img-responsive" src="http://icons.iconarchive.com/icons/paomedia/small-n-flat/96/star-icon.png" /></td></tr></table>  </div>'
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
								$scope.obtenerPresupuesto("1",currentMarker.zIndex,total);
								document.getElementById('total').innerHTML = total + ' kms';
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
	
	//FIN CODIGO PARA IMAGEN DINÁMICA
	  $scope.buscar=function(){
		  $scope.setPromesas().then(
		  function(response){
			   $scope.showLoading=false;
			   $scope.podologos = response[0].data;
			   $scope.obtenerDireccionDinamica();
		       console.log($scope.podologos); 
		  })
          } 
	  $scope.buscar();
})
 

