package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExampleTest {

    private Biblioteca bib;
    private Movie movie;

    @Before
    public void initialize(){

        bib = new Biblioteca();

        movie = bib.listMovies().get(0);
    }

    @Test
    public void testIfBiblioticaCanReturnMovie() {

        assertTrue(movie instanceof Movie);
    }

    @Test
    public void testIfMovieReturnsItsTitle()
    {
        assertEquals(movie.getTitle(), "Dark Knight");
    }

    @Test
    public void testIfMovieReturnsItsYear()
    {
        assertEquals(movie.getYear(), 2008);
    }

    @Test
    public void testIfMovieReturnsItsDirector()
    {
        assertEquals(movie.getDirector(), "Christopher Nolan");
    }

    @Test
    public void testIfMovieReturnsItsRating()
    {
        assertEquals(movie.getRating(), "10");
    }

    @Test
    public void testIfMultipleMoviesReturnedWhenListed()
    {
        assertEquals(bib.listMovies().size(), 2);
    }
}
