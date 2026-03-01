package pa.elbalero.modelo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
 
/**
 * Clase del modelo encargada de escribir y leer registros de longitud fija
 * en un archivo de acceso aleatorio (RandomAccessFile).
 * Cada registro ocupa exactamente 217 bytes con campos de tamano fijo.
 */
public class ConexionRandomAccessFile {

    // Tamaño estricto en bytes (4 + 50 + 50 + 50 + 50 + 4 + 4 + 4 + 1) = 217 bytes.
    private final int TAMANO_REGISTRO = 217;

    public ConexionRandomAccessFile() {
    }

    /**
     * Rellena o recorta una cadena para que ocupe exactamente 25 caracteres (50 bytes en UTF).
     * Si es menor a 25 se rellena con espacios. Si es mayor se recorta.
     * @param cadena texto original a ajustar
     * @return cadena de exactamente 25 caracteres
     */
    private String llenarCampoString(String cadena) {
        if (cadena == null) {
            cadena = "N/A";
        }

        if (cadena.length() < 25) {
            for (int i = cadena.length(); i < 25; i++) {
                cadena = cadena + " "; // Rellena con espacios
            }
        } else {
            cadena = cadena.substring(0, 25); // Corta si es muy largo
        }
        return cadena;
    }

    /**
     * Escribe un registro completo al final del archivo RAF con los datos del ganador.
     * El registro ocupa 217 bytes: clave(4) + nombreEquipo(50) + j1(50) + j2(50) + j3(50) + puntaje(4) + embocadas(4) + victorias(4) + haGanadoAntes(1)
     * @param file archivo de acceso aleatorio donde se persiste
     * @param clave identificador autoincremental del registro
     * @param nombreEquipo nombre del equipo ganador
     * @param nomJ1 nombre del primer jugador
     * @param nomJ2 nombre del segundo jugador
     * @param nomJ3 nombre del tercer jugador
     * @param puntaje puntos totales obtenidos por el equipo
     * @param embocadas cantidad total de embocadas acertadas
     * @param victorias numero de victorias previas del equipo
     * @param haGanadoAntes true si el equipo ya habia ganado antes
     * @throws IOException si ocurre un error al escribir en el archivo
     */
    public void escribirRegistro(File file, int clave, String nombreEquipo,
            String nomJ1, String nomJ2, String nomJ3,
            int puntaje, int embocadas, int victorias, boolean haGanadoAntes) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length()); // Posiciona el puntero al final

            raf.writeInt(clave); // 4 bytes
            raf.writeChars(llenarCampoString(nombreEquipo)); // 50 bytes
            raf.writeChars(llenarCampoString(nomJ1));// 50 bytes
            raf.writeChars(llenarCampoString(nomJ2)); // 50 bytes
            raf.writeChars(llenarCampoString(nomJ3));// 50 bytes
            raf.writeInt(puntaje);// 4 bytes
            raf.writeInt(embocadas);// 4 bytes
            raf.writeInt(victorias);// 4 bytes
            raf.writeBoolean(haGanadoAntes);// 1 byte
        }
    }

    /**
     * Calcula cuantos registros existen dividiendo el peso del archivo por 217
     * @param file
     * @return 
     * @throws java.io.IOException 
     */
    public int contarRegistros(File file) throws IOException {
        if (!file.exists()) {
            return 0;
        }
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            return (int) (raf.length() / TAMANO_REGISTRO);
        }
    }

    /**
     * Salta a un registro específico y lee solo el nombre del equipo.
     * @param file
     * @param indiceRegistro
     * @return limpia espacios en blanco
     * @throws java.io.IOException
     */
    public String leerNombreEquipo(File file, int indiceRegistro) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            // Fórmula mágica del offset: (índice * 217) + 4 bytes de la 'clave' que nos saltamos
            long posicionByte = (long) indiceRegistro * TAMANO_REGISTRO + 4;
            raf.seek(posicionByte);

            String nombre = "";
            for (int i = 0; i < 25; i++) {
                nombre += raf.readChar(); // Leemos 25 caracteres (50 bytes)
            }
            return nombre.trim(); // Eliminamos los espacios en blanco del relleno
        }
    }
}
