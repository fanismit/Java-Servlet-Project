package Classes;

import java.util.ArrayList;


public class Cinemas {
    // Attributes
    private int cinemaId;
    private boolean cinemaIs3D;
    private int cinemaNumberOfSeats;
    private String cinemaLocation;
    private ArrayList<Movies> movies;

    // Constructor
    public Cinemas(int cinemaId, boolean cinemaIs3D, int cinemaNumberOfSeats, String cinemaLocation) {
        this.cinemaId =cinemaId;
        this.cinemaIs3D = cinemaIs3D;
        this.cinemaNumberOfSeats = cinemaNumberOfSeats;
        this.cinemaLocation = cinemaLocation;
        this.movies = new ArrayList<>();
    }
    
    public Cinemas() {
    	
    }

    // Getters and Setters
    public int getCinemaId() {
        return cinemaId;
    }

    public boolean isCinemaIs3D() {
        return cinemaIs3D;
    }

    public int getCinemaNumberOfSeats() {
        return cinemaNumberOfSeats;
    }

    public String getCinemaLocation(){return cinemaLocation;}

    public ArrayList<Movies> getMovies() {
        return movies;
    }

    // Methods
    public void addFilm(Movies film){
        movies.add(film);
    }
    public void viewCinemaDetails() {
        System.out.println("Viewing cinema details.");
    }

    public void updateCinemaDetails() {
        System.out.println("Updating cinema details.");
    }

    public void deleteCinema() {
        System.out.println("Deleting a cinema.");
    }

    public void viewAllCinemas() {
        System.out.println("Viewing all cinemas.");
    }
}
