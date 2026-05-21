
package pa.minipigs.Modelo.DAO;

/**
 * Contrato para las operaciones de eliminación ISP (SOLID).
 *
 * @author Sebastian Barreto
 * @version 1.0
 */
public interface IEliminar {

    /**
     * Elimina un MIniPig por su codigo
     * @param codigo codigo del minpig
     */
    void eliminarPorCodigo(String codigo);

    /**
     *  Elimina un MiniPig por su id microchip
     * @param idMicrochip id del microchip
     */
    void eliminarPorIdMicrochip(String idMicrochip);
}
