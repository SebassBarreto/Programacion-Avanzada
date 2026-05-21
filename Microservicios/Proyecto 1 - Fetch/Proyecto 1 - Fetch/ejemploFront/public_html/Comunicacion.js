//se captura el boton de enviar del formulario
let boton = document.getElementById("btnRegistrar");

//se añade el evento del boton para poder enviar los datos con el fetch
//el boton adquiere el evento de click, y cuando lo reciba, llama a la funcion btnRegistrar
boton.addEventListener("click", evento => {
    evento.preventDefault();
    registrarJuguete();
});


let registrarJuguete = async() => {
    // Se crea una variable de tipo arreglo
    let campos = {};

    //Se capturan los campos del formulario y se guardan en el arreglo  
    campos.codigo = document.getElementById("codigoJuguete").value;
    campos.nombre = document.getElementById("nombreJuguete").value;

    /*
     * Para enviar los datos capturados, se debe realizar un fetch (para consumir una api) que llame a la URL donde
     * esta el API Rest Mediante un metodo asincrono se le envia el objeto en formato Json
     */
    //el fetch le indica al proyecto que el contenido se va a enviar a la direccion indicada
    //que el envio se va a realizar usando el metodo POST fetch() es un mecanismo que te permite realizar llamadas AJAX 
    //(Asynchronous JavaScript y XML) simples con JavaScript.
    //Asynchronous (asincrónico) significa que puedes usar fetch para realizar llamadas a una API externa sin tener que 
    //detener la ejecución de otras instrucciones. Es importante notar que fetch no es parte de los métodos de JavaScript, 
    //sino más bien un método API web integrado en la mayoría de los navegadores y accesible a través de JavaScript. 

    const peticion = await fetch("http://localhost:9000/juguete/juguete", //ESTE PUERTO SE DEBE ACTUALIZAR
            {
                method: 'POST',
                //El header indica que el tipo de formato a usar va a ser JSON
                //esas dos lineas se colocan siempre que se utiliza json
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                //esto indica que lo va a serializar en el envio, en el body
                //envia los campos, serializados, como operacion dentro del Body (con 
                //el clic del boton registrar). Si el metodo usado es get, no se 
                //coloca la siguiente linea porque se envia por la url y no por el body
                body: JSON.stringify(campos)
            });
}; 