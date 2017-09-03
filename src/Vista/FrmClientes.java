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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    private FrmTipoCliente tipoCliente;
    private Cliente cliente;
    
    public FrmClientes(AdminBaseDatos conexion, FrmMenu frmMenu) throws ParseException {
        initComponents();
        this.conexion=conexion;
        this.frmMenu = frmMenu;
        this.validaciones = new Validaciones();
        this.tipoCliente = new FrmTipoCliente();
        this.cliente = new Cliente();
        ArrayList<Cliente> clientes = conexion.getClientes();
        this.setTablaCliente(clientes);
        tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        JTableHeader header = tblClientes.getTableHeader();
//        header.setBackground(Color.red);
        
        this.modelo = (DefaultTableModel) tblClientes.getModel();
        
        comboBox.setModel(new DefaultComboBoxModel(AtributosCliente.values()));
        comboBox.setSelectedIndex(2);
        
        JTextField tf = new JTextField();
        tf.setEditable(false);
        DefaultCellEditor editor = new DefaultCellEditor( tf );
        tblClientes.setDefaultEditor(Object.class, editor);
        
        tblClientes.setDefaultRenderer(Object.class, new MyCellRenderer(frmMenu));
        //modelo.setRowColor(0, Color.RED);
        tblClientes.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (me.getClickCount() == 2 && tblClientes.getSelectedRow() != -1) {
                    ArrayList<Cliente> clientes = conexion.getClientes();
                        try {
                            if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Activos")){
                                clientes = cliente.getClientesActivos(clientes);
                            } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Morosos")){
                                clientes = cliente.getClientesMorosos(clientes);
                            } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Advertencia")){
                                clientes = cliente.getClientesMorPronta(clientes);
                            } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Tratos Especiales")){
                                clientes = cliente.getClientesTratoEspecial(clientes);
                            } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("radioBusqueda")){
                                AtributosCliente ac = (AtributosCliente)comboBox.getSelectedItem();
                                if(ac.name().equalsIgnoreCase("fechaSigPago")){
                                    clientes = getClientesFechaSigPago(txtBuscar.getText());
                                } else {
                                    clientes = conexion.getClientesBusqueda(txtBuscar.getText(), ac.name());
                                }
                            }                            
                        } catch (ParseException ex) {
                            Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    int indice = tblClientes.getSelectedRow();
                    Cliente cliente = clientes.get(indice);
                    tblClientes.getCellEditor().stopCellEditing();

                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtIdCliente(cliente.getIdCliente());
                    try {
                        frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtDiasRestantes(validaciones.calcularDiasRestantes(cliente.getFechaSigPago()));
                    } catch (ParseException ex) {
                        Logger.getLogger(MyCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtNombre(cliente.getNombreCliente());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtPrimApellido(cliente.getPrimerApellido());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtSegApellido(cliente.getSegundoApellido());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtCedula(cliente.getCedula());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtTelefono(cliente.getTelefono());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtDireccion(cliente.getDireccion());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtEmail(cliente.getEmail());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtFechaIngreso(cliente.getFechaIngreso());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtFechaPago(cliente.getFechaPago());
                    try {
                        frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtFechaProxPago(validaciones.generarFechaProxPago(cliente.getFechaPago()));
                    } catch (ParseException ex) {
                        Logger.getLogger(MyCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtMorosidades(cliente.getMorosidades());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setTxtAComentario(cliente.getComentarios());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().setChboxTratoEspecial(cliente.isTratoEspecial());
                    frmMenu.getFrmAdminCliente().getPnlAdminCliente1().getBtnModificar().setEnabled(true);
                    if(frmMenu.getNombreUsuario().equalsIgnoreCase("Edu")){
                        frmMenu.getFrmAdminCliente().getPnlAdminCliente1().getBtnEliminar().setEnabled(true);
                    } else {
                        frmMenu.getFrmAdminCliente().getPnlAdminCliente1().getBtnEliminar().setEnabled(false);
                    }
                    frmMenu.getFrmAdminCliente().setVisible(true);
                }
            }
        });
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
                ArrayList<Cliente> clientes = conexion.getClientes();
                ArrayList<Cliente> activos = new ArrayList<>();
                ArrayList<Cliente> morosos = new ArrayList<>();
                ArrayList<Cliente> advertencia = new ArrayList<>();
                ArrayList<Cliente> especial = new ArrayList<>();
                
                try {
                    activos = cliente.getClientesActivos(clientes);
                    morosos = cliente.getClientesMorosos(clientes);
                    advertencia = cliente.getClientesMorPronta(clientes);
                    especial = cliente.getClientesTratoEspecial(clientes);
                } catch (ParseException ex) {
                    Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DefaultTableModel tmpModelo = (DefaultTableModel) tblClientes.getModel();
                tmpModelo.setRowCount(0);
                setActivos("Activos: "+activos.size());
                setMorosos("Morosos: "+morosos.size());
                setMorosidadPronta("Advertencia: "+advertencia.size());
                setTratoEspecial("T. Especial: "+especial.size());
                try {
                    if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Todos")){
                        setTablaCliente(clientes);
                    } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Activos")){
                        setTablaCliente(activos);
                    } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Morosos")){
                        setTablaCliente(morosos);
                    } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Advertencia")){
                        setTablaCliente(advertencia);
                    } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("Tratos Especiales")){
                        setTablaCliente(especial);
                    } else if(tipoCliente.getRadioSeleccionado().equalsIgnoreCase("radioBusqueda")){
                        AtributosCliente ac = (AtributosCliente)comboBox.getSelectedItem();
                        if(ac.name().equalsIgnoreCase("fechaSigPago")){
                            setTablaCliente(getClientesFechaSigPago(txtBuscar.getText()));
                        } else {
                            setTablaCliente(conexion.getClientesBusqueda(txtBuscar.getText(), ac.name()));
                        }
                    }
                    
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
           int diasRestantes = validaciones.calcularDiasRestantes(cliente.getFechaSigPago());
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
        activos = new javax.swing.JLabel();
        morosos = new javax.swing.JLabel();
        morosidadPronta = new javax.swing.JLabel();
        tratoEspecial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabla de Clientes");
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
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

        btnTablaOriginal.setText("Cambiar Vista");
        btnTablaOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaOriginalActionPerformed(evt);
            }
        });

        activos.setBackground(new java.awt.Color(51, 255, 0));
        activos.setText("Activos: ");
        activos.setOpaque(true);

        morosos.setBackground(new java.awt.Color(255, 0, 0));
        morosos.setText("Morosos: ");
        morosos.setOpaque(true);

        morosidadPronta.setBackground(new java.awt.Color(255, 255, 0));
        morosidadPronta.setText("Advertencia: ");
        morosidadPronta.setOpaque(true);

        tratoEspecial.setBackground(new java.awt.Color(0, 0, 255));
        tratoEspecial.setText("T. Especial: ");
        tratoEspecial.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(activos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(morosos, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(morosidadPronta, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(tratoEspecial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdminCliente)
                                .addGap(39, 39, 39)
                                .addComponent(btnTablaOriginal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboBox, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(morosidadPronta, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(morosos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tratoEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
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
            ArrayList<Cliente> clientesBusqueda = new ArrayList<>();
            if(ac.name().equalsIgnoreCase("fechaSigPago")){
                try {
                    clientesBusqueda = getClientesFechaSigPago(this.txtBuscar.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                clientesBusqueda = conexion.getClientesBusqueda(this.txtBuscar.getText(), ac.name());
            }
            
            if(clientesBusqueda.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay resultados que concuerden con su búsqueda.");
            } else {
                this.modelo.setRowCount(0);
                try {
                    this.setTablaCliente(clientesBusqueda);
                    this.tipoCliente.setRadioBusqueda();
                } catch (ParseException ex) {
                    Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "El campo de texto de buscar esta vacío.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public ArrayList<Cliente> getClientesFechaSigPago(String buscar) throws ParseException{
        ArrayList<Cliente> c = conexion.getClientes();
        ArrayList<Cliente> nueva = new ArrayList<>();
        for (Cliente cliente : c){
            if(validaciones.generarFechaProxPago(cliente.getFechaPago()).equalsIgnoreCase(buscar)){
                nueva.add(cliente);
            }
        }
        return nueva;
    }
    
    private void btnTablaOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaOriginalActionPerformed
        // TODO add your handling code here:
        this.tipoCliente.setVisible(true);
//        modelo.setRowCount(0);
//        try {
//            this.setTablaCliente(conexion.getClientes());
//        } catch (ParseException ex) {
//            Logger.getLogger(FrmClientes.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnTablaOriginalActionPerformed

    public String getActivos() {
        return activos.getText();
    }

    public void setActivos(String activos) {
        this.activos.setText(activos);
    }

    public String getMorosidadPronta() {
        return morosidadPronta.getText();
    }

    public void setMorosidadPronta(String morosidadPronta) {
        this.morosidadPronta.setText(morosidadPronta);
    }

    public String getMorosos() {
        return morosos.getText();
    }

    public void setMorosos(String morosos) {
        this.morosos.setText(morosos);
    }

    public String getTratoEspecial() {
        return tratoEspecial.getText();
    }

    public void setTratoEspecial(String tratoEspecial) {
        this.tratoEspecial.setText(tratoEspecial);
    }

    private void btnAdminClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminClienteActionPerformed
        // TODO add your handling code here:
        this.frmMenu.getFrmAdminCliente().setVisible(true);
    }//GEN-LAST:event_btnAdminClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activos;
    private javax.swing.JButton btnAdminCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTablaOriginal;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel morosidadPronta;
    private javax.swing.JLabel morosos;
    private javax.swing.JTable tblClientes;
    private javax.swing.JLabel tratoEspecial;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
