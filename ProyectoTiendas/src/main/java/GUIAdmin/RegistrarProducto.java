package GUIAdmin;

import BInstancias.Tienda;

/**
 *
 * @author aguare
 */
public class RegistrarProducto extends javax.swing.JFrame {
    
    private final Tienda tienda;
    /**
     * Creates new form IngresarProducto
     * @param tienda la tienda en la que se estara trabajando
     */
    public RegistrarProducto(Tienda tienda) {
        initComponents();
        this.tienda = tienda;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventarioIngresar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jComboBox13 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel39 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel13.setText("CÓDIGO:");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1810714-1 MARCOS ANDRES AGUARE BRAVO", "1810714-1 JAIRO DANIEL GONZÁLEZ BRAVO", "1810714-1 ANGEL DANIEL JUAREZ BRAVO", "0000000-0 NOMBRE DE PRUEBA DE CLIENTE" }));
        jComboBox10.setEnabled(false);
        jComboBox10.setFocusCycleRoot(true);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel35.setText("FABRICANTE:");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1810714-1 MARCOS ANDRES AGUARE BRAVO", "1810714-1 JAIRO DANIEL GONZÁLEZ BRAVO", "1810714-1 ANGEL DANIEL JUAREZ BRAVO", "0000000-0 NOMBRE DE PRUEBA DE CLIENTE" }));
        jComboBox13.setEnabled(false);
        jComboBox13.setFocusCycleRoot(true);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel36.setText("NOMBRE:");

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel37.setText("DESCRIPCIÓN:");

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel38.setText("CANTIDAD:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel39.setText("PRECIO:");

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel40.setText("MESES DE GARANTÍA:");

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("REGISTRAR");

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel41.setText("INFORMACIÓN:");

        javax.swing.GroupLayout inventarioIngresarLayout = new javax.swing.GroupLayout(inventarioIngresar);
        inventarioIngresar.setLayout(inventarioIngresarLayout);
        inventarioIngresarLayout.setHorizontalGroup(
            inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioIngresarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(inventarioIngresarLayout.createSequentialGroup()
                            .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(jSpinner1))))
                    .addGroup(inventarioIngresarLayout.createSequentialGroup()
                        .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner2)
                            .addComponent(jLabel40))
                        .addGap(56, 56, 56)
                        .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jTextField18))))
                .addGap(37, 37, 37)
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.Alignment.LEADING, 0, 420, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventarioIngresarLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        inventarioIngresarLayout.setVerticalGroup(
            inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventarioIngresarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel35))
                .addGap(1, 1, 1)
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inventarioIngresarLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventarioIngresarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inventarioIngresarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(inventarioIngresarLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventarioIngresarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventarioIngresarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inventarioIngresarLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inventarioIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))
                            .addGroup(inventarioIngresarLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(32, 32, 32))))
                    .addGroup(inventarioIngresarLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventarioIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventarioIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inventarioIngresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    // End of variables declaration//GEN-END:variables
}
