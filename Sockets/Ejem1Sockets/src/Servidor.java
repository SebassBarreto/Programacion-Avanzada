
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Servidor {
    
    int PUERTO = 5000;

    public Servidor() {
        try {
            ServerSocket sServidor = new ServerSocket(PUERTO);
            System.out.println("Servidor --> Puerto de Esucha: "+ PUERTO);
            for (int numCli = 0; numCli < 3; numCli++) {
                Socket sCliente = sServidor.accept();
                System.out.println("Sirgvo al cliente "+sCliente);
                OutputStream aux = sCliente.getOutputStream();
                DataOutputStream flujo = new DataOutputStream(aux);
                flujo.writeUTF("Cliente No.: "+ numCli+ " Direccion ip del cliente: " + sCliente.getInetAddress());
                sCliente.close();
            }
            System.out.println("Demasiados clientes por hoy.");
        } catch (IOException e) {
            System.out.println("no se pudo aceptar el cliente");
        }
    }
    
    public static void main(String[] args) {
        new Servidor();
    }
    
    
    
    
}
