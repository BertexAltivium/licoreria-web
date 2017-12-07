<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-4 col-md-4" >
		<img
			src=" <s:url action='ImageAction' namespace="/image" > 
			<s:param name="imageId">${licor.image}</s:param>
			</s:url>"
			alt="" class="img-responsive" />
	</div>
	<div class="col-sm-6 col-md-6">
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
						<td>Marca</td>
						<td>${licor.marca}</td>
					</tr>
					<tr>
						<td>Tipo</td>
						<td>${licor.tipo}</td>
					</tr>
					<tr>
						<td>Edad</td>
						<td>${licor.edad}</td>
					</tr>
					<tr>
						<td>Descripción</td>
						<td>${licor.descripcion}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>



