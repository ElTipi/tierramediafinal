<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="name" name="name"
		required value="${attraction.name}">
</div>

<div class="mb-3">
	<label for="cost"
		class='col-form-label ${attraction.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="cost" name="cost"
		required value="${attraction.cost}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("cost")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="duration"
		class='col-form-label ${attraction.errors.get("duration") != null ? "is-invalid" : "" }'>Duration:</label>
	<input class="form-control" type="number" id="duration" name="duration"
		required value="${attraction.duration}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("duration")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="capacity"
		class='col-form-label ${attraction.errors.get("capacity") != null ? "is-invalid" : "" }'>Capacity:</label>
	<input class="form-control" type="number" id="capacity" name="capacity"
		required value="${attraction.capacity}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("capacity")}'></c:out>
	</div>
</div>


<!--  -->
<div class="mb-3">
	<label for="name" class="col-form-label">Tipo Atraccion:</label>
	<br>
	<select name="tipo_atraccion" id="tipo_atraccion" class="custom-select"
	required value="${tmp_user.tipo_atraccion}" style="width: 175px;
	border-radius: 3px; border-color: #D4D4D4;">
		<option value="Elija una opcion" selected>Elija una opcion</option>
		<option value="AVENTURA">AVENTURA</option>
  		<option value="DEGUSTACION">DEGUSTACION</option>
  		<option value="PAISAJE">PAISAJE</option>
	</select>
</div>
<!--  -->

<!-- bloque de descripcion agregado -->
<div class="mb-3">
	<label for="description" class="col-form-label">Descripcion:</label> <input
		type="text" class="form-control" id="description" name="description"
		required value="${attraction.description}">
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
