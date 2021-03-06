
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link href="${contextPath}/resources/css/jquery-ui.css" rel="stylesheet">
<link href="${contextPath}/resources/js/bootstrap-datepicker.min.css"
	rel="stylesheet">
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
					<span class="sr-only">Navegaci�n</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/podologo/index"><img
					src="${contextPath}/resources/img/logo1.png" class="img-responsive"
					style="width: 120px;"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown" style="padding-left: 10px;"><Strong>Bienvenid<c:if
							test="${podologo.paramSexo.id==6}">o</c:if><c:if
							test="${podologo.paramSexo.id==7}">a</c:if> ${podologo.nombres}
				</Strong></li>
				<li class="dropdown"><c:if test="${empty mensajesNuevos}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
					</c:if> <c:if test="${not empty mensajesNuevos}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i><span
							class="badge">${mensajesNuevos.size()}</span>
						</a>
					</c:if>
					<ul class="dropdown-menu dropdown-messages">
						<c:if test="${not empty mensajesNuevos}">
							<c:forEach items="${mensajesNuevos}" var="mensajeNuevo">
								<li><a
									href="${contextPath}/podologo/enviarMensaje?rutPaciente=${mensajeNuevo.emisorRut}">
										<strong></strong> <span class="pull-right text-muted"><em>${mensajeNuevo.fecha}</em>
									</span>${mensajeNuevo.cuerpo}
								</a></li>
							</c:forEach>
						</c:if>
						 
						<li><a class="text-center"
							href="${contextPath}/podologo/misMensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> </li>
					<li class="dropdown"><c:if test="${empty notificaciones}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
					</c:if> <c:if test="${not empty notificaciones}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i><span
							class="badge">${notificaciones.size()}</span>
						</a>
					</c:if>
					<ul class="dropdown-menu dropdown-messages">
						<c:if test="${not empty notificaciones}">
							<c:forEach items="${notificaciones}" var="notificacion">
								<li><a
									href="${notificacion.url}&idNotificacion=${notificacion.id}">
										<strong></strong> <span class="pull-right text-muted"><em>${notificacion.fecha}</em>
									</span> ${notificacion.titulo}
								</a></li>
							</c:forEach>
						</c:if>

						<li><a class="text-center"
							href="${contextPath}/podologo/misNotificaciones"> <strong>Ver
									todas las notificaciones</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>

				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="${contextPath}/podologo/modificarDatos"><i
								class="fa fa-gear fa-fw"></i>Mis Datos</a></li>
						<li class="divider"></li>
						<li><a href="<c:url value="/logout" />"><i
								class="fa fa-sign-out fa-fw"></i> Cerrar Sesi�n</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<c:choose>
									<c:when test="${empty podologo.foto}">
										<img src="${contextPath}/resources/img/sinfoto.jpg"
											class="img-responsive" style="width: 200px;">
									</c:when>
									<c:otherwise>
										<img src="data:image/png;base64,${podologo.foto}"
											class="img-responsive" style="width: 200px;">
									</c:otherwise>
								</c:choose>
								<br>
								<div align="center">
									<span class="text-info text-center"><b>${podologo.nombres}
											${podologo.apellidos}</b></span> <span class="text-info">Pod�log<c:if test="${podologo.paramSexo.id==6}">o</c:if><c:if test="${podologo.paramSexo.id==7}">a</c:if></span>
								</div>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath}/podologo/index"><i
								class="fa fa-home fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/podologo/miAgenda"><i
								class="fa fa-edit fa-fw"></i>Mi Horario</a></li>
						<li><a href="${contextPath}/podologo/misSolicitudes"><i
								class="fa fa-calendar-plus-o fa-fw"></i><Strong>Solicitudes de Atenci�n</Strong></a></li>
						<li><a href="${contextPath}/podologo/misAtenciones"><i
								class="fa fa-user-md fa-fw"></i> Mis atenciones</a></li>
						<li><a href="${contextPath}/podologo/misMensajes"><i
								class="fa fa-comments fa-fw"></i> Mensajes</a></li>
						<li><a href="${contextPath}/podologo/misEvaluaciones"><i
								class="fa fa-star-half-o fa-fw"></i> Evaluaciones a
								Pacientes</a></li>
						<li><a href="${contextPath}/podologo/modificarDatos"><i
								class="fa fa-gear fa-fw"></i> Modificar mis datos</a></li>
								<li><a href="${contextPath}/podologo/cuestionarios"><i
								class="fa fa-question-circle fa-fw"></i> Contestar encuesta</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		<!-- Page Content -->
		<div id="page-wrapper">
			<br>
			<c:if
				test="${fn:length(solicitudes) == 0 && fn:length(solicitudesPendientes) == 0}">
				<div class="alert alert-warning" align="center">
					<Strong>Usted no posee solicitudes de Pacientes</Strong>
				</div>
			</c:if>

			<c:if test="${not empty solicitudesPendientes}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Mis Solicitudes Pendientes <span class="badge">${solicitudesPendientes.size()}</span></strong>
							</div>
							<br>
							<div align="center">
								<p
									style="text-align: justify; padding-left: 10px; padding-right: 10px;">A
									continuaci�n se detallan todas las solicitudes pendientes que
									requieren ser respondidas.</p>
								<br>
							</div>
							<div class="table-responsive">
								<table class="table table-bordered">
									<tr>
										<th><div align="center">Paciente</div></th>
										<th><div align="center">Patologia</div></th>
										<th><div align="center">Fecha</div></th>
										<th><div align="center">Hora</div></th>
										<th><div align="center">Estado</div></th>

									</tr>
									<c:forEach items="${solicitudesPendientes}" var="solicitud">
										<tr>
											<td align="center">${solicitud.podologo.nombres}</td>
											<td align="center">${solicitud.patologia.nombre}</td>
											<td align="center">${solicitud.horario.fecha}</td>
											<td align="center">${solicitud.horario.hora}</td>
											<td align="center"><c:if
													test="${solicitud.paramEstadoSolicitudAtencion.valor eq 'Pendiente'}">
													<button type="button"
														onclick="location.href='${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}'"
														class="btn btn-warning">PENDIENTE</button>
												</c:if> <c:if
													test="${solicitud.paramEstadoSolicitudAtencion.valor eq 'Rechazada'}">
													<button type="button"
														onclick="location.href='${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}'"
														class="btn btn-danger">RECHAZADA</button>
												</c:if> <c:if
													test="${solicitud.paramEstadoSolicitudAtencion.valor eq 'Aceptada'}">
													<button type="button"
														onclick="location.href='${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}'"
														class="btn btn-success">ACEPTADA</button>
												</c:if></td>

										</tr>
									</c:forEach>
								</table>
							</div>

						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty solicitudes}">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Mis Solicitudes Respondidas <span class="badge">${solicitudes.size()}</span></strong>
							</div>
							<br>
							<div align="center">
								<p
									style="text-align: justify; padding-left: 10px; padding-right: 10px;">A
									continuaci�n se detallan todas las solicitudes de atencion que
									ha respondido.</p>
								<br>
							</div>
							<div class="table-responsive">
								<table class="table table-bordered">
									<tr>
										<th><div align="center">Paciente</div></th>
										<th><div align="center">Patologia</div></th>
										<th><div align="center">Fecha</div></th>
										<th><div align="center">Hora</div></th>
										<th><div align="center">Estado</div></th>

									</tr>
									<c:forEach items="${solicitudes}" var="solicitud">
										<tr>
											<td align="center">${solicitud.podologo.nombres}</td>
											<td align="center">${solicitud.patologia.nombre}</td>
											<td align="center">${solicitud.horario.fecha}</td>
											<td align="center">${solicitud.horario.hora}</td>
											<td align="center"><c:if
													test="${solicitud.paramEstadoSolicitudAtencion.valor eq 'Pendiente'}">
													<button type="button"
														onclick="location.href='${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}'"
														class="btn btn-warning">PENDIENTE</button>
												</c:if> <c:if
													test="${solicitud.paramEstadoSolicitudAtencion.valor eq 'Rechazada'}">
													<button type="button"
														onclick="location.href='${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}'"
														class="btn btn-danger">RECHAZADA</button>
												</c:if> <c:if
													test="${solicitud.paramEstadoSolicitudAtencion.valor eq 'Aceptada'}">
													<button type="button"
														onclick="location.href='${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}'"
														class="btn btn-success">ACEPTADA</button>
												</c:if></td>

										</tr>
									</c:forEach>
								</table>
							</div>

						</div>
					</div>
				</div>
			</c:if>
		</div>

	</div>
	<!-- /.row -->


	<!-- /.container-fluid -->

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
	<script src="${contextPath}/resources/js/jquery-ui.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>

	<script type="text/javascript">
		$.datepicker.regional['es'] = {
			closeText : 'Cerrar',
			prevText : '<Ant',
					 nextText: 'Sig>',
			currentText : 'Hoy',
			monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
					'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre',
					'Noviembre', 'Diciembre' ],
			monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
					'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
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
			inline : true
		//beforeShow: function(i) { if ($(i).attr('readonly')) { return false; } }
		});
	</script>
</body>

</html>
