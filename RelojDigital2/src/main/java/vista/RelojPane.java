/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import com.fernandowirtz.relojdigital.Alarma;
import com.fernandowirtz.relojdigital.ModeloReloj;
import controlador.ControladorReloj;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hector.garaboacasas
 */
public class RelojPane extends javax.swing.JPanel {

    /**
     * Creates new form RelojPane
     */
    public RelojPane() {
         initComponents();

        ModeloReloj modelo=new ModeloReloj();
        
        new ControladorReloj(modelo, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        btnAñadirAlarma = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLAlarmas = new javax.swing.JList<>();
        btnEliminarAlarma = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnFormato = new javax.swing.JButton();
        btnFecha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0, 0, 102));
        setForeground(new java.awt.Color(0, 255, 0));
        setToolTipText("");

        txtMensaje.setBackground(new java.awt.Color(153, 153, 153));
        txtMensaje.setColumns(20);
        txtMensaje.setForeground(new java.awt.Color(0, 255, 0));
        txtMensaje.setRows(5);
        txtMensaje.setName(""); // NOI18N
        jScrollPane1.setViewportView(txtMensaje);

        btnAñadirAlarma.setBackground(new java.awt.Color(153, 153, 153));
        btnAñadirAlarma.setForeground(new java.awt.Color(0, 255, 0));
        btnAñadirAlarma.setText("Añadir alarma");
        btnAñadirAlarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirAlarmaActionPerformed(evt);
            }
        });

        jLAlarmas.setBackground(new java.awt.Color(153, 153, 153));
        jLAlarmas.setForeground(new java.awt.Color(0, 255, 0));
        jScrollPane2.setViewportView(jLAlarmas);

        btnEliminarAlarma.setBackground(new java.awt.Color(153, 153, 153));
        btnEliminarAlarma.setForeground(new java.awt.Color(0, 255, 0));
        btnEliminarAlarma.setText("Eliminar Alarma");

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 204, 0));

        lblHora.setBackground(new java.awt.Color(0, 0, 0));
        lblHora.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 255, 0));

        btnFormato.setBackground(new java.awt.Color(153, 153, 153));
        btnFormato.setForeground(new java.awt.Color(0, 255, 0));
        btnFormato.setText("Cambiar Formato");

        btnFecha.setBackground(new java.awt.Color(153, 153, 153));
        btnFecha.setForeground(new java.awt.Color(0, 255, 0));
        btnFecha.setText("Mostrar fecha");

        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Fecha");

        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("Hora");

        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("Mensaje");

        txtFecha.setBackground(new java.awt.Color(153, 153, 153));
        txtFecha.setForeground(new java.awt.Color(0, 255, 0));
        txtFecha.setText("yyyy/MM/dd");
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtHora.setBackground(new java.awt.Color(153, 153, 153));
        txtHora.setForeground(new java.awt.Color(0, 255, 0));
        txtHora.setText("HH:mm");

        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("Lista de Alarmas");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFecha)
                                .addGap(32, 32, 32)
                                .addComponent(btnFormato))
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(btnAñadirAlarma, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarAlarma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(278, 278, 278)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnFormato)
                                            .addComponent(btnFecha)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(1, 1, 1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(btnAñadirAlarma)))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarAlarma)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirAlarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirAlarmaActionPerformed

    }//GEN-LAST:event_btnAñadirAlarmaActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirAlarma;
    private javax.swing.JButton btnEliminarAlarma;
    private javax.swing.JButton btnFecha;
    private javax.swing.JButton btnFormato;
    private javax.swing.JList<Alarma> jLAlarmas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables


public void actualizarHora(String hora) {

        lblHora.setText(hora);

    }

    public void actualizarFecha(String fecha) {

        lblFecha.setText(fecha);

    }

    
    //probar toggle buttons cMBIO DE COLORES
    public JButton getBtnFecha() {
        return btnFecha;
    }

    public JButton getBtnFormato() {
        return btnFormato;
    }
    
    
    public JButton getBtnAñadirAlarma(){
        return btnAñadirAlarma;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtHora() {
        return txtHora;
    }

    public JTextArea getTxtMensaje() {
        return txtMensaje;
    }

    public JList<Alarma> getjLAlarmas() {
        return jLAlarmas;
    }

    public JButton getBtnEliminarAlarma() {
        return btnEliminarAlarma;
    }

    public void setBtnFecha(JButton btnFecha) {
        this.btnFecha = btnFecha;
    }

    public void setBtnFormato(JButton btnFormato) {
        this.btnFormato = btnFormato;
    }
    

}
