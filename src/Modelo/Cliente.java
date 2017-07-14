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
public class Cliente {
    
    private int idCliente;
    private int diasVencimiento;
    private String nombreCliente;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;  // Tipo String debido al formato de la cedula (guiones-extranjeras)
    private String telefono;
    private String direccion;
    private String email;
    private String fechaIngreso; //La fecha tiene el siguiente formato: DD/MM/AA
    private String fechaPago;
    private String fechaSigPago;
    private String morosidades;
    private String comentarios;
    private boolean tratoEspecial;
    private boolean eliminado;

    public Cliente(int idCliente, int diasVencimiento, String nombreCliente, String primerApellido, String segundoApellido, String cedula, String telefono, String direccion, String email, String fechaIngreso, String fechaPago, String fechaSigPago, String morosidades, String comentarios, boolean tratoEspecial, boolean eliminado) {
        this.idCliente = idCliente;
        this.diasVencimiento = diasVencimiento;
        this.nombreCliente = nombreCliente;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.fechaPago = fechaPago;
        this.fechaSigPago = fechaSigPago;
        this.morosidades = morosidades;
        this.comentarios = comentarios;
        this.tratoEspecial = tratoEspecial;
        this.eliminado = eliminado;
    }
    
    public Cliente(){
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDiasVencimiento() {
        return diasVencimiento;
    }

    public void setDiasVencimiento(int diasVencimiento) {
        this.diasVencimiento = diasVencimiento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFechaSigPago() {
        return fechaSigPago;
    }

    public void setFechaSigPago(String fechaSigPago) {
        this.fechaSigPago = fechaSigPago;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getMorosidades() {
        return morosidades;
    }

    public void setMorosidades(String morosidades) {
        this.morosidades = morosidades;
    }

    public boolean isTratoEspecial() {
        return tratoEspecial;
    }

    public void setTratoEspecial(boolean tratoEspecial) {
        this.tratoEspecial = tratoEspecial;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", diasVencimiento=" + diasVencimiento + ", nombreCliente=" + nombreCliente + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", cedula=" + cedula + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", fechaIngreso=" + fechaIngreso + ", fechaPago=" + fechaPago + ", fechaSigPago=" + fechaSigPago + ", comentarios=" + comentarios + '}';
    }
    
    
}
