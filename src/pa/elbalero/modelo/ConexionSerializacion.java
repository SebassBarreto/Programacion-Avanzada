package pa.elbalero.modelo;

//Serializa equipos a archivo.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConexionSerializacion {

    /**
     * Escribe el objeto en un archivo
     * @param archivo
     * @param datos
     * @throws IOException
     */
    public void escribirObjeto(File archivo, Object datos) throws IOException {

        try (FileOutputStream fileOut = new FileOutputStream(archivo)) {
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);

            salida.writeObject(datos);
        }
    }

    /**
     * Lee el objeto desde un archivo
     * @param archivo
     * @return Object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object leerObjeto(File archivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(archivo)) {
            ObjectInputStream entrada = new ObjectInputStream(fileIn);
            return entrada.readObject();
        }
    }

}
