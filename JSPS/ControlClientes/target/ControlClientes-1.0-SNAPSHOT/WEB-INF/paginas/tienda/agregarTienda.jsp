<div class="modal fade" id="agregarTiendaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">
                    AgregarTienda
                </h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/TiendaControlador?accion=insertarTienda" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required />

                        <label for="calle">Calle</label>
                        <input type="text" class="form-control" name="calle" required />

                        <label for="telefono">Telefono</label>
                        <input type="text" class="form-control" name="telefono" required />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar Tienda
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>