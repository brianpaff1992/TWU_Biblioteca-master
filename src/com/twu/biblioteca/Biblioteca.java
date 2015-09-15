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
        movies.add(new Movie());

        return movies;
    }
}
