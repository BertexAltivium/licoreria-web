<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- Manejo de mensajes --%>
<s:if test="hasActionMessages()">
	<div class="alert alert-success fade in">
		<a href="#" class="close" data-dismiss="alert">×</a> <strong><s:actionmessage /></strong>
	</div>
</s:if>
<%-- Manejo de mensajes de error --%>
<s:if test="hasActionErrors()">
	<div class="alert alert-warning fade in">
		<a href="#" class="close" data-dismiss="alert">×</a> <strong><s:actionerror /></strong>
	</div>
</s:if>

<h4>Bienvenido ${sessionScope.nombreCompleto}</h4>

<s:if test="admin">
	<a href="<s:url action="showSucursalForm" namespace="/socios" />">
		<button class="btn btn-default">Agregar Sucursal</button>
	</a>
</s:if>



<table class="table">
	<thead>
		<tr>

			<th>Sucursal</th>

			<th>Colonia</th>

			<th>Calle</th>


			<s:if test="admin">

				<th>Editar</th>

				<th>Eliminar</th>

			</s:if>

		</tr>

	</thead>

	<s:iterator value="sucursales" var="sucursal">
		<tr>
			<td><s:property value="nombre" /></td>
			<td><s:property value="address.calle" /></td>
			<td><s:property value="address.colonia" /></td>
			<s:if test="admin">

				<td><a
					href="<s:url action="showSucursalForm" namespace="/socios">
							<s:param name="sucursalId">${sucursal.id}</s:param>
						</s:url>">Editar</a></td>
				<td><a
					href="<s:url action="deleteSucursal" namespace="/socios">
							<s:param name="sucursalId">${sucursal.id}</s:param>
						</s:url>">Eliminar</a></td>
			</s:if>
		</tr>
	</s:iterator>
</table>



