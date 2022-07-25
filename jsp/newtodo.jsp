
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Todo</title>
    </head>
    <body>
        <h1>New Todo!</h1>
        <form action="NewServlet" method="post">
            Title:<br />
                <input type="text" name="title" /><br />
            Description:<br />
                <input type="text" name="description" /><br />
            Status:<br />
            <select name="status">
                 <option value="done">done</option>
                 <option value="in progress">in progress</option>
            </select><br />
            Target Date:<br />
                <input type="text" name="date" /><br />
                <input type="submit" value="Save" />
      </form>
    </body>
</html>
