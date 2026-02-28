
package pa.elbalero.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionRandomAccessFile {
    private int clave, puntaje, embocadas, victorias;
    private String nombreEquipo, nomJugador1, nomJugador2, nomJugador3;
    private long tamreg, canreg;
    private File file;
    RandomAccessFile raf;

    public ConexionRandomAccessFile() {
        this.clave=0;
        this.nombreEquipo ="";
        this.puntaje = 0;
        this.nomJugador1="";
        this.nomJugador2="";
        this.nomJugador3="";
        this.tamreg = 212;
        this.canreg=0;
        try{
            file= new File("");
            raf = new RandomAccessFile(file, "rw");
        }catch(FileNotFoundException fnfe){
            
        }
        
    }
    public String llenarCampoString(String cadena){
        if(cadena.length()<25){
                for(int i = cadena.length(); i<25;i++){
                    cadena = cadena + "";
                }
            }
            else{
                cadena = cadena.substring(0,25);
            }
        return cadena;
    }
    
       public void escribir(int clave, int puntaje, int embocadas, int victorias, String nombreEquipo,String nomJugador1, String nomJugador2,String nomJugador3){
            
        try {
            if(raf.length()!=0){
               raf.seek(raf.length());
            }
            raf.writeInt(clave);
            raf.writeChars(llenarCampoString(nombreEquipo));
            raf.writeChars(llenarCampoString(nomJugador1));
            raf.writeChars(llenarCampoString(nomJugador2));
            raf.writeChars(llenarCampoString(nomJugador3));
            raf.writeInt(puntaje);
            raf.writeInt(embocadas);
            raf.writeInt(victorias);
        } catch (IOException ex) {
            Logger.getLogger(ConexionRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
    
