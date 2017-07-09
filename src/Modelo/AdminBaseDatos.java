package Modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sergio on 8/4/2017.
 */
public class AdminBaseDatos {

    private static final String DB_URL = "jdbc:mysql://localhost/fitnessgarage";
    
    //  Usuario
    private static final String USER = "Sescalo";
    private static final String PASS = "sergioesteban96";

//    private static final String USER = "oskrg1130";
//    private static final String PASS = "noob3001";

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepStmt;
    private ResultSet resultado;

    //    Constructor
    public AdminBaseDatos() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Base Datos Conectada!");
    }

}
