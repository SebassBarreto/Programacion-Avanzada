package pa.archivosplanos.modelo;

import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author Asus
 */
public class Archivo {
    File f;
    JFileChooser fc;

/**
 * Method for opening and selecting file whit
 * @JFileChooser
 */
public Archivo(){
	fc=new JFileChooser(System.getProperty("user.dir"));   
	fc.showOpenDialog(fc);
	f=fc.getSelectedFile(); 
    }


/**
 * Method for reading all the lines in the file whit
 * @f1 destiny
 * @f2 reader of the destiny input
 * @linea separates in bytes from buffer
 */
public void leer(){
    try{
        FileInputStream f1 =new FileInputStream(f);
        InputStreamReader f2= new InputStreamReader(f1);
        BufferedReader linea= new BufferedReader(f2);
        if (f.exists()){ 
            System.out.println("El fichero " + f + " existe \nSu contenido es: \n");
            String linea_arch=linea.readLine();//reads file line
            while (linea_arch != null) { //reads all file lines
                System.out.println(linea_arch);
                linea_arch = linea.readLine();
                }
                linea.close(); //closes the line and then goes to next one
            }
            else{System.out.println("archivo no existe");}
    }catch(IOException e){  System.out.println("No se pudo leer del archivo");  
    }

}

/**
 * Method for writing new lines in the file till you chooses between 0 and 1 
 * 
 */
public void Escribir() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader linea = new BufferedReader(isr);
            FileWriter linea_tx = new FileWriter(f, true);
            String linea_arch;
            int flag = 0;
            while (flag == 0) {
                System.out.println("Digite la nueva linea: \t");
                linea_arch = linea.readLine();
                linea_tx.write(linea_arch + "\n");
                System.out.println("Digite (0 para continuar) (1 para finalizar): \t");
                flag = Integer.parseInt(linea.readLine());
            }

            linea_tx.close();
        } catch (IOException e) {
            System.out.print("No se pudo escribir");
        }
    }


public static void main(String [] args){
		Archivo arch=new Archivo();
		arch.leer();
		arch.Escribir();
	}  //fin del main
}  //fin de la clase




