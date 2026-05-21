package pa.minipigs.Modelo;

/**
 * Data Transfer Object (DTO) que representa a un MiniPig en el sistema.
 *
 * Contiene todos los atributos de un minipig y los métodos de acceso
 * (getters/setters) para cada uno de ellos.
 *
 * @author Valen Aguilar
 * @author Sergio Vanegas
 */
public class MiniPigDTO {

    /** Código único de identificación del minipig. */
    private String codigo;

    /** Nombre del minipig. */
    private String nombre;

    /** Sexo del minipig (M = Macho / H = Hembra). */
    private String sexo;

    /** Identificador del microchip implantado en el minipig. */
    private String idMicrochip;

    /** Raza del minipig. */
    private String raza;

    /** Color del pelaje del minipig. */
    private String color;

    /** Peso del minipig en kilogramos. */
    private String peso;

    /** Altura del minipig en centímetros. */
    private String altura;

    /** Primera característica física o de comportamiento del minipig. */
    private String caracteristica1;

    /** Segunda característica física o de comportamiento del minipig. */
    private String caracteristica2;

    /** URL o ruta de la foto del minipig. */
    private String urlFoto;

    /**
     * Constructor vacío de MiniPigDTO.
     * Crea un objeto sin inicializar sus atributos.
     */
    public MiniPigDTO() {
    }

    /**
     * Constructor completo de MiniPigDTO.
     * Inicializa todos los atributos del minipig.
     *
     * @param codigo          código único del minipig
     * @param nombre          nombre del minipig
     * @param sexo            sexo del minipig (M = Macho / H = Hembra)
     * @param idMicrochip     identificador del microchip
     * @param raza            raza del minipig
     * @param color           color del pelaje
     * @param peso            peso en kilogramos
     * @param altura          altura en centímetros
     * @param caracteristica1 primera característica del minipig
     * @param caracteristica2 segunda característica del minipig
     * @param urlFoto         URL o ruta de la foto del minipig
     */
    public MiniPigDTO(String codigo, String nombre, String sexo, String idMicrochip, String raza, String color, String peso, String altura, String caracteristica1, String caracteristica2, String urlFoto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.idMicrochip = idMicrochip;
        this.raza = raza;
        this.color = color;
        this.peso = peso;
        this.altura = altura;
        this.caracteristica1 = caracteristica1;
        this.caracteristica2 = caracteristica2;
        this.urlFoto = urlFoto;
    }

    /**
     * Retorna el código único del minipig.
     *
     * @return código del minipig
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código único del minipig.
     *
     * @param codigo nuevo código del minipig
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre del minipig.
     *
     * @return nombre del minipig
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del minipig.
     *
     * @param nombre nuevo nombre del minipig
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el sexo del minipig.
     *
     * @return sexo del minipig (M = Macho / H = Hembra)
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del minipig.
     *
     * @param sexo nuevo sexo del minipig (M = Macho / H = Hembra)
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Retorna el identificador del microchip del minipig.
     *
     * @return identificador del microchip
     */
    public String getIdMicrochip() {
        return idMicrochip;
    }

    /**
     * Establece el identificador del microchip del minipig.
     *
     * @param idMicrochip nuevo identificador del microchip
     */
    public void setIdMicrochip(String idMicrochip) {
        this.idMicrochip = idMicrochip;
    }

    /**
     * Retorna la raza del minipig.
     *
     * @return raza del minipig
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Establece la raza del minipig.
     *
     * @param raza nueva raza del minipig
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Retorna el color del pelaje del minipig.
     *
     * @return color del minipig
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del pelaje del minipig.
     *
     * @param color nuevo color del minipig
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retorna el peso del minipig en kilogramos.
     *
     * @return peso del minipig
     */
    public String getPeso() {
        return peso;
    }

    /**
     * Establece el peso del minipig en kilogramos.
     *
     * @param peso nuevo peso del minipig
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * Retorna la altura del minipig en centímetros.
     *
     * @return altura del minipig
     */
    public String getAltura() {
        return altura;
    }

    /**
     * Establece la altura del minipig en centímetros.
     *
     * @param altura nueva altura del minipig
     */
    public void setAltura(String altura) {
        this.altura = altura;
    }

    /**
     * Retorna la primera característica del minipig.
     *
     * @return primera característica
     */
    public String getCaracteristica1() {
        return caracteristica1;
    }

    /**
     * Establece la primera característica del minipig.
     *
     * @param caracteristica1 nueva primera característica
     */
    public void setCaracteristica1(String caracteristica1) {
        this.caracteristica1 = caracteristica1;
    }

    /**
     * Retorna la segunda característica del minipig.
     *
     * @return segunda característica
     */
    public String getCaracteristica2() {
        return caracteristica2;
    }
    
    /**
     * Establece la segunda característica del minipig.
     *
     * @param caracteristica2 nueva segunda característica
     */
    public void setCaracteristica2(String caracteristica2) {
        this.caracteristica2 = caracteristica2;
    }

    /**
     * Retorna la URL o ruta de la foto del minipig.
     *
     * @return URL o ruta de la foto
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * Establece la URL o ruta de la foto del minipig.
     *
     * @param urlFoto nueva URL o ruta de la foto
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

}
