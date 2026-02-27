
package pa.elbalero.vista;

import javax.swing.JButton;        // Clase base del botón en Swing
import java.awt.*;                 // Clases gráficas (Color, Graphics, etc.)
import java.awt.geom.Ellipse2D;    // Permite crear formas geométricas (círculos)

// Creamos una nueva clase que hereda todo el comportamiento de JButton
public class RoundButton extends JButton {

    // Variable que almacenará la forma circular del botón
    private Shape shape;

    // Constructor del botón circular
    public RoundButton() {

        // Evita que Swing pinte el fondo rectangular por defecto
        setContentAreaFilled(false);

        // Quita el borde de enfoque cuando se hace clic
        setFocusPainted(false);

        // Evita que Swing dibuje el borde rectangular normal
        setBorderPainted(false);
    }

    // Método encargado de dibujar el componente
    @Override
    protected void paintComponent(Graphics g) {

        // Convertimos Graphics a Graphics2D para usar dibujo avanzado
        Graphics2D g2 = (Graphics2D) g.create();

        // Activa suavizado de bordes (antialiasing)
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Usa el color de fondo asignado al botón
        g2.setColor(getBackground());

        // Dibuja un óvalo que ocupará todo el botón
        // Si ancho = alto → será un círculo perfecto
        g2.fillOval(0, 0, getWidth(), getHeight());

        // Permite que JButton dibuje texto o iconos encima
        super.paintComponent(g2);

        // Libera recursos gráficos utilizados
        g2.dispose();
    }

    // Método que dibuja el borde del botón
    @Override
    protected void paintBorder(Graphics g) {

        // Dibuja un borde circular alrededor del botón
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    // Define el área real donde el botón detecta clics
    @Override
    public boolean contains(int x, int y) {

        // Si la forma no existe o cambió el tamaño del botón
        if (shape == null ||
            !shape.getBounds().equals(getBounds())) {

            // Se crea una nueva forma circular
            shape = new Ellipse2D.Float(
                0, 0, getWidth(), getHeight()
            );
        }

        // Solo devuelve true si el clic está dentro del círculo
        return shape.contains(x, y);
    }
}
