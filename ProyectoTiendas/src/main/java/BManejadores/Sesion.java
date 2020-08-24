package BManejadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aguare
 */
public class Sesion {

    public static Connection Conexion() {
        String url = "jdbc:mysql://localhost:3306/Intelaf?useSSL=false";
        String user = "adminIntel";
        String password = "intel100";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }

    public ArrayList ObtenerListaTiendas() {
        String query = "SELECT codTienda, nombre FROM Tienda";
        ArrayList<String> lista = new ArrayList();
        Connection connection = Sesion.Conexion();
        try (PreparedStatement preSt = connection.prepareStatement(query);
                ResultSet result = preSt.executeQuery()) {

            while (result.next()) {
                lista.add(result.getString(1) + ",\t" + result.getString(2));
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public boolean IniciarSesion(String usuario, String password) {
        String query = "SELECT usuario, password FROM UsuarioEmpleado WHERE usuario = ?";
        boolean inicio = false;

        Connection connection = Sesion.Conexion();
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, usuario);
            try (ResultSet result = preSt.executeQuery()) {
                String user = "";
                String pass = "";
                while (result.next()) {
                    user = result.getString("usuario");
                    pass = result.getString("password");
                }

                if (user.equals(usuario) && password.equals(pass)) {
                    inicio = true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar Consulta", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return inicio;
    }
}
