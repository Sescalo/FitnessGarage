/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Sergio
 */
public class Validaciones {
    
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
        }
        
        return dia+"/"+mes+"/"+ano;
    }
    
}
