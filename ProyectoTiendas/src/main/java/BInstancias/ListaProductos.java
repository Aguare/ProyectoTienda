package BInstancias;

import java.util.ArrayList;

/**
 *
 * @author aguare
 */
public class ListaProductos {

    private int idListaProductos;
    private ArrayList<Producto> listaProductos = new ArrayList();
    private ArrayList<Integer> cantidad = new ArrayList();
    private ArrayList<Double> totalParcial = new ArrayList();

    public ListaProductos() {
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
        if (yaIngresado(producto)) {
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getIdProducto().equals(producto.getIdProducto())) {
                    listaProductos.get(i).setCantidad(listaProductos.get(i).getCantidad() - cantidad);
                    this.cantidad.set(i, this.cantidad.get(i) + cantidad);
                    totalParcial.set(i, listaProductos.get(i).getPrecio() * this.cantidad.get(i));
                    break;
                }
            }
        } else {
            this.cantidad.add(cantidad);
            producto.setCantidad(producto.getCantidad() - cantidad);
            listaProductos.add(producto);
            totalParcial.add(producto.getPrecio() * cantidad);
        }
    }

    public void quitarProducto(String id) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getIdProducto().equals(id)) {
                Producto pro = listaProductos.get(i);
                pro.setCantidad(pro.getCantidadBodega());
                listaProductos.remove(i);
                cantidad.remove(i);
                totalParcial.remove(i);
                break;
            }
        }
    }

    public boolean yaIngresado(Producto producto) {
        for (Producto listaProducto : listaProductos) {
            if (listaProducto.getIdProducto().equals(producto.getIdProducto())) {
                return true;
            }
        }

        return false;
    }

    public Producto devolverProducto(Producto producto) {
        for (Producto listaProducto : listaProductos) {
            if (listaProducto.getIdProducto().equals(producto.getIdProducto())) {
                return listaProducto;
            }
        }
        return null;
    }

    public double obtenerTotal() {
        double total = 0;
        for (double tp : totalParcial) {
            total += tp;
        }
        return total;
    }
}
