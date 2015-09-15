package com.twu.biblioteca;

/**
 * Created by Brian on 9/15/2015.
 */
public class LibraryPatron {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;


    public LibraryPatron(String libraryNumber, String password, String name)
    {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
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
        return name;
    }

    public String getEmail()
    {
        return "bpaff@bpaff.com";
    }
}
