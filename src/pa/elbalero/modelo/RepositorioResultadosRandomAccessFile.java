
package pa.elbalero.modelo;

//Lee y escribe registros en RAF (sin reglas de negocio).

import java.io.IOException;
import java.io.RandomAccessFile;


public class RepositorioResultadosRandomAccessFile {
    
    private String leerCadenaFija(RandomAccessFile raf) throws IOException{
        //crea un array vacio de 30 espacios
        char[] buffer = new char[RegistroRandomAccessFile.TAM_CADENA];
        
        for (int i = 0; i < RegistroRandomAccessFile.TAM_CADENA; i++) {
            buffer[i] = raf.readChar();
        }
        
        //hace append a los chars y borra los espacios basura
        return new String(buffer).trim();
        
    }
    private void escribirCadenaFija(RandomAccessFile raf, String valor) throws IOException {
        //Si el valor es null entonces lo rellena con una cadena vacia
        //Crea un string builder para modificar el largo
        StringBuilder sb = new StringBuilder(valor == null ? "" : valor);
        //Fuerza el largo exactamente a el tamaño de 30 caracteres
        sb.setLength(RegistroRandomAccessFile.TAM_CADENA);
        //escribe los caraceteres
        raf.writeChars(sb.toString());
    }
    
    public void escribirRegistro(RandomAccessFile raf, RegistroRandomAccessFile registro)throws IOException{
            //mueve el puntero al final del archivo para no sobreescribir y corromperlo
            raf.seek(raf.length());
            //escribe la clave como entero
            raf.writeInt(registro.getClave());
            //escribe cada cadena con tamaño fijo
            escribirCadenaFija(raf, registro.getNombreEquipo());
            escribirCadenaFija(raf, registro.getJugador1());
            escribirCadenaFija(raf, registro.getJugador2());
            escribirCadenaFija(raf, registro.getJugador3());
            //Escribe el registro como entero
            raf.writeInt(registro.getPuntaje());
    }
    
    public RegistroRandomAccessFile leerRegistro(RandomAccessFile raf) throws IOException{
        RegistroRandomAccessFile registro = new RegistroRandomAccessFile();
        registro.setClave(raf.readInt());
        registro.setJugador1(leerCadenaFija(raf));
        registro.setJugador2(leerCadenaFija(raf));
        registro.setJugador3(leerCadenaFija(raf));
        registro.setPuntaje(raf.readInt());
        
        return registro;
    }

    
}
