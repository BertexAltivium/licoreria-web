<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Registro de Sucursales</h3>
	<s:form action="sucursal" namespace="/socios" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="sucursal.id" class="form-control" placeholder="ID" type="hidden"></s:textfield>
		<s:textfield name="sucursal.nombre" class="form-control" placeholder="Nombre"></s:textfield>
		<%-- Procesamiento del catalogo de generos como un select --%>
		<label>Dirección</label>
		<s:textfield name="sucursal.address.id" class="form-control" placeholder="ID" type="hidden"></s:textfield>
		<s:textfield name="sucursal.address.numero" class="form-control" placeholder="numero"></s:textfield>
		<s:textfield name="sucursal.address.calle" class="form-control" placeholder="calle" ></s:textfield>
		<s:textfield name="sucursal.address.colonia" class="form-control" placeholder="colonia" ></s:textfield>	
	
	
		<br/> <br/> <br/>
		<button class="btn btn-lg btn-primary btn-block btn-signin"
			type="submit">Registrar</button>
	</s:form>			
</div><!-- /card-container -->