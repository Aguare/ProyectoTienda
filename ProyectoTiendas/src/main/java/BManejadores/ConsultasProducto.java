package BManejadores;

import BInstancias.Cliente;
import BInstancias.Empleado;
import BInstancias.Producto;
import BInstancias.Tiempo;
import BInstancias.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aguare
 */
public class ConsultasProducto {
    
    
    public int CantidadProductosGeneral(String busqueda) {
        String query = "SELECT SUM(cantidad) AS Cantidad FROM ProductosEnTienda WHERE Producto_idProducto = ?";
        int cantidad = 0;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, busqueda);
                ResultSet result = preSt.executeQuery();
                
                while (result.next()) {
                    cantidad = result.findColumn("Cantidad");
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cantidad;
    }
    
    public int CantidadProductosTienda(String codTienda, String busqueda) {
        String query = "SELECT * FROM ProductosEnTienda WHERE Tienda_codTienda = ? AND Producto_idProducto = ?";
        int cantidad = 0;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, codTienda);
                preSt.setString(2, busqueda);
                ResultSet result = preSt.executeQuery();
                
                while (result.next()) {
                    cantidad = result.findColumn("Cantidad");
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cantidad;
    }
    
    public ArrayList ObtenerProductosNombre(String busqueda) {
        String query = "SELECT * FROM Producto WHERE nombre LIKE ?";
        ArrayList<Producto> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, busqueda + "%");
                ResultSet result = preSt.executeQuery();
                
                while (result.next()) {
                    lista.add(new Producto(result.getString(1), result.getString(2), CantidadProductosGeneral(result.getString(1)),
                            result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6)));
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public ArrayList ObtenerProductosCodigo(String busqueda) {
        String query = "SELECT * FROM Producto WHERE idProducto LIKE ?";
        ArrayList<Producto> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, busqueda + "%");
                ResultSet result = preSt.executeQuery();
                
                while (result.next()) {
                    lista.add(new Producto(result.getString(1), result.getString(2), CantidadProductosGeneral(result.getString(1)),
                            result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6)));
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public ArrayList ObtenerProductosNombreTienda(String busqueda, String codTienda) {
        String query = "SELECT * FROM Producto P INNER JOIN ProductosEnTienda Pr ON P.idProducto = Pr.Producto_idProducto "
                + "WHERE Pr.Tienda_codTienda = ? AND P.nombreProducto LIKE ?";
        ArrayList<Producto> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, codTienda);
                preSt.setString(2, busqueda + "%");
                
                ResultSet result = preSt.executeQuery();
                
                while (result.next()) {
                    lista.add(new Producto(result.getString(1), result.getString(2), CantidadProductosTienda(codTienda, result.getString(1)),
                            result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6)));
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public ArrayList ObtenerProductosCodigoTienda(String busqueda, String codTienda) {
        String query = "SELECT * FROM Producto P INNER JOIN ProductosEnTienda Pr ON P.idProducto = Pr.Producto_idProducto "
                + "WHERE Pr.Tienda_codTienda = ? AND P.idProducto LIKE ?";
        ArrayList<Producto> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
                
                preSt.setString(1, codTienda);
                preSt.setString(2, busqueda + "%");
                
                ResultSet result = preSt.executeQuery();
                
                while (result.next()) {
                    lista.add(new Producto(result.getString(1), result.getString(2), CantidadProductosTienda(codTienda, result.getString(1)),
                            result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6)));
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
