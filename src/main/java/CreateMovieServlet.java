

import jakarta.servlet.ServletException;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import mainpackage.ContentAdmins;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import mainpackage.Films;

/**
 * Servlet implementation class CreateMovieServlet
 */
@WebServlet("/ContentAdmin/create-movie")
public class CreateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource = null;
	private ContentAdmins contentAdmins;
	private final String SUCCESS_MSG_TITLE = "Saved Successfully!";
	private final String SUCCESS_MSG_BODY = "A new Movie was added to the database!";
	
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form inputs
		String movieTitle = request.getParameter("movieTitle");
		String movieCategory = request.getParameter("movieCategory");
		String movieDirector = request.getParameter("movieDirector"); 
		String movieLenght = request.getParameter("movieLength");
		String movieDescription = request.getParameter("movieDescription");
		String movieImageURL = request.getParameter("imageUrl");
		String movieId = request.getParameter("movieId");
		int movieIdNumber = Integer.parseInt(movieId);
		
		Films film = new Films(movieIdNumber);
		
		if(!film.isFilmIdUnique(movieId)) {

		}else {
			HttpSession session = request.getSession();
			List<String> userDetails = (List<String>) session.getAttribute("userDetails");
			contentAdmins = new ContentAdmins();
			int adminId = contentAdmins.retrieveAdminIdFromDatabase(userDetails.get(0));
			saveMovie(movieTitle, movieCategory, movieImageURL , movieDirector, movieDescription, movieIdNumber, movieLenght, adminId );
			
			// Show success message
			request.setAttribute("message_title", SUCCESS_MSG_TITLE);
			request.setAttribute("message_body", SUCCESS_MSG_BODY);
			request.getRequestDispatcher("../success.jsp").forward(request, response);
		}
	}
	
	// Save movies details to database
	private void saveMovie(String movieTitle, String movieCategory, String movieImageURL, String movieDirector, String movieDescription, int movieId, String movieLenght, int adminId) {
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
			statement.setInt(8, adminId);
			statement.executeUpdate();
			
            statement.close();
            connection.close();
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
}
