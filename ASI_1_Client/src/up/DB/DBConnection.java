package up.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    public Connection conn;

    public DBConnection(){
        conn = null;
    }

    public Connection connectToSQLite(){
        String url = "jdbc:sqlite:baza.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Nawiązano połączenie");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection connectToMySql() throws SQLException {
//        System.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "usbw");
        System.out.println("Nawiązanno połączenie");
        return conn;
    }

    public void createTable() throws SQLException {
        PreparedStatement prepe = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Person" +
                "(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "LastName TEXT," +
                "Age INTEGER );");
        prepe.execute();
    }

    public void disconnect() throws SQLException {
        if(!conn.isClosed()){
            System.out.println("kończe połączenie");
            conn.close();
        }
    }
}
