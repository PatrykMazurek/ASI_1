package up.DB;

import com.mysql.cj.MysqlType;

import java.sql.*;

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

    public void insertPersonProc(String name, String lastName, int age) throws SQLException {
        CallableStatement callstm = conn.prepareCall(
                "{ call InsertPerson(?,?,?) }");
        callstm.setString(1, name);
        callstm.setString(2, lastName);
        callstm.setInt(3, age);

        int result = callstm.executeUpdate();
        System.out.println("Dodano rekordy " + result);
    }

    public void getCountPersonProc() throws SQLException {
        CallableStatement callstm = conn.prepareCall(
                " { call GetCountPerson(?) }");
        callstm.registerOutParameter(1, MysqlType.INT);
        callstm.executeUpdate();
        int count = callstm.getInt(1);
        System.out.println("Liczba rekordów " + count);

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

    public void getAllPersonProc() throws SQLException {
        CallableStatement callstm = conn.prepareCall(
                "{ call GetAllPersons()}",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        ResultSet result = callstm.executeQuery();
        result.last();
        while( result.previous()){
            System.out.println(String.format("%d %s %s %d",
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4) ));
        }
        result.close();
    }
}
