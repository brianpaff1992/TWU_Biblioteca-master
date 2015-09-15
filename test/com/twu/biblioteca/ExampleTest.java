package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
        assertEquals(movies.get(2).getTitle(), "Steve Jobs");
    }

    @Test
    public void testIfMovieReturnsItsYear()
    {
        assertEquals(movie.getYear(), 2008);
        assertEquals(movies.get(1).getYear(), 2015);
        assertEquals(movies.get(2).getYear(), 2015);
    }

    @Test
    public void testIfMovieReturnsItsDirector()
    {
        assertEquals(movie.getDirector(), "Christopher Nolan");
        assertEquals(movies.get(1).getDirector(), "George Miller");
        assertEquals(movies.get(2).getDirector(), "Danny Boyle");

    }

    @Test
    public void testIfMovieReturnsItsRating()
    {
        assertEquals(movie.getRating(), "10");
        assertEquals(movies.get(1).getRating(), "9");
        assertEquals(movies.get(2).getRating(), "unrated");
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

    @Test
    @Ignore
    public void testToMakeSureAllMoviesGetPrintedToTheConsole()
    {
        //I can't get mokito to work on my computer, but here is where it would go.

    }

    //Check Out Movie Test Cases
    @Test
    public void testToMakeSureMoviesOnlyHaveValidRatings()
    {
        try {
            Movie movie1 = new Movie("Dark Knight", 2008, "Christopher Nolan", "11");

            fail( "My method didn't throw when I expected it to" );
        }
        catch (InvalidMovieRatingException expectedException) {
        }
        try {
        Movie movie2 = new Movie("Dark Knight", 2008, "Christopher Nolan", "0");

            fail( "My method didn't throw when I expected it to" );
    }
   catch (InvalidMovieRatingException expectedException) {
        }
    }

    @Test
    public void listOfMoviesShouldBeOneShorterOnceRemoveIsCalled()
    {
        bib.checkOut(movie.getTitle(), bib.getUsers().get(0).getLibraryNumber());
        assertEquals(2, bib.listMovies().size());
    }

    //---User Accounts - Login Test Cases
    @Test
    public void userShouldHaveLibraryNumber()
    {
        assertEquals(bib.getUsers().get(0).getLibraryNumber(), "123-4567");
    }

    @Test
    public void multipleUsersShouldHaveLibraryNumber()
    {
        assertEquals(bib.getUsers().get(0).getLibraryNumber(), "123-4567");
        assertEquals(bib.getUsers().get(1).getLibraryNumber(), "987-6543");
    }

    @Test
    public void verifyShouldReturnTrueInTheCaseOfACorrectPassword()
    {
        assertEquals(true, bib.getUsers().get(0).verifyPassword("testpassword"));
    }

    @Test
    public void verifyShouldReturnFalseInTheCaseOfAnIncorrectPassword()
    {
        assertEquals(false, bib.getUsers().get(0).verifyPassword("testpassword1"));
    }

    @Test
    public void checkPasswordShouldOnlyReturnTrueIfThePasswordMatchesTheLibraryNumber()
    {
        assertEquals(false, bib.verifyLogin("123-4567", "test"));
        assertEquals(true, bib.verifyLogin("123-4567", "testpassword"));
        assertEquals(false, bib.verifyLogin("987-6543", "test"));
        assertEquals(true, bib.verifyLogin("987-6543", "testpassword2"));
    }

    @Test
    public void allMoviesShouldStartAsNotCheckedOut()
    {
        ArrayList<Movie> movies = bib.listMovies();
        assertEquals(false, movies.get(0).isCheckedOut());

        assertEquals(false, movies.get(1).isCheckedOut());
        assertEquals(false, movies.get(2).isCheckedOut());

    }

    @Test
    public void movieShouldReturnTrueIfSomeoneHasCalledCheckOutOnItPreviously()
    {
        ArrayList<Movie> movies = bib.listMovies();
        movies.get(1).checkOut(bib.getUsers().get(0).getLibraryNumber());
        assertEquals(false, movies.get(0).isCheckedOut());

        assertEquals(true, movies.get(1).isCheckedOut());
        assertEquals(false, movies.get(2).isCheckedOut());
    }

    @Test
    public void movieShouldKeepTrackOfWhoCheckedItOut()
    {
        ArrayList<Movie> movies = bib.listMovies();
        movies.get(1).checkOut(bib.getUsers().get(0).getLibraryNumber());

        assertEquals(bib.getUsers().get(0).getLibraryNumber(), movies.get(1).getWhoCheckedOut());
    }

    //-------- User AccountsTests
    @Test
    public void libraryPatronShouldKeepTrackOfName()
    {
        assertEquals("Brian Paff", bib.getUsers().get(0).getName());
    }
   
}
