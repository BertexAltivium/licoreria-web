<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<img src=" <s:url action='ImageAction' namespace="/image" > 
	<s:param name="imageId">${licor.image}</s:param>
	</s:url>" alt="" />

<div class="table-responsive">

	<table class="table">

		<tbody>
			<tr>
				<td>Nombre</td>
				<td>${licor.nombre}</td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td>${licor.tipo}</td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td>${licor.tipo}</td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td>${licor.tipo}</td>
			</tr>
		</tbody>
	</table>
</div>