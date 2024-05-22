document.getElementById('almacen').addEventListener('change', function () {
    var almacenSeleccionado = this.value;
    var selectUbicacion = document.getElementById('ubicacion');

    // Limpia las opciones existentes
    selectUbicacion.innerHTML = '';

    // Realiza una solicitud AJAX al servidor para obtener las ubicaciones del almacén seleccionado
    fetch('/obtenerUbicaciones?almacen=' + almacenSeleccionado)
        .then(response => response.json())
        .then(ubicaciones => {
            // Añade una opción por cada ubicación
            ubicaciones.forEach(ubicacion => {
                var option = document.createElement('option');
                option.value = ubicacion;
                option.text = ubicacion;
                selectUbicacion.add(option);
            });
        });
});


document.getElementById('tipoProducto').addEventListener('change', function () {
    // Ocultar todos los formularios
    document.getElementById('formularioQuimico').style.display = 'none';
    document.getElementById('formularioMaterial').style.display = 'none';
    document.getElementById('formularioProductoAuxiliar').style.display = 'none';

    // Mostrar el formulario correspondiente
    if (this.value === 'quimico') {
        document.getElementById('formularioQuimico').style.display = 'block';
    } else if (this.value === 'material') {
        document.getElementById('formularioMaterial').style.display = 'block';
    } else if (this.value === 'productoAuxiliar') {
        document.getElementById('formularioProductoAuxiliar').style.display = 'block';
    }
});
