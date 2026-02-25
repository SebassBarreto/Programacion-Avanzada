
package pa.elbalero.modelo;

public enum TipoEmbocada {
    SIMPLE("Simple", 2), 
    DOBLE("Doble", 10),
    VERTICAL("Vertical",3), 
    MARIQUITA("Mariquita",4), 
    PUNIALADA("Puñalada",5),
    PURTINIA("Purtiña",6),
    DOMINIO_DE_REVES("Dominio de revés", 8),
    SIN_EMBOCADA("Sin embocada",0); 
    
    private final String texto;
    private final int puntos;
   
    TipoEmbocada(String texto, int puntos){
        this.texto = texto;
        this.puntos = puntos;
    }

    public String getTexto() {
        return texto;
    }

    public int getPuntos() {
        return puntos;
    }
}
