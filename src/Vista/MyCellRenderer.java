/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Validaciones;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author Sergio
 */
public class MyCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
    
    private FrmMenu frmMenu;
    private FrmAdminCliente frmAdminCliente;
    private PnlAdminCliente pnlAdminCliente;
    
    public MyCellRenderer(FrmMenu frmMenu){
        this.frmMenu = frmMenu;
        this.frmAdminCliente = frmMenu.getFrmAdminCliente();
        this.pnlAdminCliente = frmAdminCliente.getPnlAdminCliente1();
    }
    
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            final java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //MouseEvent evento;
            Object fechaPago = table.getValueAt(row, 10);
            Object seleccionado = table.getValueAt(row, 14);
            String sval = fechaPago.toString();
            Validaciones validaciones = new Validaciones();
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
                
                pnlAdminCliente.setTxtIdCliente(Integer.valueOf((table.getValueAt(row, 0).toString())));
                pnlAdminCliente.setTxtDiasRestantes(Integer.valueOf((table.getValueAt(row, 1).toString())));
                pnlAdminCliente.setTxtNombre(table.getValueAt(row, 2).toString());
                pnlAdminCliente.setTxtPrimApellido(table.getValueAt(row, 3).toString());
                pnlAdminCliente.setTxtSegApellido(table.getValueAt(row, 4).toString());
                pnlAdminCliente.setTxtCedula(table.getValueAt(row, 5).toString());
                pnlAdminCliente.setTxtTelefono(table.getValueAt(row, 6).toString());
                pnlAdminCliente.setTxtDireccion(table.getValueAt(row, 7).toString());
                pnlAdminCliente.setTxtEmail(table.getValueAt(row, 8).toString());
                pnlAdminCliente.setTxtFechaIngreso(table.getValueAt(row, 9).toString());
                pnlAdminCliente.setTxtFechaPago(table.getValueAt(row, 10).toString());
                pnlAdminCliente.setTxtFechaProxPago(table.getValueAt(row, 11).toString());
                pnlAdminCliente.setTxtMorosidades(table.getValueAt(row, 12).toString());
                pnlAdminCliente.setTxtAComentario(table.getValueAt(row, 13).toString());
                pnlAdminCliente.setChboxTratoEspecial(esSeleccionado);
                this.pnlAdminCliente.getBtnModificar().setEnabled(true);
                if(frmMenu.getNombreUsuario().equalsIgnoreCase("scampos")){
                    this.pnlAdminCliente.getBtnEliminar().setEnabled(true);
                } else {
                    this.pnlAdminCliente.getBtnEliminar().setEnabled(false);
                }
                this.frmAdminCliente.setVisible(true);
                
            }

            return cellComponent;

        }
}
