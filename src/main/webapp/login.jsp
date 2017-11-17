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
			<img id="profile-img" class="profile-img-card"
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			<%-- Manejo de mensajes --%>
			<s:if test="hasActionMessages()">
				<div class="alert alert-success fade in">
					<a href="#" class="close" data-dismiss="alert">×</a> 
			      	<strong><s:actionmessage/></strong>
			   	</div>
			</s:if>
			<%-- Verificación de la existencia de algun error generado en el controlador y
				 registrado a través de la función addActionError 
			--%>
			<s:if test="hasActionErrors()">
   				<div class="alert alert-warning fade in">
					<a href="#" class="close" data-dismiss="alert">×</a> 
      				<strong><s:actionerror/></strong>
   				</div>
			</s:if>
			<form action="<s:url action="login" namespace="/"/>" method="POST" class="form-signin">
				<span id="reauth-email" class="reauth-email"></span>
				 <input type="email" id="mail" name="login.mail" class="form-control" placeholder="usuario@dominio.com" required autofocus> 
				 <input type="password" id="inputPassword" name="login.password" class="form-control" placeholder="Contraseña" required>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Iniciar sesi&oacute;n</button>
			</form><!-- /form -->
			 <a href="<s:url action="showRegisterForm"/>" class="forgot-password">
                ¿A&uacute;n no eres usuario?
            </a>
		</div><!-- /card-container -->
	</div><!-- /container -->
</body>
</html>
