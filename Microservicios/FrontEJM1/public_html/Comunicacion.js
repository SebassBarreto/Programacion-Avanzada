//se captura el boton de enviar del formulario
let boton = document.getElementById("btnRegistrar");

//se añade el evento del boton para poder enviar los datos con el fetch
//el boton adquiere el evento de click y cuando lo reciba, llama a la funcion btnRegistrar
boton.addEventListener("click", evento=>{
    registrarJuguete();
})

let registrarJuguete = async ()=>{
    //se crea una variable de tipo arreglo
    let campos = {};

    //se capturan los campos del formularoi y se guardan en el arreglo
    campos.codigo = document.getElementById("codigoJuguete").value;
    campos.nombre = document.getElementById("nombreJuguete").value;
}

const peticion = await fetch("http://localhost:8080/juguete/juguete",
    {
        method: "POST",

        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        body:JSON.stringify(campos)
    });
