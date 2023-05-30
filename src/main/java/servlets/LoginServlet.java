package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DB_URL = "";
    private final String DB_USER = "";
    private final String DB_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (validateCredentials(username, password)) {
            // Successful login
        	// Find user role and redirect to the respective home page
        	String userRole = getUserRole(username);
        	
        	if(userRole!=null) {
        		if(userRole.equals("Customer")) {
        			response.sendRedirect("customer_home.jsp");
        		}else if(userRole.equals("ContentAdmin")) {
        			response.sendRedirect("content_admin_home.jsp");
        		}else if(userRole.equals("Admin")) {
        			response.sendRedirect("admin_home.jsp");
        		}
        	}else {
        		response.sendRedirect("index.html");
        	}
        } else {
            // Failed login
            response.sendRedirect("index.html"); // Redirect back to the login page
        }
    }

    private boolean validateCredentials(String username, String password){
        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery(query);
            boolean flag = resultSet.next();
            
            resultSet.close();
            statement.close();
            connection.close();
            
            return flag;
        }catch(SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    }

    private String getUserRole(String username){
        try{
        	Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT role FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	String userRole = resultSet.getString("role");
            	
            	resultSet.close();
                statement.close();
                connection.close();
            	
                return userRole;
            }else {
            	resultSet.close();
                statement.close();
                connection.close();
                
                return null;
            }
        }catch(SQLException e){
        	e.printStackTrace();
        	return null;
        }
    }

}
