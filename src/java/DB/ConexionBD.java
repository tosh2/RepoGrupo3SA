package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

////Conexion Remota
//    Connection Conexion = null;
//    String Driver = "com.mysql.jdbc.Driver";
//    String Usuario = "sauser";
//    String Password = "G8b1s43IfV6wYjNn";
//    String IPServer = "40.113.218.24";
//    String DB = "dbsa";
//    String Url_DB = "jdbc:mysql://" + IPServer + "/" + DB;

//Conexion Local
    Connection Conexion = null;
    String Driver = "com.mysql.jdbc.Driver";
    String Usuario = "root";
    String Password = "";
    String IPServer = "127.0.0.1";
    String DB = "dbsa";
    String Url_DB = "jdbc:mysql://" + IPServer + "/" + DB;    
    
    public Connection conectar() {
        Connection Conn = Conectar(Driver, Usuario, Password, Url_DB);
        return Conn;
    }

    public Connection Conectar(String Driver, String Usuario, String Password, String URL_DB) {
        try {
            Class.forName(Driver);
            Conexion = DriverManager.getConnection(URL_DB, Usuario, Password);
            if (Conexion != null) {
                return Conexion;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return null;
    }

    public void desconectar() {
        try {
            Conexion = null;
            Conexion.close();
            System.out.println("Base de datos Desconectada...");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
