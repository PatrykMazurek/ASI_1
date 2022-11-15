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

    public void connectToMySql() throws SQLException {
        System.setProperty("jdbcDriver", "com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://locoalhost:port",
                "student",
                "password");
        System.out.println("Nawiązanno połączenie");
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
