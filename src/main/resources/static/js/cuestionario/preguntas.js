$("#btnModalSelect").addEventListener("click",function(){
    id = "id_input";
    var input = document.createElement("input");
    input.setAttribute("type","text");
    input.setAttribute("class","form-control");
    input.setAttribute("placeholder","Respuesta");
    input.id =id;
    crearBtnEliminar(id);

    $("#divModal").appendChild(input);
})

function $(selector){
    return document.querySelector(selector);
}



function crearBtnEliminar(idEl){
    id = "id_btn";			
    var btn = document.createElement('a');
    btn.setAttribute("type","button");
    btn.setAttribute("class","close float-right");
    btn.id=id;
    btn.setAttribute('onclick','eliminarElemento("'+idEl+'" ,"'+id+'" )');
    //crear_enlace.setAttribute('th:attr','onclick=|eliminarElemento("'+idEl+'" )|');
    btn.innerHTML = "&times";
    $("#divModal").appendChild(btn);

}

function crearLinkEliminar(div_append, id_elemento){
    id_link = "id_link_"+div_append;			
    var crear_enlace = document.createElement('a');
    crear_enlace.setAttribute('id',id_link);
    //crear_enlace.setAttribute('href','javascript:eliminarElemento("'+id_elemento+'","'+id_link+'");');
    texto_enlace = document.createTextNode('Eliminar');
    crear_enlace.appendChild(texto_enlace);
    document.getElementById(div_append).appendChild(crear_enlace);
}

function eliminarElemento(id_elemento, idBtn){
    elementoEliminar = document.getElementById(id_elemento);
    link_eliminar = document.getElementById(idBtn);
    if (elementoEliminar){
        elementoPadre = elementoEliminar.parentNode;
        elementoPadre.removeChild(elementoEliminar);

        elementoPadreLink = link_eliminar.parentNode;
		elementoPadreLink.removeChild(link_eliminar);        
    } else {
        alert("El elemento selecionado no existe, \nno se pudo eliminar.");
    }
}