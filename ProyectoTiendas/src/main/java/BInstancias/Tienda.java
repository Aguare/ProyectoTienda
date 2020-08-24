package BInstancias;

/**
 *
 * @author aguare
 */
public class Tienda {

    private String codTienda;
    private String nombre;
    private String direccion;
    private int telefono;
    private String correo;
    private String horario;

    public Tienda(String codTienda, String nombre, String direccion, int telefono, String correo, String horario) {
        this.codTienda = codTienda;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.horario = horario;
    }

    public String getCodTienda() {
        return codTienda;
    }

    public void setCodTienda(String codTienda) {
        this.codTienda = codTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Tienda{" + "codTienda=" + codTienda + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", horario=" + horario + '}';
    }
    
}
