/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Asus
 */
public class Servidor {

    int puerto = 5000;

    ServerSocket sServidor = null;
    Socket sCliente = null;

    BufferedReader entrada;
    DataOutputStream salida;
    String llego;

    public Servidor() {
        try {
            sServidor = new ServerSocket(5000);
            System.out.println("Socket escuchando en puerto 5000");

            sCliente = sServidor.accept();
            System.out.println("Ya se conecto el cliente");

            entrada = new BufferedReader(new InputStreamReader(sCliente.getInputStream()));
            salida = new DataOutputStream(sCliente.getOutputStream());

            
            //CONTROL
            do {
                llego = entrada.readLine();
                if (!llego.equals("1")) {
                    System.out.println("Palabra a comparar: " + llego);
                    int fin = llego.length() - 1;
                    int ini = 0;
                    boolean espalin = true;
                    while (ini < fin) {
                        if (llego.charAt(ini) != llego.charAt(fin)) {
                            espalin = false;
                        }
                        ini++;
                        fin--;
                    }
                    String rta;
                    if (espalin) {
                        rta = "Espalindromo.";
                    } else {
                        rta = "No es palindromo.";
                    }
                    salida.writeUTF(rta);
                }

            } while (!llego.equals("1"));

            System.out.println("Ya termine de recibir");

            entrada.close();
            sCliente.close();
            sServidor.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
    
    public static void main(String[] args) {
        new Servidor();
    }

}
