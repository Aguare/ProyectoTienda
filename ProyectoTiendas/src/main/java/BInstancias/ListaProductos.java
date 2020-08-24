package BInstancias;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ListaProductos {

    private int idListaProductos;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Integer> cantidad;
    private ArrayList<Double> totalParcial;

    public ListaProductos(int idListaProductos) {
        this.idListaProductos = idListaProductos;
    }

    public int getIdListaProductos() {
        return idListaProductos;
    }

    public void setIdListaProductos(int idListaProductos) {
        this.idListaProductos = idListaProductos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Double> getTotalParcial() {
        return totalParcial;
    }

    public void setTotalParcial(ArrayList<Double> totalParcial) {
        this.totalParcial = totalParcial;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        listaProductos.add(producto);
        this.cantidad.add(cantidad);
        totalParcial.add(producto.getPrecio() * cantidad);
    }

}
