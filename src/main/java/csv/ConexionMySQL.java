package csv;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xcheko51x
 */
public class ConexionMySQL {
    String driver = "com.mysql.jdbc.Driver";
    String database = "tiendavirtual";
    String hostname = "localhost:3306";
    String url = "jdbc:mysql://"+hostname+"/"+database+"?useSSL=false";
    String username = "root";
    String password = "Colombia2021";
    
    public Connection conectarMySQL() {
        Connection con = null;
        
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return con;
    }
    
}