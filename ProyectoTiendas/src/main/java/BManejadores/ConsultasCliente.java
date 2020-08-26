package BManejadores;

import BInstancias.Cliente;
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
public class ConsultasCliente {

    public ArrayList ObtenerClientesNombre(String busqueda) {
        String query = "SELECT * FROM Cliente WHERE nombre LIKE ?";
        ArrayList<Cliente> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, busqueda + "%");
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    lista.add(new Cliente(result.getString(1), result.getString(2), result.getDouble(3),
                            result.getInt(4), result.getInt(5), result.getString(6)));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList ObtenerClientesNIT(String busqueda) {
        String query = "SELECT * FROM Cliente WHERE NIT LIKE ?";
        ArrayList<Cliente> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, busqueda + "%");
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    lista.add(new Cliente(result.getString(1), result.getString(2), result.getDouble(3),
                            result.getInt(4), result.getInt(5), result.getString(6)));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList ObtenerClientes() {
        String query = "SELECT * FROM Cliente";
        ArrayList<Cliente> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query);
                    ResultSet result = preSt.executeQuery()) {

                while (result.next()) {
                    lista.add(new Cliente(result.getString(1), result.getString(2), result.getDouble(3), result.getInt(4), result.getInt(5), result.getString(6)));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public boolean insertarCliente(String NIT, String nombre, String telefono, String DPI, String direccion) {
        String query = "INSERT INTO Cliente (NIT, nombre, telefono, DPI, direccion) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, NIT);
                preSt.setString(2, nombre);
                preSt.setString(3, telefono);
                preSt.setString(4, DPI);
                preSt.setString(5, direccion);
                preSt.executeUpdate();
                return true;
            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean insertarClienteArch(String NIT, String nombre, String telefono, String credio) {
        String query = "INSERT INTO Cliente (NIT, nombre, telefono, credito) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, NIT);
                preSt.setString(2, nombre);
                preSt.setString(3, telefono);
                preSt.setString(4, credio);
                preSt.executeUpdate();
                return true;
            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
