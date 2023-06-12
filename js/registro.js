



async function addUser() {
    let usuario ={};
    usuario.nombre = document.getElementById('nombre').value;
    usuario.contrasena = document.getElementById('password').value;
    usuario.rol = 0;



    const request = await fetch('/añadirUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    });

    if (request.ok) {
        console.log('Usuario agregado correctamente');

    } else {
        console.error('Error al agregar el Usuario');
    }
}

function validarConfirmarContrasena() {
    let password = document.getElementById('password').value;
    let passwordConf = document.getElementById('passwordConfirm').value;
    let enviarButton = document.getElementById('enviar');

    if (password === passwordConf) {
        console.log('Las contraseñas coinciden');
        enviarButton.disabled = false;
    } else {
        console.log('Las contraseñas no coinciden');
        enviarButton.disabled = true;
    }
}

document.getElementById('password').addEventListener('input', validarConfirmarContrasena);
document.getElementById('passwordConfirm').addEventListener('input', validarConfirmarContrasena);



function llamar(){
    addUser();
    validarConfirmarContrasena();
}