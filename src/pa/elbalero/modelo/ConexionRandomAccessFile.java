package pa.elbalero.modelo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
 
 // Escribir y leer bytes puros usando Registros de Longitud Fija.
public class ConexionRandomAccessFile {

    // Tamaño estricto en bytes (4 + 50 + 50 + 50 + 50 + 4 + 4 + 4 + 1) = 217 bytes.
    private final int TAMANO_REGISTRO = 217;

    public ConexionRandomAccessFile() {
    }

    //Garantiza que el String ocupe exactamente 50 bytes (25 chars).
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

    //Escribe datos primitivos al final del archivo ocupando exactamente 217 bytes 
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
    
    // En ConexionRandomAccessFile.java
public List<String[]> leerTodosLosRegistros(File file) throws IOException {
    List<String[]> registros = new ArrayList<>();
    int total = contarRegistros(file);

    try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
        for (int i = 0; i < total; i++) {
            raf.seek((long) i * TAMANO_REGISTRO);
            int clave = raf.readInt();
            String equipo = leerString(raf);
            String j1 = leerString(raf);
            String j2 = leerString(raf);
            String j3 = leerString(raf);
            int puntaje = raf.readInt();
            raf.readInt(); // embocadas
            raf.readInt(); // victorias
            raf.readBoolean(); // haGanadoAntes

            registros.add(new String[]{
                String.valueOf(clave), equipo, j1, j2, j3, String.valueOf(puntaje)
            });
        }
    }
    return registros;
}

// Método auxiliar para leer 25 chars (50 bytes)
private String leerString(RandomAccessFile raf) throws IOException {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 25; i++) {
        sb.append(raf.readChar());
    }
    return sb.toString().trim();
}
}
