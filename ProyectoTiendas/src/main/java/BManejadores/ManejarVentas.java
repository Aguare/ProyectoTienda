package BManejadores;

import BInstancias.Cliente;
import BInstancias.Empleado;
import BInstancias.ListaProductos;
import BInstancias.Producto;
import BInstancias.Tienda;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author aguare
 */
public class ManejarVentas {

    public boolean RealizarVentaSinPedido(Cliente cliente, Empleado empleado, ListaProductos lista, Tienda tienda) {
        lista.setIdListaProductos(registrarListaProductos(lista));
        registrarListaP(lista, tienda);

        Calendar fecha = new GregorianCalendar();
        int a = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String f = "" + a + "-" + mes + "-" + dia;
        String query = "INSERT INTO Venta (fecha, totalVenta, Tienda_codTienda, Empleado_codEmpleado, LidListaProductos, cliente_NIT) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = Sesion.Conexion();
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

                preSt.setString(1, f);
                preSt.setString(2, "" + lista.obtenerTotal());
                preSt.setString(3, "" + tienda.getCodTienda());
                preSt.setString(4, "" + empleado.getCodEmpleado());
                preSt.setString(5, "" + lista.getIdListaProductos());
                preSt.setString(6, cliente.getNIT());

                preSt.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en Ventas", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (HeadlessException e) {
        }
        return true;
    }

    private int registrarListaProductos(ListaProductos lista) {
        String query = "INSERT INTO ListaProductos (total) VALUES (?)";
        Connection connection = Sesion.Conexion();
        int n = 0;
        try (PreparedStatement preSt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preSt.setString(1, "" + lista.obtenerTotal());

            preSt.executeUpdate();

            try (ResultSet result = preSt.getGeneratedKeys()) {

                if (result.first()) {
                    n = (int) result.getLong(1);
                }
                result.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return n;
    }

    private void registrarListaP(ListaProductos lista, Tienda tienda) {
        ArrayList<Producto> listaP = lista.getListaProductos();
        ArrayList<Integer> listaC = lista.getCantidad();
        ArrayList<Double> listaT = lista.getTotalParcial();
        for (int i = 0; i < lista.getListaProductos().size(); i++) {
            registrarProducto(lista.getIdListaProductos(), listaP.get(i), listaC.get(i), listaT.get(i));
            restarProductos(listaP.get(i), tienda, listaC.get(i));
        }
    }

    private void registrarProducto(int id, Producto producto, int cantidad, double cantidadParcial) {
        String query = "INSERT INTO ListaP VALUES (?, ?, ?, ?);";
        Connection connection = Sesion.Conexion();
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "" + id);
            preSt.setString(2, "" + producto.getIdProducto());
            preSt.setString(3, "" + cantidad);
            preSt.setString(4, "" + cantidadParcial);

            preSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void restarProductos(Producto producto, Tienda tienda, int cantidad) {
        String query = "UPDATE ProductosEnTienda SET cantidad = ? WHERE Producto_idProducto = ?";
        Connection connection = Sesion.Conexion();
        int nuevo = producto.getCantidadBodega() - cantidad;
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, "" + nuevo);
            preSt.setString(2, "" + producto.getIdProducto());

            preSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Producto", "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

}
