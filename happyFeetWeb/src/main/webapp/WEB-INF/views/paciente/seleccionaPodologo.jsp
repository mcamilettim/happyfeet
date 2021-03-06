<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="es_CL" />
<!DOCTYPE html>

<html lang="es" ng-app="myApp">

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

<body data-ng-controller="UserCtrl">

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
				<a class="navbar-brand" href="${contextPath}/paciente/index"><img
					src="${contextPath}/resources/img/logo1.png" class="img-responsive"
					style="width: 120px;"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown" style="padding-left: 10px;"><Strong>Bienvenid<c:if
							test="${paciente.paramSexo.id==6}">o</c:if>
						<c:if test="${paciente.paramSexo.id==7}">a</c:if>
						${paciente.nombres}
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
									href="${contextPath}/paciente/enviarMensaje?rutPodologo=${mensajeNuevo.emisorRut}">
										<strong></strong> <span class="pull-right text-muted"><em>${mensajeNuevo.fecha}</em>
									</span>${mensajeNuevo.cuerpo}
								</a></li>
							</c:forEach>
						</c:if>

						<li><a class="text-center"
							href="${contextPath}/paciente/misMensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>
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
							href="${contextPath}/paciente/misNotificaciones"> <strong>Ver
									todas las notificaciones</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>

				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="${contextPath}/paciente/modificarDatos"><i
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
									<c:when test="${empty paciente.foto}">
										<img src="${contextPath}/resources/img/sinfoto.jpg"
											class="img-responsive" style="width: 200px;">
									</c:when>
									<c:otherwise>
										<img src="data:image/png;base64,${paciente.foto}"
											class="img-responsive" style="width: 200px;">
									</c:otherwise>
								</c:choose>
								<br>
								<div align="center">
									<span class="text-info text-center"><b>${paciente.nombres}
											${paciente.apellidos}</b></span> <span class="text-info">Paciente</span>
								</div>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath}/paciente/index"><i
								class="fa fa-home fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/paciente/quizPatologia"><i
								class="fa fa-edit fa-fw"></i><Strong>Solicitar Atenci�n</Strong></a></li>
						<li><a href="${contextPath}/paciente/misSolicitudes"><i
								class="fa fa-calendar-plus-o fa-fw"></i>Solicitudes de Atenci�n</a></li>
						<li><a href="${contextPath}/paciente/misAtenciones"><i
								class="fa fa-user-md fa-fw"></i> Mis atenciones</a></li>
						<li><a href="${contextPath}/paciente/misMensajes"><i
								class="fa fa-comments fa-fw"></i> Mensajes</a></li>
						<li><a href="${contextPath}/paciente/misEvaluaciones"><i
								class="fa fa-star-half-o fa-fw"></i> Evaluaciones a
								Profesionales</a></li>
						<li><a href="${contextPath}/paciente/modificarDatos"><i
								class="fa fa-gear fa-fw"></i> Modificar mis datos</a></li>
						<li><a href="${contextPath}/paciente/cuestionarios"><i
								class="fa fa-question-circle fa-fw"></i> Descuentos</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<br>
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<table class="table table-hover">
								<tr>
									<th style="background-color: #F5F5F5"><div align="center">Patologia</div></th>
									<th style="background-color: #F5F5F5"><div align="center">Foto</div></th>
								</tr>

								<tr>
									<td><strong>${patologia.nombre}</strong></td>
									<td><div align="center">
											<img class="img-responsive"
												style="width: 110px; height: 110px;"
												src="data:image/png;base64,${patologia.foto}" />
										</div></td>
								</tr>
								<tr>
									<td colspan="2"><strong>Descripci�n: </strong>
										<p
											style="text-align: justify; padding-left: 10px; padding-right: 10px; padding-top: 10px;">${patologia.descripcion}
											<br> <strong>Tratar esta Patolog�a tiene un
												precio Base de: $ <fmt:formatNumber
													value="${patologia.costo}" type="currency" pattern="#,##0" />
												pesos, a esto se le debe sumar el costo de viaje del
												Pod�logo a su hogar, el cual se calcular� a continuaci�n.
											</strong>
										</p></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="container-fluid">
				<br>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Seleccion de Podologo</strong>
							</div>
							<div align="center">
								<p
									style="text-align: justify; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
									De acuerdo a la distancia del pod�logo seleccionado y usted se
									obtendr� el monto del viaje a domicilio, el cual se sumar� al
									monto de la Patolog�a<br>
								</p>

							</div>
							<div class="table-responsive" align="center">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th style="background: #FAFAFA;"><p align="center">VIAJE</p></th>
											<th style="background: #FAFAFA;"><p align="center">PATOLOG�A</p></th>
											<th style="background: #FAFAFA;"><p align="center">TOTAL</p></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><p align="center">
													<strong ng-if="presupuesto.montoKilometros">{{presupuesto.montoKilometros
														| number}}</strong> <strong ng-if="!presupuesto.montoKilometros">
														?</strong>
												</p></td>
											<td><p align="center">
													<strong><fmt:formatNumber
															value="${patologia.costo}" type="currency"
															pattern="#,##0" /> </strong>
												</p></td>
											<td><p align="center">
													<strong ng-if="presupuesto.total">{{presupuesto.total
														| number}}</strong><strong ng-if="!presupuesto.total">?</strong>
												</p></td>
										</tr>
										<tr ng-if="presupuesto.total">
											<td colspan="3"><p align="center">
													<button ng-click="confirmarPresupuesto()"
														ng-if="presupuesto.total" type="button"
														class="btn btn-info">Continuar</button>
												</p></td>
										</tr>
									</tbody>
								</table>

							</div>

							<div class="table-responsive">
								<div id="mapa2" class="col-lg-12" style="height: 550px"></div>
							</div>


							<div ng-if="!presupuesto" align="center" class=" bg-danger "
								style="height: 40px; padding-top: 10px;">
								<p>
									<strong> Seleccione un(a) Pod�logo(a) para continuar</strong>
								</p>
							</div>
							<div ng-if="podologoSeleccionado.horarios.length==0"
								align="center" class=" bg-danger "
								style="height: 40px; padding-top: 10px;">
								<p>
									<strong> El Pod�logo seleccionado no posee horarios
										disponibles</strong>
								</p>
							</div>
							<div
								ng-if="presupuesto && !horarioSeleccionado && podologoSeleccionado.horarios.length!=0"
								align="center" class=" bg-danger "
								style="height: 40px; padding-top: 10px;">
								<p>
									<strong> Seleccione un horario de Atenci�n</strong>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid"
				ng-if="presupuesto && podologoSeleccionado.horarios.length>0">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Seleccione un Horario de Atenci�n de
									{{presupuesto.nombrePodologo}}</strong>
							</div>
							<div>
								<table class="table">
									<thead>
										<tr>
											<th scope="col">Fecha</th>
											<th scope="col">Hora Inicio</th>
											<th scope="col">Hora Fin</th>
											<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="horario in podologoSeleccionado.horarios">
											<td scope="row">{{horario.fecha}}</td>
											<td scope="row">{{horario.hora}}</td>
											<td scope="row">{{horario.horaFin}}</td>
											<td scope="row">
												<div class="form-check">
													<input ng-model="horarioSeleccionado" type="radio"
														name="rdoResult"
														ng-click="setHorarioSeleccionado(horario)"
														ng-value="horario.id" />
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br ng-if="!horarioSeleccionado"> <br
				ng-if="!horarioSeleccionado"> <br ng-if="!horarioSeleccionado">
			<div class="container-fluid" ng-if="horarioSeleccionado">
				<br>
				<div class="row">
					<form:form method="POST" modelAttribute="solicitudForm"
						action="guardarAgenda" enctype="multipart/form-data"
						onsubmit="return checkSize()">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>Detalle Presupuesto</strong>
								</div>
								<div>
									<div class="table-responsive">
										<table class="table">
											<tr>
												<th scope="col">Pod�logo</th>
												<th scope="row">{{presupuesto.nombrePodologo}}</th>
											</tr>
											<tr style="display: none;">
												<th scope="row" colspan="2"><input
													ng-model="horarioSeleccionado.id" type="text"
													class="form-control" name="horario.id" required="required"
													readonly="readonly" /></th>
											</tr>
											<tr style="display: none;">
												<th scope="row" colspan="2"><input
													ng-model="presupuesto.rutPodologo" type="text"
													class="form-control" name="podologo.rut"
													required="required" readonly="readonly" /></th>
											</tr>
											<tr style="display: none;">
												<th scope="row" colspan="2"><input
													ng-model="presupuesto.kilometros" type="text"
													class="form-control" name="kilometros" required="required"
													readonly="readonly" /></th>
											</tr>
											<tr style="display: none;">
												<th scope="row" colspan="2"><input
													ng-model="selectedDescuento" type="text"
													class="form-control" name="idCuestionario"
													required="required" readonly="readonly" /></th>
											</tr>
											<tr style="display: none;">
												<th scope="row" colspan="2"><input ng-model="urlRuta"
													type="text" class="form-control" name="urlRuta"
													required="required" readonly="readonly" /></th>
											</tr>
											<tr>
												<th scope="col">Evaluaci�n</th>
												<th scope="row">&nbsp;{{presupuesto.evaluacion}}<img
													align="left" ng-if="presupuesto.evaluacion"
													style="height: 15px; width: 15px;" class="img-responsive"
													src="http://icons.iconarchive.com/icons/paomedia/small-n-flat/96/star-icon.png" />
												</th>
											</tr>
											<tr>
												<th scope="col">Direccion Origen</th>
												<th scope="row">{{presupuesto.direccion_origen}}</th>
											</tr>
											<tr>
												<th scope="col">Direccion Destino</th>
												<th scope="row">{{presupuesto.direccion_destino}}</th>
											</tr>
											<tr>
												<th scope="col">Kil�metros</th>
												<th scope="row">{{presupuesto.kilometros}} Kms</th>
											</tr>
											<tr>
												<th scope="col">Monto por Kil�metro</th>
												<th scope="row">$ {{presupuesto.montoPorKilometro |
													number}}</th>
											</tr>
											<tr>
												<th scope="col">Viaje del Pod�logo a su Casa</th>
												<th scope="row">$ {{presupuesto.montoKilometros |
													number}}</th>
											</tr>
											<tr>
												<th scope="col">Patolog�a a Tratar</th>
												<th scope="row">{{presupuesto.patologia_nombre}}</th>
											</tr>
											<tr>
												<th scope="col">Patolog�a a Tratar Monto</th>
												<th scope="row">$ {{presupuesto.patologia_monto |
													number}}</th>
											</tr>

											<tr>
												<th scope="col">Cup�n de Descuento</th>
												<th scope="row" ng-if="paciente.descuentos.length > 0 ">
													<select ng-model="selectedDescuento"
													ng-selected="selectedDescuento == descuento.id"
													ng-change="calcularPresupuesto(selectedDescuento)"
													ng-options="descuento.id as (descuento.nombre+' '+descuento.descuento+' %') for descuento in paciente.descuentos">
														<option style="display: none" value="">SELECCIONE
															UN CUP�N</option>
												</select>
												<th scope="row" ng-if="paciente.descuentos.length == 0 ">SIN
													CUPONES &nbsp;... &nbsp;<a class="btn btn-info"
													href="cuestionarios" role="button">C�mo obtener
														Cupones?</a>
												</th>
											</tr>
											<tr>
												<th scope="col" colspan="2">Foto de sus Pies <input
													type="file" class="form-control" name="fotoPiePaciente"
													id="idFotoPiePaciente" value="Subir Carnet"
													required="required"
													accept="image/x-png,image/gif,image/jpeg"></input>
												</th>
											</tr>
											<tr>
												<th scope="col" colspan="2">Comentario para el Pod�logo
													<textarea class="form-control" rows="3"
														name="comentarioPaciente"></textarea>
												</th>
											</tr>

										</table>
									</div>
								</div>
								<div align="center" class="bg-info"
									style="height: 40px; padding-top: 10px;">
									<p>
										<strong> Monto subTotal: $ {{presupuesto.total |
											number}}</strong>
									</p>
								</div>
								<div
									ng-if="paciente.descuentos.length > 0 && presupuesto.descuento > 0"
									align="center" class="bg-secondary"
									style="height: 40px; padding-top: 10px;">
									<p>
										<strong> Monto Descuento Cup�n :
											{{presupuesto.descuento | number}}</strong>
									</p>
								</div>
								<div align="center" class="bg-info"
									style="height: 40px; padding-top: 10px;">
									<p>
										<strong> Monto total por la atenci�n : $
											{{presupuesto.totalConDescuento | number}}</strong>
									</p>
								</div>
							</div>
						</div>
						<div align="center">
							<table>
								<tr>
									<td><button type="button" class="btn">Volver</button></td>

									<td>&nbsp;&nbsp;</td>
									<td>
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#exampleModal">Confirmar
											solicitud de atenci�n</button>
									</td>
								<tr>
							</table>
							<br> <br> <br> <br>

						</div>
						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" id="exampleModalLabel">
											<strong>Confirmaci�n de Solicitud Podol�gica</strong>
										</h4>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<p style="text-align: justify;">
											<strong><span style="color: red;">*</span> Monto
												Atenci�n: $ {{presupuesto.totalConDescuento | number}} <br>
												<span style="color: red;">*</span> Horario Atenci�n:
												{{horarioSeleccionado.hora}} -
												{{horarioSeleccionado.horaFin}} <br> <span
												style="color: red;">*</span> Fecha Atenci�n:
												{{horarioSeleccionado.fecha}} <br> <span
												style="color: red;">*</span> La foto subida al Sistema debe
												coincidir con la Patolog�a seleccionada.</strong>
										</p>
									</div>
									<div class="modal-footer" align="left">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancelar</button>
										<button type="submit" class="btn btn-primary">Si,
											estoy de acuerdo</button>
									</div>
								</div>
							</div>
						</div>

					</form:form>

					<!-- /.row -->
				</div>
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
	<script type="text/javascript"
		src="${contextPath}/resources/js/angular/angular.js"></script>
	<script type="text/javascript"
		src="${contextPath}/resources/js/angular/controller/controller.js"></script>


	<script type="text/javascript">
		function checkSize() {
			max_img_size = 5242880;
			var input = document.getElementById("idFotoPiePaciente");

			if (input.files && input.files.length == 1) {
				if (input.files[0].size > max_img_size) {
					var mb = max_img_size / 1024;
					mb = mb / 1024;
					alert("La imagen subida del pie no puede superar los "
							+ (mb) + "MB");
					return false;
				}
			}

			return true;
		}
	</script>
</body>

</html>
