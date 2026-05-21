package pa.minipigs.Vista;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase utilitaria que permite al usuario seleccionar archivos del sistema
 * mediante un cuadro de diálogo.
 *
 * Utiliza un {@link JFileChooser} para abrir el explorador de archivos del
 * sistema operativo y retornar la ruta del archivo seleccionado.
 *
 * Se emplea principalmente para seleccionar archivos o imágenes asociadas a un
 * MiniPig dentro de la aplicación.
 *
 * @author Valen Aguilar
 */
public class SeleccionarArchivo {

    /**
     * Abre un cuadro de diálogo para que el usuario seleccione un archivo del
     * sistema.
     *
     * @param titulo título que se mostrará en la ventana del selector de
     * archivos
     * @return la ruta absoluta del archivo seleccionado como {@code String}. Si
     * el usuario cancela la operación, retorna {@code null}.
     */
    public String seleccionarProperties(String titulo) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(titulo);

        // Filtro solo para archivos .properties
        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("Archivos Properties (*.properties)", "properties");

        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            // Validación extra
            if (!archivo.getName().toLowerCase().endsWith(".properties")) {
                return null;
            }

            return archivo.getAbsolutePath();
        }

        return null;
    }

    /**
     * Abre un cuadro de diálogo para que el usuario seleccione una imagen con
     * extensión {@code .png}.
     *
     * Este método restringe la selección únicamente a archivos PNG utilizando
     * un {@link FileNameExtensionFilter}. Se utiliza para asignar o cambiar la
     * fotografía asociada a un MiniPig.
     *
     * @param titulo título que se mostrará en la ventana del selector
     * @return la ruta absoluta de la imagen seleccionada como {@code String}.
     * Si el usuario cancela la operación, retorna {@code null}.
     */
    public String seleccionarFoto(String titulo) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(titulo);

        // Filtro para solo archivos PNG
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Imágenes PNG (*.png)", "png");
        fileChooser.setFileFilter(filtro);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            return archivo.getAbsolutePath();
        }
        return null;
    }
}
