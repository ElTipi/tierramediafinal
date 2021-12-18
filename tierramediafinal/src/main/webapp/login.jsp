<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

<!-- vinculo a la hoja de estilos donde se define el fondo-->
<link rel = "stylesheet" href="assets/stylesheets/background.css" type="text/css">
</head>

<body>

	<jsp:include page="partials/nav.jsp"></jsp:include>
	<!-- <jsp:include page="partials/body.jsp"></jsp:include> -->
	<main class="container">
		<div class="bg-ligth p-4 rounded">
			<h1>
				¡Bienvenido, <c:out value="${user.username}" />!
			</h1>
			
		</div>
	</main>
</body>
</html>
