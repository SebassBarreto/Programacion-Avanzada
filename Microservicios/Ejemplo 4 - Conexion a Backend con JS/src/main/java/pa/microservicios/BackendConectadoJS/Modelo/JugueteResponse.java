package pa.microservicios.BackendConectadoJS.Modelo;

public class JugueteResponse {
    private String nombre;

    public JugueteResponse() {
    }

    public JugueteResponse(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}