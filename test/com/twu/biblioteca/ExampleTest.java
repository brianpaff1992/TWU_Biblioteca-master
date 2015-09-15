package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExampleTest {

    private Biblioteca bib;
    private Movie movie;
    private ArrayList<Movie> movies;

    @Before
    public void initialize(){

        bib = new Biblioteca();

        movie = bib.listMovies().get(0);
        movies = bib.listMovies();
    }

    @Test
    public void testIfBiblioticaCanReturnMovie() {

        assertTrue(movie instanceof Movie);
    }

    @Test
    public void testIfMovieReturnsItsTitle()
    {
        assertEquals(movie.getTitle(), "Dark Knight");
        assertEquals(movies.get(1).getTitle(), "Mad Max: Fury Road");
    }

    @Test
    public void testIfMovieReturnsItsYear()
    {
        assertEquals(movie.getYear(), 2008);
        assertEquals(movies.get(1).getYear(), 2015);
    }

    @Test
    public void testIfMovieReturnsItsDirector()
    {
        assertEquals(movie.getDirector(), "Christopher Nolan");
        assertEquals(movies.get(1).getDirector(), "George Miller");

    }

    @Test
    public void testIfMovieReturnsItsRating()
    {
        assertEquals(movie.getRating(), "10");
        assertEquals(movies.get(1).getRating(), "9");
    }

    @Test
    public void testIfMultipleMoviesReturnedWhenListed()
    {
        assertEquals(bib.listMovies().size(), 3);
    }

    @Test
    public void testIfMovieCanBeUnrated()
    {
        assertEquals(movies.get(2).getRating(), "unrated");
    }
}
