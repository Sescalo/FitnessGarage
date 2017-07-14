/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FrmAdminUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michelt
 */
public class ManejadorAdminUsuario implements ActionListener{
    
    private FrmAdminUsuario frmAdminUsuario;

    public ManejadorAdminUsuario(FrmAdminUsuario frmAdminUsuario) {
        this.frmAdminUsuario = frmAdminUsuario;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
