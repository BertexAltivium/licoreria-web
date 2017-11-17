<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<link href="css/login-styles.css" rel="stylesheet">
	<link href="css/bootstrap-3.3.7.min.css" rel="stylesheet">
	<script src="js/bootstrap-3.3.7.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<h3>Ingresa tus datos</h3>
			<form action="<s:url action="registro" namespace="/"/>" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				<s:fielderror/>
				<s:textfield name="usuario.email" class="form-control" placeholder="usuario@dominio.com" />
				<s:textfield name="usuario.nombre" class="form-control" placeholder="Nombre" />
				<s:textfield name="usuario.apPaterno" class="form-control" placeholder="Apellido paterno" />
				<s:textfield name="usuario.apMaterno" class="form-control" placeholder="Apellido materno" />
				<s:password name="usuario.password" class="form-control" placeholder="Contraseña" />
				<s:password name="passwordConfirn" class="form-control"  placeholder="Confirmación" />
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Crear cuenta</button>
			</form>		
		</div><!-- /card-container -->
	</div><!-- /container -->
</body>
</html>
