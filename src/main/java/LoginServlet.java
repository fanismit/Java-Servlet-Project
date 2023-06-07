import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource dataSource = null;

    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/LiveDataSource");
        } catch (NamingException e) {
            throw new ServletException("Error initializing database connection", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (validateCredentials(username, password)) {
        	HttpSession session = request.getSession();
            List<String> userDetails = getUserDetails(username);
            session.setAttribute("userDetails", userDetails);
            String userRole = userDetails.get(2);

            if (userRole != null) {
                if (userRole.equals("Customer")) {
                    response.sendRedirect("customer_home.jsp");
                } else if (userRole.equals("ContentAdmin")) {
                    request.getRequestDispatcher("/ContentAdmin/content_admin_home.jsp").forward(request, response);

                } else if (userRole.equals("Admin")) {
                    response.sendRedirect("admin_home.jsp");
                }
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            // Failed login
            response.sendRedirect("error.jsp"); // Redirect back to the login page
        }
    }

    private boolean validateCredentials(String username, String password) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            boolean flag = resultSet.next();

            resultSet.close();
            statement.close();

            return flag;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<String> getUserDetails(String username) {
        List<String> userDetails = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT email, role, password FROM user WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userEmail = resultSet.getString("email");
                String userRole = resultSet.getString("role");
                String userPassword = resultSet.getString("password");
                
                userDetails.add(username);
                userDetails.add(userEmail);
                userDetails.add(userRole);
                userDetails.add(userPassword);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userDetails;
    }
}
