<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="input-group">
	<h3>Registro de Distribuidor</h3>
	<s:form action="distribuidor" namespace="/socios" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="distribuidor.nombre" class="form-control" placeholder="Nombre"></s:textfield>
		<%-- Procesamiento del catalogo de generos como un select --%>
		<label>Dirección</label>
		<s:textfield name="distribuidor.address.numero" class="form-control" placeholder="numero"></s:textfield>
		<s:textfield name="distribuidor.address.calle" class="form-control" placeholder="calle" ></s:textfield>
		<s:textfield name="distribuidor.address.colonia" class="form-control" placeholder="colonia" ></s:textfield>

	
		<br/> 
		<button class="btn btn-primary"
			type="submit">Registrar Distribuidor</button>
	</s:form>			
</div><!-- /card-container -->