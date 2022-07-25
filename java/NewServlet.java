
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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

            if(title.isEmpty() || date.isEmpty())
            {
                request.getRequestDispatcher("newtodo.jsp").forward(request, response);
            }
            else
            {
            connection = DriverManager.getConnection(connectionUrl+database, userid, password);
            statement = connection.createStatement();

            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("insert into todo (title, status, description, date) values (?, ?, ?, ?)");
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, status);
            pstmt.setString(4, date);
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
        Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
