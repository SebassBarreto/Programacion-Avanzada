package pa.elbalero.modelo;

import java.io.Serializable;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String codigo;
    private int embocadasDesacertadas;
    private int embocadasAcertadas;
    private int puntaje;

    public Jugador() {
    }

    public Jugador(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.embocadasDesacertadas = 0;
        this.embocadasAcertadas = 0;
        this.puntaje = 0;
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

    public int getEmbocadasAcertadas() {
        return embocadasAcertadas;
    }

    public int getEmbocadasDesacertadas() {
        return embocadasDesacertadas;
    }

    public int getPuntaje() {
        return puntaje;
    }

}
