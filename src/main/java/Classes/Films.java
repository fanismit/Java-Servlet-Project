package mainpackage;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import jakarta.servlet.ServletException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Films {
    private int filmId;
    private String filmName;
    private String filmContent;
    private String filmLength;
    private String filmType;
    private String filmImageUrl;
    private String filmDirector;
    private int filmContentAdminId;
    private DataSource dataSource = null;

    public Films(int filmId, String filmName, String filmContent, String filmLength, String filmType, String filmImageUrl, String filmDirector, int filmContentAdminId) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmContent = filmContent;
        this.filmLength = filmLength;
        this.filmType = filmType;
        this.filmImageUrl = filmImageUrl;
        this.filmDirector = filmDirector;
        this.filmContentAdminId = filmContentAdminId;
    }

    public Films(int filmId) {
    	try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/LiveDataSource");
        } catch (NamingException e) {
            e.printStackTrace();
        }
	}

	public int getFilmId() {
        return filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmContent() {
        return filmContent;
    }

    public void setFilmContent(String filmContent) {
        this.filmContent = filmContent;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmImageUrl() {
        return filmImageUrl;
    }

    public void setFilmImageUrl(String filmImageUrl) {
        this.filmImageUrl = filmImageUrl;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public int getFilmContentAdminId() {
        return filmContentAdminId;
    }

    public void setFilmContentAdminId(int filmContentAdminId) {
        this.filmContentAdminId = filmContentAdminId;
    }

    public List<Films> viewAllFilms() {
        List<Films> movies = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String content = resultSet.getString("CONTENT");
                String length = resultSet.getString("LENGTH");
                String type = resultSet.getString("TYPE");
                String imageUrl = resultSet.getString("IMAGEURL");
                String director = resultSet.getString("DIRECTOR");
                int contentAdminId = resultSet.getInt("CONTENT_ADMIN_ID");
                Films movie = new Films(id, name, content, length, type, imageUrl, director, contentAdminId);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
	public boolean isFilmIdUnique(String movieId) {
		boolean flag = false;
		 try (Connection connection = dataSource.getConnection()) {
			String query = "SELECT COUNT(*) FROM movies WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, movieId);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				//if the input id is unique
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
}
