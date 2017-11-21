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

<p>Licores!!</p>

<br>
<br>
<table class="table">
	<thead>
		<tr>
			<th>Licor</th>
			<th>Marca</th>
			<s:if test="admin">
				<th>Editar</th>
				<th>Eliminar</th>
			</s:if>
		</tr>
	</thead>
	<s:iterator value="licores" var="licor">

		<tbody>
			<tr>
				<td><s:property value="tipo" /></td>
				<td><s:property value="marca" /></td>
				<s:if test="admin">

					<td><a
						href="<s:url action="showEditLicorForm" namespace="/socios">
							<s:param name="licorId">${licor.id}</s:param>
						</s:url>">Editar</a></td>
					<td>Eliminar</td>
				</s:if>
			</tr>

		</tbody>
	</s:iterator>
</table>


