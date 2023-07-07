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
        let stringHTML = `<tr>
        <td><a href=${song.urlCancion}><i class="fa-solid fa-play"></i><a/></td>
        <td>
            <div class="title-content">
                <img src=${song.urlImagen} alt="Imagen de la canción" style="width: 50px;">
                <p>${song.nombreArtista}</p>
            </div>
        </td>
        <td>${song.nombreCancion}</td>
        <td>${song.genero}</td>
    </tr>` 
        respuestaCanciones+=stringHTML;
    }
    
    let componente = document.getElementById("tbody-content");
    componente.innerHTML = respuestaCanciones;
}