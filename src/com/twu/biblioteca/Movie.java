package com.twu.biblioteca;

/**
 * Created by Brian on 9/14/2015.
 */
public class Movie {

    private String title;
    private int year;
    private String director;

    public Movie()
    {
        title = "Dark Knight";
        year = 2008;
        director = "Christopher Nolan";
    }

    public String getTitle()
    {
        return title;
    }

    public int getYear()
    {
        return year;
    }

    public String getDirector()
    {
        return director;
    }
}
