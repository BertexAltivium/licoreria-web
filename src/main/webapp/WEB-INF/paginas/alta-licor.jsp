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
		<s:textfield name="licor.image" class="form-control" placeholder="Image" type="hidden"></s:textfield>
		<s:textfield name="licor.nombre" class="form-control" placeholder="Nombre" maxlength="45"></s:textfield>
		

		<select name="licor.tipo" class="form-control" >
			<c:forEach items="${licorTypes}" var="licorType" varStatus="loop">
				 <option value="${licorType}"  <c:if test="${licorTypeIdx == loop.index}">selected="selected"</c:if>  >${licorType}</option>
			</c:forEach> 
		</select>
		<s:textfield name="licor.marca" class="form-control" placeholder="Marca" maxlength="45" ></s:textfield>
		<s:textfield name="licor.subtipo" class="form-control" placeholder="Subtipo" maxlength="45" ></s:textfield>
		<s:textfield name="licor.edad" class="form-control" placeholder="Edad" maxlength="45"></s:textfield>
		<s:textfield name="licor.contenidoNeto" class="form-control" placeholder="Contenido neto" ></s:textfield>
		<s:textarea name="licor.descripcion" class="form-control" placeholder="Descripción" rows="5" maxlength="500" ></s:textarea>
		<s:textfield name="licor.anio" type="number" min="1900" class="form-control" placeholder="año" ></s:textfield>
		<s:file name="userImage" placeholder="Selecciona la imagen a subir" size="40"  class="form-control"/>

		<s:if test="edit">
			<button class="btn btn-primary" type="submit">Actualiza Alcohol</button>
		</s:if>
		<s:if test="!edit">
			<button class="btn btn-primary" type="submit">Registra nuevo alcohol!!!</button>
		</s:if>

	</s:form>			
</div><!-- /card-container -->