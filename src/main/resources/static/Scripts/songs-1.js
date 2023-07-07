<<<<<<< HEAD
const searchIcon = document.getElementById('search-icon');
const searchInput = document.getElementById('search-input');

searchIcon.addEventListener('click', function() {
  searchInput.classList.toggle('active');
});
=======
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
>>>>>>> a600bf4a8122001d2c89c641f00da0d7d189e17a
