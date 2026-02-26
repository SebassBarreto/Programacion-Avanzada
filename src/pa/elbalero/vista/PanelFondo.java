package pa.elbalero.vista;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class PanelFondo extends JPanel {

    private Image imagen;
    // constructor vacío (IMPORTANTE para el wizard)
    public PanelFondo() {
    }

    // constructor con imagen
    public PanelFondo(String ruta) {
        setImagen(ruta);
    }

    // cualquier panel puede decidir su imagen
    public void setImagen(String ruta) {
        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
        repaint();
    }

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
