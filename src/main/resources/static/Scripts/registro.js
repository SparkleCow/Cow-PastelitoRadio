
async function cargarUsuarios(){
    
    let usuario = {};
    usuario.username = document.getElementById("name").value;
    usuario.email = document.getElementById("email").value;
    usuario.password = document.getElementById("password").value;

    let repetirPassword = document.getElementById("repeat_password").value;
    if (repetirPassword != usuario.password) {
        alert('La contraseña que escribiste es diferente.');
        return;
    }

    console.log(usuario);

    const response = await fetch("http://localhost:8080/api/createUser", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    });

    if (response.ok) {
        alert("La cuenta fue creada con éxito!");
    } else {
        const errorData = await response.json();
        alert("Error al crear la cuenta: " + errorData.message);
    }
    window.location.href = "/login.html";
};