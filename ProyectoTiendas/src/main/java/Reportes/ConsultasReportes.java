package Reportes;

import BManejadores.Sesion;
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
public class ConsultasReportes {

    public ArrayList<Object[]> PedidosLlegarTienda(String cod) {
        String query = "SELECT * FROM Pedido WHERE codTiendaLlegada = ? AND estado = 'EN TRANSITO'";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, cod);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[9];
                while (result.next()) {
                    linea[0] = result.getString("codPedido");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("anticipo");
                    linea[3] = result.getString("total");
                    linea[4] = result.getString("estado");
                    linea[5] = result.getString("Cliente_NIT");
                    linea[6] = result.getString("codTiendaOrigen");
                    linea[7] = result.getString("codTiendaLlegada");
                    linea[8] = result.getString("LidListaProductos");
                }
                lista.add(linea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Object[]> PedidosEnTienda(String cod) {
        String query = "SELECT * FROM Pedido WHERE codTiendaLlegada = ? AND estado = 'EN TIENDA'";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, cod);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[9];
                while (result.next()) {
                    linea[0] = result.getString("codPedido");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("anticipo");
                    linea[3] = result.getString("total");
                    linea[4] = result.getString("estado");
                    linea[5] = result.getString("Cliente_NIT");
                    linea[6] = result.getString("codTiendaOrigen");
                    linea[7] = result.getString("codTiendaLlegada");
                    linea[8] = result.getString("LidListaProductos");
                }
                lista.add(linea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Object[]> PedidosAtrasados(String cod) {
        String query = "SELECT * FROM Pedido WHERE codTiendaLlegada = ? AND estado = 'ATRASADO'";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, cod);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[9];
                while (result.next()) {
                    linea[0] = result.getString("codPedido");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("anticipo");
                    linea[3] = result.getString("total");
                    linea[4] = result.getString("estado");
                    linea[5] = result.getString("Cliente_NIT");
                    linea[6] = result.getString("codTiendaOrigen");
                    linea[7] = result.getString("codTiendaLlegada");
                    linea[8] = result.getString("LidListaProductos");
                }
                lista.add(linea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Object[]> PedidosSalidaTransito(String cod) {
        String query = "SELECT * FROM Pedido WHERE codTiendaOrigen = ? AND estado = 'EN TRANSITO'";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, cod);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[9];
                while (result.next()) {
                    linea[0] = result.getString("codPedido");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("anticipo");
                    linea[3] = result.getString("total");
                    linea[4] = result.getString("estado");
                    linea[5] = result.getString("Cliente_NIT");
                    linea[6] = result.getString("codTiendaOrigen");
                    linea[7] = result.getString("codTiendaLlegada");
                    linea[8] = result.getString("LidListaProductos");
                }
                lista.add(linea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Object[]> ComprasSegunCliente(String cod) {
        String query = "SELECT * FROM Venta WHERE cliente_NIT = ?";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, cod);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[6];
                while (result.next()) {
                    linea[0] = result.getString("idVenta");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("totalVenta");
                    linea[3] = result.getString("Tienda_codTienda");
                    linea[4] = result.getString("Empleado_codEmpleado");
                    linea[5] = result.getString("LidListaProductos");
                }
                lista.add(linea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Object[]> PedidosCursoCliente(String cod) {
        String query = "SELECT * FROM Pedido WHERE cliente_NIT = ? AND estado = 'EN TRANSITO'";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, cod);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[8];
                while (result.next()) {
                    linea[0] = result.getString("codPedido");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("anticipo");
                    linea[3] = result.getString("total");
                    linea[4] = result.getString("estado");
                    linea[5] = result.getString("codTiendaOrigen");
                    linea[6] = result.getString("codTiendaLlegada");
                    linea[7] = result.getString("LidListaProductos");
                }
                lista.add(linea);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Object[]> ProductoMasVendido(String fechaInicio, String fechaFinal) {
        String query = "SELECT * FROM Pedido WHERE fecha between ? AND ? limit 10";
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, fechaInicio);
                preSt.setString(1, fechaFinal);
                ResultSet result = preSt.executeQuery();
                Object[] linea = new Object[8];
                while (result.next()) {
                    linea[0] = result.getString("codPedido");
                    linea[1] = result.getString("fecha");
                    linea[2] = result.getString("anticipo");
                    linea[3] = result.getString("total");
                    linea[4] = result.getString("estado");
                    linea[5] = result.getString("codTiendaOrigen");
                    linea[6] = result.getString("codTiendaLlegada");
                    linea[7] = result.getString("LidListaProductos");
                }
                lista.add(linea);

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
