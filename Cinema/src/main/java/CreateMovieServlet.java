

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
 * Servlet implementation class CreateMovieServlet
 */
@WebServlet("/addMovie")
public class CreateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DB_URL = "";
    private final String DB_USER = "";
    private final String DB_PASSWORD = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieTitle = request.getParameter("movieTitle");
		String movieCategory = request.getParameter("movieCategory");
		String movieDirector = request.getParameter("movieDirector"); 
		String movieDescription = request.getParameter("movieDescription");
		String movieId = request.getParameter("movieId");

		if(!isMovieIdUnique(movieId)) {
			response.sendRedirect("AddMovie.jsp?error=exists");
		}else {
			saveMovie(movieTitle, movieCategory, movieDirector, movieDescription, movieId);
			response.sendRedirect("AddMovie.jsp?success=true");
		}
	}
	
	private boolean isMovieIdUnique(String movieId) {
		boolean flag = false;
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String query = "SELECT COUNT(*) FROM movies WHERE movieId = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, movieId);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count == 0) {
					flag = true;
				}
			}
			
			resultSet.close();
            statement.close();
            connection.close();
            
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private void saveMovie(String movieTitle, String movieCategory, String movieDirector, String movieDescription, String movieId) {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String query = "INSERT INTO movies (movieTitle, movieCategory, movieDirector, movieDescritpion, movieId) VALUES (?, ?, ? , ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, movieTitle);
			statement.setString(2, movieCategory);
			statement.setString(3, movieDirector);
			statement.setString(4, movieDescription);
			statement.setString(5, movieId);
			
			statement.executeUpdate();
			
            statement.close();
            connection.close();
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
}
