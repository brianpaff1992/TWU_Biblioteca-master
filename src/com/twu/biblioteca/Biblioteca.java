package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Brian on 9/14/2015.
 */
public class Biblioteca {

    ArrayList<Movie> movies;

    public ArrayList<Movie> listMovies()
    {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Dark Knight",2008, "Christopher Nolan", "10"));
        movies.add(new Movie("Mad Max: Fury Road",2015, "George Miller", "9"));

        return movies;
    }
}
