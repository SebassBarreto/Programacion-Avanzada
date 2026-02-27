package pa.elbalero.controlador;

public class ControlPrincipal {
    private ControlVista controlVista;
    
    public ControlPrincipal(){
        controlVista = new ControlVista(this);
    }
    
}
