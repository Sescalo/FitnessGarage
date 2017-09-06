/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdminBaseDatos;
import Modelo.Cliente;
import Modelo.Validaciones;
import Vista.FrmAdminCliente;
import Vista.PnlAdminCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Michelt
 */
public class ManejadorAdminCliente implements ActionListener {

    private FrmAdminCliente frmAdminCliente;
    private Validaciones validaciones;
    private AdminBaseDatos conexion;

    public ManejadorAdminCliente(FrmAdminCliente frmAdminCliente) {
        this.frmAdminCliente = frmAdminCliente;
        this.validaciones = new Validaciones();
        this.conexion = frmAdminCliente.getConexion();
    }
    
    public Cliente clienteVacio(){
        PnlAdminCliente panel = frmAdminCliente.getPnlAdminCliente1();
        if(panel.getTxtNombre().equalsIgnoreCase("") || panel.getTxtPrimApellido().equalsIgnoreCase("") || panel.getTxtSegApellido().equalsIgnoreCase("") || 
                panel.getTxtCedula().equalsIgnoreCase("") || panel.getTxtFechaIngreso().equalsIgnoreCase("") || panel.getTxtFechaPago().equalsIgnoreCase("")){
            return null;
        } else {
            return new Cliente(panel.getTxtIdCliente(), panel.getTxtDiasRestantes(), panel.getTxtNombre(), panel.getTxtPrimApellido(), panel.getTxtSegApellido(),
            panel.getTxtCedula(), panel.getTxtTelefono(), panel.getTxtDireccion(), panel.getTxtEmail(), panel.getTxtFechaIngreso(), 
            panel.getTxtFechaPago(), panel.getTxtFechaProxPago(), panel.getTxtMorosidades(), panel.getTxtAComentario(), panel.getCboxTratoEspecial(), false);
        }
    }
    
    public Cliente clienteVacioIncluir(){
        PnlAdminCliente panel = frmAdminCliente.getPnlAdminCliente1();
        if(panel.getTxtNombre().equalsIgnoreCase("") || panel.getTxtPrimApellido().equalsIgnoreCase("") || panel.getTxtSegApellido().equalsIgnoreCase("") || 
                panel.getTxtCedula().equalsIgnoreCase("") || panel.getTxtFechaIngreso().equalsIgnoreCase("") || panel.getTxtFechaPago().equalsIgnoreCase("")){
            return null;
        } else {
            return new Cliente(panel.getTxtDiasRestantes(), panel.getTxtNombre(), panel.getTxtPrimApellido(), panel.getTxtSegApellido(),
            panel.getTxtCedula(), panel.getTxtTelefono(), panel.getTxtDireccion(), panel.getTxtEmail(), panel.getTxtFechaIngreso(), 
            panel.getTxtFechaPago(), panel.getTxtFechaProxPago(), panel.getTxtMorosidades(), panel.getTxtAComentario(), panel.getCboxTratoEspecial(), false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equalsIgnoreCase("Salir")){
             frmAdminCliente.dispose();
             frmAdminCliente.getPnlAdminCliente1().limpiar();
        }
        if(ae.getActionCommand().equalsIgnoreCase("Incluir")){
            Cliente cliente = clienteVacioIncluir();
            if(cliente != null){
                if(validaciones.validarNombres(cliente.getNombreCliente(), cliente.getPrimerApellido(), cliente.getSegundoApellido()) 
                        && validaciones.validarFecha(cliente.getFechaPago())){
                    conexion.agregarCliente(cliente);
                    JOptionPane.showMessageDialog(frmAdminCliente, "Cliente agregado correctamente.");
                    frmAdminCliente.getPnlAdminCliente1().limpiar();
//                    Object[] tmp = {frmAdminCliente.getFrmMenu().getNombreUsuario()+" ha agregado el cliente "+cliente.getNombreCliente()+" el "+validaciones.generarFechaActual()};
//                    frmAdminCliente.getFrmMenu().getFrmHistorial().getModelo().addRow(tmp);
                    conexion.agregarAHistorial(frmAdminCliente.getFrmMenu().getNombreUsuario()+" ha agregado el cliente "+cliente.getNombreCliente()+" el "+validaciones.generarFechaActual());
                } else {
                    JOptionPane.showMessageDialog(frmAdminCliente, "Error en los campos de nombre y fecha.");
                }
            } else {
                JOptionPane.showMessageDialog(frmAdminCliente, "Ingrese los datos correctamente.");
            }
        }
        if(ae.getActionCommand().equalsIgnoreCase("Modificar")){
            Cliente cliente = clienteVacio();
            if(cliente != null){
                    if(validaciones.validarFecha(cliente.getFechaPago())){
                        if(JOptionPane.showConfirmDialog(frmAdminCliente, "¿Está seguro de modificar este cliente?") == 0){
                            conexion.modificarCliente(cliente);
                            JOptionPane.showMessageDialog(frmAdminCliente, "Cliente modificado correctamente.");
//                            Object[] tmp = {frmAdminCliente.getFrmMenu().getNombreUsuario()+" ha modificado el cliente "+cliente.getNombreCliente()+" el "+validaciones.generarFechaActual()};
//                            frmAdminCliente.getFrmMenu().getFrmHistorial().getModelo().addRow(tmp);
                            conexion.agregarAHistorial(frmAdminCliente.getFrmMenu().getNombreUsuario()+" ha modificado el cliente "+cliente.getNombreCliente()+" el "+validaciones.generarFechaActual());
                        }
                    } else {
                        JOptionPane.showMessageDialog(frmAdminCliente, "Error en los campos de nombre y fecha.");
                    }
            } else {
                JOptionPane.showMessageDialog(frmAdminCliente, "Ingrese los datos correctamente.");
            }
        }
//        if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
//            String nombre = frmAdminCliente.getPnlAdminCliente1().getTxtNombre();
//            String primerApellido = frmAdminCliente.getPnlAdminCliente1().getTxtPrimApellido();
//            if(!nombre.equalsIgnoreCase("") && !primerApellido.equalsIgnoreCase("")){
//                Cliente cliente = conexion.buscarCliente(nombre, primerApellido);
//                if (cliente != null){
//                    frmAdminCliente.getPnlAdminCliente1().mostrarInfoCliente(cliente);
//                    frmAdminCliente.getPnlAdminCliente1().getBtnModificar().setEnabled(true);
//                    frmAdminCliente.getPnlAdminCliente1().getBtnEliminar().setEnabled(true);
//                } else {
//                    JOptionPane.showMessageDialog(frmAdminCliente, "El cliente no existe.");
//                }
//            } else {
//                JOptionPane.showMessageDialog(frmAdminCliente, "Ingrese los datos correctamente.");
//            }
//        }
        if(ae.getActionCommand().equalsIgnoreCase("Eliminar")){
            if(JOptionPane.showConfirmDialog(frmAdminCliente, "¿Está seguro de eliminar este cliente?") == 0){
                String nombre = frmAdminCliente.getPnlAdminCliente1().getTxtNombre();
                String primerApellido = frmAdminCliente.getPnlAdminCliente1().getTxtPrimApellido();
                if(!nombre.equalsIgnoreCase("") && !primerApellido.equalsIgnoreCase("")){
                    Cliente cliente = conexion.buscarCliente(nombre, primerApellido);
                    conexion.eliminarCliente(cliente);
                    JOptionPane.showMessageDialog(frmAdminCliente, "Cliente eliminado correctamente.");
                    
                }
                
            } else {
                JOptionPane.showMessageDialog(frmAdminCliente, "No se realizaron modificaciones.");
            }
        }
    }
    
}
