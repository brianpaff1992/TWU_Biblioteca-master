package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca bib = new Biblioteca();

       ArrayList<Movie> movies =  bib.listMovies();

        for(Movie m: movies)
        {
            System.out.println("Movie: " + m.getTitle() + " year: " + m.getYear() + " directed by: "+ m.getDirector() + " rating: " + m.getRating());
        }
    }
}
