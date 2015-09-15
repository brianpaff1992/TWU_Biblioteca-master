package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private static Biblioteca bib;
    public static void main(String[] args) {

        bib = new Biblioteca();

        loginScreen();

        listAndCheckOutStage();

    }

    public static void loginScreen()
    {
        System.out.println("Welcome to the Bangalore Public Library System, Please Input Your Library Number:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String libaryNumber = null;
        try {
            libaryNumber = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please input Your password");

        String password = null;
        try {
            password = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!bib.verifyLogin(libaryNumber, password))
        {
            System.out.println("I'm sorry, the given information is incorrect, please try again");
            loginScreen();
        }

    }

    private static void listAndCheckOutStage()
    {
        boolean done = false;
        while(!done) {
            ArrayList<Movie> movies = bib.listMovies();

            printOutMovies(movies);

            System.out.println("Please input the title of the movie you would like to check out - type 'exit' when done checking out");

            done = dealWithInput();
        }
        System.out.println("Goodbye.");
    }

    private static void printOutMovies(ArrayList<Movie> movies)
    {
        for (Movie m : movies) {
            System.out.println("Movie: " + m.getTitle() + " year: " + m.getYear() + " directed by: " + m.getDirector() + " rating: " + m.getRating());
        }
    }

    private static boolean dealWithInput()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String checkOutMovie;
        try {
            checkOutMovie = br.readLine();

            if (checkOutMovie.equals("exit")) {
                return true;
            }
            bib.checkOut(checkOutMovie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
