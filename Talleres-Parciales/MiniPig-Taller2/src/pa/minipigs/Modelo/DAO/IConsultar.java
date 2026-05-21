package pa.minipigs.Modelo.DAO;

import java.util.ArrayList;
import pa.minipigs.Modelo.MiniPigDTO;

/**
 * Contrato para las operaciones de consulta ISP (SOLID).
 *
 * @author Sergio Vanegas
 * @version 1.0
 */
public interface IConsultar {

    /**
     * Consulta un minipig por su codigo
     * @param codigo codigo del minipig
     * @return MiniPigDTO con todos sus datos
     */
    MiniPigDTO consultarPorCodigo(String codigo);

    /**
     * Consulta un minipig por su id de microchip
     * @param idMicrochip id del microchip
     * @return MiniPigDTO con todos sus datos
     */
    MiniPigDTO consultarPorMicrochip(String idMicrochip);

    /**
     * Consulta todos los minipigs de una raza
     * @param raza raza a consultar
     * @return MiniPigDTO de minipigs de esa raza
     */
    ArrayList<MiniPigDTO> consultarPorRaza(String raza);

    /**
     * Consulta todos los minipigs con un nombre dado
     * @param nombre nombre a consultar
     * @return ArrayList con todos los minipigs que correspondan
     */
    ArrayList<MiniPigDTO> consultarPorNombre(String nombre);

    /**
     * Consulta todos los minipigs en la base de datos
     * @return ArrayList con todos los minipigs que correspondan
     */
    ArrayList<MiniPigDTO> consultarTodos();
    
    /**
     * Consulta todos los minipigs con un color dado
     * @param color
     * @return ArrayList con todos los minipigs que correspondan
     */
    ArrayList<MiniPigDTO> consultarPorColor(String color);
    
    /**
     * Consulta todos los minipigs con un peso dado
     * @param peso
     * @return ArrayList con todos los minipigs que correspondan
     */
    ArrayList<MiniPigDTO> consultarPorPeso(String peso);
    
    /**
     * 
     * @param altura
     * @return ArrayList con todos los minipigs que correspondan
     */
    ArrayList<MiniPigDTO> consultarPorAltura(String altura);
}