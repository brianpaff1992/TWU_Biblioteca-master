package com.twu.biblioteca;

/**
 * Created by Brian on 9/14/2015.
 */
public class Movie {

    private String title;
    private int year;
    private String director;
    private String rating;
    private boolean checkedOut;
    private String checkedOutTo;

    public Movie(String title, int year, String director, String rating) throws InvalidMovieRatingException {
        if(rating.equals("unrated") || Integer.parseInt(rating) >0 && Integer.parseInt(rating) < 11)
        {


            this.title = title;
            this.year = year;
            this.director = director;
            this.rating = rating;
            checkedOut = false;
        }

        else {
            throw new InvalidMovieRatingException();
        }
    }

    public void checkOut(String patron)
    {
        checkedOut = true;
        checkedOutTo = patron;
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

    public String getRating()
    {
        return rating;
    }

    public boolean isCheckedOut()
    {
        return checkedOut;
    }

    public String getWhoCheckedOut()
    {
        if(checkedOut)
        {
            return checkedOutTo;
        }
        else
        {
            return null;
        }
    }
}
