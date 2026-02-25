
package pa.elbalero.modelo;

//Representa la estructura fija del registro en RAF.

import java.io.File;
import java.io.RandomAccessFile;


public class RegistroRandomAccessFile {
    private int clave; //4bytes
    private String nombreEquipo; //25 caracteres cada caracter 2 bytes 25*2 = 50 bytes 
    private String nombreJugador1; //25 caracteres cada caracter 2 bytes 25*2 = 50 bytes
    private String nombreJugador2; //25 caracteres cada caracter 2 bytes 25*2 = 50 bytes
    private String nombreJugador3; //25 caracteres cada caracter 2 bytes 25*2 = 50 bytes
    private int puntaje; //4 bytes
    private File f;
    private RandomAccessFile archivo;
    
    
}
