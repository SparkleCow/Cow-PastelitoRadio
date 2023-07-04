cargarPodcast();

function cargarPodcast() {
    const token = obtenerTokenDeCookie();
    const protectedUrl = "http://localhost:8080/holaMundo";
  
    if (!token) {
      window.location.replace("http://localhost:8080/login.html");
      return;
    }
  
    fetch(protectedUrl, {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      }
    })
    .then(response => {
      if (response.ok) {
        console.log(response);
        alert('Acceso permitido');
        
        window.location.replace("http://localhost:8080/holaMundo");
      } else {
        alert('Acceso denegado');
        window.location.replace("http://localhost:8080/login.html");
      }
    })
    .catch(error => {
      alert('Error en la solicitud:', error);
    });
  }
  
  function obtenerTokenDeCookie() {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i].trim();
      if (cookie.startsWith('token=')) {
        return cookie.substring('token='.length, cookie.length);
      }
    }
    return null;
  }
  