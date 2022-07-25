
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <h1>Deleted!</h1>

<%
String id = request.getParameter("id");
String connectionUrl = "jdbc:derby://localhost:1527/";
String database = "q2todo";
String userid = "exam";
String password = "0000";
Connection connection = null;
Statement st = null;
ResultSet rs = null;
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
st = connection.createStatement();
st.executeUpdate("delete from todo where id="+id+"");

%>
    </body>
</html>