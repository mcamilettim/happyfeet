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
					<span class="sr-only">Navegaci�n</span> <span class="icon-bar"></span>
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
						<li><a href="#"> <strong></strong> <span
								class="pull-right text-muted"> <em>Ahora</em>
							</span> Sin mensajes nuevos.
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center"
							href="${contextPath}/paciente/vermensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-messages --></li>

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
										<img src="${contextPath}/resources/imagenes/${paciente.foto}"
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
								class="fa fa-dashboard fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/paciente/quizPatologia"><i
								class="fa fa-edit fa-fw"></i> Pedir hora!</a></li>
						<li><a href="${contextPath}/paciente/modificarDatos"><i
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
				<div class="row">
					<div class="col-lg-12">
						<h2 class="page-header">
							<c:if test="${mensaje != null}">
								<div class="alert alert-success alert-dismissable">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">�</button>
									${mensaje}
								</div>
							</c:if>
							<c:if test="${mensajeError != null}">
								<div class="alert alert-danger alert-dismissable">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">�</button>
									${mensajeError}
								</div>
							</c:if>
							Bienvenid<c:if test="${paciente.paramSexo.id==6}">o</c:if><c:if test="${paciente.paramSexo.id==7}">a</c:if>
						</h2>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>

			<div class="col-lg-3 col-md-6">
				<a href="${contextPath}/paciente/quizPatologia">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-edit fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">Pedir Hora!</div>
									<div></div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<span class="pull-left">Solicita una hora con un
								especialista</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>

					</div>
				</a>
			</div>

			<div class="col-lg-3 col-md-6">
				<a href="${contextPath}/paciente/modificarDatos">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-gear fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">Mis datos</div>
									<div></div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<span class="pull-left">Modifica tus datos</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>

					</div>
				</a>
			</div>

			<div class="col-lg-3 col-md-6">
				<a href="${contextPath}/paciente/misatenciones">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-gear fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">Atenciones</div>
									<div></div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<span class="pull-left">Revisa el historial de tus
								atenciones</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>

					</div>
				</a>
			</div>

			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

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

</body>

</html>
