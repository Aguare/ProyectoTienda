package BManejadores;

import BInstancias.Cliente;
import BInstancias.Empleado;
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
public class ConsultasOtros {

    public ArrayList ObtenerTiendas() {
        String query = "SELECT * FROM Tienda";
        ArrayList<Tienda> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query);
                    ResultSet result = preSt.executeQuery()) {

                while (result.next()) {
                    lista.add(new Tienda(result.getString(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6)));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList ObtenerEmpleados() {
        String query = "SELECT * FROM Empleado";
        ArrayList<Empleado> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query);
                    ResultSet result = preSt.executeQuery()) {

                while (result.next()) {
                    lista.add(new Empleado(result.getString(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5), result.getString(6), result.getString(7)));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList ObtenerEmpleadosCodigo(String busqueda) {
        String query = "SELECT * FROM Empleado WHERE codEmpleado = ?";
        ArrayList<Empleado> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, busqueda + "%");
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    lista.add(new Empleado(result.getString(1), result.getString(2), result.getInt(3), result.getInt(4),
                            result.getString(5), result.getString(6), result.getString(7)));
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en Consulta Clientes", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }

            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList ObtenerTiempos() {
        String query = "SELECT * FROM Tiempo";
        ArrayList<Tiempo> lista = new ArrayList();
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query);
                    ResultSet result = preSt.executeQuery()) {

                while (result.next()) {
                    lista.add(new Tiempo(result.getInt(1), result.getInt(2), BuscarTienda(result.getString(3)), BuscarTienda(result.getString(4))));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public Tienda BuscarTienda(String codTienda) {
        String query = "SELECT * FROM Tienda WHERE codTienda = ?";
        Tienda tienda = null;
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query);
                    ResultSet result = preSt.executeQuery()) {

                while (result.next()) {
                    tienda = new Tienda(result.getString(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return tienda;
    }
}
