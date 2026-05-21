/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Logica;

import java.util.ArrayList;
import Controlador.DAO.EstudianteDAO;
import Controlador.DAO.EstudianteDAO;
import Modelo.EstudianteDTO;

public class Gestor {

    private EstudianteDAO miEstudianteDAO;

    public Gestor() {
        registrarEstudiante();
        obtenerRegistros();
        buscarEstudiante();
        eliminarEstudiante();
        modificarEstudiante();

    }

    private void obtenerRegistros() {
        miEstudianteDAO = new EstudianteDAO();
        EstudianteDTO miEstudiante;
        ArrayList<EstudianteDTO> listaEstudiantes = miEstudianteDAO.listaDeEstudiantes();
        if (listaEstudiantes.size() > 0) {
            int numeroEstudiante = 0;
            for (int i = 0; i < listaEstudiantes.size(); i++) {
                numeroEstudiante++;
                miEstudiante = listaEstudiantes.get(i);
                System.out.println("****************Estudiante No. " + numeroEstudiante + "**********");
                System.out.println("Codigo Estudiante: " + miEstudiante.getCodigo());
                System.out.println("Nombre Estudiante: " + miEstudiante.getNombre());
                System.out.println("Edad Estudiante: " + miEstudiante.getEdad());
                System.out.println("*************************************************\n");
            }
        } else {
            System.out.println("Actualmente no existen registros de estudiantes");
        }
    }

    private void buscarEstudiante() {
        miEstudianteDAO = new EstudianteDAO();
        String codigo = "202210200030";
        EstudianteDTO estudianteEncontrada = miEstudianteDAO.consultarEstudiante(codigo);
        if (estudianteEncontrada != null) {
            System.out.println("**************** Estudiante Consultado *************************");
            System.out.println("Codigo Estudiante: " + estudianteEncontrada.getCodigo());
            System.out.println("Nombre Estudiante: " + estudianteEncontrada.getNombre());
            System.out.println("Edad Estudiante : " + estudianteEncontrada.getEdad());
            System.out.println("*************************************************\n");

        } else {
            System.out.println("No existen un estudiante con ese codigo");
        }
    }

    private void registrarEstudiante() {
        miEstudianteDAO = new EstudianteDAO();
        EstudianteDTO miEstudiante1 = new EstudianteDTO();
        miEstudiante1.setCodigo("202210200032");
        miEstudiante1.setNombre("Pepe Rojas");
        miEstudiante1.setEdad(1);
        miEstudianteDAO.insertarDatos(miEstudiante1);
        EstudianteDTO miEstudiante2 = new EstudianteDTO();
        miEstudiante2.setCodigo("202210200033");
        miEstudiante2.setNombre("Teresa Castro");
        miEstudiante2.setEdad(2);
        miEstudianteDAO.insertarDatos(miEstudiante2);
    }

    private void eliminarEstudiante() {
        String codigo = "202210200033";
        EstudianteDTO estudianteEncontrado = miEstudianteDAO.consultarEstudiante(codigo);
        if (estudianteEncontrado != null) {
            System.out.println("************Mascota a Eliminar****************");
            System.out.println("Id Mascota: " + estudianteEncontrado.getCodigo());
            System.out.println("Nombre Mascota: " + estudianteEncontrado.getNombre());
            System.out.println("Edad Mascota: " + estudianteEncontrado.getEdad());
            System.out.println("********************************************\n");
            if (miEstudianteDAO.eliminarEstudiante(codigo)) {
                System.out.println("Estudiante Eliminado");
            } else {
                System.out.println("No se pudo eliminar el estudiante");
            }
        } else {
            System.out.println("No existen un estudiante con ese codigo");
        }
    }

    private void modificarEstudiante() {
        String codigo = "202210200031";
        EstudianteDTO estudianteEncontrado = miEstudianteDAO.consultarEstudiante(codigo);
        if (estudianteEncontrado != null) {
            System.out.println("****************Estudiante a Modificar****************");
            System.out.println("Codigo Estudiante: " + estudianteEncontrado.getCodigo());
            System.out.println("Nombre Estudiante: " + estudianteEncontrado.getNombre());
            System.out.println("Edad Estudiante: " + estudianteEncontrado.getEdad());
            System.out.println("*************************************************\n");

            if (miEstudianteDAO.modificarEstudiante(codigo)) {
                System.out.println("Estudiante Modificado");
                estudianteEncontrado = miEstudianteDAO.consultarEstudiante(codigo);
                System.out.println("****************Estudiante Modificado****************");
                System.out.println("Codigo Estudiante: " + estudianteEncontrado.getCodigo());
                System.out.println("Nombre Estudiante: " + estudianteEncontrado.getNombre());
                System.out.println("Edad Estudiante: " + estudianteEncontrado.getEdad());
                System.out.println("*************************************************\n");
            } else {
                System.out.println("No se pudo modificar el estudiante");
            }
        } else {
            System.out.println("No existen una mascota con ese codigo");
        }
    }
}