package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Brian on 9/14/2015.
 */
public class Biblioteca {

    ArrayList<Movie> movies;

    public Biblioteca()
    {
        movies = new ArrayList<Movie>();
        try{
            movies.add(new Movie("Dark Knight",2008, "Christopher Nolan", "10"));
            movies.add(new Movie("Mad Max: Fury Road",2015, "George Miller", "9"));
            movies.add(new Movie("Steve Jobs", 2015, "Danny Boyle", "unrated"));
        } catch (InvalidMovieRatingException e) {
            //Notify user of invalid rating... since this is a end-user system, and not being used by the librarians, this excpetion should not be thrown, so I won't handle it yet.
        }
    }
    public ArrayList<Movie> listMovies()
    {
        ArrayList<Movie> returnMovies = new ArrayList<Movie>();
        for(Movie m: movies)
        {
            if(!m.isCheckedOut())
            {
                returnMovies.add(m);
            }
        }
        return returnMovies;
    }

    public void checkOut(String title)
    {
        for(Movie m: movies)
        {
            if(title.equals(m.getTitle()))
            {
                m.checkOut();
            }
        }
    }
}
