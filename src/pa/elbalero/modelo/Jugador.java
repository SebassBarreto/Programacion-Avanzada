package pa.elbalero.modelo;

import java.io.Serializable;

public class Jugador implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String codigo;

    public Jugador() {
    }
    
    public Jugador(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
