$("#btnModalSelect").addEventListener("click",function(){
    var id = "input-" + Math.floor(Math.random() * 999999);
    var input = document.createElement("input");
    input.setAttribute("type","text");
    input.setAttribute("class","form-control");
    input.setAttribute("placeholder","Respuesta");
    input.setAttribute("name","respuesta")
    input.id =id;
    crearBtnEliminarS(id);    
    $("#divModal").appendChild(input);
})

function $(selector){
    return document.querySelector(selector);
}

function crearBtnEliminarS(idEl){
    var id = "btn-" + Math.floor(Math.random() * 999999);

    var btn = document.createElement('a');
    btn.setAttribute("type","button");
    btn.setAttribute("class","close float-right");
    btn.id=id;
    btn.setAttribute('onclick','eliminarElementoS("'+idEl+'" ,"'+id+'" )');
    //crear_enlace.setAttribute('th:attr','onclick=|eliminarElemento("'+idEl+'" )|');
    btn.innerHTML = "&times";
    $("#divModal").appendChild(btn);

}

function eliminarElementoS(id_elemento, idBtn){
    elementoEliminar = document.getElementById(id_elemento);
    link_eliminar = document.getElementById(idBtn);
    if (elementoEliminar){
        elementoPadre = document.getElementById("divModal");
        elementoPadre.removeChild(elementoEliminar);

        elementoPadreLink = link_eliminar.parentNode;
		elementoPadreLink.removeChild(link_eliminar);        
    } else {
        alert("El elemento selecionado no se puede eliminar");
    }
}

function eliminarPregunta(idPregunta){
    Swal.fire({
        title: '¿Seguro de eliminar la pregunta?',
        icon: "warning",
        text: "Los datos relacionados con la pregunta se eliminarán",
        type: 'info',
        showCancelButton: true,
        confirmButtonText: 'Aceptar',
        cancelButtonText: 'Cancelar'
        }).then((result) => {
        if (result.value) {
            location.href = '/pregunta/eliminar/' + idPregunta;
        }
    });
}

function editarPregunta(idPregunta, titulo, descripcion){
   // location.href = '/cuestionario/editar/' + idPregunta
   var modalPregunta = document.getElementById("btn_editar_seleccion");   
    //$("#formModalSelect").attr('action',  '/cuestionario/editar/' + idPregunta);
    $("#titulo").val(titulo);
    $("#descripcion").val(descripcion);
    modalPregunta.setAttribute("data-target","seleccion")
    $('.selectpicker').selectpicker('refresh')   
 
}



