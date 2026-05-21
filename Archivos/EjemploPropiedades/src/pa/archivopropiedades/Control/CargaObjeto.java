package pa.archivopropiedades.Control;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import pa.archivopropiedades.Modelo.Persona;

public class CargaObjeto {

    Properties misPropiedades;
    File f;

    public CargaObjeto() {
        misPropiedades = cargar();
    }

    private Properties cargar() {

        Properties prop = new Properties();

        try {
            JFileChooser selector = new JFileChooser();
            int opcion = selector.showOpenDialog(null);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                f = selector.getSelectedFile();

                FileInputStream fis = new FileInputStream(f);
                prop.load(fis);
                fis.close();
            }

        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }

        return prop;
    }

    public void listarArchivo() {
        misPropiedades.list(System.out);
    }

    public void mostrarDatos() {

        String nombre = misPropiedades.getProperty("nombre");
        String apellido = misPropiedades.getProperty("apellido");
        int edad = Integer.parseInt(misPropiedades.getProperty("edad"));

        Persona persona = new Persona(nombre, apellido, edad);

        System.out.println(persona.getNombre());
        System.out.println(persona.getApellido());
        System.out.println(persona.getEdad());
    }
}