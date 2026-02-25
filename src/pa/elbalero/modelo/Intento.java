
package pa.elbalero.modelo;

//Guarda el resultado de un intento (éxito/fallo + tipo embocada).

public class Intento {

    private boolean acierto;
    private TipoEmbocada tipoEmbocada;

    public Intento() {
    }

    public Intento(boolean acierto, TipoEmbocada tipoEmbocada) {
        this.acierto = acierto;
        this.tipoEmbocada = tipoEmbocada;
    }

    public boolean isAcierto(){
        return acierto;
    }
    
    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }
    
    public TipoEmbocada getTipoEmbocada(){
        return tipoEmbocada;
    }
    
    public void setTipoEmbocada(TipoEmbocada tipoEmbocada) {
        this.tipoEmbocada = tipoEmbocada;
    }
    
}
