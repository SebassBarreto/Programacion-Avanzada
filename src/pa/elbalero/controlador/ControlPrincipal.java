package pa.elbalero.controlador;

public class ControlPrincipal {
    private ControlVista controlVista;
    int Tiempo;
    
    public ControlPrincipal(){
        controlVista = new ControlVista(this);
    }
    
    public void tiempoDeLaCompetencia(int t){
        Tiempo = t;
    }
    
    
    
}
