package pa.minipigs.Modelo.DAO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import pa.minipigs.Control.ControlMiniPig;
import pa.minipigs.Modelo.Conexion.CnxBD;
import pa.minipigs.Modelo.MiniPigDTO;

/**
 * Contrato para la operación de modificación ISP (SOLID)
 *
 * @author Sergio Vanegas
 * @author Valen Aguilar
 */
public class MiniPigDAO implements IConsultar, IEliminar, IInsertar, IModificar {

    private ControlMiniPig cmp;
    private MiniPigDTO minipig;
    private ArrayList<MiniPigDTO> lista;

    /**
     * Constructor que recibe la inyección de dependencia
     *
     * @param cmp controlador de minipig utilizado para crear instancias de MiniPigDTO
     */
    public MiniPigDAO(ControlMiniPig cmp) {
        this.cmp = cmp;
        this.minipig = null;
        lista = new ArrayList<>();
    }

    /**
     * Consulta un minipig por su codigo
     *
     * @param codigo codigo del minipig
     * @return MiniPigDTO con todos sus datos
     */
    @Override
    public MiniPigDTO consultarPorCodigo(String codigo) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE codigo=?")) {
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rsAMiniPig(rs);
                }
            }
        } catch (SQLException sqlex) {
        }
        return null;
    }

    /**
     * Consulta un minipig por su id de microchip
     *
     * @param id_microchip id del microchip
     * @return MiniPigDTO con todos sus datos
     */
    @Override
    public MiniPigDTO consultarPorMicrochip(String id_microchip) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE id_microchip=?")) {
            ps.setString(1, id_microchip);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rsAMiniPig(rs);
                }
            }
        } catch (SQLException sqlex) {
        }
        return null;
    }

    /**
     * Consulta todos los minipigs de una raza
     *
     * @param raza raza a consultar
     * @return MiniPigDTO de minipigs de esa raza
     */
    @Override
    public ArrayList<MiniPigDTO> consultarPorRaza(String raza) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE raza=?")) {
            ps.setString(1, raza);
            try (ResultSet rs = ps.executeQuery()) {
                lista = rsAList(rs);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Consulta todos los minipigs con un nombre dado
     *
     * @param nombre nombre a consultar
     * @return ArrayList con todos los minipigs que correspondan
     */
    @Override
    public ArrayList<MiniPigDTO> consultarPorNombre(String nombre) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE nombre=?")) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                lista = rsAList(rs);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Consulta todos los minipigs en la base de datos
     *
     * @return ArrayList con todos los minipigs que correspondan
     */
    @Override
    public ArrayList<MiniPigDTO> consultarTodos() {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs");
             ResultSet rs = ps.executeQuery()) {
            lista = rsAList(rs);
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Consulta todos los minipigs con un color dado
     *
     * @param color color a consultar
     * @return ArrayList con todos los minipigs que correspondan
     */
    @Override
    public ArrayList<MiniPigDTO> consultarPorColor(String color) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE color=?")) {
            ps.setString(1, color);
            try (ResultSet rs = ps.executeQuery()) {
                lista = rsAList(rs);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Consulta todos los minipigs con un peso dado
     *
     * @param peso peso a consultar
     * @return ArrayList con todos los minipigs que correspondan
     */
    @Override
    public ArrayList<MiniPigDTO> consultarPorPeso(String peso) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE peso=?")) {
            ps.setString(1, peso);
            try (ResultSet rs = ps.executeQuery()) {
                lista = rsAList(rs);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Consulta todos los minipigs con una altura dada
     *
     * @param altura altura a consultar
     * @return ArrayList con todos los minipigs que correspondan
     */
    @Override
    public ArrayList<MiniPigDTO> consultarPorAltura(String altura) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM minipigs WHERE altura=?")) {
            ps.setString(1, altura);
            try (ResultSet rs = ps.executeQuery()) {
                lista = rsAList(rs);
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Extrae los datos del minipig proporcionados por el ResultSet y los pasa
     * al método de ControlMiniPig para instanciación de un solo objeto
     *
     * @param rs ResultSet con los datos del minipig
     * @return MiniPigDTO instanciado a partir de ResultSet
     */
    private MiniPigDTO rsAMiniPig(ResultSet rs) {
        try {

            String codigo = rs.getString("codigo");
            String nombre = rs.getString("nombre");
            String sexo = rs.getString("sexo");
            String idMicrochip = rs.getString("id_microchip");
            String raza = rs.getString("raza");
            String color = rs.getString("color");
            String peso = rs.getString("peso");
            String altura = rs.getString("altura");
            String caracteristica1 = rs.getString("caracteristica1");
            String caracteristica2 = rs.getString("caracteristica2");
            String urlFoto = rs.getString("url_foto");

            minipig = cmp.crearMiniPig(codigo, nombre, sexo, idMicrochip, raza, color, peso, altura, caracteristica1, caracteristica2, urlFoto);

        } catch (SQLException ex) {
        }
        return minipig;
    }

    /**
     * Recorre el ResultSet mientras siga habiendo elementos. Añade cada minipig
     * a un ArrayList, utilizando el método de un solo objeto para cada uno.
     *
     * @param rs ResultSet con los datos de múltiples minipigs
     * @return ArrayList con los MiniPigDTO recién instanciados a partir del
     * ResultSet
     */
    private ArrayList<MiniPigDTO> rsAList(ResultSet rs) {
        lista.clear();
        try {
            while (rs.next()) {
                lista.add(rsAMiniPig(rs));
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    /**
     * Elimina el minipig que corresponde con el codigo proporcionado
     *
     * @param codigo código del minipig a eliminar
     */
    @Override
    public void eliminarPorCodigo(String codigo) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("DELETE FROM minipigs WHERE codigo=?")) {
            ps.setString(1, codigo);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    /**
     * Elimina el minipig que corresponde con el id de microchip proporcionado
     *
     * @param idMicrochip identificador del microchip del minipig a eliminar
     */
    @Override
    public void eliminarPorIdMicrochip(String idMicrochip) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement("DELETE FROM minipigs WHERE id_microchip=?")) {
            ps.setString(1, idMicrochip);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    /**
     * Inserta un nuevo minipig en la base de datos
     *
     * @param minipig objeto MiniPigDTO con los datos del minipig a insertar
     * @return {@code true} si la inserción fue exitosa; {@code false} en caso contrario
     */
    @Override
    public boolean insertar(MiniPigDTO minipig) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO minipigs VALUES(?,?,?,?,?,?,?,?,?,?,?)")) {
            ps.setString(1, minipig.getCodigo());
            ps.setString(2, minipig.getNombre());
            ps.setString(3, minipig.getSexo());
            ps.setString(4, minipig.getIdMicrochip());
            ps.setString(5, minipig.getRaza());
            ps.setString(6, minipig.getColor());
            ps.setString(7, minipig.getPeso());
            ps.setString(8, minipig.getAltura());
            ps.setString(9, minipig.getCaracteristica1());
            ps.setString(10, minipig.getCaracteristica2());
            ps.setString(11, minipig.getUrlFoto());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Modifica los datos de un minipig existente en la base de datos
     *
     * @param minipig objeto MiniPigDTO con los nuevos datos del minipig
     */
    @Override
    public void modificar(MiniPigDTO minipig) {
        try (Connection con = CnxBD.getConexion();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE minipigs SET nombre=?, sexo=?, raza=?, color=?, peso=?, "
                     + "altura=?, caracteristica1=?, caracteristica2=?, url_foto=? "
                     + "WHERE codigo=?")) {
            ps.setString(1, minipig.getNombre());
            ps.setString(2, minipig.getSexo());
            ps.setString(3, minipig.getRaza());
            ps.setString(4, minipig.getColor());
            ps.setString(5, minipig.getPeso());
            ps.setString(6, minipig.getAltura());
            ps.setString(7, minipig.getCaracteristica1());
            ps.setString(8, minipig.getCaracteristica2());
            ps.setString(9, minipig.getUrlFoto());
            ps.setString(10, minipig.getCodigo());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
}
