package com.adobe.mappingexample.client;

import com.adobe.mappingexample.entity.Actor;
import com.adobe.mappingexample.entity.Movie;
import com.adobe.mappingexample.service.MovieService;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieClient implements CommandLineRunner {
    private final MovieService movieService;
    @Override
    public void run(String... args) throws Exception {
       first();
       // second();
        //third();
    }

    private void third() {
        movieService.assignActorToMovie(2, 1);
    }

    private void second() {
        Movie m = new Movie();
        m.setName("Broken Arrow");
        movieService.addMovieWithActors(m);
    }

    private void first() {
        Movie m1 = new Movie();
        m1.setName("Pulp Fiction");

        Actor a1 = new Actor();
        a1.setName("John Travolta");

        Actor a2 = new Actor();
        a2.setName("Uma Thruman");

        m1.getActors().add(a1);
        m1.getActors().add(a2);
        movieService.addMovieWithActors(m1);
    }
}
