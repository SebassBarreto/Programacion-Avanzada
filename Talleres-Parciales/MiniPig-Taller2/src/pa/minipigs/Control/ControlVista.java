package pa.minipigs.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import pa.minipigs.Modelo.MiniPigDTO;
import pa.minipigs.Vista.PanelCreditos;
import pa.minipigs.Vista.Emergente;
import pa.minipigs.Vista.PanelBuscar;
import pa.minipigs.Vista.PanelCompletarInfoProperties;
import pa.minipigs.Vista.PanelIngresar;
import pa.minipigs.Vista.PanelModificarVer;
import pa.minipigs.Vista.PanelPrincipal;
import pa.minipigs.Vista.PanelSiNoIngresar;
import pa.minipigs.Vista.SeleccionarArchivo;
import pa.minipigs.Vista.Ventana;

/**
 * Controlador encargado de gestionar los eventos generados en la interfaz
 * gráfica del sistema. Implementa la interfaz ActionListener para capturar las
 * acciones realizadas por los componentes de la vista, como botones y campos de
 * interacción.
 *
 * Esta clase se encarga de: - Gestionar la navegación entre los diferentes
 * paneles de la aplicación. - Recibir las acciones del usuario. - Validar
 * información ingresada en los formularios. - Delegar las operaciones de lógica
 * al ControlPrincipal.
 *
 * Forma parte de la capa de control dentro de la arquitectura MVC.
 *
 * @author Valen Aguilar
 */
public class ControlVista implements ActionListener {

    /** Índice de la columna "Ver Datos" en la tabla de búsqueda. */
    private static final int COLUMNA_VER_DATOS = 2;
    /** Índice de la columna "Modificar" en la tabla de búsqueda. */
    private static final int COLUMNA_MODIFICAR = 3;
    /** Índice de la columna "Eliminar" en la tabla de búsqueda. */
    private static final int COLUMNA_ELIMINAR = 4;

    /**
     * Referencia al controlador principal de la aplicación.
     */
    private ControlPrincipal controlPrincipal;

    /**
     * Ventana principal donde se cargan los diferentes paneles.
     */
    private Ventana ventana;

    /**
     * Componente encargado de mostrar mensajes emergentes al usuario.
     */
    private Emergente emergente;

    /**
     * Panel utilizado para realizar búsquedas de MiniPigs.
     */
    private PanelBuscar panelBuscar;

    /**
     * Panel que muestra la información de créditos de la aplicación.
     */
    private PanelCreditos panelCreditos;

    /**
     * Panel principal de la aplicación.
     */
    private PanelPrincipal panelPrincipal;

    /**
     * Componente que permite seleccionar archivos del sistema.
     */
    private SeleccionarArchivo seleccionarArchivo;

    /**
     * Panel utilizado para modificar la información de un MiniPig.
     */
    private PanelModificarVer panelModificar;

    private PanelSiNoIngresar panelSiNoIngresar;

    private PanelIngresar panelIngresar;

    private PanelCompletarInfoProperties panelCompletarInfoProperties;

    /**
     * Constructor del controlador de la vista. Inicializa los paneles de la
     * interfaz, registra los listeners de los botones y establece el panel
     * principal como vista inicial.
     *
     * @param controlPrincipal controlador principal encargado de la lógica del
     * sistema y la comunicación con el modelo.
     */
    public ControlVista(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        emergente = new Emergente();
        panelPrincipal = new PanelPrincipal(this);
        panelCreditos = new PanelCreditos(this);
        panelBuscar = new PanelBuscar(this);
        seleccionarArchivo = new SeleccionarArchivo();
        ventana = new Ventana();
        panelModificar = new PanelModificarVer(this);
        panelSiNoIngresar = new PanelSiNoIngresar(this);
        panelIngresar = new PanelIngresar(this);
        panelCompletarInfoProperties = new PanelCompletarInfoProperties(this);

        //Botones del PanelPrincipal
        panelPrincipal.jButton1Buscar.addActionListener(this);
        panelPrincipal.jButton1Buscar.setActionCommand("Ir a PanelBuscar");
        panelPrincipal.jButton2Creditos.addActionListener(this);
        panelPrincipal.jButton2Creditos.setActionCommand("Creditos");
        panelPrincipal.jButton3Salir.addActionListener(this);
        panelPrincipal.jButton3Salir.setActionCommand("SalirPP");

        //Botones de PanelBuscar
        panelBuscar.jButton1VolverPantallaPrincipal.addActionListener(this);
        panelBuscar.jButton1VolverPantallaPrincipal.setActionCommand("Ir a Pantalla Principal");
        panelBuscar.jButton2EncontrarMP.addActionListener(this);
        panelBuscar.jButton2EncontrarMP.setActionCommand("Encontrar");
        panelBuscar.jButton3Limpiar.addActionListener(this);
        panelBuscar.jButton3Limpiar.setActionCommand("Limpiar");

        //Boton de PanelCreditos
        panelCreditos.jButton1VolverPantallaPrincipal.addActionListener(this);
        panelCreditos.jButton1VolverPantallaPrincipal.setActionCommand("Ir a Pantalla Principal");

        //Botones de PanelModificarVer
        panelModificar.jButton1VolverBuscar.addActionListener(this);
        panelModificar.jButton1VolverBuscar.setActionCommand("Ir A Buscar");
        panelModificar.jButton2CambiarFoto.addActionListener(this);
        panelModificar.jButton2CambiarFoto.setActionCommand("Cambiar Foto");
        panelModificar.jButton3Guardar.addActionListener(this);
        panelModificar.jButton3Guardar.setActionCommand("Guardar");

        //Botones del Panel Si no ingresar
        panelSiNoIngresar.jButton1IngresarunMiniPig.addActionListener(this);
        panelSiNoIngresar.jButton1IngresarunMiniPig.setActionCommand("Ir a PanelIngresar");
        panelSiNoIngresar.jButton2NoingresarMiniPig.addActionListener(this);
        panelSiNoIngresar.jButton2NoingresarMiniPig.setActionCommand("Ir a Pantalla Principal");

        //Botones del panel ingresar
        panelIngresar.jButton1VolverSiNoIngresar.addActionListener(this);
        panelIngresar.jButton1VolverSiNoIngresar.setActionCommand("Ir a panelsinoingresar");
        panelIngresar.jButton2CambiarFoto.addActionListener(this);
        panelIngresar.jButton2CambiarFoto.setActionCommand("Cambiar Foto");
        panelIngresar.jButton3IngresarNuevoMiniPig.addActionListener(this);
        panelIngresar.jButton3IngresarNuevoMiniPig.setActionCommand("Ingresar Nuevo MiniPig");

        //Botones del panel completar info del properties
        panelCompletarInfoProperties.jButton1CambiarFoto.addActionListener(this);
        panelCompletarInfoProperties.jButton1CambiarFoto.setActionCommand("Cambiar Foto");
        panelCompletarInfoProperties.jButton2Completar.addActionListener(this);
        panelCompletarInfoProperties.jButton2Completar.setActionCommand("Completar Informacion");

        //Ponemos en la ventana el Panel Principal
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(false); //Ventana visible en pantalla

        // MouseListener para la tabla de búsqueda (Ver Datos, Modificar, Eliminar)
        panelBuscar.jTableBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = panelBuscar.jTableBusqueda.rowAtPoint(evt.getPoint());
                int columna = panelBuscar.jTableBusqueda.columnAtPoint(evt.getPoint());
                if (fila >= 0) {
                    String codigo = (String) panelBuscar.jTableBusqueda.getValueAt(fila, 0);
                    if (columna == COLUMNA_VER_DATOS) { // Ver Datos
                        verDatos(codigo);
                    } else if (columna == COLUMNA_MODIFICAR) { // Modificar
                        modificarDatos(codigo);
                    } else if (columna == COLUMNA_ELIMINAR) { // Eliminar
                        int respuesta = javax.swing.JOptionPane.showConfirmDialog(null,
                                "\u00bfSeguro que desea eliminar este MiniPig?", "Confirmar eliminaci\u00f3n",
                                javax.swing.JOptionPane.YES_NO_OPTION);
                        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                            controlPrincipal.eliminar(codigo);
                            ((DefaultTableModel) panelBuscar.jTableBusqueda.getModel()).removeRow(fila);
                        }
                    }
                }
            }
        });
    }
    
    

    /**
     * Muestra los datos de un MiniPig en el panel de modificación en modo solo lectura.
     *
     * @param codigo código del MiniPig a visualizar
     */
    private void verDatos(String codigo) {
        MiniPigDTO mp = controlPrincipal.consultarPorCodigoCompleto(codigo);
        if (mp != null) {
            llenarPanelModificar(mp);
            configurarPanelModificar(false);
            cambiarPanel(panelModificar);
        }
    }

    /**
     * Muestra los datos de un MiniPig en el panel de modificación en modo editable.
     *
     * @param codigo código del MiniPig a modificar
     */
    private void modificarDatos(String codigo) {
        MiniPigDTO mp = controlPrincipal.consultarPorCodigoCompleto(codigo);
        if (mp != null) {
            llenarPanelModificar(mp);
            configurarPanelModificar(true);
            cambiarPanel(panelModificar);
        }
    }

    /**
     * Configura la editabilidad de los campos del panel de modificación.
     * El código y el idMicroChip siempre son de solo lectura.
     *
     * @param editable {@code true} para habilitar edición; {@code false} para solo lectura
     */
    private void configurarPanelModificar(boolean editable) {
        panelModificar.nombre.setEditable(editable);
        panelModificar.genero.setEditable(editable);
        panelModificar.raza.setEditable(editable);
        panelModificar.color.setEditable(editable);
        panelModificar.peso.setEditable(editable);
        panelModificar.altura.setEditable(editable);
        panelModificar.caracteristica1.setEditable(editable);
        panelModificar.caracteristica2.setEditable(editable);
        panelModificar.jButton3Guardar.setEnabled(editable);
        panelModificar.jButton2CambiarFoto.setEnabled(editable);
    }

    /**
     * Rellena todos los campos del panel de modificación con los datos del MiniPig recibido.
     *
     * @param mp objeto MiniPigDTO con los datos a mostrar
     */
    private void llenarPanelModificar(MiniPigDTO mp) {
        panelModificar.codigo.setText(mp.getCodigo());
        panelModificar.nombre.setText(mp.getNombre());
        panelModificar.genero.setText(mp.getSexo());
        panelModificar.idMicroChip.setText(mp.getIdMicrochip());
        panelModificar.raza.setText(mp.getRaza());
        panelModificar.color.setText(mp.getColor());
        panelModificar.peso.setText(mp.getPeso());
        panelModificar.altura.setText(mp.getAltura());
        panelModificar.caracteristica1.setText(mp.getCaracteristica1());
        panelModificar.caracteristica2.setText(mp.getCaracteristica2());
        panelModificar.URL.setText(mp.getUrlFoto());
        if (mp.getUrlFoto() != null && !mp.getUrlFoto().trim().isEmpty()) {
            panelModificar.ponerImagen(mp.getUrlFoto());
        }
    }

    /**
     * Cambia el panel que se muestra actualmente en la ventana principal.
     *
     * @param panel panel que se desea mostrar en la ventana.
     */
    public void cambiarPanel(javax.swing.JPanel panel) {
        ventana.setContentPane(panel);
        ventana.revalidate();
        ventana.repaint();
    }

    public void mostrarCompletarInformacion(String codigo,
            String nombre,
            String sexo,String IdMicroChip,
            String raza,String color,
            String peso,String altura,String c1,
            String c2,String URL) {

        panelCompletarInfoProperties.codigo.setText(codigo);
        panelCompletarInfoProperties.codigo.setEditable(codigo == null || codigo.trim().isEmpty());

        panelCompletarInfoProperties.nombre.setText(nombre);
        panelCompletarInfoProperties.nombre.setEditable(nombre == null || nombre.trim().isEmpty());

        panelCompletarInfoProperties.genero.setText(sexo);
        panelCompletarInfoProperties.genero.setEditable(sexo == null || sexo.trim().isEmpty());

        panelCompletarInfoProperties.idMicroChip.setText(IdMicroChip);
        panelCompletarInfoProperties.idMicroChip.setEditable(IdMicroChip == null || IdMicroChip.trim().isEmpty());

        panelCompletarInfoProperties.raza.setText(raza);
        panelCompletarInfoProperties.raza.setEditable(raza == null || raza.trim().isEmpty());

        panelCompletarInfoProperties.color.setText(color);
        panelCompletarInfoProperties.color.setEditable(color == null || color.trim().isEmpty());

        panelCompletarInfoProperties.peso.setText(peso);
        panelCompletarInfoProperties.peso.setEditable(peso == null || peso.trim().isEmpty());

        panelCompletarInfoProperties.altura.setText(altura);
        panelCompletarInfoProperties.altura.setEditable(altura == null || altura.trim().isEmpty());

        panelCompletarInfoProperties.caracteristica1.setText(c1);
        panelCompletarInfoProperties.caracteristica1.setEditable(c1 == null || c1.trim().isEmpty());

        panelCompletarInfoProperties.caracteristica2.setText(c2);
        panelCompletarInfoProperties.caracteristica2.setEditable(c2 == null || c2.trim().isEmpty());

        panelCompletarInfoProperties.URL.setText(URL);
        panelCompletarInfoProperties.URL.setEditable(false);

        // controlar botón de cambiar foto
        if (URL == null || URL.trim().isEmpty()) {
            panelCompletarInfoProperties.jButton1CambiarFoto.setEnabled(true);
        } else {
            panelCompletarInfoProperties.jButton1CambiarFoto.setEnabled(false);
        }
        
        panelCompletarInfoProperties.ponerImagen(URL);
        cambiarPanel(panelCompletarInfoProperties);
        ventana.setVisible(true);
    }
    
    public void reiniciarVentanaPanelCompletar(){
        ventana.setVisible(false);
        panelCompletarInfoProperties.codigo.setText("");
        panelCompletarInfoProperties.nombre.setText("");
        panelCompletarInfoProperties.genero.setText("");
        panelCompletarInfoProperties.idMicroChip.setText("");
        panelCompletarInfoProperties.raza.setText("");
        panelCompletarInfoProperties.color.setText("");
        panelCompletarInfoProperties.peso.setText("");
        panelCompletarInfoProperties.altura.setText("");
        panelCompletarInfoProperties.caracteristica1.setText("");
        panelCompletarInfoProperties.caracteristica2.setText("");
        panelCompletarInfoProperties.URL.setText("");
    }
    
    public void activarIngresoMiniPigs(){
        cambiarPanel(panelSiNoIngresar);
        ventana.setVisible(true);
    }

    /**
     * Elimina todas las filas de la tabla de resultados de búsqueda del panel
     * de búsqueda.
     */
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) panelBuscar.jTableBusqueda.getModel();
        modelo.setRowCount(0);
    }

    /**
     * Agrega una nueva fila a la tabla de resultados de búsqueda.
     *
     * @param codigo código identificador del MiniPig
     * @param nombre nombre del MiniPig
     */
    public void agregarFila(String codigo, String nombre) {
        DefaultTableModel modelo = (DefaultTableModel) panelBuscar.jTableBusqueda.getModel();
        modelo.addRow(new Object[]{
            codigo,
            nombre,
            "Ver Datos",
            "Modificar",
            "Eliminar"
        });
    }

    public void mostrarMensaje(String mensaje) {
        emergente.mostrarMensaje(mensaje);
    }

    public String seleccionar(String titulo) {
        return seleccionarArchivo.seleccionarProperties(titulo);
    }

    public boolean verificarExistenciaDeDatos(
            String codigo,
            String nombre,
            String genero,
            String idMicroChip,
            String raza,
            String color,
            String peso,
            String altura,
            String caracteristica1,
            String caracteristica2,
            String url) {

        if (codigo.trim().isEmpty()
                || nombre.trim().isEmpty()
                || genero.trim().isEmpty()
                || idMicroChip.trim().isEmpty()
                || raza.trim().isEmpty()
                || color.trim().isEmpty()
                || peso.trim().isEmpty()
                || altura.trim().isEmpty()
                || caracteristica1.trim().isEmpty()
                || caracteristica2.trim().isEmpty()
                || url.trim().isEmpty()) {

            emergente.mostrarAdvertencia("Debe completar todos los campos para poder guardar.");
            return false;
        }

        try {
            Integer.parseInt(codigo);
        } catch (NumberFormatException e) {
            emergente.mostrarAdvertencia("El código debe ser un número.");
            return false;
        }

        try {
            Double.parseDouble(peso);
        } catch (NumberFormatException e) {
            emergente.mostrarAdvertencia("El peso debe ser numérico.");
            return false;
        }

        try {
            Double.parseDouble(altura);
        } catch (NumberFormatException e) {
            emergente.mostrarAdvertencia("La altura debe ser numérica.");
            return false;
        }

        return true;
    }

    /**
     * Método que captura y gestiona los eventos generados por los componentes
     * de la interfaz gráfica.
     *
     * Dependiendo del ActionCommand recibido, se ejecutan diferentes acciones
     * como cambiar de panel, realizar búsquedas, limpiar campos, modificar
     * información o cerrar la aplicación.
     *
     * @param e evento generado por un componente de la interfaz.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Ir a PanelBuscar")) {
            cambiarPanel(panelBuscar);

        } else if (e.getActionCommand().equalsIgnoreCase("Creditos")) {
            cambiarPanel(panelCreditos);

        } else if (e.getActionCommand().equalsIgnoreCase("SalirPP")) {
            emergente.confirmacionSalir();

        } else if (e.getActionCommand().equalsIgnoreCase("Ir a Pantalla Principal")) {
            cambiarPanel(panelPrincipal);

        } else if (e.getActionCommand().equalsIgnoreCase("Encontrar")) {
            if (panelBuscar.jTextFieldParametroBusqueda.getText().trim().isEmpty()) {
                emergente.mostrarMensaje("Debe ingresar un parámetro para poder realizar la búsqueda.");
            } else {
                controlPrincipal.buscar(panelBuscar.jTextFieldParametroBusqueda.getText(), (String) panelBuscar.jComboBoxTipoBusqueda.getSelectedItem());

            }

        } else if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
            panelBuscar.jTextFieldParametroBusqueda.setText("");
            panelBuscar.jComboBoxTipoBusqueda.setSelectedIndex(-1);
            limpiarTabla();

        } else if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
            if (verificarExistenciaDeDatos(
                    panelModificar.codigo.getText(),
                    panelModificar.nombre.getText(),
                    panelModificar.genero.getText(),
                    panelModificar.idMicroChip.getText(),
                    panelModificar.raza.getText(),
                    panelModificar.color.getText(),
                    panelModificar.peso.getText(),
                    panelModificar.altura.getText(),
                    panelModificar.caracteristica1.getText(),
                    panelModificar.caracteristica2.getText(),
                    panelModificar.URL.getText())) {

                controlPrincipal.modificar(
                        panelModificar.codigo.getText(),
                        panelModificar.nombre.getText(),
                        panelModificar.genero.getText(),
                        panelModificar.idMicroChip.getText(),
                        panelModificar.raza.getText(),
                        panelModificar.color.getText(),
                        panelModificar.peso.getText(),
                        panelModificar.altura.getText(),
                        panelModificar.caracteristica1.getText(),
                        panelModificar.caracteristica2.getText(),
                        panelModificar.URL.getText()
                );
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Cambiar Foto")) {
            String foto = seleccionarArchivo.seleccionarFoto("Seleccione la foto del MiniPig:");
            if (foto != null) {
                if (ventana.getContentPane() == panelModificar) {
                    panelModificar.URL.setText(foto);
                    panelModificar.ponerImagen(foto);
                } else if (ventana.getContentPane() == panelIngresar) {
                    panelIngresar.URL.setText(foto);
                    panelIngresar.ponerImagen(foto);
                } else if (ventana.getContentPane() == panelCompletarInfoProperties) {
                    panelCompletarInfoProperties.URL.setText(foto);
                    panelCompletarInfoProperties.ponerImagen(foto);
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Ir a PanelIngresar")) {
            cambiarPanel(panelIngresar);

        } else if (e.getActionCommand().equalsIgnoreCase("Ingresar Nuevo MiniPig")) {
            if (verificarExistenciaDeDatos(
                    panelIngresar.codigo.getText(), panelIngresar.nombre.getText(),
                    panelIngresar.genero.getText(), panelIngresar.idMicroChip.getText(),
                    panelIngresar.raza.getText(), panelIngresar.color.getText(),
                    panelIngresar.peso.getText(), panelIngresar.altura.getText(),
                    panelIngresar.caracteristica1.getText(), panelIngresar.caracteristica2.getText(),
                    panelIngresar.URL.getText())) {

                controlPrincipal.insertar(
                        panelIngresar.codigo.getText(), panelIngresar.nombre.getText(),
                        panelIngresar.genero.getText(), panelIngresar.idMicroChip.getText(),
                        panelIngresar.raza.getText(), panelIngresar.color.getText(),
                        panelIngresar.peso.getText(), panelIngresar.altura.getText(),
                        panelIngresar.caracteristica1.getText(), panelIngresar.caracteristica2.getText(),
                        panelIngresar.URL.getText()
                );
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Ir a panelsinoingresar")) {
            cambiarPanel(panelSiNoIngresar);
        } else if (e.getActionCommand().equalsIgnoreCase("Ir A Buscar")) {
            cambiarPanel(panelBuscar);
        } else if (e.getActionCommand().equalsIgnoreCase("Completar Informacion")) {
            if (verificarExistenciaDeDatos(
                    panelCompletarInfoProperties.codigo.getText(), panelCompletarInfoProperties.nombre.getText(),
                    panelCompletarInfoProperties.genero.getText(), panelCompletarInfoProperties.idMicroChip.getText(),
                    panelCompletarInfoProperties.raza.getText(), panelCompletarInfoProperties.color.getText(),
                    panelCompletarInfoProperties.peso.getText(), panelCompletarInfoProperties.altura.getText(),
                    panelCompletarInfoProperties.caracteristica1.getText(), panelCompletarInfoProperties.caracteristica2.getText(),
                    panelCompletarInfoProperties.URL.getText())) {
                controlPrincipal.completarInformacion(
                        panelCompletarInfoProperties.codigo.getText(), panelCompletarInfoProperties.nombre.getText(),
                        panelCompletarInfoProperties.genero.getText(), panelCompletarInfoProperties.idMicroChip.getText(),
                        panelCompletarInfoProperties.raza.getText(), panelCompletarInfoProperties.color.getText(),
                        panelCompletarInfoProperties.peso.getText(), panelCompletarInfoProperties.altura.getText(),
                        panelCompletarInfoProperties.caracteristica1.getText(), panelCompletarInfoProperties.caracteristica2.getText(),
                        panelCompletarInfoProperties.URL.getText()
                );
            }
        }
    }
}
