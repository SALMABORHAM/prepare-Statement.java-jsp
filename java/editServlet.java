
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/editServlet"})
public class editServlet extends HttpServlet {

String connectionUrl = "jdbc:derby://localhost:1527/";
String database = "q2todo";
String userid = "exam";
String password = "0000";
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        String id = request.getParameter("todoid");
        int nid = Integer.parseInt(id);

            if(title.isEmpty() || date.isEmpty())
            {
                request.getRequestDispatcher("edit.jsp?id="+nid).forward(request, response);
            }
            else
            {

            connection = DriverManager.getConnection(connectionUrl+database, userid, password);
            statement = connection.createStatement();

            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("update todo set title =?, status =?, description =?, date =? where id=?");
            pstmt.setString(1, title);
            pstmt.setString(2, status);
            pstmt.setString(3, description);
            pstmt.setString(4, date);
            pstmt.setInt(5, nid);
            pstmt.executeUpdate();

        
            request.getRequestDispatcher("index.jsp").forward(request, response);
    }
 
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(editServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(editServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
