/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Asus
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Conexion;


public class Prueba {

    private Connection con;
    private Statement st; //castear la cadena de sql para manipularla como si fuera SQL
    private ResultSet rs; //guarda las rtas de la bd

    //todo en nulo porque no hemos iniciado con nada
    public Prueba() {
        con = null;
        st = null;
        rs = null;
    }
    
    public void metodo() {
        String codigo,nombre, cedula;
        
        String consulta = "SELECT * FROM estudiantes";
        try {
            //la conexion es la misma porque el Conexion es static
            con = (Connection) Conexion.getConexion();
            //preparando para empaquetar el string
            st = con.createStatement();
            //el Query se ejecuta cuando tengo instrucciones de SELECT
            rs = st.executeQuery(consulta);
            //mientras halla mas consultas de tipo SELECT
             while (rs.next()) {
               
                codigo=rs.getString("codigo");
                cedula=rs.getString("cedula");
                nombre=rs.getString("nombre");
                
                 System.out.println("Los datos del Producto son: "+ codigo + "  "+cedula+" "+nombre);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }

    } 
    
    
    public void consultarEstudiantePorLetra(String letra) {
        String codigo,nombre, cedula;
        

        String consulta = "SELECT * FROM estudiantes WHERE nombre LIKE '" + letra + "%'";
        try {
            //la conexion es la misma porque el Conexion es static
            con = (Connection) Conexion.getConexion();
            //preparando para empaquetar el string
            st = con.createStatement();
            //el Query se ejecuta cuando tengo instrucciones de SELECT
            rs = st.executeQuery(consulta);
            //mientras halla mas consultas de tipo SELECT
             while (rs.next()) {
               
                codigo=rs.getString("codigo");
                cedula=rs.getString("cedula");
                nombre=rs.getString("nombre");
                
                 System.out.println("Los estudiantes que empiezan por la letra "+letra+" son : "+ codigo + "  "+cedula+" "+nombre);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }

    } 

    
}

