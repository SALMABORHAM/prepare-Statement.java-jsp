
import java.sql.*;

public class Main {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        new database().newTable();
        new database().newData();
        
    }
}