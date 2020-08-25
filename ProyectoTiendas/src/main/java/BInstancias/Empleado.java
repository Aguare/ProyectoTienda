package BInstancias;

/**
 *
 * @author aguare
 */
public class Empleado {

    private String codEmpleado;
    private String nombre;
    private int DPI;
    private int telefono;
    private String NIT;
    private String correo;
    private String direccion;

    public Empleado(String codEmpleado, String nombre, int DPI, int telefono, String NIT, String correo, String direccion) {
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.DPI = DPI;
        this.telefono = telefono;
        this.NIT = NIT;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
