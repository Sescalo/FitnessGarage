/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Validaciones;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class MyCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
    
    private FrmMenu frmMenu;
    private FrmAdminCliente frmAdminCliente;
    private PnlAdminCliente pnlAdminCliente;
    private Validaciones validaciones;
    
    public MyCellRenderer(FrmMenu frmMenu){
        this.frmMenu = frmMenu;
        this.frmAdminCliente = frmMenu.getFrmAdminCliente();
        this.pnlAdminCliente = frmAdminCliente.getPnlAdminCliente1();
        this.validaciones = new Validaciones();
    }
    
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            final java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //MouseEvent evento;
            Object fechaPago = table.getValueAt(row, 11);
            Object seleccionado = table.getValueAt(row, 14);
            String sval = fechaPago.toString();
            boolean moroso = validaciones.calcularMorosos(sval);
            String sseleccionado = seleccionado.toString();
            boolean esSeleccionado = Boolean.valueOf(sseleccionado);
            if (validaciones.calcularMorosidadPronta(sval)){
                cellComponent.setForeground(Color.black);
                cellComponent.setBackground(Color.yellow);
            }
            else if (moroso) {
                cellComponent.setForeground(Color.black);
                cellComponent.setBackground(Color.red);

            } 
            else if (esSeleccionado) {
                cellComponent.setForeground(Color.black);
                cellComponent.setBackground(Color.blue);
            }
            else {
                cellComponent.setBackground(Color.green);
                cellComponent.setForeground(Color.black);
            }
            if (isSelected) {
                cellComponent.setForeground(table.getSelectionForeground());
                cellComponent.setBackground(table.getSelectionBackground());
//                String tmp = table.getValueAt(row, 2).toString();
//                if(!table.getValueAt(row, 12).toString().equalsIgnoreCase("")){
//                    tmp = tmp.substring(0, tmp.length()-1);
//                }
//                pnlAdminCliente.setTxtIdCliente(Integer.valueOf((table.getValueAt(row, 0).toString())));
//                try {
//                    pnlAdminCliente.setTxtDiasRestantes(validaciones.calcularDiasRestantes(table.getValueAt(row, 10).toString()));
//                } catch (ParseException ex) {
//                    Logger.getLogger(MyCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                pnlAdminCliente.setTxtNombre(tmp);
//                pnlAdminCliente.setTxtPrimApellido(table.getValueAt(row, 3).toString());
//                pnlAdminCliente.setTxtSegApellido(table.getValueAt(row, 4).toString());
//                pnlAdminCliente.setTxtCedula(table.getValueAt(row, 5).toString());
//                pnlAdminCliente.setTxtTelefono(table.getValueAt(row, 6).toString());
//                pnlAdminCliente.setTxtDireccion(table.getValueAt(row, 7).toString());
//                pnlAdminCliente.setTxtEmail(table.getValueAt(row, 8).toString());
//                pnlAdminCliente.setTxtFechaIngreso(table.getValueAt(row, 9).toString());
//                pnlAdminCliente.setTxtFechaPago(table.getValueAt(row, 10).toString());
//                try {
//                    pnlAdminCliente.setTxtFechaProxPago(validaciones.generarFechaProxPago(table.getValueAt(row, 10).toString()));
//                } catch (ParseException ex) {
//                    Logger.getLogger(MyCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                pnlAdminCliente.setTxtMorosidades(table.getValueAt(row, 12).toString());
//                pnlAdminCliente.setTxtAComentario(table.getValueAt(row, 13).toString());
//                pnlAdminCliente.setChboxTratoEspecial(esSeleccionado);
//                this.pnlAdminCliente.getBtnModificar().setEnabled(true);
//                if(frmMenu.getNombreUsuario().equalsIgnoreCase("Edu")){
//                    this.pnlAdminCliente.getBtnEliminar().setEnabled(true);
//                } else {
//                    this.pnlAdminCliente.getBtnEliminar().setEnabled(false);
//                }
//                this.frmAdminCliente.setVisible(true);
                
            }

            return cellComponent;

        }
}
