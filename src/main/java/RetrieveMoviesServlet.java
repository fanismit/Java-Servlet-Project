



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Movies;

/**
 * Servlet implementation class MoviesServlet
 */
@WebServlet("/RetrieveMovieServlet")
public class RetrieveMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveMoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Movies> movies = new ArrayList<>();
	
		String db_url = "";
	    String db_user = "";
	    String db_password = "";
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
            String query = "SELECT * FROM movies";
			Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				Movies movie = new Movies();
				movie.setMovieId(resultSet.getInt("id"));
				movie.setMovieTitle(resultSet.getString("title"));
				movie.setMovieCategory(resultSet.getString("category"));
				movie.setMovieDescription(resultSet.getString("description"));
				
				movies.add(movie);
			}
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.setAttribute("movies", movies);
	    request.getRequestDispatcher("CreateProvoli.jsp").forward(request, response);
	}
}
