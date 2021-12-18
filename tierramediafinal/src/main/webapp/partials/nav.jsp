<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- bg-dark -->
<nav class="navbar navbar-expand-md navbar-dark mb-4"
	Style="background-color: #5E5846;">
	<div class="container">
		<!-- <a class="navbar-brand" href="/tierramediafinal/index.jsp">Turismo en la Tierra Media</a>
		 -->
		<a class="navbar-brand" style="margin-left: 5%" href="#"> <img
			src="http://www.estudiodproducciones.com.ar/tierramedia/img/logotipo-blanco.png" width="200px">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse"
			style="text-align: right">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/tierramediafinal/attractions/index.do">Atracciones</a></li>


				<!-- LINK MENU MI ITINERARIO -->
				
				<c:if test="${!user.isAdmin()}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/tierramediafinal/itinerario/index.do">Mi itinerario</a></li>
				</c:if>

				<c:if test="${user.isAdmin()}">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/tierramediafinal/users/index.do">Usuarios</a></li>
				</c:if>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${user.username}"></c:out>
				</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="monedas" style="color: gold;" class="bi bi-coin"></i>
								<c:out value="${user.coins}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
								<c:out value="${user.time}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/tierramediafinal/logout" class="dropdown-item">Salir</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

<c:if test="${success != null}">
	<div class="alert alert-success">
		<p>
			<c:out value="${success}" />
		</p>
	</div>
</c:if>
