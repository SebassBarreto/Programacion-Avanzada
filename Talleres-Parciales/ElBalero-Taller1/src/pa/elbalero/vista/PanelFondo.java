package pa.elbalero.vista;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

/**
 * JPanel personalizado que dibuja una imagen de fondo escalada al tamano del panel.
 * Se usa como fondo decorativo en los diferentes paneles de la interfaz.
 */
public class PanelFondo extends JPanel {

    private Image imagen;

    // constructor vacío (IMPORTANTE para el wizard)
    public PanelFondo() {
    }

    /**
     * Crea el panel y carga la imagen de fondo desde la ruta indicada
     * @param ruta ruta relativa o absoluta de la imagen a cargar
     */
    // constructor con imagen
    public PanelFondo(String ruta) {
        setImagen(ruta);
    }

    /**
     * Carga una imagen desde la ruta proporcionada y la establece como fondo.
     * Lanza una excepcion si la imagen no se encuentra en la ruta dada.
     * @param ruta ruta del archivo de imagen
     */
    // cualquier panel puede decidir su imagen
    public void setImagen(String ruta) {
//        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
//        repaint();
        ImageIcon icono = new ImageIcon(ruta);

        if (icono.getIconWidth() == -1) {
            throw new RuntimeException(
                    "No se encontró la imagen: " + ruta
            );
        }

        imagen = icono.getImage();
        repaint();
    }

    /**
     * Dibuja la imagen de fondo escalada al tamano completo del panel.
     * Se invoca automaticamente por Swing cada vez que el panel necesita repintarse.
     * @param g objeto Graphics proporcionado por el sistema de pintado de Swing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(
                    imagen,
                    0, 0,
                    getWidth(),
                    getHeight(),
                    this
            );
        }
    }
}
