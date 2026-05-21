package avanzada.microservices.msjuguetes.Domain;

public class JugueteResponse {

    private Long id;
    private String codigo;
    private String nombre;
    private FabricanteResponse fabricanteResponse;

    public Long getId() {       return id;    }

    public void setId(Long id) {        this.id = id;    }

    public String getCodigo() {        return codigo;    }

    public void setCodigo(String codigo) {        this.codigo = codigo;    }

    public String getNombre() {        return nombre;    }

    public void setNombre(String nombre) {        this.nombre = nombre;    }

    public FabricanteResponse getFabricanteResponse() {
        return fabricanteResponse;
    }

    public void setFabricanteResponse(FabricanteResponse fabricanteResponse) {
        this.fabricanteResponse = fabricanteResponse;
    }
}