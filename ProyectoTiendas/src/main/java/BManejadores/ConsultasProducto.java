package BManejadores;

import BInstancias.Producto;
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

    public ArrayList<Object[]> ObtenerListaProductos(String id) {
        String query = "SELECT * FROM ListaP WHERE LidListaProductos = ?";
        ArrayList<Object[]> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, id);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[3];
                while (result.next()) {
                    linea[0] = result.getString("ProductoidProducto");
                    linea[1] = result.getString("cantidad");
                    linea[2] = result.getString("totalParcial");
                    lista.add(linea);
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

    public Producto ObtenerProductoCodigo(String busqueda) {
        String query = "SELECT * FROM Producto WHERE idProducto = ?";
        Producto lista = null;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, busqueda);
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    lista = new Producto(result.getString(1), result.getString(2), CantidadProductosGeneral(result.getString(1)),
                            result.getDouble(3), result.getString(4), result.getInt(5), result.getString(6));
                }

            } catch (SQLException e) {

            }
            connection.close();
        } catch (SQLException e) {

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
                    lista.add(new Producto(result.getString("idProducto"), result.getString("nombreProducto"), result.getInt("cantidad"), result.getDouble("precio"),
                            result.getString("descripcion"), result.getInt("garantiaMeses"), result.getString("Fabricante_nombre"), result.getString("Tienda_codTienda")));
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
                    lista.add(new Producto(result.getString("idProducto"), result.getString("nombreProducto"), result.getInt("cantidad"), result.getDouble("precio"),
                            result.getString("descripcion"), result.getInt("garantiaMeses"), result.getString("Fabricante_nombre"), result.getString("Tienda_codTienda")));
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

    public ArrayList tiendaExistencia(String busqueda) {
        String query = "SELECT * FROM ProductosEnTienda WHERE Producto_idProducto = ?";
        ArrayList<Tienda> lista = new ArrayList();
        ConsultasOtros con = new ConsultasOtros();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, busqueda);
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    lista.add(con.BuscarTienda(result.getString("Tienda_codTienda")));
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

    public int cantidadEnTienda(String busqueda, String codTienda) {
        String query = "SELECT * FROM ProductosEnTienda WHERE Producto_idProducto = ? AND Tienda_codTienda = ?";
        ConsultasOtros con = new ConsultasOtros();
        int n = 0;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, busqueda);
                preSt.setString(2, codTienda);
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    n = result.getInt("Cantidad");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return n;
    }

    public boolean actualizarProducto(String nombre, String precio, String desc, String garantia, String id, Tienda tienda, int cantidad) {
        String query = "UPDATE Producto SET nombreProducto = ?, precio = ?, descripcion = ?, garantiaMeses = ? WHERE idProducto = ?";
        Connection connection = Sesion.Conexion();
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, precio);
            preSt.setString(3, desc);
            preSt.setString(4, garantia);
            preSt.setString(5, id);
            preSt.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        if (actualizarCantidad(tienda, cantidad, id)) {
            return true;
        }
        return false;
    }

    private boolean actualizarCantidad(Tienda tienda, int cantidad, String id) {
        String query = "UPDATE ProductosEnTienda SET cantidad = ? WHERE Producto_idProducto = ? AND Tienda_codTienda = ?";
        Connection connection = Sesion.Conexion();
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "" + cantidad);
            preSt.setString(2, id);
            preSt.setString(3, tienda.getCodTienda());
            preSt.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean insertarProducto(String codProducto, String nombre, String precio, String descripcion, String garantia, String fabricante, String cantidad, String tienda) {
        String query = "INSERT INTO Producto VALUES (?, ?, ?, ?, ?, ?)";
        insertarFabricante(fabricante);
        Producto producto = ObtenerProductoCodigo(codProducto);
        if (producto != null) {
            return insertarEnTienda(codProducto, tienda, cantidad);
        } else {
            try {
                Connection connection = Sesion.Conexion();
                try (PreparedStatement preSt = connection.prepareStatement(query)) {

                    preSt.setString(1, codProducto);
                    preSt.setString(2, nombre);
                    preSt.setString(3, precio);
                    preSt.setString(4, descripcion);
                    preSt.setString(5, garantia);
                    preSt.setString(6, fabricante);
                    preSt.executeUpdate();
                    if (!cantidad.equals("") && !tienda.equals("")) {
                        insertarEnTienda(codProducto, tienda, cantidad);
                    }
                    return true;
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al insertar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.getMessage());
                }
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    public boolean insertarEnTienda(String codProducto, String codTienda, String cantidad) {
        String query = "INSERT INTO ProductosEnTienda VALUES (?,?,?)";
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, codProducto);
                preSt.setString(2, codTienda);
                preSt.setString(3, cantidad);
                preSt.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar Tienda", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Tienda", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void insertarFabricante(String fabricante) {
        String query = "INSERT INTO Fabricante VALUES (?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, fabricante);

                preSt.executeUpdate();

            } catch (SQLException e) {

            }
            connection.close();
        } catch (SQLException e) {

        }

    }

}
