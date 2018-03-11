<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cuido mis pies - Login</title>
	<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
	<link rel="apple-touch-icon" sizes="57x57" href="/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
	<link rel="manifest" href="/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">	
    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style type="text/css">
		.loader {
		    border: 16px solid #f3f3f3; /* Light grey */
		    border-top: 16px solid #3498db; /* Blue */
		    border-radius: 50%;
		    width: 120px;
		    height: 120px;
		    animation: spin 2s linear infinite;
		}
			
		@keyframes spin {
		    0% { transform: rotate(0deg); }
		    100% { transform: rotate(360deg); }
		}
	</style>
	<script type="text/javascript">
	function ingresar() {
		$("#formbody").hide();
		$("#loader").show();
		$("#loginform").submit();
	}
	</script>
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" style="background-color: #286090;">
                    	<img src="${contextPath}/resources/img/logo2.png" class="img-responsive" style="width: 360px;">
                        <h1 class="panel-title" style="margin-top: -16px;"></h1>
                    </div>
                    <div class="panel-body">
                         <form method="POST" action="${contextPath}/login" name="loginForm" id="loginform">
                         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                         <center><div class="loader" style="display: none;" id="loader"></div></center>
                         <div class="form-group ${error != null ? 'has-error' : ''}" id="formbody">
                            <fieldset>
                            
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" required="required">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="" required="required">
                                </div>
                                <div class="form-group" align="center">
                                    <a href="${contextPath}/forgot" style="text-align: center;">Olvidé mi contraseña</a>
                                </div>
                                <p class="text-success" align="center">${mensaje}</p>
                                <p class="text-danger" align="center">${error}</p>

                                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="ingresar()">Ingresar</button>
                                <br>
                                <br>
                                <br>
                                <div class="form-group">
	                            	<button class="btn btn-lg btn-success btn-block" onclick="location.href='${contextPath}/registrarPaciente';" type="button" >¿Paciente nuevo?</button>
	                                <button class="btn btn-lg btn-info btn-block" onclick="location.href='${contextPath}/solicitud';" type="button">¿Registrarte como podólogo?</button>	
                            	</div>
                            	<br> <center><a href="/">Volver al Inicio</a></center>
                            </fieldset>
                          </div>
                        </form>
                    </div>
                </div>
                
            </div>
            
        </div>
    </div>

    <!-- jQuery -->
    <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
