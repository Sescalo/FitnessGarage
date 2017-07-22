/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdminBaseDatos;
import Modelo.Usuario;
import Vista.FrmSesion;
import Vista.FrmTablaMorosos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Michelt
 */
public class ManejadorSesion implements ActionListener{

    private FrmSesion frmSesion;
    private AdminBaseDatos conexion;
    private FrmTablaMorosos frmMorosos;

    public ManejadorSesion(FrmSesion frmSesion) {
        this.frmSesion = frmSesion;
        this.conexion= this.frmSesion.getConexion();
        this.frmMorosos = frmSesion.getFrmMorosos();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equalsIgnoreCase("Salir")){
            frmSesion.dispose();
            frmSesion.limpiarCamposSesion();
        }
        if(ae.getActionCommand().equalsIgnoreCase("Iniciar Sesión")){
            String nombreUsuario=this.frmSesion.getTxtSesionUsuario();
            String contrasena= this.frmSesion.getTxtContrasena();
            if(!nombreUsuario.equalsIgnoreCase("") && !contrasena.equalsIgnoreCase("")){
               Usuario usuario= new Usuario(nombreUsuario,contrasena);
               if(conexion.existeUsuario(usuario)){
                    frmSesion.getFrmMenu().setNombreUsuario(nombreUsuario);
                    frmSesion.getFrmMenu().habilitarMantenimiento();
                    frmSesion.dispose();
                    frmSesion.setTxtSesionUsuario("");
                    frmSesion.setTxtContrasena("");
                    frmMorosos.setVisible(true);
                    if(!nombreUsuario.equalsIgnoreCase("scampos")){
                        frmSesion.getFrmMenu().getFrmAdminUsuario().getBtnEliminar().setEnabled(false);
                        frmSesion.getFrmMenu().getFrmAdminUsuario().getJTextContra().setVisible(false);
                        frmSesion.getFrmMenu().getFrmAdminCliente().getPnlAdminCliente1().getBtnEliminar().setEnabled(false);
                    }
               }else {
                     JOptionPane.showMessageDialog(frmSesion, "No existe el usuario.");
                     frmSesion.setTxtContrasena("");
            }
        }else {
                JOptionPane.showMessageDialog(frmSesion, "Ingrese correctamente los datos.");
            }
    }
    
    }
}
