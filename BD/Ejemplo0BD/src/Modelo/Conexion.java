/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Asus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //static porque es variable de clase, es la misma conexion para todo el mundo, singleton

    private static Connection cn = null;
    private static String URLBD = "jdbc:mysql://localhost/universidad"; //URLBD, usuario y contraseña
    //Estos datos deben ingresarse por otro lado para cumplir el Open/Closed
    private static String usuario = "root"; //usuario
    private static String contrasena = ""; //empty

    public static Connection getConexion() {
        try {
            /**
             * La conexion a la base de datos
             *
             * @param URL a la base de datos
             * @param usuario el usuario de la bd
             * @param contrasena contrasena a la bd
             * @return conexion a la base de datos
             */
            cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        } catch (SQLException ex) { //excepcion SQL
            System.out.println("No se puede cargar el controlado");
        }
        return cn;
    }

    public static void desconectar() {
        cn = null; //desconecta la base de datos dejando a cn en null
    }
}
