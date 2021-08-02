<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Registrar Pelicula | TCine</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<h1>Registrar Pelicula</h1>
<form action="${context}/createMovies" method="POST">
    <input type="hidden" value="create" name="action">
    <label>Nombre:</label>
    <input class="form-control" type="text" name="nombre" />
    <br>
    <label>Descripcion:</label>
    <input class="form-control" type="text" name="descripcion" />
    <br>
    <label>Fecha de Estreno:</label>
    <input class="form-control" type="text" name="fechaEstreno" />
    <br>
    <label>Recaudacion:</label>
    <input class="form-control" type="number" name="recaudacion" />
    <br>

    <button type="button" class="btn btn-secondary"><i class="fas fa-times"></i> Cancelar</button>
    <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Agregar</button>
</form>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>