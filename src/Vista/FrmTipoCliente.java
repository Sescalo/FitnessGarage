/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

/**
 *
 * @author Sergio
 */
public class FrmTipoCliente extends javax.swing.JFrame {

    private ButtonGroup radioGrupo;
    private String radioSeleccionado;
    
    /**
     * Creates new form FrmTipoCliente
     */
    public FrmTipoCliente() {
        initComponents();
        this.radioGrupo = new ButtonGroup();
        radioGrupo.add(radioGeneral);
        radioGrupo.add(radioActivos);
        radioGrupo.add(radioMorosos);
        radioGrupo.add(radioFechaCercana);
        radioGrupo.add(radioEspecial);
        this.setResizable(false);
        this.radioSeleccionado = "Todos";
        this.setIconImage(new ImageIcon("src/Img/icono.jpg").getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAceptar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        radioGeneral = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        radioActivos = new javax.swing.JRadioButton();
        radioMorosos = new javax.swing.JRadioButton();
        radioFechaCercana = new javax.swing.JRadioButton();
        radioEspecial = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Vista");

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        radioGeneral.setSelected(true);
        radioGeneral.setText("Todos");
        radioGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGeneralActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Cambiar Vista");

        radioActivos.setText("Activos");
        radioActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioActivosActionPerformed(evt);
            }
        });

        radioMorosos.setText("Morosos");
        radioMorosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMorososActionPerformed(evt);
            }
        });

        radioFechaCercana.setText("Advertencia");
        radioFechaCercana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFechaCercanaActionPerformed(evt);
            }
        });

        radioEspecial.setText("Tratos especiales");
        radioEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEspecialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioMorosos)
                                    .addComponent(radioActivos)
                                    .addComponent(radioFechaCercana)
                                    .addComponent(radioEspecial)
                                    .addComponent(radioGeneral))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(radioGeneral)
                .addGap(18, 18, 18)
                .addComponent(radioActivos)
                .addGap(18, 18, 18)
                .addComponent(radioMorosos)
                .addGap(18, 18, 18)
                .addComponent(radioFechaCercana)
                .addGap(18, 18, 18)
                .addComponent(radioEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGeneralActionPerformed
        // TODO add your handling code here:
        radioGrupo.clearSelection();
        radioGeneral.setSelected(true);
    }//GEN-LAST:event_radioGeneralActionPerformed

    private void radioActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioActivosActionPerformed
        // TODO add your handling code here:
        this.radioGrupo.clearSelection();
        this.radioActivos.setSelected(true);
    }//GEN-LAST:event_radioActivosActionPerformed

    private void radioMorososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMorososActionPerformed
        // TODO add your handling code here:
        this.radioGrupo.clearSelection();
        this.radioMorosos.setSelected(true);
    }//GEN-LAST:event_radioMorososActionPerformed

    private void radioFechaCercanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFechaCercanaActionPerformed
        // TODO add your handling code here:
        this.radioGrupo.clearSelection();
        this.radioFechaCercana.setSelected(true);
    }//GEN-LAST:event_radioFechaCercanaActionPerformed

    private void radioEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEspecialActionPerformed
        // TODO add your handling code here:
        this.radioGrupo.clearSelection();
        this.radioEspecial.setSelected(true);
    }//GEN-LAST:event_radioEspecialActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        for (Enumeration<AbstractButton> buttons = radioGrupo.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                radioSeleccionado = button.getText();
                System.out.println(radioSeleccionado);
            }
        }
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    public String getRadioSeleccionado() {
        return radioSeleccionado;
    }

    public void setRadioSeleccionado(String radioSeleccionado) {
        this.radioSeleccionado = radioSeleccionado;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTipoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTipoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTipoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTipoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTipoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton radioActivos;
    private javax.swing.JRadioButton radioEspecial;
    private javax.swing.JRadioButton radioFechaCercana;
    private javax.swing.JRadioButton radioGeneral;
    private javax.swing.JRadioButton radioMorosos;
    // End of variables declaration//GEN-END:variables
}
