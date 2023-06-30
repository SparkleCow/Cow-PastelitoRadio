function toggleDiv() {
    var divDesplegable = document.getElementById("sidebar");
    divDesplegable.classList.toggle("visible");
}

function abrirPestana() {
    window.location.href = "register.html";
};

async function login(){

    let user = {};
    user.username = document.getElementById("username").value;
    user.password = document.getElementById("password").value;

    const response = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
      })
      .then(response => {
        if (response.ok) {
          return response.json(); // Si la respuesta es exitosa, convierte la respuesta a JSON
        } else {
          // El inicio de sesión falló, muestra un mensaje de error
          alert("Nombre de usuario o contraseña incorrectos");
          document.getElementById("username").value = "";
          document.getElementById("password").value = "";
          return;
        }
      })
      .then(data => {
        // Maneja la respuesta del servidor
        const token = data.token; // Obtiene el token de la respuesta
      
        if (token) {
          // El inicio de sesión fue exitoso, se recibió un token
          localStorage.setItem("token", token);
          alert("Inicio de sesión exitoso");
          // Redirige a la página principal u otra página protegida
          window.location.href = "/index.html";
        } else {
          throw new Error("Error de inicio de sesión"); // Si la respuesta no es exitosa, lanza un alert
        }
      })
      .catch(error => {
        // Maneja errores de conexión u otros errores
        console.error("1Error:", error);
      });
};

