



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

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CreateMovieServlet
 */
@WebServlet("/ContentAdmin/create-movie")
public class CreateMovieServlet extends HttpServlet {
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
    
	 public CreateMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("YES-1!");
		String movieTitle = request.getParameter("movieTitle");
		String movieCategory = request.getParameter("movieCategory");
		String movieDirector = request.getParameter("movieDirector"); 
		String movieLenght = request.getParameter("movieLength");
		String movieDescription = request.getParameter("movieDescription");
		String movieImageURL = request.getParameter("imageUrl");
		String movieId = request.getParameter("movieId");
		int movieIdNumber = Integer.parseInt(movieId);
		int admin= 1;

		if(!isMovieIdUnique(movieId)) {
            JOptionPane.showMessageDialog(null, "ID is not unique. Please enter a different ID.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
		}else {
			saveMovie(movieTitle, movieCategory, movieImageURL , movieDirector, movieDescription, movieIdNumber, movieLenght, admin );
			response.sendRedirect("../error.jsp");
		}
	}
	
	private boolean isMovieIdUnique(String movieId) {
		boolean flag = false;
		 try (Connection connection = dataSource.getConnection()) {
			String query = "SELECT COUNT(*) FROM movies WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, movieId);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count == 0) {
					flag = true;
				}
			}
			System.out.println("YES-3!");
			resultSet.close();
            statement.close();
            connection.close();
            
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private void saveMovie(String movieTitle, String movieCategory, String movieImageURL, String movieDirector, String movieDescription, int movieId, String movieLenght, int admin) {
		 try (Connection connection = dataSource.getConnection()) {
			String query = "INSERT INTO movies (ID, NAME, CONTENT, LENGTH, TYPE, IMAGEURL , DIRECTOR, CONTENT_ADMIN_ID ) VALUES (?, ?, ? , ?, ? , ? , ? , ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, movieId);
			statement.setString(2, movieTitle);
			statement.setString(3, movieDescription);
			statement.setString(4, movieLenght);
			statement.setString(5, movieCategory);
			statement.setString(6, movieImageURL);
			statement.setString(7, movieDirector);
			statement.setInt(8, admin);
			System.out.println("YES-2!");
			statement.executeUpdate();
			
            statement.close();
            connection.close();
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
}
