
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Cliente {
    
    String HOST = "127.0.0.1";
    int PUERTO = 5000;

    public Cliente() {
    
        try {
            Socket sCliente = new Socket(HOST, PUERTO);
            InputStream aux = sCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            System.out.println(flujo.readUTF());
            sCliente.close();
            
        } catch (IOException e) {
            
            System.out.println(e.getMessage());
        
        }
        
    }
   
    
    
    
}
