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
    
    // Metodo que captura todos los clientes de la base de datos
    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM cliente WHERE eliminado = 0;");

            while(resultado.next()){
                listaClientes.add(new Cliente(resultado.getInt("idCliente"), resultado.getInt("diasVencimiento"), 
                        resultado.getString("nombreCliente"), resultado.getString("primerApellido"),
                        resultado.getString("segundoApellido"), resultado.getString("cedula"), 
                        resultado.getString("telefono"), resultado.getString("direccion"), resultado.getString("email"), 
                        resultado.getString("fechaIngreso"), resultado.getString("fechaPago"), resultado.getString("fechaSigPago"),
                        resultado.getString("morosidades"), resultado.getString("comentarios"), resultado.getBoolean("tratoEspecial"),
                        resultado.getBoolean("eliminado")));
            }
        }

        catch(Exception e){
            System.err.println("Error al extraer clientes: "+e);
        }
        System.out.println("Clientes extraidos de la BD");
        return listaClientes;
    }
    
        public boolean existeCliente(Cliente cliente){
        boolean existe = false;
        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM cliente where nombreUsuario = '"+cliente.getNombreCliente()+"' and"
                    + " contrasena = '"+cliente.getPrimerApellido()+"' and eliminado = '0';");
            
            existe = resultado.next();   
        }
        catch(Exception e){
            System.err.println("Error de consulta(existeCliente): "+e);
        }
        System.out.println("El cliente existe:"+ existe);
        return existe;
    }
        
    public void agregarCliente(Cliente cliente){
        try{
            prepStmt = conn.prepareStatement("insert into cliente (diasVencimiento, nombreCliente, primerApellido, segundoApellido,"
                    + "cedula, telefono, direccion, email, fechaIngreso, fechaPago, fechaSigPago, morosidades, comentarios, tratoEspecial, eliminado) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            prepStmt.setInt(1, cliente.getDiasVencimiento());
            prepStmt.setString(2, cliente.getNombreCliente());
            prepStmt.setString(3, cliente.getPrimerApellido());
            prepStmt.setString(4, cliente.getSegundoApellido());
            prepStmt.setString(5, cliente.getCedula()); 
            prepStmt.setString(6, cliente.getTelefono());
            prepStmt.setString(7, cliente.getDireccion());
            prepStmt.setString(8, cliente.getEmail());
            prepStmt.setString(9, cliente.getFechaIngreso());
            prepStmt.setString(10, cliente.getFechaPago());
            prepStmt.setString(11, cliente.getFechaSigPago());
            prepStmt.setString(12, cliente.getMorosidades());
            prepStmt.setString(13, cliente.getComentarios());
            prepStmt.setBoolean(14, cliente.isTratoEspecial());
            prepStmt.setBoolean(15, cliente.isEliminado());
            
            int res = prepStmt.executeUpdate();
            if(res>0){
                System.out.println("Cliente guardado");
            }
            else{
                System.out.println("Error al guardar cliente");
            }
//            conn.close();
        }

        catch(Exception e){
            System.out.println("Error al agregar Cliente");
        }
    }
    
    public void modificarCliente(Cliente cliente){
        int tmpTrato;
        if(cliente.isTratoEspecial()){
            tmpTrato = 1;
        }else{
            tmpTrato =0;
        }
        try{
                prepStmt = conn.prepareStatement("update cliente set diasVencimiento = ?, nombreCliente = ?, "
                        + "primerApellido = ?, segundoApellido = ?, cedula = ?, telefono = ?, direccion = ?, email = ?,"
                        + "fechaIngreso = ?, fechaPago = ?, fechaSigPago = ?, morosidades = ?, comentarios = ?, tratoEspecial = '"+tmpTrato+"'"
                        + "where idCliente = ? and eliminado = '0';");
                
                prepStmt.setInt(1, cliente.getDiasVencimiento());
                prepStmt.setString(2, cliente.getNombreCliente());
                prepStmt.setString(3, cliente.getPrimerApellido());
                prepStmt.setString(4, cliente.getSegundoApellido());
                prepStmt.setString(5, cliente.getCedula());
                prepStmt.setString(6, cliente.getTelefono());
                prepStmt.setString(7, cliente.getDireccion());
                prepStmt.setString(8, cliente.getEmail());
                prepStmt.setString(9, cliente.getFechaIngreso());
                prepStmt.setString(10, cliente.getFechaPago());
                prepStmt.setString(11, cliente.getFechaSigPago());
                prepStmt.setString(12, cliente.getMorosidades());
                prepStmt.setString(13, cliente.getComentarios());
//                prepStmt.setInt(14, tmpTrato);
                prepStmt.setInt(14, cliente.getIdCliente());
                int res = prepStmt.executeUpdate();
                    if(res>0){
                        System.out.println("Cliente Actualizado");
                    }
                    else{
                        System.out.println("Error al actualizar el cliente");
                    }
//                  conn.close();
            }
        
            catch(Exception e){
            }
    }
    
    public void eliminarCliente(Cliente cliente){
        try{
                prepStmt = conn.prepareStatement("update cliente set eliminado = ? where idCliente = ? and eliminado ='0';");
                
                prepStmt.setBoolean(1, true);
                prepStmt.setInt(2, cliente.getIdCliente());
                
                int res = prepStmt.executeUpdate();
                    if(res>0){
                        System.out.println("Cliente Eliminado");
                    }
                    else{
                        System.out.println("Error al eliminar el cliente");
                    }
//                  conn.close();
            }
            catch(Exception e){
            }
    }
        
    public Cliente buscarCliente(String nombre, String primerApellido){
        Cliente cliente = null;
        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM cliente where nombreCliente = '"+nombre+"' and"
                    + " primerApellido = '"+primerApellido+"' and eliminado='0';");
            
            if(resultado.next()){
                cliente = new Cliente(resultado.getInt("idCliente"), resultado.getInt("diasVencimiento"), resultado.getString("nombreCliente"),
                resultado.getString("primerApellido"), resultado.getString("segundoApellido"), resultado.getString("cedula"),
                resultado.getString("telefono"), resultado.getString("direccion"), resultado.getString("email"), resultado.getString("fechaIngreso"),
                resultado.getString("fechaPago"), resultado.getString("fechaSigPago"), resultado.getString("morosidades"),
                resultado.getString("comentarios"), resultado.getBoolean("tratoEspecial"), resultado.getBoolean("eliminado"));
            }   
        }
        catch(Exception e){
            System.err.println("Error de consulta(buscarCliente): "+e);
        }
        return cliente;
    }
    
    public boolean existeUsuario(Usuario usuario){
        boolean existe = false;
        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM usuario where nombreUsuario = '"+usuario.getNombreUsuario()+"' and"
                    + " contrasena = '"+usuario.getContrasena()+"' and eliminado = '0';");
            
            existe = resultado.next();   
        }
        catch(Exception e){
            System.err.println("Error de consulta(existeUsuario): "+e);
        }
        System.out.println("El usuario existe:"+ existe);
        return existe;
    }
    
    public void agregarUsuario(Usuario usuario){
        try{
            prepStmt = conn.prepareStatement("insert into Usuario (nombreUsuario, contrasena, nombre, primerApellido, segundoApellido, eliminado) VALUES (?,?,?,?,?,?);");

            prepStmt.setString(1, usuario.getNombreUsuario());
            prepStmt.setString(2, usuario.getContrasena());
            prepStmt.setString(3, usuario.getNombre());
            prepStmt.setString(4, usuario.getPrimerApellido());
            prepStmt.setString(5, usuario.getSegundoApellido()); //Modificar contrasena con MD5
            prepStmt.setBoolean(6, usuario.isEliminado());
            
            int res = prepStmt.executeUpdate();
            if(res>0){
                System.out.println("Usuario guardado");
            }
            else{
                System.out.println("Error al guardar usuario");
            }
//            conn.close();
        }

        catch(Exception e){
            System.out.println("Error al agregar Usuario");
        }
    }
    
    // Obtener los usuarios que hay en la base de datos
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM usuario WHERE eliminado = '0';");

            while(resultado.next()){
                listaUsuarios.add( new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombreUsuario"), resultado.getString("contrasena"),
                        resultado.getString("nombre"), resultado.getString("primerApellido"), resultado.getString("segundoApellido"),
                        resultado.getBoolean("eliminado")));
            }
        }
        catch(Exception e){

        }
        System.out.println("Usuarios extraidos de la BD");
        return listaUsuarios;
    }
    
    public void modificarUsuario(Usuario usuario){
        try{
                prepStmt = conn.prepareStatement("update usuario set nombreUsuario = ?, nombre = ?, primerApellido = ?, "
                        + "segundoApellido = ? where idUsuario = ? and eliminado = '0';");
                
                prepStmt.setString(1, usuario.getNombreUsuario());
                prepStmt.setString(2, usuario.getNombre());
                prepStmt.setString(3, usuario.getPrimerApellido());
                prepStmt.setString(4, usuario.getSegundoApellido());
                prepStmt.setInt(5, usuario.getIdUsuario());
                int res = prepStmt.executeUpdate();
                    if(res>0){
                        System.out.println("Usuario Actualizado");
                    }
                    else{
                        System.out.println("Error al actualizar el usuario");
                    }
//                  conn.close();
            }
        
            catch(Exception e){
            }
    }
    
    public void eliminarUsuario(int idUsuario){
        try{
                prepStmt = conn.prepareStatement("update usuario set eliminado = ? where idUsuario = ? and eliminado ='0';");
                
                prepStmt.setBoolean(1, true);
                prepStmt.setInt(2, idUsuario);
                
                int res = prepStmt.executeUpdate();
                    if(res>0){
                        System.out.println("Usuario Eliminado");
                    }
                    else{
                        System.out.println("Error al eliminar el usuario");
                    }
//                  conn.close();
            }
            catch(Exception e){
            }
    }
    
    public Usuario buscarUsuario(String nombre, String primerApellido){
        Usuario usuario = null;
        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM usuario where nombre = '"+nombre+"' and"
                    + " primerApellido = '"+primerApellido+"' and eliminado='0';");
            
            if(resultado.next()){
                usuario = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombreUsuario"),
                resultado.getString("contrasena"), resultado.getString("nombre"), resultado.getString("primerApellido"),
                resultado.getString("segundoApellido"), resultado.getBoolean("eliminado"));
            }   
        }
        catch(Exception e){
            System.err.println("Error de consulta(buscarUsuario): "+e);
        }
        return usuario;
    }
    
    // Metodo que captura todos los clientes de la base de datos
    public ArrayList<Cliente> getClientesBusqueda(String nombreCliente){
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try{
            stmt = conn.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM cliente WHERE nombreCliente LIKE \"%" + nombreCliente + "%\" ;");

            while(resultado.next()){
                listaClientes.add(new Cliente(resultado.getInt("idCliente"), resultado.getInt("diasVencimiento"), 
                        resultado.getString("nombreCliente"), resultado.getString("primerApellido"),
                        resultado.getString("segundoApellido"), resultado.getString("cedula"), 
                        resultado.getString("telefono"), resultado.getString("direccion"), resultado.getString("email"), 
                        resultado.getString("fechaIngreso"), resultado.getString("fechaPago"), resultado.getString("fechaSigPago"),
                        resultado.getString("morosidades"), resultado.getString("comentarios"), resultado.getBoolean("tratoEspecial"),
                        resultado.getBoolean("eliminado")));
            }
        }

        catch(Exception e){
            System.err.println("Error al extraer clientes: "+e);
        }
        System.out.println("Clientes extraidos de la BD");
        return listaClientes;
    }
    
}
