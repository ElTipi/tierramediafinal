<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Su itinerario en Tierra Media</h1>
		</div>
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Listado de Atracciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itinerario}" var="tmp_itinerario">
					<tr>
						<td><strong><c:out value="${tmp_itinerario.attraction_id}"></c:out></strong></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>