/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Sergio
 */
public enum AtributosCliente {
    idCliente("ID Cliente"),
    diasVencimiento("Días Vencimiento"),
    nombreCliente("Nombre"),
    primerApellido("Primer Apellido"),
    segundoApellido("Segundo Apellido"),
    cedula("Cédula"),
    telefono("Teléfono"),
    direccion("Dirección"),
    email("Correo"),
    fechaIngreso("Fecha Ingreso"),
    fechaPago("Fecha Pago"),
    fechaSigPago("Fecha Siguiente Pago"),
    morosidades("Morosidades"),
    comentarios("Comentarios");
    
    private final String displayName;
    
    AtributosCliente(String displayName){
        this.displayName = displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
