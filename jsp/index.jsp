<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo list</title>
    </head>
    <body>
        <h1>Todo list!</h1>
        <h4><a href="newtodo.jsp">New Todo</a></h4>
    <table>
<%
String id = request.getParameter("id");
String connectionUrl = "jdbc:derby://localhost:1527/";
String database = "q2todo";
String userid = "exam";
String password = "0000";
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
    try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement = connection.createStatement();
String sql ="select * from todo";
resultSet = statement.executeQuery(sql);
while(resultSet.next())
{
%>
<tr>
<td><%=resultSet.getInt("id") %></td>
<td><%=resultSet.getString("title") %></td>
<td><%=resultSet.getString("status") %></td>
<td><%=resultSet.getString("date") %></td>
<td><a href="edit.jsp?id=<%=resultSet.getString("id")%>">edit</a></td>
<td><a href="deletetodo.jsp?id=<%=resultSet.getString("id")%>">delete</a></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
    </table>
    </body>
</html>
