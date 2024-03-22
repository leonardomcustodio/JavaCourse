package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String url = "jdbc:mysql://localhost:3306/coursejdbc";
    private static final String user = "developer";
    private static final String password = "123456";

    private static Connection conn = null;

    public static Connection getConnection(){

        if(conn == null){
            try{
                conn = DriverManager.getConnection(url, user, password);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }                
        }
        return conn;

    }

    public static void closeConnection(){

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

    }

}
