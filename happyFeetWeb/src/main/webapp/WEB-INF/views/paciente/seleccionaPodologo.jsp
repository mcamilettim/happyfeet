<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html lang="es">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="apple-touch-icon" sizes="57x57"
	href="${contextPath}/resources/icon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="${contextPath}/resources/icon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${contextPath}/resources/icon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="${contextPath}/resources/icon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${contextPath}/resources/icon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="${contextPath}/resources/icon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="${contextPath}/resources/icon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${contextPath}/resources/icon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="${contextPath}/resources/icon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="${contextPath}/resources/icon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="${contextPath}/resources/icon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${contextPath}/resources/icon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="${contextPath}/resources/icon/favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<title>Cuido mis pies</title>

<!-- Bootstrap Core CSS -->
<link
	href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${contextPath}/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${contextPath}/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Navegación</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/paciente/index"><img
					src="${contextPath}/resources/img/logo1.png" class="img-responsive"
					style="width: 120px;"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#">
								<div>
									<strong></strong> <span class="pull-right text-muted"> <em>Ahora</em>
									</span>
								</div>
								<div>Sin mensajes nuevos.</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center"
							href="${contextPath}/paciente/vermensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-messages --></li>
				</li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="${contextPath}/paciente/modificardatos"><i
								class="fa fa-gear fa-fw"></i>Mis Datos</a></li>
						<li class="divider"></li>
						<li><a href="<c:url value="/logout" />"><i
								class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<img src="${contextPath}/resources/img/sinfoto.jpg"
									class="img-responsive" style="width: 200px;"> <br>
								<div align="center">
									<span class="text-info text-center"><b>${paciente.nombres}
											${paciente.apellidos}</b></span> <span class="text-info">Paciente</span>
								</div>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath}/paciente/index"><i
								class="fa fa-dashboard fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/paciente/solicitud"><i
								class="fa fa-edit fa-fw"></i> Pedir hora!</a></li>
						<li><a href="${contextPath}/paciente/modificardatos"><i
								class="fa fa-gear fa-fw"></i> Modificar mis datos</a></li>
						<li><a href="${contextPath}/paciente/misatenciones"><i
								class="fa fa-table fa-fw"></i> Mis atenciones</a></li>
						<li><a href="${contextPath}/paciente/califica"><i
								class="fa fa-edit fa-fw"></i> Calificar a profesional</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Seleccion de Podologo</strong>
							</div>
							<br>
							<div class="container-fluid">
								<div class="table-responsive">
								 <table class="table table-hover">
									<tr>
										<th><div align="center">Foto de lo que usted dice tener</div></th>

									</tr>
									<tr>
										<td><div align="center">
												<img style="width: 150px; height: 150px;"
													src="${contextPath}/resources/imagenes/${patologia.foto}">
											</div></td>

									</tr>
								</table>
								</div>
							</div>
							<div align="center">
								<p>De acuerdo a la distancia del podologo seleccionado y
									usted se sacara el monto del viaje</p>
								<br>
 
	 
							<div class="container-fluid">
								<div class="table-responsive">
									<div id="mapa2" class="col-lg-12" style="height: 500px"></div>
									<p>
									<h2 id="total"></h2>
									</p>
								</div>
							</div>
							</div>
								<br>
	
							<br> <br>
						</div>
					</div>
					<!-- /.row -->
				</div>
			</div>
		</div>



		<!-- jQuery -->
		<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script
			src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script
			src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>
		<script type="text/javascript"
			src="http://maps.googleapis.com/maps/api/js?v3&libraries=places&key=AIzaSyAVgzIQhGvX45D1OGk-De6fgj-12xDuZjU
			">
			
		</script>
		<script type="text/javascript">
		//llamada ajax para traer direcciones
        function getPodologosPorComuna() {
           $.ajax({
               url: "/servicesPodologo/podologo/getPodologosPorComuna?idComuna=1",
               type: "get",
               success: function(podologos) {
                    botonObtenerDireccionDinamica(podologos);              
               }
           });
		}
		
		//CODIGO PARA IMAGEN DINÁMICA
		var divMapa2 = document.getElementById('mapa2');
		
		function botonObtenerDireccionDinamica(podologos) {
			//navigator.geolocation.getCurrentPosition(geoDinOk, geoDinError);
			geoDinOk(podologos);
		}
		
			//Coordenadas ORIGEN
		var latitud = "-33.5253895";
		var longitud = "-70.76047649999998";
		var gMapa = null;
		function geoDinOk(podologos) {
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
			// nombre, latitud, longitud, id
			var aMarkers = [];
			console.log(podologos);
			 for (var i = 0; i < podologos.length; i++) {
				aMarkers.push([podologos[i].nombres +" "+ podologos[i].apellidos, podologos[i].ubicacion.latitud, podologos[i].ubicacion.longitud, i, podologos[i].foto]);
			}
			console.log(aMarkers);
		 
			setearMarcadores(gMapa, gLatLon, aMarkers);	
		}
			var arrayMarkers = [];
			var arrayDR = [];
			var arrayInfoMarkers = [];
			var currentMarker = null;
			var currentPointsResult = null;
			function setearMarcadores(gMapa, gLatLonOrigin, aMarkers) {
				
				for (var i = 0; i < aMarkers.length; i++) {
					var destino = aMarkers[i];
					var gLatLon = new google.maps.LatLng(destino[1], destino[2]);
					
					
					
					//creando icono
					var icono = {
    						url: 'data:image/png;base64,'+destino[4], // url
   							scaledSize: new google.maps.Size(50, 50), // scaled size
    						origin: new google.maps.Point(0,0), // origin
   							anchor: new google.maps.Point(0, 0) // anchor
						};
					
					
					var gMarkerDin = new google.maps.Marker({
					  position: gLatLon,
					  map: gMapa,
					  icon: icono,
					  title: destino[0],
					  zIndex: destino[3]
					});
					arrayMarkers[destino[3]] = gMarkerDin;
					
					console.log(aMarkers[i][4]);
					var objHtml = {
						content: '<div style="height:150px; width:300px;"><h3> Cuido mis pies </h3><h4>'+aMarkers[i][0]+'</h4><p><a href="www.cuidomispies.cl">www.cuidomispies.cl</a></p>  </div>'
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
 getPodologosPorComuna();
	</script>
</body>

</html>
