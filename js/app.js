$(document).ready(function () {
    cargarAlumnos();
});

async function cargarAlumnos() {
    const request = await fetch('/listarAlumno', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const alumnos = await request.json();
    //const usuario = await requestU.json();
    console.log(alumnos);
        let alumnoHTML = '';
        let admin = false;
        for (let alumno of alumnos) {
            let HTML = '<tr><td>' + alumno.id + '</td><td>' + alumno.nombre +
                '</td><td>' + alumno.nota + '</td><td><button class="delete" onclick="eliminarAlumno(' + alumno.id + ')">Eliminar</button></td>' +
                '<td><button class="update" onclick="updateAlumno(' + alumno.id + ')">Actualizar</button></td></tr>';

            // for(let user of usuario) {
            //     if (usuario.rol === 1) {
            //         alumnoHTML = alumnoHTML + HTML + '<td><button class="delete" onclick="eliminarAlumno(' + alumno.id + ')">Eliminar</button></td>' +
            //             '<td><button class="update" onclick="updateAlumno(' + alumno.id + ')">Actualizar</button></td>';
            //     }
            // }
            alumnoHTML = alumnoHTML + HTML;
        }
        let HTML = '<tr><td class="inserttd"><button class="insert" onclick="addAlumno()">Añadir</button></td></tr>'
        alumnoHTML = alumnoHTML + HTML;
        document.querySelector('tbody').outerHTML = alumnoHTML;

        document.querySelector('.insert').addEventListener('click', function () {
            window.location.href = 'insert.html';
        });
}

async function eliminarAlumno(id) {
    const request = await fetch('/eliminarAlumno/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    location.reload();
}


async function addAlumno() {
    const nombre = document.getElementById('nombre').value;
    const nota = document.getElementById('nota').value;

    const nuevoAlumno = {
        nombre: nombre,
        nota: parseFloat(nota)
    };

    const request = await fetch('/añadirAlumno', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuevoAlumno)
    });

    if (request.ok) {
        console.log('Alumno agregado correctamente');
        cargarAlumnos(); // Actualizar la lista de alumnos después de la inserción
    } else {
        console.error('Error al agregar el alumno');
    }
}

function redirigirActualizar(id) {
    window.location.href = 'update.html?id=' + id;
}

async function updateAlumno(idAlumno) {
    let alumno = {};
    alumno.id = idAlumno;
    alumno.nombre = document.getElementById("nombre").value;
    alumno.nota = document.getElementById("nota").value;

    if (alumno.nombre !== "" && alumno.nota !== "") {

        const request = await fetch('/updateAlumno/', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alumno)
        });
    }
    location.reload();
}