let boton = document.getElementById("btnRegistrar");
boton.addEventListener("click", evento => {
    evento.preventDefault();
    registrarJuguete();
});

let botonCodigo = document.getElementById("btnCodigo");
boton.addEventListener("click", evento => {
    evento.preventDefault();
    consultarJuguetePorCodigo();
});

let consultarJuguetePorCodigo = async() =>{
    let campo = document.getElementByCodigo("codigoJuguete".toString()).value;
    
    const peticion = await fetch("http://localhost:8383/juguete/juguetecodigo/" + campo,)
    
};
let registrarJuguete = async() => {
    let campos = {};
    campos.codigo = document.getElementById("codigoJuguete").value;
    campos.nombre = document.getElementById("nombreJuguete").value;

    const peticion = await fetch("http://localhost:9000/juguete/juguete", //ESTE PUERTO SE DEBE ACTUALIZAR
            {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(campos)
            })
            .then((res) => {
                if (res.ok) {
                    window.location.replace('index2.html');
                }
                res.json();
            });
};

async function buscarJuguete() {
    const codigo = document.getElementById('codigo').value;
    const resultadoDiv = document.getElementById('resultado');

    if (!codigo) {
        alert('Por favor ingrese un código');
        return;
    }

    try {
        
        const response = await fetch(`http://localhost:8383/juguete/juguetecodigo/${codigo}`);

        if (response.ok) {
            const juguete = await response.json();

            // Mostrar los datos del juguete
            resultadoDiv.innerHTML = `
                        <h3>Juguete Encontrado:</h3>
                        <p><strong>Código:</strong> ${juguete.codigo}</p>
                        <p><strong>Nombre:</strong> ${juguete.nombre}</p>
                        <p><strong>Precio:</strong> ${juguete.precio}</p>
                        <!-- Agrega más campos según tu clase Juguete -->
                    `;
            resultadoDiv.style.display = 'block';
            resultadoDiv.className = '';
        } else if (response.status === 404) {
            resultadoDiv.innerHTML = '<p class="error">Juguete no encontrado</p>';
            resultadoDiv.style.display = 'block';
        } else {
            throw new Error('Error en la petición');
        }

    } catch (error) {
        resultadoDiv.innerHTML = `<p class="error">Error: ${error.message}</p>`;
        resultadoDiv.style.display = 'block';
        resultadoDiv.className = 'error';
    }
}

// Permitir buscar con Enter
document.getElementById('codigo').addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
        buscarJuguete();
    }
}); 


