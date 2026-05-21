
package pa.minipigs.Vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;

/**
 * Botón personalizado con forma circular.
 *
 * Esta clase extiende JButton y redefine su comportamiento de
 * renderizado para mostrar un botón con forma redonda en lugar
 * del botón rectangular tradicional de Swing.
 *
 * Se sobrescriben métodos de pintura y detección de clics para
 * asegurar que tanto la apariencia como el área interactiva del
 * botón sean circulares.
 *
 * Utiliza antialiasing para mejorar la calidad visual del borde
 * y del relleno del botón.
 *
 * @author Valen Aguilar
 */
public class BotonRedondo extends JButton {
    /** Forma circular utilizada para definir el área interactiva del botón. */
    private Shape shape;
    
    /**
    * Constructor del botón redondo.
    *
    * Configura el botón para que no utilice el renderizado rectangular
    * por defecto de Swing y permita dibujar una forma circular personalizada.
    */
    public BotonRedondo(){
        //Evita que Swing pinte el fondo rectangular por defecto
        setContentAreaFilled(false);
        
        // Quita el borde de enfoque cuando se hace clic
        setFocusPainted(false);
        
        //Evita que swing dibuje el borge rectangular normal
        setBorderPainted(false);
    }
    
    /**
    * Dibuja el componente del botón con forma circular.
    *
    * Se utiliza antialiasing para mejorar la calidad visual del
    * renderizado y se dibuja un círculo cuyo diámetro corresponde
    * al menor valor entre el ancho y el alto del componente.
    *
    * @param g objeto Graphics utilizado para realizar el dibujo.
    */
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int diameter = Math.min(getWidth(), getHeight());

        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }

        g2.fillOval(0, 0, diameter, diameter);

        super.paintComponent(g);

        g2.dispose();
    }

    /**
    * Dibuja el borde circular del botón.
    *
    * @param g objeto Graphics utilizado para renderizar el borde.
    */
    @Override
    protected void paintBorder(Graphics g) {

        // Dibuja un borde circular alrededor del botón
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    /**
    * Determina si un punto específico se encuentra dentro del
    * área interactiva circular del botón.
    *
    * Este método redefine la detección de clics para que solo
    * se registren dentro de la forma circular del botón y no
    * dentro del área rectangular del componente.
    *
    * @param x coordenada X del punto evaluado
    * @param y coordenada Y del punto evaluado
    * @return true si el punto está dentro del área circular del botón,
    * false en caso contrario.
    */
    @Override
    public boolean contains(int x, int y) {

        // Si la forma no existe o cambió el tamaño del botón
        if (shape == null
                || !shape.getBounds().equals(getBounds())) {

            // Se crea una nueva forma circular
            shape = new Ellipse2D.Float(
                    0, 0, getWidth(), getHeight()
            );
        }

        // Solo devuelve true si el clic está dentro del círculo
        return shape.contains(x, y);
    }
}

