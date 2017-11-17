<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Registro de libro</h3>
	<s:form action="altalibro" namespace="/socios" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="libro.isbn" class="form-control" placeholder="ISBN"></s:textfield>
		<s:textfield name="libro.titulo" class="form-control" placeholder="Título" ></s:textfield>
		<%-- Procesamiento del catalogo de generos como un select --%>
		<select name="idGeneroSeleccionado">
			<c:forEach items="${generos}" var="genero">
				 <option value="${genero.id}">${genero.nombre}</option>
			</c:forEach> 
		</select>
		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="submit">Registrar libro</button>
	</s:form>			
</div><!-- /card-container -->