package pa.minipigs.Control;

import java.util.ArrayList;
import pa.minipigs.Modelo.DAO.MiniPigDAO;
import pa.minipigs.Modelo.MiniPigDTO;

/**
 * Clase de control encargada de gestionar las operaciones relacionadas con los
 * objetos MiniPig dentro del sistema.
 *
 * Actúa como intermediario entre la capa de vista y la capa de acceso a datos
 * (MiniPigDAO), permitiendo crear objetos MiniPig y realizar consultas según
 * diferentes criterios.
 *
 * También mantiene una lista de MiniPigs utilizados dentro de la aplicación
 * durante la ejecución.
 *
 * Forma parte de la arquitectura MVC del sistema MiniPigs.
 *
 * @author Valen Aguilar
 * @author Sergio Vanegas
 */
public class ControlMiniPig {

    /**
     * Referencia al controlador principal de la aplicación.
     */
    private ControlPrincipal controlPrincipal;

    /**
     * Objeto MiniPig que se está manipulando actualmente.
     */
    private MiniPigDTO minipig;

    /**
     * Lista de MiniPigs utilizados en la aplicación.
     */
    private ArrayList<MiniPigDTO> listaPigsProperties;

    /**
     * Cola de MiniPigs con datos incompletos pendientes de completar por el usuario.
     */
    private ArrayList<MiniPigDTO> pendientesCompletar;

    /**
     * Objeto encargado de acceder a la base de datos de MiniPigs.
     */
    private MiniPigDAO miniPigDAO;
    

    /**
     * Constructor del controlador de MiniPigs.
     *
     * Inicializa la conexión con el controlador principal y crea la instancia
     * del objeto DAO que permitirá acceder a los datos almacenados.
     *
     * @param controlPrincipal controlador principal del sistema
     */
    public ControlMiniPig(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        miniPigDAO = new MiniPigDAO(this);
        listaPigsProperties = new ArrayList<>();
        pendientesCompletar = new ArrayList<>();
    }

    /**
     * Crea un objeto MiniPigDTO con la información recibida.
     *
     * @param codigo código identificador del MiniPig
     * @param nombre nombre del MiniPig
     * @param sexo sexo del MiniPig
     * @param idMicrochip identificador del microchip
     * @param raza raza del MiniPig
     * @param color color del MiniPig
     * @param peso peso del MiniPig
     * @param altura altura del MiniPig
     * @param caracteristica1 primera característica especial
     * @param caracteristica2 segunda característica especial
     * @param urlFoto ruta de la imagen del MiniPig
     * @return objeto MiniPigDTO creado con los datos proporcionados
     */
    public MiniPigDTO crearMiniPig(String codigo, String nombre, String sexo, String idMicrochip, String raza, String color, String peso, String altura, String caracteristica1, String caracteristica2, String urlFoto) {
        minipig = new MiniPigDTO(codigo, nombre, sexo, idMicrochip, raza, color, peso, altura, caracteristica1, caracteristica2, urlFoto);
        return minipig;
    }
    
    

//    public ArrayList<MiniPigDTO> crearArrayMiniPigs() {
//        if (listapigs == null) {
//            listapigs = new ArrayList<>();
//        }
//        return listapigs;
//    }

    /**
     * Procesa la lista de MiniPigs provenientes del archivo properties.
     * Los que tienen datos completos se insertan directamente en la base de datos.
     * Los que tienen datos faltantes se agregan a una cola y se muestran uno
     * a uno para que el usuario los complete.
     *
     * @param minipigs lista de MiniPigDTO cargados desde el properties
     */
    public void agregarMiniPigsDeProperties(ArrayList<MiniPigDTO> minipigs) {
        pendientesCompletar.clear();
        for (MiniPigDTO minipig : minipigs) {
            if (tieneDatosFaltantes(minipig)) {
                pendientesCompletar.add(minipig);
            } else {
                miniPigDAO.insertar(minipig);
            }
        }
        mostrarSiguientePendiente();
    }

    /**
     * Verifica si un MiniPig tiene algún campo obligatorio vacío o nulo.
     *
     * @param mp objeto MiniPigDTO a verificar
     * @return true si le falta algún dato obligatorio, false si está completo
     */
    private boolean tieneDatosFaltantes(MiniPigDTO mp) {
        return mp.getCodigo() == null || mp.getCodigo().trim().isEmpty()
                || mp.getNombre() == null || mp.getNombre().trim().isEmpty()
                || mp.getSexo() == null || mp.getSexo().trim().isEmpty()
                || mp.getIdMicrochip() == null || mp.getIdMicrochip().trim().isEmpty()
                || mp.getRaza() == null || mp.getRaza().trim().isEmpty()
                || mp.getColor() == null || mp.getColor().trim().isEmpty()
                || mp.getPeso() == null || mp.getPeso().trim().isEmpty()
                || mp.getAltura() == null || mp.getAltura().trim().isEmpty()
                || mp.getCaracteristica1() == null || mp.getCaracteristica1().trim().isEmpty()
                || mp.getCaracteristica2() == null || mp.getCaracteristica2().trim().isEmpty()
                || mp.getUrlFoto() == null || mp.getUrlFoto().trim().isEmpty();
    }

    /**
     * Muestra el siguiente MiniPig pendiente de completar al usuario.
     * Si no hay más pendientes, activa el panel de ingreso de nuevos MiniPigs.
     */
    public void mostrarSiguientePendiente() {
        if (!pendientesCompletar.isEmpty()) {
            MiniPigDTO mp = pendientesCompletar.remove(0);
            controlPrincipal.mostrarCompletarInformacion(
                    mp.getCodigo(), mp.getNombre(), mp.getSexo(), mp.getIdMicrochip(),
                    mp.getRaza(), mp.getColor(), mp.getPeso(), mp.getAltura(),
                    mp.getCaracteristica1(), mp.getCaracteristica2(), mp.getUrlFoto());
        } else {
            controlPrincipal.activarIngresoMiniPigs();
        }
    }
    /**
     * Consulta un MiniPig a partir de su código identificador.
     *
     * @param parametro código del MiniPig
     * @return objeto MiniPigDTO encontrado o null si no existe
     */
    public String[] consultarPorCodigo(String parametro) {
        MiniPigDTO miniPigAux = miniPigDAO.consultarPorCodigo(parametro);
        if (miniPigAux == null) {
            return null;
        } else {
            String[] datos = new String[2];
            datos[0] = miniPigAux.getCodigo();
            datos[1] = miniPigAux.getNombre();
            return datos;
        }
    }

    /**
     * Consulta MiniPigs según su nombre.
     *
     * @param parametro nombre del MiniPig
     * @return lista de MiniPigs que coinciden con el nombre
     */
    public ArrayList<MiniPigDTO> consultarPorNombre(String parametro) {
        return miniPigDAO.consultarPorNombre(parametro);
    }

    /**
     * Consulta un MiniPig según su identificador de microchip.
     *
     * @param parametro id del microchip
     * @return MiniPigDTO encontrado o null si no existe
     */
    public String[] consultarPorMicrochip(String parametro) {
        MiniPigDTO miniPigAux = miniPigDAO.consultarPorMicrochip(parametro);
        if (miniPigAux == null) {
            return null;
        } else {
            String[] datos = new String[2];
            datos[0] = miniPigAux.getCodigo();
            datos[1] = miniPigAux.getNombre();
            return datos;
        }
    }

    /**
     * Consulta MiniPigs según su raza.
     *
     * @param parametro raza del MiniPig
     * @return lista de MiniPigs que coinciden con la raza
     */
    public ArrayList<MiniPigDTO> consultarPorRaza(String parametro) {
        return miniPigDAO.consultarPorRaza(parametro);
    }

    /**
     * Consulta MiniPigs según su color.
     *
     * @param parametro color del MiniPig
     * @return lista de MiniPigs encontrados
     */
    public ArrayList<MiniPigDTO> consultarPorColor(String parametro) {
        return miniPigDAO.consultarPorColor(parametro);
    }

    /**
     * Consulta MiniPigs según su peso.
     *
     * @param parametro peso del MiniPig
     * @return lista de MiniPigs que coinciden con el peso
     */
    public ArrayList<MiniPigDTO> consultarPorPeso(String parametro) {
        return miniPigDAO.consultarPorPeso(parametro);
    }

    /**
     * Consulta MiniPigs según su altura.
     *
     * @param parametro altura del MiniPig
     * @return lista de MiniPigs encontrados
     */
    public ArrayList<MiniPigDTO> consultarPorAltura(String parametro) {
        return miniPigDAO.consultarPorAltura(parametro);
    }

    /**
     * Modifica la información de un MiniPig existente en el sistema.
     *
     * Recibe los datos actualizados del MiniPig, crea un objeto
     * {@link MiniPigDTO} con dicha información y delega la operación de
     * actualización al objeto {@link MiniPigDAO}, encargado de realizar la
     * modificación en la base de datos.
     *
     * @param codigo código identificador del MiniPig
     * @param nombre nombre del MiniPig
     * @param sexo sexo del MiniPig
     * @param IdMicroChip identificador del microchip del MiniPig
     * @param raza raza del MiniPig
     * @param color color del MiniPig
     * @param peso peso del MiniPig
     * @param altura altura del MiniPig
     * @param c1 primera característica especial del MiniPig
     * @param c2 segunda característica especial del MiniPig
     * @param URL ruta o dirección de la imagen asociada al MiniPig
     */
    public void modificar(String codigo, String nombre, String sexo, String IdMicroChip, String raza, String color, String peso, String altura, String c1, String c2, String URL) {
        miniPigDAO.modificar(crearMiniPig(codigo, nombre, sexo, IdMicroChip, raza, color, peso, altura, c1, c2, URL));
    }

    public boolean insertar(String codigo, String nombre, String sexo, String IdMicroChip, String raza, String color, String peso, String altura, String c1, String c2, String URL) {
        return miniPigDAO.insertar(crearMiniPig(codigo, nombre, sexo, IdMicroChip, raza, color, peso, altura, c1, c2, URL));
    }

    /**
     * Elimina un MiniPig de la base de datos según su código.
     *
     * @param codigo código del MiniPig a eliminar
     */
    public void eliminar(String codigo) {
        miniPigDAO.eliminarPorCodigo(codigo);
    }

    /**
     * Consulta y retorna el objeto MiniPigDTO completo de un MiniPig por su código.
     *
     * @param codigo código del MiniPig a consultar
     * @return objeto MiniPigDTO con todos los datos, o null si no existe
     */
    public MiniPigDTO consultarPorCodigoCompleto(String codigo) {
        return miniPigDAO.consultarPorCodigo(codigo);
    }
}
