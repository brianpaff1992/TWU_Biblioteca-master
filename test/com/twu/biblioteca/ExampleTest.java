package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExampleTest {

    private Biblioteca bib;

    @Before
    public void initialize(){

        bib = new Biblioteca();
    }

    @Test
    public void testIfBiblioticaCanReturnMovie() {

        assertTrue(bib.listMovies() instanceof Movie);
    }

    @Test
    public void testIfMovieReturnsItsTitle()
    {
        Movie movie = bib.listMovies();
        assertEquals(movie.getTitle(), "Dark Knight");
    }
}
