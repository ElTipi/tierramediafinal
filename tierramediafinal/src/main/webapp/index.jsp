<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

<!-- VINCULO A HOJA E ESTILOS PERSONALLIZADA -->
<link rel = "stylesheet" href="css/navbar.css" type="text/css"> 
</head>

<body style="font-family: Open Sans; color: #333333;">

<!-- BARRA DE NAVEGACIÓN (MAIN MENU) SUPERIOR -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top"
		style=" font-size: 18px; background-color: rgba(94, 88, 70, 0.9);">
		<div class="container">
			<a class="navbar-brand" style="margin-left: 5%" href="#"> 
			<img src="assets/img/logotipo-blanco.png" width="200px">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<div style="padding-right:4%; text-align:right; padding-left:75%;"> <!-- ???????????????????? padding-left -->
					<ul class="navbar-nav">
					
					
					<!-- QUE CONVIENE HACER PARA DESPEGAR EL LOGO DE LOS MENÚ, ALINENANDO EL MENÚ A LA DERECHA Y EL LOGO A LA IZQUIERDA???? -->
						<li class="nav-item"><a class="nav-link"
						aria-current="page" href="#">HOME</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#form-login">LOGIN</a>
						</li>
						<!-- <li class="nav-item"><a class="nav-link" href="#">CLIENTE</a>
						</li> -->
					</ul>
					
				</div>
			</div>
		</div>
	</nav>
	<!-- Fin BARRA DE NAVEGACION SUPERIOR -->

<!-- CARRUSEL / SLIDE -->
	<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  
  <div class="carousel-inner">
    <div class="carousel-item active">
	
	<!-- En los TAGs <img> cambié h-100 por w-100 para que tome la altura de la imagen, 
	pero me genera un margen izquierdo y derecho. Además quisiera que se muestre el centro de la imagen en cualquier dispositivo -->
      <img src="assets/img/carrusel01.jpg" class="d-block h-100" w-100 alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h3></h3>
        <p></p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="assets/img/carrusel02.jpg" class="d-block h-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h3></h3>
        <p></p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="assets/img/carrusel03.jpg" class="d-block h-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h3></h3>
        <p></p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	 <!-- Fin Carrusel -->

	<div class="col-lg-5 mx-auto p-5 py-md-5" id="form-login" style="background-color: #DBD3C3; margin: 5% 0; font-color: #777777">

		<main>
			<h4>Ingrese sus datos</h4>


			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">

				<div class="mb-3">
					<label for="username" class="form-label">Usuario</label>
					<input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2" style="margin-top: 70px; padding: 0 auto">
					<button type="submit" class="btn btn-lg btn-light">Ingresar</button>
				</div>
			</form>

		</main>
	</div>
</body>
<footer><jsp:include page="partials/footer.html"></jsp:include></footer>
</html>