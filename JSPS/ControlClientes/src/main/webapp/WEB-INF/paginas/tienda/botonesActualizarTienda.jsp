<section id="actionsTienda" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/TiendaControlador" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Actualizar Tienda
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/TiendaControlador?accion=eliminarTienda&idTienda=${tienda.idTienda}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar Tienda
                </a>
            </div>
        </div>
    </div>
</section>
