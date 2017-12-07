<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Registro de Producto</h3>
	<s:form action="altaProducto" namespace="/socios" enctype="multipart/form-data" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="producto.id" class="form-control" placeholder="ID" type="hidden"></s:textfield>
		<s:textfield name="producto.descripcion" class="form-control" placeholder="Descripción" maxlength="45" ></s:textfield>
		<s:textfield name="producto.precio" class="form-control" placeholder="Precio" maxlength="45"></s:textfield>
		<s:textfield name="producto.stock" class="form-control" placeholder="Cantidad" type="number" maxlength="500" ></s:textfield>
		<s:textfield name="producto.presentacion" class="form-control" placeholder="Presentación" maxlength="45"></s:textfield>
		<select name="producto.sucursal.id">
			<!--
			<c:forEach items="${sucursalesString}" var="sucursal" varStatus="loop">
				 <option value="${sucursal}"  <c:if test="${sucursalIdx == loop.index}">selected="selected"</c:if>  >${sucursal}</option>
			</c:forEach> 
			-->
			
			<option value="0">Elige una sucursal</option>
			<c:forEach items="${sucursales}" var="sucursal">
				 <option value="${sucursal.id}">${sucursal.nombre}</option>
			</c:forEach>
			
		</select>
		<select name="producto.distribuidor.id">
			<option value="0">Elige un distribuidor</option>
			<c:forEach items="${distribuidores}" var="distribuidor">
				 <option value="${distribuidor.id}">${distribuidor.nombre}</option>
			</c:forEach> 
		</select>
		<br>
		<label>Datos de Factura</label>
		<s:textfield name="producto.factura.id" class="form-control" placeholder="ID" type="hidden"></s:textfield>
		<s:textfield name="producto.factura.fecha" class="form-control" placeholder="Fecha" type="date" maxlength="45" ></s:textfield>
		<s:textfield name="producto.factura.vendedor" class="form-control" placeholder="Vendedor" maxlength="45" ></s:textfield>
		<s:textfield name="producto.factura.comprador" class="form-control" placeholder="Comprador" maxlength="45" ></s:textfield>

		<s:if test="edit">
			<button class="btn btn-primary" type="submit">Actualiza Producto</button>
		</s:if>
		<s:if test="!edit">
			<button class="btn btn-primary" type="submit">Registra nuevo producto!!!</button>
		</s:if>

	</s:form>			
</div><!-- /card-container -->