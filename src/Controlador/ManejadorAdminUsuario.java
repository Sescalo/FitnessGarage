/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdminBaseDatos;
import Modelo.Usuario;
import Modelo.Validaciones;
import Vista.FrmAdminUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Michelt
 */
public class ManejadorAdminUsuario implements ActionListener{
    
    private FrmAdminUsuario frmAdminUsuario;
    private Validaciones validar;
    private AdminBaseDatos conexion;

    public ManejadorAdminUsuario(FrmAdminUsuario frmAdminUsuario) {
        this.frmAdminUsuario = frmAdminUsuario;
        this.validar = new Validaciones();
        this.conexion = this.frmAdminUsuario.getConexion();
    }
    
    public Usuario usuarioVacio(){
        String nombreUsuario = frmAdminUsuario.getTxtNombreUsuario();
        String contrasena = frmAdminUsuario.getTxtContrasena();
        String nombre = frmAdminUsuario.getTxtNombre();
        String primerApellido = frmAdminUsuario.getTxtPriApellido();
        String segundoApellido = frmAdminUsuario.getTxtSegApellido();
        if (nombreUsuario.equalsIgnoreCase("") || contrasena.equalsIgnoreCase("") || nombre.equalsIgnoreCase("") || primerApellido.equalsIgnoreCase("") || segundoApellido.equalsIgnoreCase("")){
            return null;
        } else {
            return new Usuario(nombreUsuario, contrasena, nombre, primerApellido, segundoApellido, false);
        }
    }
    
    public boolean validarDatosUsuario(Usuario usuario){
        if(!validar.validarNombreUsuario(usuario.getNombreUsuario())){
            JOptionPane.showMessageDialog(frmAdminUsuario, "El nombre de usuario es incorrecto.");
            return false;
        }
        else if(conexion.existeUsuario(usuario)){
            JOptionPane.showMessageDialog(frmAdminUsuario, "El nombre de usuario ya existe.");
            return false;
        }
        else if(usuario.getIdUsuario() == 1){
            JOptionPane.showMessageDialog(frmAdminUsuario, "No puede modificar a este usuario.");
            return false;
        }
        else if(!validar.validarNombres(usuario.getNombre(), usuario.getPrimerApellido(), usuario.getSegundoApellido())){
            JOptionPane.showMessageDialog(frmAdminUsuario, "El nombre o apellido es incorrecto.");
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Usuario usuario;
        if(ae.getActionCommand().equalsIgnoreCase("Salir")){
           frmAdminUsuario.dispose();
        }
        if(ae.getActionCommand().equalsIgnoreCase("Incluir")){
            usuario = usuarioVacio();
            if(usuario != null){
                if(validarDatosUsuario(usuario)){
                    conexion.agregarUsuario(usuario);
                    JOptionPane.showMessageDialog(frmAdminUsuario, "Usuario agregado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(frmAdminUsuario, "Ingrese los datos correctamente.");
            }
        }
        if(ae.getActionCommand().equalsIgnoreCase("Modificar")){
            usuario = usuarioVacio();
            if(usuario != null){
                if(validarDatosUsuario(usuario) && usuario.getIdUsuario() != 1){
                    conexion.modificarUsuario(usuario);
                    JOptionPane.showMessageDialog(frmAdminUsuario, "Usuario modificado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(frmAdminUsuario, "Ingrese los datos correctamente.");
            }
        }
        if(ae.getActionCommand().equalsIgnoreCase("Mostrar")){
            String nombre = frmAdminUsuario.getTxtNombre();
            String primerApellido = frmAdminUsuario.getTxtPriApellido();
            if(!nombre.equalsIgnoreCase("") && !primerApellido.equalsIgnoreCase("")){
                usuario = conexion.buscarUsuario(nombre, primerApellido);
                if (usuario != null){
                    frmAdminUsuario.mostrarInfoUsuario(usuario);
                } else {
                    JOptionPane.showMessageDialog(frmAdminUsuario, "El usuario no existe.");
                }
            } else {
                JOptionPane.showMessageDialog(frmAdminUsuario, "Ingrese los datos correctamente.");
            }
        }
        if(ae.getActionCommand().equalsIgnoreCase("Eliminar")){
            if(JOptionPane.showConfirmDialog(frmAdminUsuario, "¿Está seguro de eliminar este usuario?") == 0 && frmAdminUsuario.getTxtIdUsuario() != 1){
                conexion.eliminarUsuario(frmAdminUsuario.getTxtIdUsuario());
                JOptionPane.showMessageDialog(frmAdminUsuario, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(frmAdminUsuario, "No puede eliminar este usuario.");
            }
        }
        
    }
    
}
