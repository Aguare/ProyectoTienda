package BInstancias;

import java.util.Date;

/**
 *
 * @author aguare
 */
public class Venta {

    private int idVenta;
    private Date fecha;
    private double totalVenta;
    private Tienda tienda;
    private ListaProductos lista;
    private Empleado empleado;
    private Pedido pedido;

    public Venta(int idVenta, Date fecha, double totalVenta, Tienda tienda, ListaProductos lista, Empleado empleado, Pedido pedido) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.tienda = tienda;
        this.lista = lista;
        this.empleado = empleado;
        this.pedido = pedido;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public ListaProductos getLista() {
        return lista;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Pedido getPedido() {
        return pedido;
    }

}
