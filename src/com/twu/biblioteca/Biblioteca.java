package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Brian on 9/14/2015.
 */
public class Biblioteca {

    ArrayList<Movie> movies;
    ArrayList<LibraryPatron> users;

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

        users = new ArrayList<LibraryPatron>();
        users.add(new LibraryPatron("123-4567", "testpassword", "Brian Paff", "bpaff@bpaff.com", "909-555-5655"));
        users.add(new LibraryPatron("987-6543", "testpassword2", "Momma Paff", "mpaff@bpaff.com", "909-555-6656"));
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

    public void checkOut(String title,String libaryPatron)
    {
        for(Movie m: movies)
        {
            if(title.equals(m.getTitle()))
            {
                m.checkOut(libaryPatron);
            }
        }
    }

    public boolean verifyLogin(String libraryNumber, String givenPassword)
    {
       for(LibraryPatron u: users)
       {
           if(libraryNumber.equals(u.getLibraryNumber()))
           {
                return u.verifyPassword(givenPassword);
           }
       }

        return false;
    }

    public ArrayList<LibraryPatron> getUsers()
    {
        return users;
    }

    public LibraryPatron getPatron(String libraryNumber)
    {
        for(LibraryPatron u: users)
        {
            if(u.getLibraryNumber().equals(libraryNumber))
                return u;
        }
        return null;
    }

    public void printOutAccountInfo(LibraryPatron patron)
    {
        System.out.println("Account info:");
        System.out.println("Library Number: " + patron.getLibraryNumber());
        System.out.println("Name: " + patron.getName());
        System.out.println("Email: " + patron.getEmail());
        System.out.println("Phone Number: " + patron.getPhoneNumber());
        System.out.println("");
    }
}
