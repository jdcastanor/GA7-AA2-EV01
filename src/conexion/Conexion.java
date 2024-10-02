
package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/adso";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            
            //Consuta de datos
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {   
                System.out.println(rs.getString("nombre"));                
            }
            
            //Inserción de datos
            statement.execute("INSERT INTO `clientes`(`edad`, `nombre`) VALUES ('24','CARLOS')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {   
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));                
            }
            
            //Actualización de datos
            statement.execute("UPDATE `clientes` SET `nombre` = 'Jimena' WHERE `clientes`.`idclientes` = 9;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {   
                System.out.println(rs.getInt("idclientes")+" "+rs.getString("nombre")+" "+rs.getInt("edad"));                
            }
            
            //Eliminación de datos
            statement.execute("DELETE FROM `clientes` WHERE `clientes`.`idclientes` = 11 ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {   
                System.out.println(rs.getInt("idclientes")+" "+rs.getString("nombre")+" "+rs.getInt("edad"));                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
