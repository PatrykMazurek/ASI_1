package up.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation{

    private Connection conn;

    public DBOperation(Connection c){
        conn = c;
    }

    public void insertPerson(String name, String lastName, int age) throws SQLException {
        PreparedStatement preper = conn.prepareStatement(
                "INSERT INTO Person (Name, LastName, Age) VALUES (?,?,?)"
        );
        preper.setString(1, name);
        preper.setString(2, lastName);
        preper.setInt(3, age);
        int record = preper.executeUpdate();
        System.out.println(String.format("wstawiono %d rekordów", record ) );
    }

    public void getAllPerson() throws SQLException {
        PreparedStatement preper = conn.prepareStatement(
                "SELECT * FROM Person",
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_UPDATABLE
        );
        ResultSet result = preper.executeQuery();

        while(result.next()){
            System.out.println(String.format("Rekordy z bazy %d, %s, %s, %d",
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4)));
        }
        result.close();
    }
}
