package BManejadores;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author aguare
 */
public class ManejarPedidos {

    public boolean realizarPedido(String codPedido, String tiendaOrigen, String tiendaLlegada, String fecha, String cliente, String articulo, String cantidad, String total, String anticipo) {
        String query = "INSERT INTO Pedido VALUES (?,?,?,?,?,?,?,?,?,?)";
        int n = buscarPedido(codPedido);
        if (n != -1) {
            registrarListaP(n, articulo, cantidad, total);
            actualizarTotal(total, n + "");
            return true;
        } else {
            int idLista = registrarListaProductos(total);
            ConsultasOtros otros = new ConsultasOtros();
            int idTiempo = otros.buscarTiempo(tiendaOrigen, tiendaLlegada);
            if (idTiempo == 0) {
                idTiempo = otros.buscarTiempo(tiendaLlegada, tiendaOrigen);
            }
            registrarListaP(idLista, articulo, cantidad, total);
            try {
                Connection connection = Sesion.Conexion();
                try (PreparedStatement preSt = connection.prepareStatement(query)) {

                    preSt.setString(1, codPedido);
                    preSt.setString(2, fecha);
                    preSt.setString(3, anticipo);
                    preSt.setString(4, total);
                    preSt.setString(5, "EN TRANSITO");
                    preSt.setString(6, cliente);
                    preSt.setString(7, "" + idTiempo);
                    preSt.setString(8, tiendaOrigen);
                    preSt.setString(9, tiendaLlegada);
                    preSt.setString(10, "" + idLista);

                    preSt.executeUpdate();
                    connection.close();
                    return true;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            } catch (HeadlessException e) {
            }
        }
        return false;
    }

    private int registrarListaProductos(String total) {
        String query = "INSERT INTO ListaProductos (total) VALUES (?)";
        Connection connection = Sesion.Conexion();
        int n = 0;
        try (PreparedStatement preSt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preSt.setString(1, total);

            preSt.executeUpdate();

            try (ResultSet result = preSt.getGeneratedKeys()) {

                if (result.first()) {
                    n = (int) result.getLong(1);
                }
                result.close();
            } catch (Exception e) {

            }

            preSt.close();
        } catch (SQLException e) {

        }

        return n;
    }

    private void registrarListaP(int idListaProductos, String codProducto, String cantidad, String totalParcial) {
        registrarProducto("" + idListaProductos, codProducto, cantidad, totalParcial);
    }

    private void registrarProducto(String id, String producto, String cantidad, String cantidadParcial) {
        String query = "INSERT INTO ListaP VALUES (?, ?, ?, ?);";
        Connection connection = Sesion.Conexion();
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, id);
            preSt.setString(2, producto);
            preSt.setString(3, cantidad);
            preSt.setString(4, cantidadParcial);

            preSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
        }
    }

    private int buscarPedido(String codPedido) {
        String query = "SELECT * FROM Pedido WHERE codPedido = ?";
        int numeroLista = -1;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, codPedido);
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    numeroLista = result.getInt("LidListaProductos");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            if (numeroLista != -1) {
                return numeroLista;
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return numeroLista;
    }

    private void actualizarTotal(String total, String idlista) {
        String query = "UPDATE ListaProductos SET total = ? WHERE idListaProductos = ?";
        Connection connection = Sesion.Conexion();
        double t = Double.parseDouble(total);
        double nuevo = obtenerTotal(idlista) + t;
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "" + nuevo);
            preSt.setString(2, "" + idlista);

            preSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double obtenerTotal(String idLista) {
        String query = "SELECT * FROM ListaProductos WHERE idListaProductos = ?";
        double numeroLista = -1;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, idLista);
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    numeroLista = result.getInt("total");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            if (numeroLista != -1) {
                return numeroLista;
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return numeroLista;
    }
}
