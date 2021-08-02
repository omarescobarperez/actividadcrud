<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Listado de peliculas</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<a href="${context}/views/peliculas/register.jsp" class="btn btn-outline-success"><i class="fas fa-plus"></i> Agregar Pelicula</a>
<table class="table">
    <thead class="table-dark">
    <tr>
        <th>No.</th>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Fecha Estreno</th>
        <th>Recaudacion</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ listPeliculas }" var="peliculas" varStatus="status">
        <tr>
            <td>${ status.count }</td>
            <td>${ peliculas.nombre }</td>
            <td>${ peliculas.descripcion }</td>
            <td>${ peliculas.fechaEstreno }</td>
            <td>${ peliculas.recaudacion }</td>
            <td>
                <c:if test="${ peliculas.status == 1 }">
                    <span class="badge rounded-pill bg-success">Activo</span>
                </c:if>
                <c:if test="${ peliculas.status == 0 }">
                    <span class="badge rounded-pill bg-danger">Inactivo</span>
                </c:if>
            </td>
            <td>
                <c:if test="${ peliculas.status == 1 }">
                    <form action="${context}/getMovieById" method="POST" style="display: inline;">
                        <input type="hidden" name="action" value="getMovieById">
                        <input type="hidden" name="id" value="${ peliculas.id }">
                        <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
                    </form>
                    <button id="btn-delete-${ status.count }" data-code="${ peliculas.id }" data-text="${ peliculas.nombre }" type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Eliminar</button>
                </c:if>
                <c:if test="${ peliculas.status == 0 }">
                    <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#details"><i class="fas fa-info-circle"></i> Detalles </button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%-- MODAL --%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${context}/deleteMovie" method="POST">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" id="id">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Eliminar Pelicula</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label>¿Deshabilitar?</label>
                    <h5 id="text-delete"></h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="details" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Detalles de la pelicula</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h5>Nombre</h5>
                <label>${peliculas.nombre}</label>
                <br>
                <h5>Descripcion:</h5>
                <label>${peliculas.descripcion}</label>
                <br>
                <h5>Fecha de estreno:</h5>
                <label>${peliculas.fechaEstreno}</label>
                <br>
                <h5>Recaudacion:</h5>
                <label>${peliculas.fechaRecaudacion}</label>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
            </div>
        </div>
    </div>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>
</body>
</html>