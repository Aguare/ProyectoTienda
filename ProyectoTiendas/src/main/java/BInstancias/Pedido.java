package BInstancias;

import java.util.Date;

/**
 *
 * @author aguare
 */
public class Pedido {
    
    private String codPedido;
    private Date fecha;
    private double anticipo;
    private double total;
    private Cliente cliente;
    private ListaProductos lista;
    private Tienda origen;
    private Tienda llegada;

    public Pedido(String codPedido, Date fecha, double anticipo, double total, Cliente cliente, ListaProductos lista, Tienda origen, Tienda llegada) {
        this.codPedido = codPedido;
        this.fecha = fecha;
        this.anticipo = anticipo;
        this.total = total;
        this.cliente = cliente;
        this.lista = lista;
        this.origen = origen;
        this.llegada = llegada;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaProductos getLista() {
        return lista;
    }

    public void setLista(ListaProductos lista) {
        this.lista = lista;
    }

    public Tienda getOrigen() {
        return origen;
    }

    public void setOrigen(Tienda origen) {
        this.origen = origen;
    }

    public Tienda getLlegada() {
        return llegada;
    }

    public void setLlegada(Tienda llegada) {
        this.llegada = llegada;
    }
    
}
