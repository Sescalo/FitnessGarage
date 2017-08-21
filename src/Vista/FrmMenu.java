/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.AdminBaseDatos;
import Modelo.AtributosCliente;
import Modelo.Cliente;
import Modelo.Validaciones;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author Michelt
 */
public class FrmMenu extends javax.swing.JFrame {

    private FrmSesion frmSesion;
    private FrmAdminCliente frmAdminCliente;
    private FrmAdminUsuario frmAdminUsuario;
    private FrmClientes frmCliente;
    private FrmTablaMorosos frmMorosos;
    private AdminBaseDatos conexion;
    private FrmHistorial frmHistorial;
    
    public FrmMenu() throws ClassNotFoundException, SQLException, ParseException, FileNotFoundException {
        initComponents();
        this.nombreUsuario.setVisible(false);
        deshabilitarComponentes();
        this.conexion = new AdminBaseDatos();
        this.frmMorosos = new FrmTablaMorosos(conexion,this);
        this.frmSesion = new FrmSesion(conexion, this, frmMorosos);
        this.frmAdminCliente = new FrmAdminCliente(conexion, this);
        this.frmAdminUsuario = new FrmAdminUsuario(conexion, this);
        this.frmCliente = new FrmClientes(conexion, this);
        this.frmHistorial = new FrmHistorial(conexion, this);
    }
    
    public void deshabilitarComponentes() {
        jmMantenimiento.setEnabled(false);
        jmiCerrarSesion.setEnabled(false);
    }
    
    public void habilitarMantenimiento() {        
        jmMantenimiento.setEnabled(true);
        jmiIniciarSesion.setEnabled(false);
        jmiCerrarSesion.setEnabled(true);
    }

    public String getNombreUsuario() {
        return nombreUsuario.getText();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario.setText(nombreUsuario);
    }

    public FrmSesion getFrmSesion() {
        return frmSesion;
    }

    public void setFrmSesion(FrmSesion frmSesion) {
        this.frmSesion = frmSesion;
    }

    public FrmAdminCliente getFrmAdminCliente() {
        return frmAdminCliente;
    }

    public void setFrmAdminCliente(FrmAdminCliente frmAdminCliente) {
        this.frmAdminCliente = frmAdminCliente;
    }

    public FrmAdminUsuario getFrmAdminUsuario() {
        return frmAdminUsuario;
    }

    public void setFrmAdminUsuario(FrmAdminUsuario frmAdminUsuario) {
        this.frmAdminUsuario = frmAdminUsuario;
    }

    public FrmClientes getFrmCliente() {
        return frmCliente;
    }

    public void setFrmCliente(FrmClientes frmCliente) {
        this.frmCliente = frmCliente;
    }

    public FrmTablaMorosos getFrmMorosos() {
        return frmMorosos;
    }

    public void setFrmMorosos(FrmTablaMorosos frmMorosos) {
        this.frmMorosos = frmMorosos;
    }
    
    public FrmHistorial getFrmHistorial(){
      return frmHistorial;
}
    
    public void setFrmHistorial(FrmHistorial frmHistorial){
        this.frmHistorial= frmHistorial;
    }
    
    public void crearInserts() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("C:\\Users\\Sergio\\Desktop\\listaNueva.csv"), "ISO-8859-1");
        scanner.useDelimiter(";|\\n");
        int count=0;
        Cliente cliente = new Cliente();
        while(scanner.hasNext()){
            if(count == 0){
                scanner.next();
            }
            else if(count == 1){
                cliente.setDiasVencimiento(Integer.valueOf(scanner.next()));
            } else if(count == 2){
                cliente.setNombreCliente(scanner.next());
            } else if(count == 3){
                cliente.setPrimerApellido(scanner.next());
            } else if(count == 4){
                cliente.setSegundoApellido(scanner.next());
            } else if(count == 5){
                cliente.setCedula(scanner.next());
            } else if(count == 6){
                cliente.setTelefono(scanner.next());
            } else if(count == 7){
                cliente.setDireccion(scanner.next());
            } else if(count == 8){
                cliente.setEmail(scanner.next());
            } else if(count == 9){
                cliente.setFechaIngreso(scanner.next());
            } else if(count == 10){
                String fechaPago = scanner.next();
                if(fechaPago.charAt(2) != '/'){
                    fechaPago = "0"+fechaPago;
                }if (fechaPago.charAt(5) != '/'){
                    fechaPago = fechaPago.substring(0,3)+"0"+fechaPago.substring(3, fechaPago.length());
                }
                cliente.setFechaPago(fechaPago);
            } else if(count == 11){
                cliente.setFechaSigPago(scanner.next());
            } else if(count == 12){
                cliente.setComentarios(scanner.next());
                cliente.setTratoEspecial(false);
                cliente.setEliminado(false);
                cliente.setMorosidades("");
                count = -1;
                System.out.println(cliente.toString());
                conexion.agregarCliente(cliente);
            }
            count++;
        }
        scanner.close();
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
        nombreUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmSesion = new javax.swing.JMenu();
        jmiIniciarSesion = new javax.swing.JMenuItem();
        jmiCerrarSesion = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();
        jmMantenimiento = new javax.swing.JMenu();
        jmiTblClientes = new javax.swing.JMenuItem();
        jmiAdminUsuarios = new javax.swing.JMenuItem();
        jmiAdminClientes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mniHistorial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(902, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/grande.png"))); // NOI18N

        nombreUsuario.setText("jLabel2");

        jmSesion.setText("Sesión");

        jmiIniciarSesion.setText("Iniciar Sesión");
        jmiIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIniciarSesionActionPerformed(evt);
            }
        });
        jmSesion.add(jmiIniciarSesion);

        jmiCerrarSesion.setText("Cerrar Sesión");
        jmiCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCerrarSesionActionPerformed(evt);
            }
        });
        jmSesion.add(jmiCerrarSesion);

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmSesion.add(jmiSalir);

        jMenuBar1.add(jmSesion);

        jmMantenimiento.setText("Mantenimiento");

        jmiTblClientes.setText("Tabla de Clientes");
        jmiTblClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTblClientesActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiTblClientes);

        jmiAdminUsuarios.setText("Administrador Usuarios");
        jmiAdminUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdminUsuariosActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiAdminUsuarios);

        jmiAdminClientes.setText("Administrador Clientes");
        jmiAdminClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdminClientesActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiAdminClientes);

        jMenuItem1.setText("Tabla de Avisos de pago");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem1);

        mniHistorial.setText("Historial");
        mniHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHistorialActionPerformed(evt);
            }
        });
        jmMantenimiento.add(mniHistorial);

        jMenuBar1.add(jmMantenimiento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAdminUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdminUsuariosActionPerformed
        frmAdminUsuario.setVisible(true);
    }//GEN-LAST:event_jmiAdminUsuariosActionPerformed

    private void jmiAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdminClientesActionPerformed
        frmAdminCliente.setVisible(true);
    }//GEN-LAST:event_jmiAdminClientesActionPerformed

    private void jmiTblClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTblClientesActionPerformed
        frmCliente.setVisible(true);
    }//GEN-LAST:event_jmiTblClientesActionPerformed

    private void jmiIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIniciarSesionActionPerformed
         frmSesion.setVisible(true);
    }//GEN-LAST:event_jmiIniciarSesionActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCerrarSesionActionPerformed
       jmMantenimiento.setEnabled(false);
        jmiIniciarSesion.setEnabled(true);
        jmiCerrarSesion.setEnabled(false);
    }//GEN-LAST:event_jmiCerrarSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmMorosos.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mniHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHistorialActionPerformed
       frmHistorial.setVisible(true);
    }//GEN-LAST:event_mniHistorialActionPerformed

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
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmMenu().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmMantenimiento;
    private javax.swing.JMenu jmSesion;
    private javax.swing.JMenuItem jmiAdminClientes;
    private javax.swing.JMenuItem jmiAdminUsuarios;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiIniciarSesion;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiTblClientes;
    private javax.swing.JMenuItem mniHistorial;
    private javax.swing.JLabel nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
