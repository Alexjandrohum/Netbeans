<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Tiendas</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>No.</th>
                                <th>Nombre</th>
                                <th>Calle</th>
                                <th>Telefono</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la tienda -->
                            <c:forEach var="tienda" items="${tiendas}">
                                <tr>
                                    <td>${tienda.idTienda}</td>
                                    <td>${tienda.nombre}</td>
                                    <td>${tienda.calle}</td>
                                    <td>${tienda.telefono}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/TiendaControlador?accion=editarTienda&idTienda=${tienda.idTienda}"
                                           class="btn btn-secondary">
                                            <i class=" fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregar Tienda Modal -->
<jsp:include page="agregarTienda.jsp"/>