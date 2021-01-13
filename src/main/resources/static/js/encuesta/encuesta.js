$(document).ready(function(){
    $("#formSeccion").attr('action', '/encuesta/save');
    $('.selectpicker').selectpicker('refresh')
});


function eliminarEncuesta(idEncuesta){
    Swal.fire({
        title: '¿Seguro de eliminar la Encuesta?',
        icon: "warning",
        text: "Los datos relacionados con la Encuesta se eliminarán",
        type: 'info',
        showCancelButton: true,
        confirmButtonText: 'Aceptar',
        cancelButtonText: 'Cancelar'
        }).then((result) => {
        if (result.value) {
            location.href = '/encuesta/eliminar/' + idEncuesta;
        }
    });
}


function btnLimpiarEncuesta(){
    $("#formEncuesta").attr('action', '@{/encuesta/save}');
    $("#nombre").val("");
    $("#codigo").val("");
    $("#descripcion").val("");
    $('.selectpicker').selectpicker('refresh')
    $("#btnAccionSeccion").html('Guardar');
}