package pa.ejemploserializacion.control;

import pa.ejemploserializacion.modelo.Persona;
import pa.ejemploserializacion.modelo.Serializacion;

/**
 *
 * @author Asus
 */
public class Gestor {
    
    private Persona personaASerializar;
    private Persona personaDesSerializada;
    private Serializacion serializar; 

    public Gestor() {
        serializar = new Serializacion();
    }
    
    public void PruebaSerializar(){
        personaASerializar = new Persona("Sebastian", "Correa", 18);
        serializar.escribirArchivoSerializado(personaASerializar);
        personaDesSerializada = new Persona();
        personaDesSerializada = (Persona) serializar.leerArchivoSerializado();
        System.out.println("Persona DesSerializada: "+personaDesSerializada.getNombre()+" "+ personaDesSerializada.getApellido());
    }
    
    
    
}
