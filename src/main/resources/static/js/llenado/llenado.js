
function eliminarLlenado(idLlenado){
    Swal.fire({
        title: '¿Seguro de cancelar la encuesta en proceso de llenado?',
        icon: "warning",
        text: "Los datos relacionados con el llenado se eliminarán",
        type: 'info',
        showCancelButton: true,
        confirmButtonText: 'Aceptar',
        cancelButtonText: 'Cancelar'
        }).then((result) => {
        if (result.value) {
            location.href = '/llenado/eliminar/' + idLlenado;
        }
    });
}

function submitform()
    {
      document.forms["formPreguntas"].submit();
      
    }
