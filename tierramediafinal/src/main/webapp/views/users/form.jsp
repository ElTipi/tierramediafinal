<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mb-3">
	<label for="name" class="col-form-label">Username:</label>
	<input
		type="text" class="form-control" id="name" name="username"
		required value="${tmp_user.username}">
		
</div>

<div class="mb-3">
	<label for="password"
		class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input type="password" class="form-control" id="password" name="password"
		required value="${tmp_user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("password")}'></c:out>
	</div>
</div>


<div class="mb-3">
	<label for="coins"
		class='col-form-label ${tmp_user.errors.get("coins") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="coins" name="coins"
		required value="${tmp_user.coins}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("coins")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="time"
		class='col-form-label ${tmp_user.errors.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="time" name="time"
		required value="${tmp_user.time}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("time")}'></c:out>
	</div>
</div>

<!-- Campo preferencia agregado tipo select-->


<div class="mb-3">
	<label for="name" class="col-form-label">Preferencia:</label>
	<br>
	<select name="preferencia" id="preferencia" class="custom-select"
	required value="${tmp_user.preferencia}" style="width: 175px;
	border-radius: 3px; border-color: #D4D4D4;">
		<option value="Elija una opcion" selected>Elija una opcion</option>
		<option value="AVENTURA">AVENTURA</option>
  		<option value="DEGUSTACION">DEGUSTACION</option>
  		<option value="PAISAJE">PAISAJE</option>
	</select>
</div>


<!-- dropdownMenuButton1   form-group -->

<br><br><br>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
