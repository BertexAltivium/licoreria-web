<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Actualizacion de Alcohol</h3>
	<s:form action="editLicor" namespace="/socios" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="licor.id" class="form-control" placeholder="ID"></s:textfield>
		
		<s:textfield name="licor.tipo" class="form-control" placeholder="Tipo"></s:textfield>
		<s:textfield name="licor.marca" class="form-control" placeholder="Marca" ></s:textfield>
		<s:textfield name="licor.subtipo" class="form-control" placeholder="Subtipo" ></s:textfield>
		<s:textfield name="licor.denominacion" class="form-control" placeholder="Denominación" ></s:textfield>
		<s:textfield name="licor.contenidoNeto" class="form-control" placeholder="Contenido neto" ></s:textfield>
		<s:textfield name="licor.anio" type="number" min="1900" class="form-control" placeholder="año" ></s:textfield>
		
		<%-- Procesamiento del catalogo de generos como un select --%>

		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="submit">Actualiza el Alcohol!!</button>
	</s:form>			
</div><!-- /card-container -->