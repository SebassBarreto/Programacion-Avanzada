package pa.minipigs.Control;

import java.util.ArrayList;
import pa.minipigs.Modelo.CnxProperties;
import pa.minipigs.Modelo.Conexion.CnxBD;
import pa.minipigs.Modelo.MiniPigDTO;

/**
 * Clase principal del controlador. Coordina la interacción entre la Vista
 * y el Modelo, delegando las operaciones de negocio a {@link ControlMiniPig}
 * y las operaciones de presentación a {@link ControlVista}.
 *
 * @author Valen Aguilar
 */
public class ControlPrincipal {

    private ControlVista controlVista;
    private ControlMiniPig controlMiniPig;

    public ControlPrincipal() {
        controlMiniPig = new ControlMiniPig(this);
        controlVista = new ControlVista(this);
        seleccionarProperties();
    }

    /**
     * Solicita al usuario que seleccione el archivo {@code .properties},
     * carga las credenciales de la base de datos y los minipigs
     * previamente registrados en dicho archivo.
     */
    public void seleccionarProperties() {
        String urlProperties = controlVista.seleccionar("Seleccione al archivo properties: ");
        // cargar credenciales de BD
        CnxBD.cargarCredenciales(urlProperties);
        CnxProperties cnxproperties = CnxProperties.getInstance();
        controlMiniPig.agregarMiniPigsDeProperties(cnxproperties.cargarProperties(urlProperties));
            
    }
    
    /**
     * Activa el panel de ingreso de nuevos minipigs en la vista.
     */
    public void activarIngresoMiniPigs(){
        controlVista.activarIngresoMiniPigs();
    }

    /**
     * Modifica los datos de un minipig existente en la base de datos.
     *
     * @param codigo      código único del minipig a modificar
     * @param nombre      nuevo nombre del minipig
     * @param sexo        nuevo sexo del minipig
     * @param IdMicroChip nuevo identificador de microchip
     * @param raza        nueva raza del minipig
     * @param color       nuevo color del minipig
     * @param peso        nuevo peso del minipig
     * @param altura      nueva altura del minipig
     * @param c1          nueva primera característica
     * @param c2          nueva segunda característica
     * @param URL         nueva URL o ruta de la foto del minipig
     */
    public void modificar(
            String codigo,
            String nombre,
            String sexo,
            String IdMicroChip,
            String raza,
            String color,
            String peso,
            String altura,
            String c1,
            String c2,
            String URL) {
        controlMiniPig.modificar(codigo, nombre, sexo, IdMicroChip, raza, color, peso, altura, c1, c2, URL);
    }

    /**
     * Inserta un nuevo minipig en la base de datos y notifica el resultado
     * a través de un mensaje en la vista.
     *
     * @param codigo      código único del nuevo minipig
     * @param nombre      nombre del nuevo minipig
     * @param sexo        sexo del nuevo minipig
     * @param IdMicroChip identificador de microchip del nuevo minipig
     * @param raza        raza del nuevo minipig
     * @param color       color del nuevo minipig
     * @param peso        peso del nuevo minipig
     * @param altura      altura del nuevo minipig
     * @param c1          primera característica del nuevo minipig
     * @param c2          segunda característica del nuevo minipig
     * @param URL         URL o ruta de la foto del nuevo minipig
     */
    public void insertar(
            String codigo,
            String nombre,
            String sexo,
            String IdMicroChip,
            String raza,
            String color,
            String peso,
            String altura,
            String c1,
            String c2,
            String URL) {
        if (controlMiniPig.insertar(codigo, nombre, sexo, IdMicroChip, raza, color, peso, altura, c1, c2, URL)) {
            controlVista.mostrarMensaje("El MiniPig de nombre " + nombre + "ha sido insertado correctamente.");
        } else {
            controlVista.mostrarMensaje("El MiniPig no se ha podido agregar.");
        }
    }

    /**
     * Muestra el panel para completar la información de un minipig cuyos
     * datos venían incompletos desde el archivo properties.
     *
     * @param codigo      código del minipig
     * @param nombre      nombre del minipig
     * @param sexo        sexo del minipig
     * @param IdMicroChip identificador de microchip
     * @param raza        raza del minipig
     * @param color       color del minipig
     * @param peso        peso del minipig
     * @param altura      altura del minipig
     * @param c1          primera característica
     * @param c2          segunda característica
     * @param URL         URL o ruta de la foto del minipig
     */
    public void mostrarCompletarInformacion(String codigo,String nombre,
            String sexo,String IdMicroChip,
            String raza,String color,
            String peso,String altura,
            String c1,String c2,
            String URL) {
        controlVista.mostrarCompletarInformacion(codigo, nombre, sexo, IdMicroChip, raza, color, peso, altura, c1, c2, URL);
    }

    /**
     * Valida que el código y el microchip del minipig no existan previamente
     * y, de ser así, lo inserta en la base de datos.
     * Notifica a través de la vista si alguno ya existe.
     *
     * @param codigo      código del minipig
     * @param nombre      nombre del minipig
     * @param sexo        sexo del minipig
     * @param IdMicroChip identificador de microchip
     * @param raza        raza del minipig
     * @param color       color del minipig
     * @param peso        peso del minipig
     * @param altura      altura del minipig
     * @param c1          primera característica
     * @param c2          segunda característica
     * @param URL         URL o ruta de la foto del minipig
     */
    public void completarInformacion(
            String codigo,
            String nombre,
            String sexo,
            String IdMicroChip,
            String raza,
            String color,
            String peso,
            String altura,
            String c1,
            String c2,
            String URL) {
        if (controlMiniPig.consultarPorCodigo(codigo) == null) {
            if (controlMiniPig.consultarPorMicrochip(IdMicroChip) == null) {
                if (controlMiniPig.insertar(codigo, nombre, sexo, IdMicroChip, raza, color, peso, altura, c1, c2, URL)){
                    controlVista.reiniciarVentanaPanelCompletar();
                    controlMiniPig.mostrarSiguientePendiente();
                }
            } else {
                controlVista.mostrarMensaje("Este IdMicroChip de MiniPig ya existe");
            }
        } else {
            controlVista.mostrarMensaje("Este código de MiniPig ya existe");
        }
    }

    /**
     * Elimina un minipig de la base de datos según su código.
     *
     * @param codigo código del minipig a eliminar
     */
    public void eliminar(String codigo) {
        controlMiniPig.eliminar(codigo);
    }

    /**
     * Consulta y retorna el objeto MiniPigDTO completo de un minipig por su código.
     *
     * @param codigo código del minipig a consultar
     * @return objeto MiniPigDTO con todos los datos, o null si no existe
     */
    public MiniPigDTO consultarPorCodigoCompleto(String codigo) {
        return controlMiniPig.consultarPorCodigoCompleto(codigo);
    }

    /**
     * Realiza una búsqueda de minipigs según el parámetro y el tipo de
     * búsqueda indicados, y muestra los resultados en la tabla de la vista.
     *
     * @param parametro    valor a buscar
     * @param tipoBusqueda tipo de búsqueda: "Código", "Nombre", "ID MicroChip",
     *                     "Raza", "Color", "Peso" o "Altura"
     */
    public void buscar(String parametro, String tipoBusqueda) {
        ArrayList<MiniPigDTO> lista;
        String[] datos;
        controlVista.limpiarTabla();

        switch (tipoBusqueda) {

            case "Código":
                datos = controlMiniPig.consultarPorCodigo(parametro);
                if (datos == null) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con el código buscado.");
                } else {
                    controlVista.agregarFila(datos[0], datos[1]);
                }
                break;

            case "Nombre":
                lista = controlMiniPig.consultarPorNombre(parametro);
                if (lista == null || lista.isEmpty()) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con el nombre buscado.");
                } else {
                    for (MiniPigDTO mp : lista) {
                        controlVista.agregarFila(mp.getCodigo(), mp.getNombre());
                    }
                }
                break;

            case "ID MicroChip":
                datos = controlMiniPig.consultarPorMicrochip(parametro);
                if (datos == null) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con el ID MicroChip buscado.");
                } else {
                    controlVista.agregarFila(datos[0], datos[1]);
                }
                break;

            case "Raza":
                lista = controlMiniPig.consultarPorRaza(parametro);
                if (lista == null || lista.isEmpty()) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con la raza buscada.");
                } else {
                    for (MiniPigDTO mp : lista) {
                        controlVista.agregarFila(mp.getCodigo(), mp.getNombre());
                    }
                }
                break;

            case "Color":
                lista = controlMiniPig.consultarPorColor(parametro);
                if (lista == null || lista.isEmpty()) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con el color buscado.");
                } else {
                    for (MiniPigDTO mp : lista) {
                        controlVista.agregarFila(mp.getCodigo(), mp.getNombre());
                    }
                }
                break;

            case "Peso":
                lista = controlMiniPig.consultarPorPeso(parametro);
                if (lista == null || lista.isEmpty()) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con el peso buscado.");
                } else {
                    for (MiniPigDTO mp : lista) {
                        controlVista.agregarFila(mp.getCodigo(), mp.getNombre());
                    }
                }
                break;

            case "Altura":
                lista = controlMiniPig.consultarPorAltura(parametro);
                if (lista == null || lista.isEmpty()) {
                    controlVista.mostrarMensaje("No se encontró ningún MiniPig que coincida con la altura buscada.");
                } else {
                    for (MiniPigDTO mp : lista) {
                        controlVista.agregarFila(mp.getCodigo(), mp.getNombre());
                    }
                }
                break;
        }

    }
}
