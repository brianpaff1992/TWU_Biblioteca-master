package com.twu.biblioteca;

/**
 * Created by Brian on 9/15/2015.
 */
public class LibraryPatron {

    private String libraryNumber;
    private String password;


    public LibraryPatron(String libraryNumber, String password)
    {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean verifyPassword(String passwordGiven) {
        if (passwordGiven.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getLibraryNumber()
    {
        return libraryNumber;
    }

    public String getName()
    {
        return "Brian Paff";
    }
}
