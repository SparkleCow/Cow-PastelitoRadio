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




