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
							<div align="center">
								<p>De acuerdo a la distancia del podologo seleccionado y
									usted se sacara el monto del viaje</p>
								<br>
							</div>
							<div class="container-fluid">
								<div class="table-responsive">
								<button onclick="botonObtenerDireccionDinamica()">Obtener imagen dinámica de direccion por GPS</button>
									<div id="mapa2" style="width: 700px; height: 500px;">
									
									</div>
									<p><h2 id="total"></h2></p>
								</div>
							</div>
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
		//CODIGO PARA IMAGEN DINÁMICA
		var divMapa2 = document.getElementById('mapa2');
		
		function botonObtenerDireccionDinamica() {
			navigator.geolocation.getCurrentPosition(geoDinOk, geoDinError);
		}
		
		
		function geoDinOk(respuesta) {
			//divMapa.innerHTML = 'Autorizado.'
			var latitud = respuesta.coords.latitude;
			var longitud = respuesta.coords.longitude;
			
			var gLatLon = new google.maps.LatLng(latitud,longitud);
			
			//configuracion de mapa
			var objConfig = {
				zoom: 15,
				center: gLatLon
			}
			//pintar el mapa en el DIV con la configuracion de objConfig
			var gMapa = new google.maps.Map(divMapa2, objConfig);
			
			//MARKER = MARCA DENTRO DEL MAPA
			//EL MARCADOR EXISTA EN LA POSICION DEL USUARIO Y DENTRO DEL MAPA
			var objConfigMarker = {
				position: gLatLon,
				map: gMapa,
				title: "Esta es su dirección actual."
			}
			//SE AGREGA AL MAPA el MARKER "objConfigMarker"
			var gMarker = new google.maps.Marker(objConfigMarker);
			
			
			
			
			//Obtener direccion en base a direccion escrita por usuario
			//'Santa Victoria 492, Santiago'
			var gCoder = new google.maps.Geocoder();
			var objDireccion = {
				address: 'Santa Victoria 492, Santiago'
			}
			gCoder.geocode(objDireccion, fnCoder);
			
			
			function fnCoder(datos) {
				var coordenadas = datos[0].geometry.location;
				var config = {
					map: gMapa,
					animation: google.maps.Animation.DROP,
					position: coordenadas,
					title: 'Casa de Pablo'
				}
				var gMarkerDin = new google.maps.Marker(config);
				gMarkerDin.setIcon('');

				var objHtml = {
					content: '<div style="height:150px; width:300px;"><h2>SERVEL</h2><h3>Servicio Electoral de Chile</h3><p><a href="www.servel.cl">www.servel.cl</a></p></div>'
				}

				var gInfoWindow = new google.maps.InfoWindow(objHtml);
				
				google.maps.event.addListener(gMarkerDin,'click', function (){
					gInfoWindow.open(gMapa, gMarkerDin);
				});
				
				var objConfigDR = {
					map: gMapa,
					supressMarkers: true
				};
				var objConfigDS = {
					origin: gLatLon,
					destination: 'Santa Victoria 492, Santiago',
					travelMode: google.maps.TravelMode.DRIVING,
					drivingOptions: {
						departureTime: new Date(Date.now())
					}
				};
				//obtener coordenadas
				var ds = new google.maps.DirectionsService( );
				//traduce coordenadas a ruta visible
				var dr = new google.maps.DirectionsRenderer(objConfigDR );
				
				ds.route(objConfigDS, rutear);
				
				function rutear(resultados,status) {
					//mostrar ruta entre A y B
					//    OK indica que la respuesta contiene un DirectionsResult válido.
					//    NOT_FOUND indica que no se pudo geocodificar al menos a una de las ubicaciones especificadas en el origen, el destino o los waypoints de la solicitud.
					//    ZERO_RESULTS indica que no fue posible hallar una ruta entre el origen y el destino.
					//   MAX_WAYPOINTS_EXCEEDED indica que se proporcionaron demasiados campos DirectionsWaypoint en DirectionsRequest. Consulta la sección sobre límites de waypoints más adelante.
					//    INVALID_REQUEST indica que el DirectionsRequest proporcionado no fue válido. Estos códigos de error se deben con mayor frecuencia a la falta un origen o un destino en las solicitudes, o bien a la inclusión de waypoints en las mismas.
					//    OVER_QUERY_LIMIT indica que la página web ha enviado demasiadas solicitudes dentro del período de tiempo permitido.
					//   REQUEST_DENIED indica que la página web no puede usar el servicio de indicaciones.
					//    UNKNOWN_ERROR indica que no se pudo procesar una solicitud de indicaciones debido a un error en el servidor. La solicitud puede tener éxito si realizas un nuevo intento.

						
					if(status == 'OK') {
						dr.setDirections(resultados);
						var total = 0;
						var myroute = resultados.routes[0];
						for (var i = 0; i < myroute.legs.length; i++) {
							total += myroute.legs[i].distance.value;
						}
						total = total / 1000;
						document.getElementById('total').innerHTML = total + ' kms';
					} else{
						alert('Error: '+status);
					}
				}
			}
			
			
		}
		
		function geoDinError() {
			divMapa2.innerHTML = 'GPS No autorizado.'
		}	
		//FIN CODIGO PARA IMAGEN DINÁMICA

	</script>
</body>

</html>
