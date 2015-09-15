package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private static Biblioteca bib;
    public static void main(String[] args) {

        bib = new Biblioteca();

        listAndCheckOutStage();

    }

    private static void listAndCheckOutStage()
    {
        boolean done = false;
        while(!done) {
            ArrayList<Movie> movies = bib.listMovies();

            for (Movie m : movies) {
                System.out.println("Movie: " + m.getTitle() + " year: " + m.getYear() + " directed by: " + m.getDirector() + " rating: " + m.getRating());
            }

            System.out.println("Please input the title of the movie you would like to check out");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String checkOutMovie;
            try {
                checkOutMovie = br.readLine();

                if (checkOutMovie.equals("exit")) {
                    done = true;
                }
                bib.checkOut(checkOutMovie);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Goodbye.");
    }
}
