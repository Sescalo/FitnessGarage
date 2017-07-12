/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sergio
 */
public class prueba {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        AdminBaseDatos coneccion = new AdminBaseDatos();
        Validaciones validaciones = new Validaciones();
        System.out.println(validaciones.generarFechaActual());
    }
}
