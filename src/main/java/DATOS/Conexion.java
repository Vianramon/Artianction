
package DATOS;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author vramirez
 */
public class Conexion {

    
    
    public Connection conectar () {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost/Artinaction?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";
           
            
            Connection conexion = (Connection) DriverManager.getConnection(url, user, password);
            
            return conexion;
              
    } catch(ClassNotFoundException e){
        System.err.println("Error -> "+e.getMessage());
        
        }catch (SQLException e){
            System.err.println("Error -> "+ e.getMessage ());
        }
        return null;
    }
    
    public static void  main (String [] args) throws SQLException {
        Conexion conexion = new Conexion ();
        
        Connection cnx = conexion.conectar ();
        
        
            
         
        }
        
}
 