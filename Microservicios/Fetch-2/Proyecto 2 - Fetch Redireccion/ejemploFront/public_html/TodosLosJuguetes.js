window.onload = function () {
    MostrarJuguetes();
};

let MostrarJuguetes = async () => {
    const peticion = await fetch("http://localhost:9000/juguete/mostrarjuguetes",
            {
                method: 'GET',
                headers: {
                    'Acceot': 'application/json',
                    'Content-Type': ' application/json'
                }
            });

    const juguetes = await peticion.json();
    
    let contenidoTabla = '';
    let contenidoFila = '';

    for (let juguete of juguetes) {
        contenidoFila = "<tr><td>" + juguete.id + "</td><td>" + juguete.codigo + "</td><td>" + juguete.nombre + "</td><td>";
        contenidoTabla += contenidoFila;
    }
    document.querySelector('#tabla tbody').outerHTML = contenidoTabla;
};