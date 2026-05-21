package pa.minipigs.Modelo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Valen Aguilar
 */
public class CnxProperties {

    /**
     * Instancia única de la clase (Patrón Singleton).
     */
    private static CnxProperties instancia = null;

    /**
     * Lista de MiniPigs cargados desde el archivo properties.
     */
    private ArrayList<MiniPigDTO> minipigsCargados;

    /**
     * Constructor privado para el patrón Singleton. Inicializa la lista de
     * minipigs.
     */
    private CnxProperties() {
        this.minipigsCargados = new ArrayList<>();
    }

    public static synchronized CnxProperties getInstance() {
        if (instancia == null) {
            instancia = new CnxProperties();
        }
        return instancia;
    }

    public ArrayList<MiniPigDTO> cargarProperties(String rutaArchivo) {

        Properties props = new Properties();
        minipigsCargados.clear();

        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {

            props.load(fis);

            // Detectar cuántos minipigs hay
            int indice = 1;

            while (true) {

                String prefijo = "minipig" + indice;

                // Si no existe el código, asumimos que no hay más minipigs
                if (props.getProperty(prefijo + ".codigo") == null) {
                    break;
                }

                MiniPigDTO minipig = new MiniPigDTO(
                        props.getProperty(prefijo + ".codigo", "").trim(),
                        props.getProperty(prefijo + ".nombre", "").trim(),
                        props.getProperty(prefijo + ".sexo", "").trim(),
                        props.getProperty(prefijo + ".idMicrochip", "").trim(),
                        props.getProperty(prefijo + ".raza", "").trim(),
                        props.getProperty(prefijo + ".color", "").trim(),
                        props.getProperty(prefijo + ".peso", "").trim(),
                        props.getProperty(prefijo + ".altura", "").trim(),
                        props.getProperty(prefijo + ".caracteristica1", "").trim(),
                        props.getProperty(prefijo + ".caracteristica2", "").trim(),
                        props.getProperty(prefijo + ".urlFoto", "").trim()
                );

                minipigsCargados.add(minipig);

                indice++;
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al cargar el archivo properties: " + rutaArchivo,
                    e
            );
        }

        return minipigsCargados;
    }

    /**
     * Parsea una línea de datos del archivo properties y crea un MiniPigDTO.
     *
     * Formato esperado:
     * {codigo},{nombre},{sexo},{id_microchip},{raza},{color},{peso},
     * {altura},{caracteristica1},{caracteristica2},{url_foto}
     *
     * Si algún campo contiene la palabra "null", lo marca como incompleto.
     *
     * @param datos cadena con los datos del minipig separados por comas
     * @return objeto MiniPigDTO con los datos parseados, o null si hay error
     */
    private MiniPigDTO parsearDatosMinipig(String datos) {
        try {
            // Divide los datos por coma
            String[] campos = datos.split(",");

            // Verifica que haya exactamente 11 campos
            if (campos.length != 11) {
                System.err.println("Error: Formato incorrecto. Se esperaban 11 campos, se encontraron: "
                        + campos.length);
                return null;
            }

            // Limpia espacios en blanco
            for (int i = 0; i < campos.length; i++) {
                campos[i] = campos[i].trim();
            }

            // Crea el objeto MiniPigDTO
            MiniPigDTO minipig = new MiniPigDTO(
                    campos[0], // codigo
                    campos[1], // nombre
                    campos[2], // sexo
                    campos[3], // idMicrochip
                    campos[4], // raza
                    campos[5], // color
                    campos[6], // peso
                    campos[7], // altura
                    campos[8], // caracteristica1
                    campos[9], // caracteristica2
                    campos[10] // urlFoto
            );

            return minipig;
        } catch (Exception e) {
            System.err.println("Error al parsear datos del minipig: " + e.getMessage());
            return null;
        }
    }
}
