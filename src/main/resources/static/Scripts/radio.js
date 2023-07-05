cargarCanciones();

async function cargarCanciones(){
    const response = await fetch("http://localhost:8080/api/songs", {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });

    const content = await response.json();
    let respuestaCanciones = "";
    for(let song of content){
        let stringHTML = `<a href=${song.urlCancion} target="_blank"><div class="card"><img src=${song.urlImagen} /><div class="card-cuerpo"><p>${song.nombreArtista} - ${song.nombreCancion}.</p></div></div></a>`
        respuestaCanciones+=stringHTML;
    }
    
    let componente = document.getElementById("galeriaCard");
    componente.innerHTML = respuestaCanciones;
}

function direccionarCanciones(url){
  window.open(url);
}

function funcionLogueo(url){
  var token = obtenerValorDeCookie("token");
  if(token){
    alert("Ya te has logueado :D")
    return;
  }
  window.location.href=url;
}

function obtenerValorDeCookie(nombre) {
  var cookies = document.cookie.split(";");
  for (var i = 0; i < cookies.length; i++) {
    var cookie = cookies[i].trim();

    if (cookie.startsWith(nombre + "=")) {
      return cookie.substring(nombre.length + 1);
    }
  }
  return null;
}


