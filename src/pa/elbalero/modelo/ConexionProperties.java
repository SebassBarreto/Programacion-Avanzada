/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.elbalero.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Asus
 */
public class ConexionProperties {
    
    public Properties leerArchivo(File archivo) throws IOException{
        
        Properties propiedades = new Properties();
        
        try(FileInputStream entrada = new FileInputStream(archivo)){
            propiedades.load(entrada);
        }
        
        return propiedades;
    }
    

    
}
