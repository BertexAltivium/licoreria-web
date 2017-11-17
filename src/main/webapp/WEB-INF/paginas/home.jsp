<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- Manejo de mensajes --%>
<s:if test="hasActionMessages()">
	<div class="alert alert-success fade in">
		<a href="#" class="close" data-dismiss="alert">×</a> 
      	<strong><s:actionmessage/></strong>
   	</div>
</s:if>
<%-- Manejo de mensajes de error --%>
<s:if test="hasActionErrors()">
	<div class="alert alert-warning fade in">
		<a href="#" class="close" data-dismiss="alert">×</a> 
      	<strong><s:actionerror/></strong>
   	</div>
</s:if>
<h4>Bienvenido ${sessionScope.nombreCompleto}</h4>
	
<%--  
	Validación del tipo de usuario que inicio sesión. Si la bandera 
	isAdmin es igual a true, se mostrará el menú de acciones de 
	administrador. 
--%>


<p>Búsqueda en el catálogo de libros</p>