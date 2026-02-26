
package pa.elbalero.modelo;

//Lee el archivo .properties y construye las entidades.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class CargadorPropertiesEquipo {
    public Equipo[] cargarEquipos(String ruta) throws IOException{
        
        Properties properties = new Properties();
        
        try {
            FileInputStream fis = new FileInputStream(ruta);
            properties.load(fis);
            
        } catch (FileNotFoundException e) {
            
        }
        return null;
    }
}
