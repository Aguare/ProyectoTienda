package BInstancias;

/**
 *
 * @author aguare
 */
public class Producto {

    private String idProducto;
    private String nombre;
    private int cantidad;
    private int cantidadBodega;
    private double precio;
    private String descripcion;
    private int garantiaMeses;
    private String fabricante;
    private String codTienda;

    public Producto(String idProducto, String nombre, int cantidad, double precio, String descripcion, int garantiaMeses, String fabricante) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.garantiaMeses = garantiaMeses;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.cantidadBodega = cantidad;
    }

    public Producto(String idProducto, String nombre, int cantidad, double precio, String descripcion, int garantiaMeses, String fabricante, String codTienda) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.garantiaMeses = garantiaMeses;
        this.fabricante = fabricante;
        this.codTienda = codTienda;
        this.cantidad = cantidad;
        this.cantidadBodega = cantidad;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodTienda() {
        return codTienda;
    }

    public void setCodTienda(String codTienda) {
        this.codTienda = codTienda;
    }

}
