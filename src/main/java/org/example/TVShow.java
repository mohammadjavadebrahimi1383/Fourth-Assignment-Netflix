package org.example;
import java.util.ArrayList;

class TVShow {
    private String title,genre, duration, rating;
    private int releaseYear;
    private ArrayList<String> casts;

    public TVShow(String title, String genre, String duration, String rating, int releaseYear, ArrayList<String> casts) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.casts = casts;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", rating='" + rating + '\'' +
                ", releaseYear=" + releaseYear +
                ", casts=" + casts +
                '}';
    }
}
