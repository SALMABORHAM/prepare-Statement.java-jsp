
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit</title>
    </head>
    <body>
        <h1>edit!</h1>
<%
String id = request.getParameter("id");
String connectionUrl = "jdbc:derby://localhost:1527/";
String database = "q2todo";
String userid = "exam";
String password = "0000";
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement = connection.createStatement();
String sql ="select * from todo where id="+id;
resultSet = statement.executeQuery(sql);
resultSet.next();


%>
        <form action="editServlet" method="post">
            Title:<br />
                <input type="text" value="<%=resultSet.getString("title")%>" name="title" /><br />
            Description:<br />
                <input type="text" value="<%=resultSet.getString("description")%>" name="description" /><br />
            Status:<br />
            <select name="status">
                 <option value="done" selected>done</option>
                 <option value="in progress">in progress</option>
            </select><br />
            Target Date:<br />
                <input type="hidden" name="todoid" value="<%=id%>" />
                <input type="text" value="<%=resultSet.getString("date")%>" name="date" /><br />
                <input type="submit" value="update" />
      </form>
    </body>
</html>
