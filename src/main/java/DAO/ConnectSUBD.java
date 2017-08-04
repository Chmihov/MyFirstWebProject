package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectSUBD {

    public final static String DB_DRIVER = "com.mysql.jdbc.Driver";
    public final static String DB_CONNECTION = "jdbc:mysql://localhost:3306/address";
    public final static String DB_USER = "root";
    public final static String DB_PASSWORD = "password";


    protected static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;

    }
}