package BManejadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aguare
 */
public class CargaArchivo {

    //guardar informacion
    private ArrayList<ArrayList<String>> Tienda = new ArrayList();
    private ArrayList<ArrayList<String>> Cliente = new ArrayList();
    private ArrayList<ArrayList<String>> Producto = new ArrayList();
    private ArrayList<ArrayList<String>> Pedido = new ArrayList();
    private ArrayList<ArrayList<String>> Empleado = new ArrayList();
    private ArrayList<ArrayList<String>> Tiempo = new ArrayList();

    private ArrayList<String> aceptados = new ArrayList();
    private ArrayList<String> ignorados = new ArrayList();
    private ArrayList<ArrayList<String>> Error = new ArrayList();

    //utilizacion dle archivo
    private File archivo;
    private String path;

    //Realizar operaciones en DB
    private ConsultasCliente c = new ConsultasCliente();
    private ConsultasOtros otros = new ConsultasOtros();
    private ConsultasProducto cPro = new ConsultasProducto();
    private ManejarPedidos pedi = new ManejarPedidos();

    public CargaArchivo() {

    }

    public String getPath() {
        return path;
    }

    public ArrayList<String> getAceptados() {
        return aceptados;
    }

    public ArrayList<String> getIgnorados() {
        return ignorados;
    }

    public boolean SeleccionarArchivo(JFrame frame) {
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
        file.setFileFilter(filtro);
        int opcion = file.showOpenDialog(frame);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String path = file.getSelectedFile().getAbsolutePath();
            archivo = new File(path);
            return true;
        } else {
            return false;
        }
    }

    public boolean leer() {
        FileReader fr = null;
        BufferedReader br = null;
        boolean error = false;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                ArrayList<String> data = new ArrayList();
                String[] datos = linea.split(",");
                for (int i = 1; i < datos.length; i++) {
                    data.add(datos[i]);
                    if (datos[i].equalsIgnoreCase("")) {
                        error = true;
                    }
                }
                if (datos[0].equalsIgnoreCase("Tienda")) {
                    Tienda.add(data);
                }
                if (datos[0].equalsIgnoreCase("Cliente")) {
                    Cliente.add(data);
                }
                if (datos[0].equalsIgnoreCase("Producto")) {
                    Producto.add(data);
                }
                if (datos[0].equalsIgnoreCase("Pedido")) {
                    Pedido.add(data);
                }
                if (datos[0].equalsIgnoreCase("Empleado")) {
                    Empleado.add(data);
                }
                if (datos[0].equalsIgnoreCase("Tiempo")) {
                    Tiempo.add(data);
                }
                if (datos[0].equalsIgnoreCase("") | error) {
                    Error.add(data);
                }

                error = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return true;
        }
    }

    public void ImprimirDatos() {
        System.out.println("****Tiendas****");
        for (int i = 0; i < Tienda.size(); i++) {
            System.out.println(Tienda.get(i));
        }
        System.out.println("****Tiempo****");
        for (int i = 0; i < Tiempo.size(); i++) {
            System.out.println(Tiempo.get(i));
        }
        System.out.println("****Productos****");
        for (int i = 0; i < Producto.size(); i++) {
            System.out.println(Producto.get(i));
        }
        System.out.println("****Empleados****");
        for (int i = 0; i < Empleado.size(); i++) {
            System.out.println(Empleado.get(i));
        }
        System.out.println("****Clientes****");
        for (int i = 0; i < Cliente.size(); i++) {
            System.out.println(Cliente.get(i));
        }
        System.out.println("****Pedidos****");
        for (int i = 0; i < Pedido.size(); i++) {
            System.out.println(Pedido.get(i));
        }
        System.out.println("****Errores****");
        for (int i = 0; i < Error.size(); i++) {
            System.out.println(Error.get(i));
        }
    }

    public void insertarDatos() {
        insertarTiendas();
        insertarClientes();
        insertarEmpleados();
        insertarProductos();
        insertarTiempo();
        insertarPedidos();
    }

    public void separarCaracteres(String linea) {
        String[] datos = linea.split(",");
    }

    private void insertarTiendas() {
        for (ArrayList<String> a : Tienda) {
            boolean aceptado = otros.insertarTienda(a.get(2), a.get(0), a.get(1), a.get(3), "", "");
            if (aceptado) {
                aceptados.add("TIENDA-> " + a.get(2) + " " + a.get(0) + " " + a.get(1) + " " + a.get(3));
            } else {
                ignorados.add("TIENDA-> " + a.get(2) + " " + a.get(0) + " " + a.get(1) + " " + a.get(3));
            }

        }
    }

    private void insertarProductos() {
        for (ArrayList<String> a : Producto) {
            boolean aceptado = cPro.insertarProducto(a.get(2), a.get(0), a.get(4), "", "0", a.get(1), a.get(3), a.get(5));
            if (aceptado) {
                aceptados.add("PRODUCTO-> " + a.get(2) + " " + a.get(0) + " " + a.get(4) + " " + a.get(1) + " " + a.get(3) + " " + a.get(5));
            } else {
                ignorados.add("PRODUCTO-> " + a.get(2) + " " + a.get(0) + " " + a.get(4) + " " + a.get(1) + " " + a.get(3) + " " + a.get(5));
            }
        }
    }

    private void insertarClientes() {
        for (ArrayList<String> a : Cliente) {
            boolean aceptado = c.insertarClienteArch(a.get(1), a.get(0), a.get(2), a.get(3));
            if (aceptado) {
                aceptados.add("CLIENTE-> " + a.get(1) + " " + a.get(0) + " " + a.get(2) + " " + a.get(3));
            } else {
                ignorados.add("CLIENTE-> " + a.get(1) + " " + a.get(0) + " " + a.get(2) + " " + a.get(3));

            }
        }
    }

    private void insertarPedidos() {
        for (ArrayList<String> a : Pedido) {
            boolean aceptado = pedi.realizarPedido(a.get(0), a.get(1), a.get(2), a.get(3), a.get(4), a.get(5), a.get(6), a.get(7), a.get(8));
            if (aceptado) {
                aceptados.add("PEDIDO-> " + a.get(0) + " " + a.get(1) + " " + a.get(2) + " " + a.get(3) + " " + a.get(4) + " " + a.get(5) + " " + a.get(6) + " " + a.get(7) + " " + a.get(8));
            } else {
                ignorados.add("PEDIDO-> " + a.get(0) + " " + a.get(1) + " " + a.get(2) + " " + a.get(3) + " " + a.get(4) + " " + a.get(5) + " " + a.get(6) + " " + a.get(7) + " " + a.get(8));
            }
        }
    }

    private void insertarTiempo() {
        for (ArrayList<String> a : Tiempo) {
            boolean aceptado = otros.insertarTiempo(a.get(2), a.get(0), a.get(1));
            if (aceptado) {
                aceptados.add("TIEMPO-> " + a.get(2) + " " + a.get(0) + " " + a.get(1));
            } else {
                ignorados.add("TIEMPO-> " + a.get(2) + " " + a.get(0) + " " + a.get(1));
            }
        }
    }

    private void insertarEmpleados() {
        for (ArrayList<String> a : Empleado) {
            boolean aceptado = otros.insertarEmpleados(a.get(1), a.get(0), a.get(3), a.get(2), "0", "-", "-");
            if (aceptado) {
                aceptados.add("EMPLEADO-> " + a.get(1) + " " + a.get(0) + " " + a.get(3) + " " + a.get(2));
            } else {
                ignorados.add("EMPLEADO-> " + a.get(1) + " " + a.get(0) + " " + a.get(3) + " " + a.get(2));
            }
        }
    }

}
