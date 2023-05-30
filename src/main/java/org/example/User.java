package org.example;
import java.util.Objects;
import java.util.ArrayList;

class User {
    /*
     * FUNCTION: the user should have a function to watch a show and add it to watch history.
     */

    private String username, pass;
    private ArrayList <TVShow> Favorites;
    private ArrayList <TVShow> whatchHistory;
    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
        this.Favorites = new ArrayList<>();
        this.whatchHistory= new ArrayList<>();
    }

    public ArrayList<TVShow> searchByTitle(String title) {

        ArrayList<TVShow> output = new ArrayList<>();
        for (TVShow show : Favorites)
        {
            if(Objects.equals(show.getTitle(), title))
                output.add(show);
        }
        return output;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {

        ArrayList<TVShow> output = new ArrayList<>();

        for (TVShow show : Favorites)
        {
            if(Objects.equals(show.getGenre(), genre))
                output.add(show);
        }
        return output;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> output = new ArrayList<>();

        for (TVShow show : Favorites)
        {
            if(Objects.equals(show.getReleaseYear(), year))
                output.add(show);
        }
        return output;
    }
    public void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
        Favorites.add(show);
    }
    public void viewFavorites() {
        for (TVShow i : Favorites)
        {
            System.out.println(i.toString());
        }
    }
    public void addToHistory(TVShow show) {

        whatchHistory.add(show);
    }

    public void viewHistory() {
        for (TVShow i : whatchHistory)
        {
            System.out.println(i.toString());
        }
    }

    public boolean userPassCheck(String passInput){
        if (passInput.equals(pass)) return true;
        return false;
    }
}