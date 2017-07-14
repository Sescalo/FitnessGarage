/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Validaciones;
import java.awt.Color;

/**
 *
 * @author Sergio
 */
public class MyCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
    
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            final java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Object val = table.getValueAt(row, 10);
            String sval = val.toString();
            Validaciones validaciones = new Validaciones();
            boolean unDia = validaciones.calcularDiaAntes(sval);
            if (unDia) {
                cellComponent.setForeground(Color.black);
                cellComponent.setBackground(Color.red);

            } else {
                cellComponent.setBackground(Color.white);
                cellComponent.setForeground(Color.black);
            }
            if (isSelected) {
                cellComponent.setForeground(table.getSelectionForeground());
                cellComponent.setBackground(table.getSelectionBackground());
            }

            return cellComponent;

        }
}
