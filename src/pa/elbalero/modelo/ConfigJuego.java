
package pa.elbalero.modelo;

//Guarda parámetros de configuración (tiempo total por equipo, intervalo, probabilidad si aplica).

public class ConfigJuego {
    
    private int tiempoTotalEquipo; //en segs
    private int intervaloTick; //en mili segs

    public ConfigJuego() {
    }

    public ConfigJuego(int tiempoTotalEquipo, int intervaloTick) {
        this.tiempoTotalEquipo = tiempoTotalEquipo;
        this.intervaloTick = intervaloTick;
    }

    public int getTiempoPorJugador(){
        return tiempoTotalEquipo/3;
    }
    
    public int getTiempoTotalEquipo() {
        return tiempoTotalEquipo;
    }

    public void setTiempoTotalEquipo(int tiempoTotalEquipo) {
        this.tiempoTotalEquipo = tiempoTotalEquipo;
    }

    public int getIntervaloTick() {
        return intervaloTick;
    }

    public void setIntervaloTick(int intervaloTick) {
        this.intervaloTick = intervaloTick;
    }
    
    
}
