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
	<a href="<s:url action="showAddProducto" namespace="/socios" />"
		class="btn btn-default"> Agregar Producto </a>
</s:if>



<p>Productos!!</p>

<br>
<br>
<table class="table">
	<thead>
		<tr>
			<th>Producto</th>
			<th>Descripción</th>
			<th>Distribuidor</th>
			<th>Stock</th>

			<s:if test="admin">
				<th>Editar</th>
				<th>Eliminar</th>
			</s:if>
		</tr>
	</thead>
	<s:iterator value="productos" var="producto">

		<tbody>
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="descripcion" /></td>
				<td><s:property value="distribuidor.nombre" /></td>
				<td><s:property value="stock" /></td>
				<s:if test="#session.isAdmin">

					<td><a
						href="<s:url action="showProductoForm" namespace="/socios">
							<s:param name="distribuidorId">${producto.id}</s:param>
						</s:url>">Editar</a></td>
					<td><a
						href="<s:url action="deleteProducto" namespace="/socios">
							<s:param name="distribuidorId">${producto.id}</s:param>
						</s:url>">Eliminar</a></td>
				</s:if>
			</tr>

		</tbody>
	</s:iterator>
</table>
