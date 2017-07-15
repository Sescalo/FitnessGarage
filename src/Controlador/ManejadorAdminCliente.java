/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FrmAdminCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michelt
 */
public class ManejadorAdminCliente implements ActionListener {

    private FrmAdminCliente frmAdminCliente;

    public ManejadorAdminCliente(FrmAdminCliente frmAdminCliente) {
        this.frmAdminCliente = frmAdminCliente;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equalsIgnoreCase("Salir")){
             frmAdminCliente.dispose();
        }
        if(ae.getActionCommand().equalsIgnoreCase("Incluir")){
        
        }
        if(ae.getActionCommand().equalsIgnoreCase("Modificar")){
        
        }
        if(ae.getActionCommand().equalsIgnoreCase("Mostrar")){
        
        }
        if(ae.getActionCommand().equalsIgnoreCase("Eliminar")){
        
        }
    }
    
}
