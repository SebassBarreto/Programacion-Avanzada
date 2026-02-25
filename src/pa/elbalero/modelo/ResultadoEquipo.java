
package pa.elbalero.modelo;

public class ResultadoEquipo {
    private int puntos, intentos, embocados;

    public ResultadoEquipo(int puntos, int intentos, int embocados) {
        this.puntos = puntos;
        this.intentos = intentos;
        this.embocados = embocados;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getEmbocados() {
        return embocados;
    }

    public void setEmbocados(int embocados) {
        this.embocados = embocados;
    }
 
    
}
