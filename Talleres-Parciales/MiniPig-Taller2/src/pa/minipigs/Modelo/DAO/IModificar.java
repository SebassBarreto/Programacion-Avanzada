
package pa.minipigs.Modelo.DAO;

import pa.minipigs.Modelo.MiniPigDTO;


/**
 * Contrato para la operación de modificación ISP (SOLID)
 * @author Sebastian Barreto
 */
public interface IModificar {

    /**
     * Modifica los datos de un minipig en la BD
     * @param minipig objeto DTO
     */
    void modificar(MiniPigDTO minipig);
}
