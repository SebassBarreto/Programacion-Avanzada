/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Servidor {

    //ServerSocket para recibir el cliente
    private ServerSocket servidor;
    //Dos sockets uno para recibir la comunicacion y el otro para enviar
    private Socket serverIn, serverOut;
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;
    private BufferedReader delTeclado;

    public Servidor() {
        try {
            servidor = new ServerSocket(5051);
            System.out.println("Servidor en espera de conversacion ......");

            //se conecta el cliente (uno) por eso no hay ciclo
            serverIn = servidor.accept();
            System.out.println("Conversacioniniciada......");

            //crear los flujos de comunicacion con el cliente
            crearFlujos();
        } catch (IOException e) {
            System.out.println("Error: No se pudo crear el Servidor");
        }
    }

    private void crearFlujos() {
        try {
            //flujos para leer desde el cliente
            is = serverIn.getInputStream();
            dis = new DataInputStream(is);
            //flujos para escribirle al cliente (distintos puertos)
            serverOut = new Socket(serverIn.getInetAddress(), 5052);
            os = serverOut.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (IOException ex) {
            System.out.println("Error: No se pudo crear los flujos");
        }
        //activar la lectura de la consola
        delTeclado = new BufferedReader(new InputStreamReader(System.in));
        //iniciar la charla
        charlar();
    }

    private void charlar() {
        String teclado = null, delCliente = "";
        String[] palabras = new String[2];

        palabras[1] = "";
        try {
            while (!palabras[1].equalsIgnoreCase("chao")) {
                //se lee el mensaje del cliente por el socket
                delCliente = dis.readUTF();
                //El mensaje llegaria como 
                //cliente>>mensaje
                System.out.print("\n" + delCliente);
                //Partir usando split
                palabras = delCliente.split(">>");
                //si el cliente aun no se despide
                if (!palabras[1].equalsIgnoreCase("Chao")) {
                    System.out.print("\nMensaje: ");
                    teclado = delTeclado.readLine();
                    dos.writeUTF("Servidor >>" + teclado);
                    if (teclado.equalsIgnoreCase("chao")) {
                        palabras[1] = "chao";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo leer desde el socket");
        }
        System.out.println("\nSetermino la conversacion");
        cerrarSockets();
    }

    private void cerrarSockets() {
        try {
            dis.close();
            dos.close();
            serverIn.close();
            serverOut.close();
            servidor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo cerrar los sockets");
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }

}
