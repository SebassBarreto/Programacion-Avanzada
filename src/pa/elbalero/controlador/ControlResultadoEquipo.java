package pa.elbalero.controlador;

import pa.elbalero.modelo.ResultadoEquipo;

public class ControlResultadoEquipo {
    private ResultadoEquipo resultado;
    
    public void crearResultado(int puntos, int intentos, int embocados){
        resultado = new ResultadoEquipo(puntos, intentos, embocados);
    }
    
    public void sumarPuntos(int puntos){
        resultado.setPuntos(resultado.getPuntos()+puntos);
    }
    
    public void sumarIntentos(int intentos){
        resultado.setIntentos(resultado.getIntentos()+ intentos);
    }
    
    public void sumarEmbocados(int embocados){
        resultado.setIntentos(resultado.getIntentos()+ embocados);
    }
}
