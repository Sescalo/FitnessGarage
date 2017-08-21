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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Michelt
 */
public class FrmClientes extends javax.swing.JFrame {

    /**
     * Creates new form FrmClientes
     */
    
    private DefaultTableModel modelo;
    private AdminBaseDatos conexion;
    private FrmMenu frmMenu;
    private Validaciones validaciones;
    
    public FrmClientes(AdminBaseDatos conexion, FrmMenu frmMenu) throws ParseException {
        initComponents();
        this.conexion=conexion;
        this.frmMenu = frmMenu;
        this.validaciones = new Validaciones();
        this.setTablaCliente(conexion.getClientes());
        tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        JTableHeader header = tblClientes.getTableHeader();
//        header.setBackground(Color.red);
        
        this.modelo = (DefaultTableModel) tblClientes.getModel();
        
        comboBox.setModel(new DefaultComboBoxModel(AtributosCliente.values()));
        
        JTextField tf = new JTextField();
        tf.setEditable(false);
        DefaultCellEditor editor = new DefaultCellEditor( tf );
        tblClientes.setDefaultEditor(Object.class, editor);
        
        tblClientes.setDefaultRenderer(Object.class, new MyCellRenderer(frmMenu));
        //modelo.setRowColor(0, Color.RED);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent e) {
//                DefaultTableModel tmpModelo = (DefaultTableModel) tblClientes.getModel();
//                tmpModelo.setRowCount(0);
//                setTablaCliente(conexion.getClientes());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                DefaultTableModel tmpModelo = (DefaultTableModel) tblClientes.getModel();
                tmpModelo.setRowCount(0);
                try {
                    setTablaCliente(conexion.getClientes());
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (ParseException ex) {
                    Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    public void escuchar(ActionListener manejador){
         this.btnSalir.addActionListener(manejador);
    }
    
    public void setTablaCliente(ArrayList<Cliente> clientes) throws ParseException{
       DefaultTableModel modelo = (DefaultTableModel) this.tblClientes.getModel();
       String ast;
       for(Cliente cliente: clientes){
           ast="";
           if(!cliente.getMorosidades().equalsIgnoreCase("")){
               ast = "*";
           }
           int diasRestantes = validaciones.calcularDiasRestantes(cliente.getFechaPago());
           String fechaProxPago = validaciones.generarFechaProxPago(cliente.getFechaPago());
            Object[] tmp={cliente.getIdCliente(),diasRestantes,cliente.getNombreCliente()+ast,cliente.getPrimerApellido(),cliente.getSegundoApellido(),
            cliente.getCedula(),cliente.getTelefono(),cliente.getDireccion(),cliente.getEmail(),cliente.getFechaIngreso(),
            cliente.getFechaPago(),fechaProxPago,cliente.getMorosidades(),cliente.getComentarios(),cliente.isTratoEspecial()};
            modelo.addRow(tmp);
       }
    }

    public String getTxtBuscar() {
        return txtBuscar.getText();
    }

    public void setTxtBuscar(String txtBuscar) {
        this.txtBuscar.setText(txtBuscar);
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAdminCliente = new javax.swing.JButton();
        btnTablaOriginal = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 0));
        jLabel1.setText("Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Clientes", "Días restantes para vencimiento", "Nombre", "Primer Apellido", "Segundo Apellido", "Cedula", "Telefono", "Dirección", "E-mail", "Fecha de Ingreso", "Fecha de Pago", "Fecha del próximo pago", "Morosidades", "Comentarios", "Trato Especial"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblClientes.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblClientes.getColumnModel().getColumn(4).setPreferredWidth(110);
            tblClientes.getColumnModel().getColumn(5).setPreferredWidth(110);
            tblClientes.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblClientes.getColumnModel().getColumn(7).setPreferredWidth(330);
            tblClientes.getColumnModel().getColumn(8).setPreferredWidth(140);
            tblClientes.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblClientes.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblClientes.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblClientes.getColumnModel().getColumn(12).setPreferredWidth(150);
            tblClientes.getColumnModel().getColumn(13).setPreferredWidth(200);
            tblClientes.getColumnModel().getColumn(14).setPreferredWidth(100);
        }

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAdminCliente.setText("Administrar Clientes");
        btnAdminCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminClienteActionPerformed(evt);
            }
        });

        btnTablaOriginal.setText("Ver Tabla Original");
        btnTablaOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaOriginalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdminCliente)
                                .addGap(39, 39, 39)
                                .addComponent(btnTablaOriginal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(comboBox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnAdminCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTablaOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
//        modelo.setRowCount(0);
//        this.setTablaCliente(conexion.getClientes());
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if(!this.txtBuscar.getText().equalsIgnoreCase("")){
            AtributosCliente ac = (AtributosCliente)comboBox.getSelectedItem();
            ArrayList<Cliente> clientesBusqueda = conexion.getClientesBusqueda(this.txtBuscar.getText(), ac.name());
            if(clientesBusqueda.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay resultados que concuerden con su búsqueda.");
            } else {
                this.modelo.setRowCount(0);
                try {
                    this.setTablaCliente(clientesBusqueda);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "El campo de texto de buscar esta vacío.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTablaOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaOriginalActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        try {
            this.setTablaCliente(conexion.getClientes());
        } catch (ParseException ex) {
            Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTablaOriginalActionPerformed

    private void btnAdminClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminClienteActionPerformed
        // TODO add your handling code here:
        this.frmMenu.getFrmAdminCliente().setVisible(true);
    }//GEN-LAST:event_btnAdminClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTablaOriginal;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
