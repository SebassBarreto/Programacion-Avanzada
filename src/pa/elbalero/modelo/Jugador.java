package pa.elbalero.modelo;

import java.io.Serializable;

/**
 * Representa un jugador individual dentro de un equipo.
 * Almacena el nombre el codigo de estudiante y las estadisticas de embocadas.
 * Implementa Serializable para poder ser persistido junto con su equipo.
 */
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String codigo;
    private int embocadasDesacertadas;
    private int embocadasAcertadas;
    private int puntaje;

    public Jugador() {
    }

    /**
     * Crea un jugador con su nombre y codigo de estudiante.
     * Las estadisticas se inicializan en cero.
     * @param nombre nombre del jugador
     * @param codigo codigo de estudiante del jugador
     */
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

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setEmbocadasAcertadas(int embocadasAcertadas) {
        this.embocadasAcertadas = embocadasAcertadas;
    }

    public void setEmbocadasDesacertadas(int embocadasDesacertadas) {
        this.embocadasDesacertadas = embocadasDesacertadas;
    }

    /**
     * Suma puntos al puntaje acumulado del jugador
     * @param puntos cantidad de puntos a agregar segun el tipo de embocada
     */
    public void agregarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

    /**
     * Incrementa en uno el contador de embocadas acertadas del jugador
     */
    public void incrementarAcertadas() {
        this.embocadasAcertadas++;
    }

    /**
     * Incrementa en uno el contador de embocadas fallidas del jugador
     */
    public void incrementarDesacertadas() {
        this.embocadasDesacertadas++;
    }

}
