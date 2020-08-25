package BInstancias;

/**
 *
 * @author aguare
 */
public class Tiempo {

    private int idTiempo;
    private int tiempo;
    private Tienda tiendaOrigen;
    private Tienda tiendaLlegada;

    public Tiempo(int idTiempo, int tiempo, Tienda tiendaOrigen, Tienda tiendaLlegada) {
        this.idTiempo = idTiempo;
        this.tiempo = tiempo;
        this.tiendaOrigen = tiendaOrigen;
        this.tiendaLlegada = tiendaLlegada;
    }

    
    public int getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Tienda getTiendaOrigen() {
        return tiendaOrigen;
    }

    public void setTiendaOrigen(Tienda tiendaOrigen) {
        this.tiendaOrigen = tiendaOrigen;
    }

    public Tienda getTiendaLlegada() {
        return tiendaLlegada;
    }

    public void setTiendaLlegada(Tienda tiendaLlegada) {
        this.tiendaLlegada = tiendaLlegada;
    }

}
