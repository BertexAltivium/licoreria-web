<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Registro de Sucursales</h3>
	<s:form action="sucursal" namespace="/socios" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="nombre" class="form-control" placeholder="Nombre"></s:textfield>
		<%-- Procesamiento del catalogo de generos como un select --%>
		<select name="registroSucursal.direccion">
			<option value="0">seleccione una direccion</option>
			<c:forEach items="${direcciones}" var="direccion">
				 <option value="${direccion.id}">${direccion.numero}, ${direccion.calle}, ${direccion.colonia}</option>
			</c:forEach> 
		</select>		
		<br/> <br/> <br/>
		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="submit">Registrar</button>
	</s:form>			
</div><!-- /card-container -->