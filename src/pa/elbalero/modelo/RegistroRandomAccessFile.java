
package pa.elbalero.modelo;

//Representa la estructura fija del registro en RAF.

import java.io.File;
import java.io.RandomAccessFile;


public class RegistroRandomAccessFile {
    
    public static final int TAM_CADENA = 30;
    public static final int TAM_REGISTRO = 4+(TAM_CADENA*2*4)+4; //4 bytes de la clave 120 de strings y otros 4 bytes de el puntaje

    private int clave; //4bytes
    private String nombreEquipo; //30 caracteres cada caracter 2 bytes 30*2 = 60 bytes 
    private String jugador1; //30caracteres cada caracter 2 bytes 30*2 = 60 bytes
    private String jugador2; //30 caracteres cada caracter 2 bytes 30*2 = 60 bytes
    private String jugador3; //30 caracteres cada caracter 2 bytes 30*2 = 60  bytes
    private int puntaje; //4 bytes

    public RegistroRandomAccessFile() {
    }

    public RegistroRandomAccessFile(int clave, String nombreEquipo, String jugador1, String jugador2, String jugador3, int puntaje) {
        this.clave = clave;
        this.nombreEquipo = nombreEquipo;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = jugador3;
        this.puntaje = puntaje;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getJugador3() {
        return jugador3;
    }

    public void setJugador3(String jugador3) {
        this.jugador3 = jugador3;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
}
