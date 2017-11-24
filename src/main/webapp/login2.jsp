<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title></title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
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
          <div class="form-group">
            <label for="exampleInputEmail1">Email</label>
            <input class="form-control" type="email" id="mail" name="login.mail" aria-describedby="emailHelp" placeholder="usuario@dominio.com" required autofocus>             
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" id="inputPassword" name="login.password" class="form-control" placeholder="Contraseña" required>
          </div>
          
          <button class="btn btn-lg btn-primary btn-block btn-signin"
          type="submit">Iniciar sesi&oacute;n</button>
        </form>
        <div class="text-center">
          <a href="<s:url action="showRegisterForm"/>" class="forgot-password">
                ¿A&uacute;n no eres usuario?
            </a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
