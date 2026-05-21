
package pa.minipigs.Modelo.DAO;
import pa.minipigs.Modelo.MiniPigDTO;

/**
 * Contrato para la operacion de insercion  ISP (SOLID)
 * @author Sebastian Barreto
 */
public interface IInsertar {
    
    /**
     * Inserta un MiniPig en la BD
     * @param minipig objeto DTO
     */
    boolean insertar(MiniPigDTO minipig);
}
