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
                         <form method="POST" action="${contextPath}/recuperarclave" id="actionForm">
                         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                         <center><div class="loader" style="display: none;" id="loader"></div></center>
                         <div class="form-group ${error != null ? 'has-error' : ''}" id="formbody">
                            <fieldset>

                            <c:choose>
							<c:when test="${exito != null}">
								<center><h4>${exito}</h4><br></center>
								<br> <center><a href="${contextPath}">Volver al Inicio</a></center>
							</c:when>
							<c:otherwise>
								<center><h2>Cambia tu contraseña</h2></center>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Ingresa tu contraseña" name="pass" type="password" required="required">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Re-Ingresa tu contraseña" name="pass2" type="password" required="required">
                                </div>
                                <button type="submit" class="btn btn-lg btn-primary btn-block">Cambiar Clave</button>
								    <p class="text-danger" align="center">${error}</p>
<%-- 							    <center><div id="loadingEnvio" style="display: none;"> --%>
<%-- 							    <br><img style="width:130px; height:90px; align:center;" src="<c:url value="/resources/gif/ajax-loader.gif" />" /></br>Procesando...</div></center> --%>
							    <br>
                            	<br> <center><a href="/">Volver al Inicio</a></center>
							</c:otherwise>
							</c:choose>


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
	<script type="text/javascript">
    function onSubmit() {
    	$("#formbody").hide();
		$("#loader").show();
        document.getElementById("actionForm").submit();
      }
	</script>
</body>

</html>
