package pa.persistenciadearchivos.modelo;

import java.io.*;
import static java.lang.System.in;

/**
 *
 * @author Asus
 */
public class ArchivoAleatorio {

    private int clave; //4 bytes
    private String nombre; //25 caracteres cada caracter 2 bytes 25*2 = 50 bytes
    private int edad; //4 bytes
    private long tamanioRegistro; //Tamaño de registros
    private long cantidadRegistro; //Candidad de registros
    private File fl;
    private RandomAccessFile archivo;

    public ArchivoAleatorio() {
        //inicializar todo en valores nulos
        this.clave = 0;
        this.nombre = "";
        this.edad = 0;
        this.tamanioRegistro = 58;
        this.cantidadRegistro = 0;
        this.fl = new File("C:\\Users\\Asus\\Documents//Prueba.dat"); //ruta
        try {
            this.archivo = new RandomAccessFile(this.fl, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void escribir() {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(in));
        try {
            System.out.println("\nEscribiendo Registros:");
            String r = "S"; //Quiere continuar? S = si nuestra flag
            while (r.equalsIgnoreCase("S")) {
                clave = (int) (archivo.length() / tamanioRegistro);
                clave++;
                System.out.println("Ingrese nombre: ");
                nombre = teclado.readLine();
                if (nombre.length() < 25) { //Completar los bytes si es menor que 25 caracteres
                    for (int i = nombre.length(); i < 25; i++) {
                        nombre += " ";
                    }
                } else { //No es menor a los 25 caracteres
                    nombre = nombre.substring(0, 25); //extrae un substring de la cadena del 
                    //nombre desde el caracter 0 hasta 25 de ahi en adelante se pierde.
                }
                System.out.println("Ingrese edad: ");
                edad = Integer.parseInt(teclado.readLine());//parsear la edad para tomarla como string
                if (archivo.length() != 0) { //hasta que haya 
                    archivo.seek(archivo.length());//para que nos deje al final del archivo con esto no se corrompe
                }
                archivo.writeInt(clave); //escriba el registro
                archivo.writeChars(nombre);//escriba el nombre  
                archivo.writeInt(edad);//escriba la edad
                System.out.println("Ingresar otra linea (S or N)?: \t");
                r = teclado.readLine();
            }
        } catch (FileNotFoundException fnfe) {/* Archivo no encontrado */
        } catch (IOException ioe) {
            /* Error al escribir */
        }
    }

    public void leerTodo() {
        System.out.println("\nMostrando todos los Registros");
        try {
            archivo.seek(0);

            cantidadRegistro = archivo.length() / tamanioRegistro; //calcular registros reales

            for (int r = 0; r < cantidadRegistro; r++) {
                nombre = "";

                clave = archivo.readInt();

                for (int i = 0; i < 25; ++i) {
                    nombre += archivo.readChar();
                }

                edad = archivo.readInt();

                System.out.println(" Registro No: " + clave
                        + " Nombre: " + nombre
                        + " Edad: " + edad);
            }

        } catch (IOException ioe) {
        }
    }

    public void cerrar() {
        try {
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArchivoAleatorio arch = new ArchivoAleatorio();
        arch.escribir();
        arch.leerTodo();
        arch.leerUnRegistro();
        arch.cerrar();
    }

    public void leerUnRegistro() {
        nombre = "";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nBuscando un Registro:");
        System.out.println("Ingrese el numero de registro a buscar: ");
        try {
            archivo.seek(0);
            clave = Integer.parseInt(teclado.readLine());
            archivo.seek((clave - 1) * tamanioRegistro); // argumento es tipo long
            clave = archivo.readInt();
            for (int i = 0; i < 25; ++i) {
                nombre += archivo.readChar();
            }
            edad = archivo.readInt();
            System.out.println("Registro No. " + clave + " Nombre: " + nombre
                    + " Edad: " + edad + "\n\n");
            nombre = "";
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
    }
}
