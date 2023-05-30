package org.example;
import java.util.ArrayList;

class Movie extends TVShow {
    private float lenght;

    public Movie(String title, String genre, String duration, String rating, int releaseYear, ArrayList<String> casts, float lenght) {
        super(title, genre, duration, rating, releaseYear, casts);
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return super.toString()+"Movie{" + "lenght=" + lenght + '}';

    }
}