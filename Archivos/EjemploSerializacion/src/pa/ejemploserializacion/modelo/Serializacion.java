package pa.ejemploserializacion.modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Asus
 */
public class Serializacion {

    //canal de salida para escribir en el archivo de serializacions
    private FileOutputStream fileOut;
    private ObjectOutputStream salida;  
    
    //canal de salida para escsribir en el archivo de serializacion
    private FileInputStream fileIn;
    private ObjectInputStream entrada;
    
    //Metodo Constructor que prepara los canales para leer / escribir
    //en el archivo de srializacion 

    public Serializacion(){
    
        try {
            //para escribir 
            fileOut = new FileOutputStream("personas.bin");
            salida = new ObjectOutputStream(fileOut);
        
            //para leer
            fileIn= new FileInputStream("personas.bin");
            entrada = new ObjectInputStream(fileIn);
            
        } catch (FileNotFoundException ex) {
        } catch(IOException ex){
        }
    }
   
     
    public void cerrarArchivoSerializadoOut(){
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    System.out.println("no se puede cerrar la salida");
                }
            }
        }
    
    public void cerrarArchivoSerialziadoIn(){
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException ex) {
                System.out.println("no se puede cerrar la entrada");
            }
        }
    }
    
    public void escribirArchivoSerializado(Persona persona){
        if (salida != null) {
            try {
                salida.writeObject(persona);
            } catch (IOException ex) {
                System.out.println("no se puede serialziar la persona");
            }
        }
    }
    
    public Persona leerArchivoSerializado(){
        Persona persona = null;
        
        if (entrada != null) {
            try {
                persona = (Persona)entrada.readObject();
            } catch (EOFException eof) {
              //fin del archivo  
            } catch (IOException ex){
                
            } catch (ClassNotFoundException cnfe){
                
            }
        }
        
        return persona;
    }
    
    }
    
    
    
    

    
