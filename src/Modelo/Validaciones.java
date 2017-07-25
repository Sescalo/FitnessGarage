/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sergio
 */
public class Validaciones {
    
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]+$";
    private static final String NAMES_PATTERN = "^[a-zA-ZÀ-ÿ]{1,}(?: [a-zA-ZÀ-ÿ]+){0,}$";
    private static final String NUMBERS_PATTERN = "^(0|[1-9][0-9]*)$";
    private static final String EMAIL_PATTERN = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)";
    private static final String DATE_PATTERN = "^\\d{2}\\/\\d{2}\\/\\d{4}$";
    
    public String generarFechaActual(){
        Date fecha = new Date();
        String fechaString = fecha.toString();
        String mes = fechaString.substring(4, 7);
        String dia = fechaString.substring(8, 10);
        String ano = fechaString.substring(fechaString.length()-4, fechaString.length());
        switch(mes){
            case "Jan":
                mes = "01";
                break;
            case "Feb":
                mes = "02";
                break;
            case "Mar":
                mes = "03";
                break;
            case "Apr":
                mes = "04";
                break;
            case "May":
                mes = "05";
                break;
            case "Jun":
                mes = "06";
                break;
            case "Jul":
                mes = "07";
                break;
            case "Aug":
                mes = "08";
                break;
            case "Sep":
                mes = "09";
                break;
            case "Oct":
                mes = "10";
                break;
            case "Nov":
                mes = "11";
                break;
            case "Dec":
                mes = "12";
                break;
            default:
                break;
        }
        return dia+"/"+mes+"/"+ano;
    }
    
    public boolean calcularDiaAntes(String fechaPago){
        
        String fechaActual = generarFechaActual();
        int dia = Integer.valueOf(fechaActual.substring(0, 2));
        int mes = Integer.valueOf(fechaActual.substring(3, 5));
        int ano = Integer.valueOf(fechaActual.substring(6, 10));
        
        //String fechaPago = cliente.getFechaPago();
        int diaPago = Integer.valueOf(fechaPago.substring(0, 2));
        int mesPago = Integer.valueOf(fechaPago.substring(3, 5));
        int anoPago = Integer.valueOf(fechaPago.substring(6, 10));
        int diaAntPago;
        if(diaPago == 1 && (mesPago == 1 || mesPago == 3 || mesPago == 5 || mesPago == 7 || mesPago == 8 || mesPago == 10 || mesPago == 12)){
            diaAntPago = 31;
        } 
        else if(diaPago == 1 && (mesPago == 4 || mesPago == 6 || mesPago == 7 || mesPago == 9 || mesPago == 11)){
            diaAntPago = 30;
        }
        else if(diaPago == 1  && mesPago == 2){
            boolean isLeapYear = ((anoPago % 4 == 0) && (anoPago % 100 != 0) || (anoPago % 400 == 0));
            if (isLeapYear){
                diaAntPago = 30;
            } else {
                diaAntPago = 29;
            }
        }
        else {
            diaAntPago = diaPago-1;
        }
//        return dia>=diaAntPago || (mesPago-mes<=0 || anoPago-ano<=0);
//dia>=diaAntPago || (mes>mesPago || ano>anoPago)
//        System.out.println((mes>mesPago || ano>anoPago)==false);
//        System.out.println(dia>diaAntPago);
//        System.out.println("-------------------------------------");
        if(anoPago < ano){
            return true;
        }
        else if(mesPago-mes==0 && anoPago-ano==0){
            return dia >= diaAntPago;
        } 
        else if (mesPago-mes<0 && anoPago-ano<0) {
            return true;
        } 
        else if(mesPago-mes>0 && anoPago-ano>=0){
            return false;
        }
        else {
            return false;
        }
    }
    
    public boolean validarDatosUsuario(Usuario usuario){
        return true;
    }
    
    public boolean validarNombreUsuario(String nombreUsuario){
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(nombreUsuario);
        return matcher.matches();
    }
    
    public boolean validarNombres(String nombre, String primerApellido, String segundoApellido){
        pattern = Pattern.compile(NAMES_PATTERN);
        return pattern.matcher(nombre).matches() && pattern.matcher(primerApellido).matches() && pattern.matcher(segundoApellido).matches();
    }
    
    public boolean validarNumeros(String expresion){
        pattern = Pattern.compile(NUMBERS_PATTERN);
        matcher = pattern.matcher(expresion);
        return matcher.matches();
    }
    
    public boolean validarEmail(String email){
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public boolean validarFecha(String fecha){
        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(fecha);
        return matcher.matches();
    }
    
}
