$("#btnModalMultiple").addEventListener("click",function(){
    var id = "input-" + Math.floor(Math.random() * 999999);
    var input = document.createElement("input");
    //var input = document.getElementById("respuesta");
    //var clon = input.cloneNode(true);
    //clon.id =id;
    //document.getElementById("divModal").appendChild(clon);
    input.setAttribute("type","text");
    input.setAttribute("class","form-control");
    input.setAttribute("placeholder","Respuesta");
    input.setAttribute("name","respuesta")
    input.id =id;
    crearBtnEliminar(id);    
    $("#div_multiple").appendChild(input);
})

function $(selector){
    return document.querySelector(selector);
}

function crearBtnEliminar(idEl){
    var id = "btn-" + Math.floor(Math.random() * 999999);

    var btn = document.createElement('a');
    btn.setAttribute("type","button");
    btn.setAttribute("class","close float-right");
    btn.id=id;
    btn.setAttribute('onclick','eliminarMultiple("'+idEl+'" ,"'+id+'" )');
    //crear_enlace.setAttribute('th:attr','onclick=|eliminarElemento("'+idEl+'" )|');
    btn.innerHTML = "&times";
    $("#div_multiple").appendChild(btn);

}

function eliminarMultiple(id_elemento, idBtn){
    elementoEliminar = document.getElementById(id_elemento);
    link_eliminar = document.getElementById(idBtn);
    if (elementoEliminar){
        elementoPadre = document.getElementById("div_multiple");
        elementoPadre.removeChild(elementoEliminar);

        elementoPadreLink = link_eliminar.parentNode;
		elementoPadreLink.removeChild(link_eliminar);        
    } else {
        alert("El elemento selecionado no se puede eliminar");
    }
}

/*function crearLinkEliminar(div_append, id_elemento){
    id_link = "id_link_"+div_append;			
    var crear_enlace = document.createElement('a');
    crear_enlace.setAttribute('id',id_link);
    //crear_enlace.setAttribute('href','javascript:eliminarElemento("'+id_elemento+'","'+id_link+'");');
    texto_enlace = document.createTextNode('Eliminar');
    crear_enlace.appendChild(texto_enlace);
    document.getElementById(div_append).appendChild(crear_enlace);
}
    var c = document.getElementById("about");
    var clon = c.cloneNode("about");
    clon.style.width = "50px";
    clon.style.height = "50px";
    document.body.appendChild(clon);*/

