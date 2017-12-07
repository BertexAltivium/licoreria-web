<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="card card-container">
	<h3>Registro de Alcohol</h3>
	<s:form action="altaLicor" namespace="/socios" enctype="multipart/form-data" method="POST" class="form-signin">
		<span id="reauth-email" class="reauth-email"></span>
		<s:fielderror/>
		<s:textfield name="licor.id" class="form-control" placeholder="Id" type="hidden"></s:textfield>
		<s:textfield name="licor.nombre" class="form-control" placeholder="Nombre"></s:textfield>
		<s:textfield name="licor.tipo" class="form-control" placeholder="Tipo"></s:textfield>
		<s:textfield name="licor.marca" class="form-control" placeholder="Marca" ></s:textfield>
		<s:textfield name="licor.subtipo" class="form-control" placeholder="Subtipo" ></s:textfield>
		<s:textfield name="licor.denominacion" class="form-control" placeholder="Denominación" ></s:textfield>
		<s:textfield name="licor.contenidoNeto" class="form-control" placeholder="Contenido neto" ></s:textfield>
		
		<s:textarea name="licor.descripcion" class="form-control" placeholder="Description" rows="5" ></s:textarea>
		<s:textfield name="licor.anio" type="number" min="1900" class="form-control" placeholder="año" ></s:textfield>
		<s:file name="userImage" placeholder="Selecciona la imagen a subir" size="40"  class="form-control"/>
		<%-- Procesamiento del catalogo de generos como un select --%>


		<s:if test="edit">
			<button class="btn btn-primary" type="submit">Actualiza Alcohol</button>
		</s:if>
		<s:if test="!edit">
			<button class="btn btn-primary" type="submit">Registra nuevo alcohol!!!</button>
		</s:if>

	</s:form>			
</div><!-- /card-container -->