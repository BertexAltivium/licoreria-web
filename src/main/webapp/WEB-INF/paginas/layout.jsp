<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<link href="../css/login-styles.css" rel="stylesheet">
<link href="../css/bootstrap-3.3.7.min.css" rel="stylesheet">
<script src="../js/bootstrap-3.3.7.min.js"></script>
</head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Licoreria en L&iacute;nea</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url action="showInicio" namespace="/socios"/>">Home</a></li>
					<s:if test="admin">
						<li><a
							href="<s:url action="showAddLicorForm" namespace="/socios"/>">Agregar
								Licor</a></li>

					</s:if>

					<li><a
						href="<s:url action="showSucursalList" namespace="/socios"/>">Sucursales</a></li>
					<li><a
						href="<s:url action="showDistribuidores" namespace="/socios"/>">Distribuidores</a></li>



					<s:if test="logged">
						<li><a
							href="<s:url action="showCambioPasswdForm" namespace="/socios"/>">Cambio
								contraseña</a></li>
					</s:if>
					<s:if test="logged">
						<li><a href="<s:url action="logout" namespace="/socios"/>">Cerrar
								Sesi&oacute;n</a></li>
					</s:if>
					<s:if test="!logged">
						<li><a href="<s:url action="logout" namespace="/socios"/>">Iniciar
								Sesi&oacute;n</a></li>
					</s:if>


				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>
		<!-- Contenido de la página -->
		<tiles:insertAttribute name="body" />
		<!-- Fin contenido de la página -->
	</div>
	<!-- /container -->
</body>
</html>