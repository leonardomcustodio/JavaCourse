package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conection {

    private static final String url = "jdbc:mysql://localhost:3306/coursejdbc";
    private static final String user = "developer";
    private static final String password = "123456";

    private static Connection conn;

    public static Connection getConnection(){

        try {
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }     

    }
    
}
