package Classes;
public class Movies {
    // Attributes
    private int movieId;
    private String movieTitle;
    private String movieCategory;
    private String movieDescription;
    //private String imagePath;
    
    // Constructor
    public Movies(int movieId, String movieTitle, String movieCategory, String movieDescription) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieCategory = movieCategory;
        this.movieDescription = movieDescription;
    }
    
    public Movies() {
    }
    
    // Getters
    public int getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public String getMovieDescription() {
        return movieDescription;
    }
    
    // Setters
    public void setMovieId(int movieId) {
    	this.movieId = movieId;
    }
    
    public void setMovieTitle(String movieTitle) {
    	this.movieTitle = movieTitle;
    }
    
    public void setMovieCategory(String movieCategory) {
    	this.movieCategory = movieCategory;
    }
    
    public void setMovieDescription(String movieDescription) {
    	this.movieDescription = movieDescription;
    }
}
