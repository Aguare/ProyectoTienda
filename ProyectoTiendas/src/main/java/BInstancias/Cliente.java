package BInstancias;

/**
 *
 * @author aguare
 */
public class Cliente {

    private String NIT;
    private String nombre;
    private double credito;
    private int telefono;
    private int DPI;
    private String direccion;

    public Cliente(String NIT, String nombre, double credito, int telefono, int DPI, String direccion) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.credito = credito;
        this.telefono = telefono;
        this.DPI = DPI;
        this.direccion = direccion;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
