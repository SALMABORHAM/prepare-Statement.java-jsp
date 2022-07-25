import java.sql.*;
import java.util.logging.*;

public class database {


String connectionUrl = "jdbc:derby://localhost:1527/";
String database = "q2todo";
String userid = "exam";
String password = "0000";
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;


    public void newTable(){
        try {
            connection = DriverManager.getConnection(connectionUrl+database, userid, password);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE todo (id INTEGER primary key generated always as identity, TITLE varchar(200), STATUS varchar(200), DESCRIPTION varchar(200), DATE DATE )");

        } catch (SQLException ex) {
            System.out.println(ex);
         }
         finally{
            try {
                connection.close();
             } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }

    public void newData(){
        try {

connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement = connection.createStatement();

            PreparedStatement pstmt, pstmt2, pstmt3;
            pstmt = connection.prepareStatement("insert into todo (title, status, description, date) values (?, ?, ?, ?)");
            pstmt.setString(1, "1111");
            pstmt.setString(2, "done");
            pstmt.setString(3, "desc1");
            pstmt.setString(4, "2020-09-23");
            pstmt.executeUpdate();
            pstmt2 = connection.prepareStatement("insert into todo (title, status, description, date) values (?, ?, ?, ?)");
            pstmt2.setString(1, "2222");
            pstmt2.setString(2, "progress");
            pstmt2.setString(3, "desc2");
            pstmt2.setString(4, "2021-09-23");
            pstmt2.executeUpdate();
            pstmt3 = connection.prepareStatement("insert into todo (title, status, description, date) values (?, ?, ?, ?)");
            pstmt3.setString(1, "3333");
            pstmt3.setString(2, "done");
            pstmt3.setString(3, "desc3");
            pstmt3.setString(4, "2022-09-23");
            pstmt3.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex);
         }
         finally{
            try {
                connection.close();
             } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     }

}
