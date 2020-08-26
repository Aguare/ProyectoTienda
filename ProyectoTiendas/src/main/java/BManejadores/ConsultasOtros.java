package BManejadores;

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
                JOptionPane.showMessageDialog(null, "Base de datos vacía", "Vacío", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Base de datos vacía", "Vacío", JOptionPane.ERROR_MESSAGE);
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
        String query = "SELECT * FROM Empleado WHERE codEmpleado LIKE ?";
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
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
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
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, codTienda);
                ResultSet result = preSt.executeQuery();

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

    public boolean insertarTienda(String codTienda, String nombre, String direccion, String numero, String correo, String horario) {
        String query = "INSERT INTO Tienda  VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, codTienda);
                preSt.setString(2, nombre);
                preSt.setString(3, direccion);
                preSt.setString(4, numero);
                preSt.setString(5, correo);
                preSt.setString(6, horario);
                preSt.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar Tienda", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Tienda", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public int buscarTiempo(String tiendaOrigen, String tiendaLlegada) {
        int numero = 0;
        String query = "SELECT * FROM Tiempo WHERE codTienda1 = ? AND codTienda2 = ?";
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, tiendaOrigen);
                preSt.setString(2, tiendaLlegada);
                ResultSet result = preSt.executeQuery();

                while (result.next()) {
                    numero = result.getInt("idTiempo");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }

            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta Otros", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return numero;
    }

    public boolean insertarTiempo(String dias, String cod1, String cod2) {
        String query = "INSERT INTO Tiempo (tiempo, codTienda1, codTienda2) VALUES (?,?,?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, dias);
                preSt.setString(2, cod1);
                preSt.setString(3, cod2);

                preSt.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar Tiempo", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Tiempo", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean insertarEmpleados(String codEmpleado, String nombre, String DPI, String telefono, String NIT, String correo, String direccion) {
        String query = "INSERT INTO Empleado (codEmpleado, nombre, DPI, telefono, NIT, correo, direccion) VALUES (?,?,?,?,?,?,?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, codEmpleado);
                preSt.setString(2, nombre);
                preSt.setString(3, DPI);
                preSt.setString(4, telefono);
                preSt.setString(5, NIT);
                preSt.setString(6, correo);
                preSt.setString(7, direccion);

                preSt.executeUpdate();
                insertarUsuario(codEmpleado, codEmpleado + "ps", codEmpleado);
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar Tiempo", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Tiempo", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void insertarUsuario(String usuario, String password, String cod) {
        String query = "INSERT INTO UsuarioEmpleado (usuario, password, Empleado_codEmpleado) VALUES (?,?,?)";

        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, usuario);
                preSt.setString(2, password);
                preSt.setString(3, cod);

                preSt.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar Tiempo", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Tiempo", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
