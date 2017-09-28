package com.outofbounds.empire.MovieDBApi.Models;

import com.outofbounds.empire.Movies.Models.Movie;
import org.json.JSONObject;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDBApi {

    Movie movie;

    public ArrayList<Movie> MovietoDB() throws Exception {
        // URL query's to get JSON Response
        String movieapi = "https://api.themoviedb.org/3/movie/now_playing?api_key=6043d9a30e51276989c8adc4ff3ce738&language=en-US&page=1";
        String genereapi = "https://api.themoviedb.org/3/genre/movie/list?api_key=6043d9a30e51276989c8adc4ff3ce738&language=en-US";

        // take the string and make an URL
        URL movieurl = new URL(movieapi);
        URL genreurl = new URL(genereapi);

        // read from the URL
        JSONObject movieobject = scanner(movieurl);
        JSONObject genreobject = scanner(genreurl);

        // Make an array to store the movies from JSON
        ArrayList<Movie> movies = new ArrayList<>();
        // creating a temp movie, to compare for duplicates
        Movie tempmovie = new Movie();
        // going trough each movie in the JSON array and extracting the data we need for our database
        for (int i = 0; i < movieobject.getJSONArray("results").length() ; i++) {
            JSONObject movieresult = movieobject.getJSONArray("results").getJSONObject(i);
            // we need a genres in movies JSON array, because the API returns genre id's and not string like "Horror"
            int genresinmovie = (int) movieresult.getJSONArray("genre_ids").get(0);
            movie = new Movie();
            // testing if 19 of the genres match the genre id on the movie we are looking at.
            for (int j = 0; j < 19 ; j++) {
                JSONObject genereresult = genreobject.getJSONArray("genres").getJSONObject(j);
                if(genresinmovie == (int) genereresult.get("id")){
                    movie.setCategory(genereresult.getString("name"));
                }
            }
            // setting the movies paramteres, that we need in the our database
            movie.setTitle(movieresult.getString("title"));
            movie.setDescription(movieresult.getString("overview"));
            movie.setImageUrl("https://image.tmdb.org/t/p/w640" + movieresult.getString("poster_path"));
            // check if we have duplicates
            if(!movie.getTitle().equals(tempmovie.getTitle()) || !tempmovie.getDescription().equals(movie.getDescription())){
                movies.add(movie);
            }
            tempmovie.setTitle(movieresult.getString("title"));
            tempmovie.setDescription(movieresult.getString("overview"));
        }
        //return the movies Arraylist, so we can insert them into the database, with the MoviesController.
        return movies;
    }

    //custom scanner for getting the JSON from the api.
    public JSONObject scanner(URL s) throws IOException {
        Scanner scan = new Scanner(s.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();
        // build a JSON object
        JSONObject obj = new JSONObject(str);
        return obj;
    }
}
