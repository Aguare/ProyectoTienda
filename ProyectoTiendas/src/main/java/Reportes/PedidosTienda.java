package Reportes;

import BInstancias.Tienda;
import BManejadores.ConsultasOtros;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
package Reportes;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aguare
 */
public class PedidosTienda extends javax.swing.JFrame {
    
    private ConsultasReportes reportes = new ConsultasReportes();
    private ArrayList<Object[]> datos;
    private ArrayList<Tienda> listaTiendas;
    private ConsultasOtros otros = new ConsultasOtros();

    /**
     * Creates new form PedidosTienda
     */
    public PedidosTienda() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaTiendas = otros.ObtenerTiendas();
        ingresarTiendas();
    }
    
    private void ingresarTiendas() {
        for (Tienda listaTienda : listaTiendas) {
            comboTiendas.addItem("" + listaTienda.getCodTienda() + ",\t" + listaTienda.getNombre());
        }
        comboTiendas.setEnabled(true);
    }
    
    private void agregarLista() {
        limpiarTabla();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (Object[] dato : datos) {
            modelo.addRow(dato);
        }
    }
    
    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboTiendas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PEDIDOS PENDIENTES DE LLEGAR A LA TIENDA");
        jLabel1.setOpaque(true);

        comboTiendas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTiendasItemStateChanged(evt);
            }
        });

        jLabel2.setText("SELECCIONE LA TIENDA:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Pedido", "Fecha", "Anticipo", "Total", "Estado", "NIT Cliente", "Tienda Origen", "Tienda Llegada", "No. Lista Productos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("Ver Productos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTiendasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTiendasItemStateChanged
        int n = comboTiendas.getSelectedIndex();
        if (n >= 0) {
            datos = reportes.PedidosLlegarTienda(listaTiendas.get(comboTiendas.getSelectedIndex()).getCodTienda());
            agregarLista();
        }
    }//GEN-LAST:event_comboTiendasItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int numero = tabla.getSelectedColumn();
        if (numero > 0) {
            String valor = (String) modelo.getValueAt(numero, 8);
            VerProductos nuevo = new VerProductos(valor);
            nuevo.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboTiendas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
