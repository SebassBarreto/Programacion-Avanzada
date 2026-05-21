/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Modelo.Conexion.Conexion;
import Modelo.EstudianteDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class EstudianteDAO {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public EstudianteDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public EstudianteDTO consultarEstudiante(String codigo) {
        EstudianteDTO estudiante = null;
        String consulta = "SELECT * FROM Estudiantes where codigo='" + codigo + "'";
        try {
            con = (Connection) Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                estudiante = new EstudianteDTO();
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setEdad(rs.getInt("edad"));
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return estudiante;
    }
    //SI tiene SQL EN EL DAO  si no tiene sql en el GESTOR

    public ArrayList<EstudianteDTO> listaDeEstudiantes() {
        ArrayList<EstudianteDTO> misEstudiantes = new ArrayList<EstudianteDTO>();
        String consulta = "SELECT * FROM Estudiantes";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                EstudianteDTO estudiante = new EstudianteDTO();
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setEdad(rs.getInt("edad"));
                misEstudiantes.add(estudiante);
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return misEstudiantes;
    }

    public void insertarDatos(EstudianteDTO estudiante) {
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Estudiantes VALUES('" + estudiante.getCodigo() + "','" + estudiante.getNombre() + "'," + estudiante.getEdad() + ")";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }

    public boolean eliminarEstudiante(String codigo) {
        String consulta = "DELETE FROM Estudiantes where codigo='" + codigo + "'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la eliminacion");
        }
        return false;
    }

    public boolean modificarEstudiante(String codigo) {
        //Update estudiantes set nombre='Maria Perez' where codigo=202210200031
        String consulta = "update Estudiantes set edad=" + 45 + " where codigo='" + codigo + "'";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la modifcacion");
        }
        return false;
    }
}